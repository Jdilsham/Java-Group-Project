package Weather;

import destination.ui.ViewDetails; // Import ViewDetails class from the destination.ui package

import org.json.JSONArray;
import org.json.JSONObject;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SeaConditionPanel extends JPanel {

    private static final String API_KEY = "40d9020a-60e1-11f0-80b9-0242ac130006-40d902c8-60e1-11f0-80b9-0242ac13000"; // API
    private String apiUrlTemplate = "https://api.stormglass.io/v2/weather/point?lat=%s&lng=%s&params=waveHeight,waterTemperature,windSpeed,precipitation"; // API URL template

    private JTextField latitudeField;
    private JTextField longitudeField;
    private JButton searchButton;

    private JPanel headerPanel; // Declare headerPanel here so it can be reused

    public SeaConditionPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(50, 50, 50)); // Subtle darker background for contrast

        // Header Panel with futuristic design
        headerPanel = new JPanel(); // Initialize headerPanel here
        headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setBackground(new Color(80, 80, 80, 180)); // Semi-transparent background

        JLabel titleLabel = new JLabel("Sea Conditions Over Time");
        titleLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 24)); // Futuristic font
        titleLabel.setForeground(new Color(255, 255, 255)); // White font for contrast
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0)); // Padding for spacing
        headerPanel.add(titleLabel);

        add(headerPanel, BorderLayout.NORTH);

        // Search Panel
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        searchPanel.setBackground(new Color(80, 80, 80, 180)); // Semi-transparent background

        JLabel searchLabel = new JLabel("Enter Latitude and Longitude:");
        searchLabel.setForeground(Color.WHITE);
        searchPanel.add(searchLabel);

        latitudeField = new JTextField(10);
        longitudeField = new JTextField(10);
        searchButton = new JButton("Search");

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String latitude = latitudeField.getText().trim();
                String longitude = longitudeField.getText().trim();

                if (!latitude.isEmpty() && !longitude.isEmpty()) {
                    // Fetch and update data based on search
                    fetchSeaConditions(latitude, longitude);
                } else {
                    JOptionPane.showMessageDialog(SeaConditionPanel.this, "Please enter both Latitude and Longitude.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        searchPanel.add(latitudeField);
        searchPanel.add(longitudeField);
        searchPanel.add(searchButton);

        add(searchPanel, BorderLayout.NORTH);

        // Main panel to display charts side by side
        JPanel chartsPanel = new JPanel();
        chartsPanel.setLayout(new GridLayout(1, 2, 20, 0)); // 1 row, 2 columns, 20px spacing
        chartsPanel.setBackground(new Color(50, 50, 50));

        // Data and Table Panel
        JPanel dataPanel = new JPanel();
        dataPanel.setLayout(new BorderLayout());
        dataPanel.setBackground(new Color(30, 30, 30));

        // Remove the Back Button section (no need to add it)
    }

    private void fetchSeaConditions(String latitude, String longitude) {
        String apiUrl = String.format(apiUrlTemplate, latitude, longitude);

        // Lists to store API data
        List<String> times = new ArrayList<>();
        List<Double> waveHeights = new ArrayList<>();
        List<Double> waterTemps = new ArrayList<>();
        List<Double> windSpeeds = new ArrayList<>();
        List<Double> precipitations = new ArrayList<>();

        try {
            // Fetch API data
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Authorization", API_KEY);

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                content.append(line);
            }
            in.close();
            conn.disconnect();

            JSONObject json = new JSONObject(content.toString());
            JSONArray hours = json.getJSONArray("hours");

            for (int i = 0; i < hours.length(); i++) {
                JSONObject hourData = hours.getJSONObject(i);
                String time = hourData.getString("time").substring(11, 16); // Extract time

                if (hourData.has("waveHeight") && hourData.has("waterTemperature") && hourData.has("windSpeed") && hourData.has("precipitation")) {
                    JSONObject waveHeight = hourData.getJSONObject("waveHeight");
                    JSONObject waterTemp = hourData.getJSONObject("waterTemperature");
                    JSONObject windSpeed = hourData.getJSONObject("windSpeed");
                    JSONObject precipitation = hourData.getJSONObject("precipitation");

                    if (waveHeight.has("noaa") && waterTemp.has("noaa") && windSpeed.has("noaa") && precipitation.has("noaa")) {
                        times.add(time);
                        waveHeights.add(waveHeight.getDouble("noaa"));
                        waterTemps.add(waterTemp.getDouble("noaa"));
                        windSpeeds.add(windSpeed.getDouble("noaa"));
                        precipitations.add(precipitation.getDouble("noaa"));
                    }
                }
            }

            // Create and add chart panels with modern UI
            JPanel chartsPanel = new JPanel();
            chartsPanel.setLayout(new GridLayout(1, 2, 20, 0)); // 1 row, 2 columns, 20px spacing
            chartsPanel.setBackground(new Color(50, 50, 50));

            chartsPanel.add(createChartPanel("Wave Height", "Height (m)", "Wave Height (m)", times, waveHeights));
            chartsPanel.add(createChartPanel("Water Temperature", "Temperature (°C)", "Water Temp (°C)", times, waterTemps));

            // Create Data Table
            JTable dataTable = createDataTable(times, waveHeights, waterTemps, windSpeeds, precipitations);
            JScrollPane tableScrollPane = new JScrollPane(dataTable);
            JPanel dataPanel = new JPanel();
            dataPanel.setLayout(new BorderLayout());
            dataPanel.setBackground(new Color(30, 30, 30));
            dataPanel.add(tableScrollPane, BorderLayout.CENTER);

            // Update the SeaConditionPanel with the new data
            removeAll();
            add(headerPanel, BorderLayout.NORTH); // Reuse the existing headerPanel
            add(chartsPanel, BorderLayout.CENTER);
            add(dataPanel, BorderLayout.SOUTH);
            revalidate();
            repaint();

        } catch (Exception e) {
            e.printStackTrace();
            JLabel errorLabel = new JLabel("Failed to load sea condition data.");
            errorLabel.setForeground(new Color(255, 0, 0)); // Red color for error messages
            errorLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
            add(errorLabel, BorderLayout.CENTER);
        }
    }

    private ChartPanel createChartPanel(String title, String yAxisLabel, String seriesName, List<String> times, List<Double> values) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < times.size(); i++) {
            dataset.addValue(values.get(i), seriesName, times.get(i));
        }
        JFreeChart chart = ChartFactory.createLineChart(
                title, "Time", yAxisLabel, dataset, PlotOrientation.VERTICAL, true, true, false
        );

        chart.setBackgroundPaint(new Color(60, 60, 60)); // Dark chart background
        chart.getTitle().setFont(new Font("Helvetica Neue", Font.BOLD, 18)); // Futuristic font
        chart.getTitle().setPaint(new Color(255, 255, 255)); // White title for contrast
        chart.getPlot().setBackgroundPaint(new Color(40, 40, 40)); // Darker background for plot

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 300));
        chartPanel.setBackground(new Color(50, 50, 50));
        chartPanel.setMouseWheelEnabled(true); // Enable zooming with mouse scroll
        chartPanel.setPreferredSize(new Dimension(600, 350)); // Adjust chart panel size

        return chartPanel;
    }

    private JTable createDataTable(List<String> times, List<Double> waveHeights, List<Double> waterTemps, List<Double> windSpeeds, List<Double> precipitations) {
        String[] columnNames = {"Time", "Wave Height (m)", "Water Temp (°C)", "Wind Speed (m/s)", "Precipitation (mm)"};
        Object[][] data = new Object[times.size()][5];

        for (int i = 0; i < times.size(); i++) {
            data[i][0] = times.get(i);
            data[i][1] = waveHeights.get(i);
            data[i][2] = waterTemps.get(i);
            data[i][3] = windSpeeds.get(i);
            data[i][4] = precipitations.get(i);
        }

        return new JTable(data, columnNames);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sea Conditions");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 700);
        frame.setLocationRelativeTo(null);
        frame.add(new SeaConditionPanel());
        frame.setVisible(true);
    }
}

package API;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.json.*;

public class WeatherApp {

    private static JPanel weatherPanel;
    private static JTextField locationTextField;
    private static JLabel currentLocationLabel;
    private static String currentLocation = "";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(WeatherApp::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Weather App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        // Background panel with gradient
        JPanel backgroundPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Gradient Background (light blue to white)
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(0, 0, new Color(0, 137, 255), 0, getHeight(), Color.white);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        backgroundPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        frame.add(backgroundPanel);

        try {
            ImageIcon logoIcon = new ImageIcon("resources/logo.png");
            Image logo = logoIcon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            JLabel logoLabel = new JLabel(new ImageIcon(logo));
            logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
            backgroundPanel.add(logoLabel, BorderLayout.NORTH);
        } catch (Exception ignored) {}

        try {
            ImageIcon bannerIcon = new ImageIcon("resources/banner.png");
            Image banner = bannerIcon.getImage().getScaledInstance(150, 600, Image.SCALE_SMOOTH);
            JLabel bannerLabel = new JLabel(new ImageIcon(banner));
            backgroundPanel.add(bannerLabel, BorderLayout.WEST);
        } catch (Exception ignored) {}

        JLabel titleLabel = new JLabel("Weather Forecast", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setForeground(Color.white);  // White text for better contrast on gradient background
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        backgroundPanel.add(titleLabel, BorderLayout.PAGE_START);

        currentLocationLabel = new JLabel("", SwingConstants.CENTER);
        currentLocationLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        currentLocationLabel.setForeground(new Color(255, 255, 255)); // White text for better visibility
        currentLocationLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 15, 0));
        backgroundPanel.add(currentLocationLabel, BorderLayout.AFTER_LAST_LINE);

        // Weather Panel (scrollable)
        weatherPanel = new JPanel();
        weatherPanel.setLayout(new BoxLayout(weatherPanel, BoxLayout.Y_AXIS));

        // -------- EMBEDDED SEARCH BAR --------
        JPanel searchBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchBar.setMaximumSize(new Dimension(950, 60));
        searchBar.setBackground(new Color(240, 240, 240)); // Soft light gray background

        locationTextField = new JTextField(20);
        locationTextField.setFont(new Font("Arial", Font.PLAIN, 16));
        locationTextField.setBorder(BorderFactory.createLineBorder(new Color(0, 137, 255), 2));

        JButton searchButton = new JButton("Search");
        searchButton.setFont(new Font("Arial", Font.PLAIN, 16));
        searchButton.setBackground(new Color(0, 137, 255)); // Blue button color
        searchButton.setForeground(Color.white);
        searchButton.setBorder(BorderFactory.createLineBorder(new Color(0, 137, 255), 2));
        searchButton.setPreferredSize(new Dimension(100, 35));

        searchButton.addActionListener(e -> searchWeather());
        locationTextField.addActionListener(e -> searchWeather());

        searchBar.add(new JLabel("Enter City:"));
        searchBar.add(locationTextField);
        searchBar.add(searchButton);

        weatherPanel.add(searchBar);

        // Startup instruction
        JLabel startupLabel = new JLabel("Please enter a city and press Enter or click Search.", SwingConstants.CENTER);
        startupLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        startupLabel.setForeground(new Color(128, 128, 128)); // Subtle gray color for instructions
        startupLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        weatherPanel.add(startupLabel);

        JScrollPane scrollPane = new JScrollPane(weatherPanel);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        backgroundPanel.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private static void searchWeather() {
        String location = locationTextField.getText().trim();
        if (!location.isEmpty()) {
            currentLocation = location;
            currentLocationLabel.setText("Showing weather for: " + currentLocation);
            loadWeatherForecast(currentLocation);
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a valid location!", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void loadWeatherForecast(String location) {
        try {
            String API_KEY = "db7b78d271405bb6e4f6343f49a523f2";
            String encodedLoc = URLEncoder.encode(location, "UTF-8");
            String urlStr = "https://api.openweathermap.org/data/2.5/forecast?q=" + encodedLoc
                    + "&units=metric&appid=" + API_KEY;

            HttpURLConnection conn = (HttpURLConnection) new URL(urlStr).openConnection();
            conn.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            for (String line; (line = br.readLine()) != null; ) sb.append(line);
            br.close();

            parseAndDisplayWeather(sb.toString());

        } catch (Exception ex) {
            ex.printStackTrace();
            showError("Failed to load weather data for " + currentLocation + ".\n" + ex.getMessage());
        }
    }

    private static void parseAndDisplayWeather(String jsonData) {
        try {
            JSONObject root = new JSONObject(jsonData);
            if (root.has("cod") && root.getString("cod").equals("404")) {
                showError("City not found. Please enter a valid location.");
                return;
            }

            JSONObject cityObj = root.getJSONObject("city");
            JSONArray list = root.getJSONArray("list");

            // Clear previous data except search bar
            weatherPanel.removeAll();
            weatherPanel.revalidate();
            weatherPanel.repaint();

            // Add search bar again
            createAndAddSearchBar();

            JSONObject now = list.getJSONObject(0);
            JSONObject main = now.getJSONObject("main");
            JSONObject wind = now.getJSONObject("wind");

            double temp = main.getDouble("temp");
            double feels = main.getDouble("feels_like");
            double tempMin = main.getDouble("temp_min");
            double tempMax = main.getDouble("temp_max");
            int humidity = main.getInt("humidity");
            int pressure = main.getInt("pressure");
            int visibility = now.has("visibility") ? now.getInt("visibility") : -1;
            double windSpeed = wind.getDouble("speed");
            String desc = now.getJSONArray("weather").getJSONObject(0).getString("description");
            String iconCode = now.getJSONArray("weather").getJSONObject(0).getString("icon");

            JPanel currentPanel = new JPanel(new BorderLayout());
            currentPanel.setPreferredSize(new Dimension(950, 330));
            currentPanel.setBorder(BorderFactory.createLineBorder(new Color(0, 137, 255), 5));
            currentPanel.setBackground(Color.white);

            JLabel tempLabel = new JLabel(String.format("Current Temp: %.1f °C", temp), SwingConstants.CENTER);
            tempLabel.setFont(new Font("Arial", Font.BOLD, 48));
            tempLabel.setForeground(new Color(0, 137, 255));

            JLabel descLabel = new JLabel(desc, SwingConstants.CENTER);
            descLabel.setFont(new Font("Arial", Font.PLAIN, 28));
            descLabel.setForeground(new Color(255, 94, 0));

            JLabel iconLabel = new JLabel(loadWeatherIcon(iconCode));
            iconLabel.setHorizontalAlignment(SwingConstants.CENTER);

            JPanel detailGrid = new JPanel(new GridLayout(2, 3, 10, 10));
            detailGrid.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            detailGrid.setBackground(Color.white);
            detailGrid.add(detailCell("Feels Like", String.format("%.1f °C", feels)));
            detailGrid.add(detailCell("Min / Max", String.format("%.1f / %.1f °C", tempMin, tempMax)));
            detailGrid.add(detailCell("Visibility", visibility >= 0 ? visibility / 1000 + " km" : "N/A"));
            detailGrid.add(detailCell("Humidity", humidity + " %"));
            detailGrid.add(detailCell("Pressure", pressure + " hPa"));
            detailGrid.add(detailCell("Wind Speed", String.format("%.1f km/h", windSpeed)));

            JPanel northHolder = new JPanel(new GridLayout(1, 3));
            northHolder.setBackground(Color.white);
            northHolder.add(tempLabel);
            northHolder.add(descLabel);
            northHolder.add(iconLabel);

            currentPanel.add(northHolder, BorderLayout.NORTH);
            currentPanel.add(detailGrid, BorderLayout.CENTER);
            weatherPanel.add(currentPanel);

            long sunrise = cityObj.getLong("sunrise");
            long sunset = cityObj.getLong("sunset");
            int tzOffset = cityObj.getInt("timezone");

            JPanel sunPanel = new JPanel(new GridLayout(1, 2, 20, 0));
            sunPanel.setBackground(Color.white);
            sunPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            sunPanel.add(createWeatherCard("Sunrise", formatUnix(sunrise, tzOffset)));
            sunPanel.add(createWeatherCard("Sunset", formatUnix(sunset, tzOffset)));
            weatherPanel.add(sunPanel);

            JPanel forecastPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            for (int i = 0; i < list.length(); i += 8) {
                JSONObject item = list.getJSONObject(i);
                String date = item.getString("dt_txt");
                double fTemp = item.getJSONObject("main").getDouble("temp");
                String fDesc = item.getJSONArray("weather").getJSONObject(0).getString("description");
                String fIcon = item.getJSONArray("weather").getJSONObject(0).getString("icon");

                JPanel card = new JPanel();
                card.setPreferredSize(new Dimension(150, 200));
                card.setBackground(Color.white);
                card.setBorder(BorderFactory.createLineBorder(new Color(0, 137, 255)));
                card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));

                card.add(centeredLabel(date, 14, Color.black));
                card.add(centeredLabel(String.format("Temp: %.1f °C", fTemp), 14, new Color(0, 137, 255)));
                card.add(centeredLabel(fDesc, 14, new Color(255, 94, 0)));
                card.add(new JLabel(loadWeatherIcon(fIcon)));

                forecastPanel.add(card);
            }

            weatherPanel.add(forecastPanel);
            weatherPanel.revalidate();
            weatherPanel.repaint();

        } catch (JSONException ex) {
            ex.printStackTrace();
            showError("Error parsing weather data.\n" + ex.getMessage());
        }
    }

    private static void createAndAddSearchBar() {
        JPanel searchBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchBar.setMaximumSize(new Dimension(950, 60));
        searchBar.setBackground(new Color(240, 240, 240)); // Soft light gray background

        searchBar.add(new JLabel("Enter City:"));
        searchBar.add(locationTextField);
        searchBar.add(new JButton("Search") {{
            setFont(new Font("Arial", Font.PLAIN, 16));
            setBackground(new Color(0, 137, 255)); // Blue button color
            setForeground(Color.white);
            setBorder(BorderFactory.createLineBorder(new Color(0, 137, 255), 2));
            setPreferredSize(new Dimension(100, 35));
            addActionListener(e -> searchWeather());
        }});

        weatherPanel.add(searchBar);
    }

    private static JPanel detailCell(String title, String value) {
        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(Color.white);
        JLabel t = new JLabel(title, SwingConstants.CENTER);
        t.setFont(new Font("Arial", Font.BOLD, 16));
        t.setForeground(new Color(0, 137, 255)); // Blue color
        JLabel v = new JLabel(value, SwingConstants.CENTER);
        v.setFont(new Font("Arial", Font.PLAIN, 14));
        p.add(t, BorderLayout.NORTH);
        p.add(v, BorderLayout.CENTER);
        p.setBorder(BorderFactory.createLineBorder(new Color(0, 137, 255), 1, true));
        return p;
    }

    private static JLabel centeredLabel(String text, int size, Color color) {
        JLabel l = new JLabel(text, SwingConstants.CENTER);
        l.setFont(new Font("Arial", Font.PLAIN, size));
        l.setForeground(color);
        return l;
    }

    private static JPanel createWeatherCard(String title, String value) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(Color.white);
        card.setPreferredSize(new Dimension(250, 150));
        card.setBorder(BorderFactory.createLineBorder(new Color(0, 137, 255), 1, true));

        JLabel titleLbl = new JLabel(title, SwingConstants.CENTER);
        titleLbl.setFont(new Font("Arial", Font.BOLD, 18));
        titleLbl.setForeground(new Color(0, 137, 255)); // Blue color

        JLabel valLbl = new JLabel(value, SwingConstants.CENTER);
        valLbl.setFont(new Font("Arial", Font.PLAIN, 16));
        valLbl.setForeground(new Color(0, 137, 255)); // Blue color

        card.add(titleLbl, BorderLayout.NORTH);
        card.add(valLbl, BorderLayout.CENTER);
        return card;
    }

    private static ImageIcon loadWeatherIcon(String code) {
        try {
            String url = "https://openweathermap.org/img/wn/" + code + "@2x.png";
            Image img = new ImageIcon(new URL(url)).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            return new ImageIcon(img);
        } catch (Exception ignored) {
            return new ImageIcon();
        }
    }

    private static String formatUnix(long utcSeconds, int tzOffsetSeconds) {
        Date date = new Date((utcSeconds + tzOffsetSeconds) * 1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        return sdf.format(date);
    }

    private static void showError(String msg) {
        weatherPanel.removeAll();
        createAndAddSearchBar();
        JLabel err = new JLabel(msg, SwingConstants.CENTER);
        err.setFont(new Font("Arial", Font.BOLD, 16));
        err.setForeground(Color.red);
        weatherPanel.add(err);
        weatherPanel.revalidate();
        weatherPanel.repaint();
    }
}

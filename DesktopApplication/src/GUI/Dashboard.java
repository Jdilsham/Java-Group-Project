/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import destination.ui.ViewDetails;
import API.SeaConditionPanel;
import java.awt.CardLayout;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.SwingUtilities;
import org.jfree.data.category.DefaultCategoryDataset;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.logging.Logger;




/**
 *
 * @author akilanilusha
 */
public final class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    private CardLayout cardLayout;
    private static final Logger LOGGER = Logger.getLogger(Dashboard.class.getName()); 
    private final String apiKey = "9f8f1b21597fd8f27c01fc532cbf4a66"; // API key here.

    public Dashboard() {
        initComponents();

        loadSeaConditionChart();
        //loadWeatherForecastList();

    }

    private void loadSeaConditionChart() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Sample data (you can dynamically load this from database or API later)
        dataset.addValue(1.2, "Wave Height (m)", "08:00");
        dataset.addValue(1.5, "Wave Height (m)", "10:00");
        dataset.addValue(1.0, "Wave Height (m)", "12:00");
        dataset.addValue(0.8, "Wave Height (m)", "14:00");


//        SeaConditionPanel seaConditionPanel = new SeaConditionPanel();
//
//        // Make sure to add the seaConditionPanel to the jPanel6 (which uses CardLayout)
//        seeConditionChart.setLayout(new java.awt.BorderLayout());
//        seeConditionChart.add(seaConditionPanel, BorderLayout.CENTER); // Adding the chart to the panel
//        jPanel6.add(seeConditionChart, "seaConditionChart"); // Add the seaConditionChart panel to the CardLayout
//        cardLayout.show(jPanel6, "seaConditionChart"); //
        SeaConditionPanel chartPanel = new SeaConditionPanel();
//        ChartPanel chartPanel = new ChartPanel(lineChart);
//        chartPanel.setPreferredSize(new java.awt.Dimension(380, 160)); // Adjust to fit your panel

        seeConditionChart.removeAll(); // Clear previous chart if any
        seeConditionChart.add(chartPanel, java.awt.BorderLayout.CENTER);
        seeConditionChart.validate();
    }

    private void loadWeatherForecastList(String city) {
        new Thread(() -> { // Perform network operation in a separate thread
            try {
                if (apiKey.equals("")) {
                    SwingUtilities.invokeLater(() -> {
                        JOptionPane.showMessageDialog(this, "Please enter a valid OpenWeatherMap API key.", "API Key Required", JOptionPane.ERROR_MESSAGE);
                    });
                    return; // Stop execution if API key is missing
                }

                //String city = "Colombo";
                String urlString = "https://api.openweathermap.org/data/2.5/forecast?q=" + city + "&units=metric&appid=" + apiKey;

                URL url = new URL(urlString);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder json = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    json.append(line);
                }
                reader.close();

                String jsonResponse = json.toString(); // Store the raw JSON
                //LOGGER.log(Level.INFO, "Weather API Response: {0}", jsonResponse); // Log the response

                JSONObject jsonObj = new JSONObject(jsonResponse);
                JSONArray list = jsonObj.getJSONArray("list");

                JPanel forecastListPanel = new JPanel();
                forecastListPanel.setLayout(new BoxLayout(forecastListPanel, BoxLayout.Y_AXIS));

                for (int i = 0; i < list.length(); i++) {
                    JSONObject entry = list.getJSONObject(i);
                    String dateTime = entry.getString("dt_txt");
                    JSONObject main = entry.getJSONObject("main");
                    double temp = main.getDouble("temp");

                    JSONArray weatherArr = entry.getJSONArray("weather");
                    String description = weatherArr.getJSONObject(0).getString("description");

                    JLabel label = new JLabel("⏰ " + dateTime + " | 🌡️ " + temp + "°C | " + description);
                    label.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
                    forecastListPanel.add(label);
                }

                SwingUtilities.invokeLater(() -> { // Update the UI on the EDT
                    weatherPanel.setViewportView(forecastListPanel);
                });

            } catch (Exception e) {
                // LOGGER.log(Level.SEVERE, "Error loading weather forecast: {0}", e.getMessage()); // Log the error
                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(this, "Failed to load weather data. Please check your network connection and API key.", "Error", JOptionPane.ERROR_MESSAGE);
                });

            }
        }).start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        weatherDetails = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        weatherPanel = new javax.swing.JScrollPane();
        weatherScroller = new javax.swing.JScrollBar();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        seeConditionChart = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        searcharea = new javax.swing.JPanel();
        search = new javax.swing.JTextField();
        searchbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(224, 247, 250));

        weatherDetails.setBackground(new java.awt.Color(2, 136, 209));
        weatherDetails.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel5.setText("Weather Details");

        weatherPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        weatherScroller.setBackground(new java.awt.Color(176, 190, 197));
        weatherPanel.setViewportView(weatherScroller);

        javax.swing.GroupLayout weatherDetailsLayout = new javax.swing.GroupLayout(weatherDetails);
        weatherDetails.setLayout(weatherDetailsLayout);
        weatherDetailsLayout.setHorizontalGroup(
            weatherDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(weatherDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(weatherDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(weatherDetailsLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(216, 216, 216))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, weatherDetailsLayout.createSequentialGroup()
                        .addComponent(weatherPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        weatherDetailsLayout.setVerticalGroup(
            weatherDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(weatherDetailsLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(weatherPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(2, 136, 209));

        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel10.setText("Sea Condition");

        seeConditionChart.setBackground(new java.awt.Color(176, 190, 197));

        javax.swing.GroupLayout seeConditionChartLayout = new javax.swing.GroupLayout(seeConditionChart);
        seeConditionChart.setLayout(seeConditionChartLayout);
        seeConditionChartLayout.setHorizontalGroup(
            seeConditionChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        seeConditionChartLayout.setVerticalGroup(
            seeConditionChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 371, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(seeConditionChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(375, 375, 375))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(seeConditionChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton1.setBackground(new java.awt.Color(38, 166, 154));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("Back");
        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        searcharea.setBackground(new java.awt.Color(224, 247, 250));

        search.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        search.setMargin(new java.awt.Insets(2, 15, 2, 6));
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        searchbtn.setBackground(new java.awt.Color(38, 166, 154));
        searchbtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchbtn.setText("Search");
        searchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchareaLayout = new javax.swing.GroupLayout(searcharea);
        searcharea.setLayout(searchareaLayout);
        searchareaLayout.setHorizontalGroup(
            searchareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchareaLayout.createSequentialGroup()
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(searchbtn)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        searchareaLayout.setVerticalGroup(
            searchareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchareaLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(searchareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchbtn))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(weatherDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(searcharea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(weatherDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(searcharea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        ViewDetails dest = new ViewDetails();
        dest.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void searchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtnActionPerformed
        String city = search.getText().trim(); // Get the city name entered by the user

    if (city.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter a city name to search.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
    } else {
        loadWeatherForecastList(city); // Call the method to load weather for the searched city
    }
    }//GEN-LAST:event_searchbtnActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTextField search;
    private javax.swing.JPanel searcharea;
    private javax.swing.JButton searchbtn;
    private javax.swing.JPanel seeConditionChart;
    private javax.swing.JPanel weatherDetails;
    private javax.swing.JScrollPane weatherPanel;
    private javax.swing.JScrollBar weatherScroller;
    // End of variables declaration//GEN-END:variables
}

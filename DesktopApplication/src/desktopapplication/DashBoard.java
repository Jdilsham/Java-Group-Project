package desktopapplication;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border; // Add this import
import java.awt.event.*;
import Weather.SeaConditionPanel; // Import SeaConditionPanel

public class DashBoard extends JFrame {
    public DashBoard() {

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(1000, 700));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        // Top Panel
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 102)); // Dark Blue
        p1.setBounds(0, 0, 1920, 65);
        add(p1);

        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(15, 10, 300, 40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(heading);

        // Search Button
        JButton search = createButton("Search", 1580, 10, 150, 40);
        p1.add(search);
        search.addActionListener(e -> {
            new destination.ui.Search().setVisible(true);
            dispose();
        });

        // Log Out Button
        JButton logout = createButton("Log Out", 1750, 10, 150, 40);
        p1.add(logout);
        logout.addActionListener(e -> {
            new login.LoginPage().setVisible(true);
            dispose();
        });

        // Side Panel
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0, 0, 102)); // Dark Blue
        p2.setBounds(0, 65, 300, 1015);
        add(p2);

        // Navigation Buttons
        String[] buttonLabels = {
            "Add Customer", "Check Packages", "Book Hotels", "Book Destinations", 
            "Check Weather","Check Sea Condition", "Check Map", "About Us"
        };
        Class[] actions = {
            desktopapplication.databaseConn.NewCustomer.class, project.Checkpackage.class,
            project.Bookpackage.class, destination.ui.Book.class, Weather.WeatherApp.class, 
            Weather.SeaConditionPanel.class, MAPmain.Main.class, login.AboutPage.class
        };

        int yPosition = 0;
        for (int i = 0; i < buttonLabels.length; i++) {
            JButton button = createButton(buttonLabels[i], 0, yPosition, 300, 50);
            p2.add(button);
            int finalI = i;
            button.addActionListener(e -> {
                try {
                    if (actions[finalI] == Weather.SeaConditionPanel.class) {
                        SeaConditionPanel.launch();  // Launch the SeaConditionPanel
                    } else {
                        JFrame newWindow = (JFrame) actions[finalI].newInstance();
                        newWindow.setVisible(true);
                    }
                    dispose();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
            yPosition += 60; // Increase the y-position for the next button
        }

        // Background Image
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("imagepath/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1620, 1015, Image.SCALE_SMOOTH);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(300, 0, 1620, 1015);
        add(image);

        setVisible(true);
    }

    // Helper method to create creative and modern buttons
    private JButton createButton(String text, int x, int y, int width, int height) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setFont(new Font("Tahoma", Font.BOLD, 20));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setOpaque(true);
        button.setBorder(createButtonBorder());
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Set Initial Background with Gradient
        button.setBackground(new Color(0, 102, 204)); // Dark Blue
        
        // Add Hover Animation Effect (Scale the button)
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(0, 153, 255)); // Lighter Blue
                button.setBorder(createButtonHoverBorder());
                button.setFont(new Font("Tahoma", Font.BOLD, 22)); // Increase font size on hover
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(0, 102, 204)); // Revert to Original Color
                button.setBorder(createButtonBorder());
                button.setFont(new Font("Tahoma", Font.BOLD, 20)); // Revert font size
            }
        });

        return button;
    }

    // Method to create creative button border with rounded corners
    private Border createButtonBorder() {
        return BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(0, 51, 102), 3), // Dark Blue border
            BorderFactory.createEmptyBorder(10, 20, 10, 20) // Padding
        );
    }

    // Method to create hover button border (glow effect)
    private Border createButtonHoverBorder() {
        return BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(255, 255, 255), 3), // White border on hover
            BorderFactory.createEmptyBorder(10, 20, 10, 20) // Padding
        );
    }

    public static void main(String[] args) {
        new DashBoard();
    }
}

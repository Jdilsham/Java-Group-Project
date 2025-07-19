package login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AboutPage extends JFrame {

    private float opacity = 0f;

    public AboutPage() {
        setTitle("About - Tourism App");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setLayout(new BorderLayout());

        // Main Panel with Background Gradient
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(255, 255, 255));
        mainPanel.setLayout(new BorderLayout());

        // Hero Section: Background Image or Gradient
        JPanel heroPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Color startColor = new Color(70, 130, 180); // Light Blue
                Color endColor = new Color(255, 255, 255); // White
                GradientPaint gradient = new GradientPaint(0, 0, startColor, 0, getHeight(), endColor);
                ((Graphics2D) g).setPaint(gradient);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        heroPanel.setPreferredSize(new Dimension(0, 300)); // Reduced height of hero section

        // Content Panel for the About Section
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(new Color(255, 255, 255));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 50, 50)); // Reduced top padding to move content up

        // Title Label
        JLabel titleLabel = new JLabel("About the Tourism App");
        titleLabel.setFont(new Font("Montserrat", Font.BOLD, 36));
        titleLabel.setForeground(new Color(40, 40, 80));
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // App Description (without the scrollbar)
        JTextArea aboutText = new JTextArea();
        aboutText.setText(
                "Welcome to the Tourism App!\n\n" +
                "This application helps travelers discover amazing places, plan trips, and explore cities with ease.\n\n" +
                "Key Features:\n" +
                "✓ Discover the best tourist spots\n" +
                "✓ Get personalized travel recommendations\n" +
                "✓ Book tours and unique experiences\n\n" +
                "Developed by:\n" +
                "• Anupa Supul \t (SC/2022/12867)\n" +
                "• P.H.S. Fernando \t (SC/2022/12890)\n" +
                "• Jayani \t (SC/2022/)\n" +
                "• M.K.K.L. Jayashan \t (SC/2022/12868)\n" +
                "• Wanniarachchi J.D. \t (SC/2022/12911)\n" +
                "• Maheshi Wickramarathna \t (SC/2022/12903)\n\n" +
                "Version 1.0\n" +
                "© 2025 Tourism App Team"
        );
        aboutText.setFont(new Font("Roboto", Font.PLAIN, 18));
        aboutText.setForeground(new Color(70, 70, 100));
        aboutText.setOpaque(false);
        aboutText.setEditable(false);
        aboutText.setFocusable(false);
        aboutText.setLineWrap(true);
        aboutText.setWrapStyleWord(true);
        aboutText.setAlignmentX(Component.LEFT_ALIGNMENT);
        aboutText.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0)); // Padding

        // Feature Cards Section
        JPanel featuresPanel = new JPanel(new GridLayout(1, 3, 20, 0));
        featuresPanel.setBackground(Color.WHITE);
        featuresPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        featuresPanel.setMaximumSize(new Dimension(900, 150));
        featuresPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));

        featuresPanel.add(createFeatureCard("Best Destinations", "\uD83C\uDF0D"));
        featuresPanel.add(createFeatureCard("Affordable Prices", "\uD83D\uDCB5"));
        featuresPanel.add(createFeatureCard("24/7 Support", "\u260E\uFE0F"));

        // Add title, about text, and feature cards to content panel
        contentPanel.add(titleLabel);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        contentPanel.add(aboutText);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        contentPanel.add(featuresPanel);

        // Adding Panels to the Main Panel
        mainPanel.add(heroPanel, BorderLayout.NORTH);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        add(mainPanel, BorderLayout.CENTER);

        // Custom Top Panel (Close Button)
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topPanel.setOpaque(false);

        JButton closeButton = new JButton("X");
        closeButton.setFont(new Font("Arial", Font.BOLD, 18));
        closeButton.setForeground(Color.WHITE);
        closeButton.setBackground(new Color(255, 0, 0));
        closeButton.setFocusPainted(false);
        closeButton.setBorderPainted(false);
        closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closeButton.addActionListener(e -> System.exit(0));

        topPanel.add(closeButton);
        add(topPanel, BorderLayout.NORTH);

        // Beautiful Back Button at Bottom Right
        RoundedButton backButton = new RoundedButton("← Back");
        backButton.setFont(new Font("Segoe UI", Font.BOLD, 16));  // Slightly larger font size for more prominence
        backButton.setBackground(new Color(255, 102, 102));
        backButton.setForeground(Color.WHITE);
        backButton.setPreferredSize(new Dimension(150, 45));  // Slightly larger button size for elegance
        backButton.addActionListener(e -> {
            new desktopapplication.DashBoard().setVisible(true);
            dispose();
        });

        // Bottom Panel for the Back Button (Positioned at Bottom Right)
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.setOpaque(false);

        // Add the back button to the bottom-right corner using GridBagLayout
        JPanel backButtonPanel = new JPanel();
        backButtonPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1; // Position to the right
        gbc.gridy = 0; // At the top row
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(0, 0, 25, 40); // Padding: Moves the button up and left slightly
        backButtonPanel.add(backButton, gbc);

        bottomPanel.add(backButtonPanel, BorderLayout.EAST);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    // Create a feature card with hover effect
    private JPanel createFeatureCard(String text, String icon) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(new Color(245, 245, 255));
        card.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 250), 2));
        card.setPreferredSize(new Dimension(250, 150));

        JLabel iconLabel = new JLabel(icon, SwingConstants.CENTER);
        iconLabel.setFont(new Font("Segoe UI", Font.PLAIN, 40));
        iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel textLabel = new JLabel(text, SwingConstants.CENTER);
        textLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        textLabel.setForeground(new Color(40, 40, 80));
        textLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        card.add(Box.createRigidArea(new Dimension(0, 10)));
        card.add(iconLabel);
        card.add(Box.createRigidArea(new Dimension(0, 10)));
        card.add(textLabel);
        card.add(Box.createRigidArea(new Dimension(0, 10)));

        // Add hover effect to the card
        card.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                card.setBackground(new Color(230, 230, 255));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                card.setBackground(new Color(245, 245, 255));
            }
        });

        return card;
    }

    private void startFadeIn() {
        Timer timer = new Timer(30, null);
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opacity += 0.05f;
                if (opacity >= 1f) {
                    opacity = 1f;
                    timer.stop();
                }
                setOpacity(opacity);
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AboutPage page = new AboutPage();
            page.setVisible(true);
            page.startFadeIn();
        });
    }
}

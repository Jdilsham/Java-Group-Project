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

        // Main Split Panel
        JPanel mainPanel = new JPanel(new GridLayout(1, 2));

        // Left Panel - Background Image
        JPanel leftPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon("travel.jpg");
                Image image = imageIcon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        leftPanel.setLayout(new BorderLayout());

        // Right Panel - Content
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        JLabel titleLabel = new JLabel("About Tourism App");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 36));
        titleLabel.setForeground(new Color(40, 40, 80));
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextArea aboutText = new JTextArea();
        aboutText.setText(
                "Welcome to the Tourism App! \n\n" +
                "This application helps travelers discover amazing places, plan trips, and explore cities with ease.\n\n" +
                "Key Features:\n" +
                "✓ Find popular tourist spots\n" +
                "✓ Get travel recommendations\n" +
                "✓ Book tours and experiences\n\n" +
                "Developed by:\n" +
                "• Anupa Supul \t\t (SC/2022/12867)\n" +
                "• M.K.K.L. Jayashan \t (SC/2022/12868)\n" +
                "• Wanniarachchi J.D. \t (SC/2022/12911)\n" +
                "• Maheshi Wickramarathna \t (SC/2022/12903)\n" +
                "• Jayani Anuththara \t (SC/2022/12843)\n" +
                "• Shehara Frenando \t (SC/2022/12890)\n\n" +
                "Version 1.0\n" +
                "© 2025 Tourism App Team"
        );
        aboutText.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        aboutText.setForeground(new Color(70, 70, 100));
        aboutText.setOpaque(false);
        aboutText.setEditable(false);
        aboutText.setFocusable(false);
        aboutText.setLineWrap(true);
        aboutText.setWrapStyleWord(true);
        aboutText.setAlignmentX(Component.LEFT_ALIGNMENT);

        JScrollPane aboutScrollPane = new JScrollPane(aboutText);
        aboutScrollPane.setOpaque(false);
        aboutScrollPane.getViewport().setOpaque(false);
        aboutScrollPane.setBorder(BorderFactory.createEmptyBorder());
        aboutScrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Feature Cards
        JPanel featuresPanel = new JPanel(new GridLayout(1, 3, 20, 0));
        featuresPanel.setBackground(Color.WHITE);
        featuresPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        featuresPanel.setMaximumSize(new Dimension(900, 150));
        featuresPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));

        featuresPanel.add(createFeatureCard("Best Destinations", "\uD83C\uDF0D"));
        featuresPanel.add(createFeatureCard("Affordable Prices", "\uD83D\uDCB5"));
        featuresPanel.add(createFeatureCard("24/7 Support", "\u260E\uFE0F"));

        rightPanel.add(titleLabel);
        rightPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        rightPanel.add(aboutScrollPane);
        rightPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        rightPanel.add(featuresPanel);

        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);

        add(mainPanel, BorderLayout.CENTER);

        // Custom Top Panel (Close Button and Back Button)
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topPanel.setOpaque(false);

        RoundedButton backButton = new RoundedButton("← Back");
        backButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
        backButton.setBackground(new Color(255, 102, 102));
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(e -> {
            new desktopapplication.DashBoard().setVisible(true);
            dispose();
        });

        JButton closeButton = new JButton("X");
        closeButton.setFont(new Font("Arial", Font.BOLD, 18));
        closeButton.setForeground(Color.WHITE);
        closeButton.setBackground(Color.RED);
        closeButton.setFocusPainted(false);
        closeButton.setBorderPainted(false);
        closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closeButton.addActionListener(e -> System.exit(0));

        topPanel.add(backButton);
        topPanel.add(closeButton);

        add(topPanel, BorderLayout.NORTH);
    }

    private JPanel createFeatureCard(String text, String icon) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(new Color(245, 245, 255));
        card.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 250), 2));

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

// Rounded Button Class
//class RoundedButton extends JButton {
//
//    private Color hoverBackgroundColor;
//    private Color normalBackgroundColor;
//
//    public RoundedButton(String text) {
//        super(text);
//        setContentAreaFilled(false);
//        setFocusPainted(false);
//        setBorderPainted(false);
//        normalBackgroundColor = new Color(255, 102, 102);
//        hoverBackgroundColor = new Color(255, 80, 80);
//
//        addMouseListener(new java.awt.event.MouseAdapter() {
//            public void mouseEntered(java.awt.event.MouseEvent evt) {
//                setBackground(hoverBackgroundColor);
//            }
//
//            public void mouseExited(java.awt.event.MouseEvent evt) {
//                setBackground(normalBackgroundColor);
//            }
//        });
//        setBackground(normalBackgroundColor);
//    }
//
//    @Override
//    protected void paintComponent(Graphics g) {
//        if (getModel().isArmed()) {
//            g.setColor(getBackground().darker());
//        } else {
//            g.setColor(getBackground());
//        }
//        g.fillRoundRect(0, 0, getWidth(), getHeight(), 40, 40);
//        super.paintComponent(g);
//    }
//
//    @Override
//    public void paintBorder(Graphics g) {
//        g.setColor(getBackground());
//    }
//}
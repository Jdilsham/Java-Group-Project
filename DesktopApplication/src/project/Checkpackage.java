package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Checkpackage extends JFrame {
    CardLayout cardLayout = new CardLayout();
    JPanel contentPanel;

    public Checkpackage() {
        setUndecorated(true);
        setTitle("Tour Packages");
        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        // Package data (Same as before)
        String[] bronze = {
                "BRONZE PACKAGE",
                "🏝 Duration: 7 Days and 6 Nights",
                "📍 Locations: Colombo, Galle, Bentota, Mirissa",
                "🛎 Included Services:",
                "✅ Airport Pickup & Drop",
                "🍽 Daily Breakfast + Dinner Buffets",
                "🏨 4-Star Hotel Accommodation",
                "🧃 Welcome Drinks on Arrival",
                "🗣 English / Sinhala Speaking Tour Guide",
                "💰 Price: Rs. 12,000/- per person (All Inclusive)",
                "📞 Book via tab or call: ‪+94 77 123 4567‬"
        };

        String[] silver = {
                "SILVER PACKAGE",
                "🏝 Duration: 5 Days and 6 Nights",
                "📍 Locations: Colombo, Galle, Bentota, Mirissa",
                "🛎 Included Services:",
                "✅ Airport Pickup & Drop",
                "🍽 All Meals Included",
                "🏨 5-Star Hotel Accommodation",
                "🧖‍♂ Spa & Wellness Sessions",
                "🗣 Multilingual Tour Guide",
                "💰 Price: Rs. 25,000/- per person (All Inclusive)",
                "📞 Book via tab or call: ‪‪+94 76 987 6543‬‬"
        };

        String[] gold = {
                "GOLD PACKAGE",
                "🏝 Duration: 5 Days and 4 Nights",
                "📍 Locations: Colombo, Galle, Bentota, Mirissa",
                "🛎 Included Services:",
                "🎁 Free Tickets: Turtle Hatchery & Museum",
                "🍽 All Meals Included",
                "🏨 5-Star Hotel Accommodation",
                "📸 Professional Photography Session",
                "🔖 10% Off for Groups (3+)",
                "💰 Price: Rs. 30,000/- per person (All Inclusive)",
                "📞 Book via tab or call: ‪‪+94 76 987 6543‬‬"
        };

        // Card layout for switching views
        contentPanel = new JPanel(cardLayout);
        contentPanel.add(new JScrollPane(createPackagePanel(bronze)), "Bronze");
        contentPanel.add(new JScrollPane(createPackagePanel(silver)), "Silver");
        contentPanel.add(new JScrollPane(createPackagePanel(gold)), "Gold");
        add(contentPanel, BorderLayout.CENTER);

        // Bottom navigation bar with colored buttons
        JPanel navBar = new JPanel(new GridLayout(1, 3));
        navBar.setPreferredSize(new Dimension(0, 70));

        JButton bronzeTab = createNavButton("🥉 Bronze", new Color(205, 127, 50), Color.WHITE);
        JButton silverTab = createNavButton("🥈 Silver", new Color(192, 192, 192), Color.BLACK);
        JButton goldTab = createNavButton("🥇 Gold", new Color(255, 215, 0), Color.BLACK);

        bronzeTab.addActionListener(e -> cardLayout.show(contentPanel, "Bronze"));
        silverTab.addActionListener(e -> cardLayout.show(contentPanel, "Silver"));
        goldTab.addActionListener(e -> cardLayout.show(contentPanel, "Gold"));

        navBar.add(bronzeTab);
        navBar.add(silverTab);
        navBar.add(goldTab);
        add(navBar, BorderLayout.SOUTH);

        setVisible(true);
    }

    private JPanel createPackagePanel(String[] pack) {
        GradientPanel panel = new GradientPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        // Package title with shadow
        JLabel title = new JLabel(pack[0]);
        title.setOpaque(true);
        title.setBackground(new Color(255, 215, 0));
        title.setForeground(Color.DARK_GRAY);
        title.setFont(new Font("Segoe UI", Font.BOLD, 36));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        title.setPreferredSize(new Dimension(0, 60));
        title.setForeground(new Color(40, 40, 40));
        title.setFont(new Font("Segoe UI", Font.BOLD, 36));
        title.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 3));
        panel.add(title);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        for (int i = 1; i < pack.length; i++) {
            JLabel label = new JLabel(pack[i]);
            label.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 22));
            label.setForeground(new Color(40, 40, 40));
            label.setAlignmentX(Component.LEFT_ALIGNMENT);
            label.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            label.setPreferredSize(new Dimension(0, 40));
            panel.add(label);
        }

        panel.add(Box.createRigidArea(new Dimension(0, 30)));

        // Stylish buttons with gradient and shadow effects
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 0));
        buttonPanel.setOpaque(false);

        JButton bookNow = createStyledButton(" Book Now", new Color(60, 179, 113));
        JButton backButton = createStyledButton(" Back", new Color(70, 130, 180));
        bookNow.addActionListener(e -> {
            new project.Bookpackage().setVisible(true);
            dispose();
        });
        backButton.addActionListener(e -> {
            new desktopapplication.DashBoard().setVisible(true);
            dispose();
        });

        buttonPanel.add(bookNow);
        buttonPanel.add(backButton);
        panel.add(buttonPanel);

        return panel;
    }

    private JButton createNavButton(String text, Color bgColor, Color fgColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 18));
        button.setBackground(bgColor);
        button.setForeground(fgColor);
        button.setFocusPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setBorder(BorderFactory.createLineBorder(bgColor.darker(), 2));

        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                button.setBackground(bgColor.darker());
                button.setForeground(Color.WHITE);
            }

            public void mouseExited(MouseEvent evt) {
                button.setBackground(bgColor);
                button.setForeground(Color.BLACK);
            }
        });

        return button;
    }

    private JButton createStyledButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 20));
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setPreferredSize(new Dimension(200, 50));

        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                button.setBackground(bgColor.darker());
            }

            public void mouseExited(MouseEvent evt) {
                button.setBackground(bgColor);
            }
        });
        return button;
    }

    class GradientPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            Color top = new Color(173, 216, 230);   // Light cyan
            Color bottom = new Color(0, 105, 148);  // Sea blue
            int w = getWidth();
            int h = getHeight();
            GradientPaint gp = new GradientPaint(0, 0, top, 0, h, bottom);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, w, h);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Checkpackage::new);
    }
}

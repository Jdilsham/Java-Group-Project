package login;

import desktopapplication.DashBoard;
import desktopapplication.databaseConn.DatabaseCon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginPage extends JFrame implements ActionListener {

    private final JTextField usernameField;
    private final JPasswordField passwordField;
    private final JCheckBox showPassword;
    private final RoundedButton loginButton;
    private final RoundedButton signupButton;
    private final RoundedButton forgotPasswordButton;
    private float opacity = 0f;

    public LoginPage() {
        setTitle("Login Page");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);

        JPanel mainPanel = new JPanel(new GridLayout(1, 2));

        // Left Panel with Background Image
        JPanel leftPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/beach1.jpg"));
                Image img = icon.getImage();
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };
        leftPanel.setLayout(new BorderLayout());

        // Right Panel with Gradient Background
        JPanel rightPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Color color1 = new Color(255, 182, 193);  // Light Pink
                Color color2 = new Color(173, 216, 230);  // Light Blue
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        rightPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);  // Add some space between components

        // Labels and Inputs
        JLabel titleLabel = new JLabel("Welcome Back!");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titleLabel.setForeground(new Color(80, 0, 80));

        JLabel userLabel = new JLabel("Username:");
        userLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        JLabel passLabel = new JLabel("Password:");
        passLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        usernameField = new JTextField(15);
        usernameField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        usernameField.setBorder(BorderFactory.createLineBorder(new Color(173, 216, 230), 2));

        passwordField = new JPasswordField(15);
        passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        passwordField.setBorder(BorderFactory.createLineBorder(new Color(173, 216, 230), 2));

        showPassword = new JCheckBox("Show Password");
        showPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        showPassword.setForeground(new Color(80, 0, 80));
        showPassword.addActionListener(e -> passwordField.setEchoChar(showPassword.isSelected() ? (char) 0 : '•'));

        
        loginButton = new RoundedButton("Login");
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        loginButton.setBackground(new Color(0, 123, 255)); // Vibrant blue
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(this);

        signupButton = new RoundedButton("Sign Up");
        signupButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        signupButton.setBackground(new Color(0, 204, 102)); // Fresh green
        signupButton.setForeground(Color.WHITE);
        signupButton.addActionListener(e -> {
            new SignUpPage().setVisible(true);
            dispose();
        });

        forgotPasswordButton = new RoundedButton("Forgot Password?");
        forgotPasswordButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        forgotPasswordButton.setForeground(Color.WHITE);
        forgotPasswordButton.setBackground(new Color(255, 87, 34)); // Warm orange
        forgotPasswordButton.addActionListener(e -> {
            new ForgotPasswordPage().setVisible(true);
            dispose();
        });

        // Arrange components using GridBagLayout
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        rightPanel.add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.gridx = 0;
        gbc.gridy = 1;
        rightPanel.add(userLabel, gbc);

        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.gridx = 1;
        rightPanel.add(usernameField, gbc);

        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.gridx = 0;
        gbc.gridy = 2;
        rightPanel.add(passLabel, gbc);

        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.gridx = 1;
        rightPanel.add(passwordField, gbc);

        // Position Show Password Checkbox below Password field
        gbc.gridx = 1;
        gbc.gridy = 3;
        rightPanel.add(showPassword, gbc);

        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 60, 10)); // Increased spacing between buttons
        buttonPanel.setOpaque(false);
        buttonPanel.add(loginButton);
        buttonPanel.add(signupButton);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        rightPanel.add(buttonPanel, gbc);

        // Positioning Forgot Password Button below Login and Sign Up buttons, centered
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        rightPanel.add(forgotPasswordButton, gbc);

        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);
        add(mainPanel);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = String.valueOf(passwordField.getPassword());

        try {
            Connection conn = DatabaseCon.getConnection();
            String query = "SELECT password FROM user_data WHERE userName = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String storedPass = rs.getString("password");
                if (storedPass.equals(password)) {
                    JOptionPane.showMessageDialog(this, "Login successful!");
                    new DashBoard().setVisible(true);
                    dispose(); // Close LoginPage after successful login
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid password.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "User not found.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error: ");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginPage loginPage = new LoginPage();
            loginPage.setVisible(true);
            loginPage.startFadeIn();
        });
    }
}

// Custom RoundedButton Class
class RoundedButton extends JButton {
    public RoundedButton(String text) {
        super(text);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Add hover effect using mouse listener
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(getBackground().darker());
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(getBackground().brighter());
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Adding gradient effect
        Graphics2D g2 = (Graphics2D) g.create();
        GradientPaint gradient = new GradientPaint(0, 0, new Color(0, 123, 255), 0, getHeight(), new Color(0, 204, 255)); // Blue gradient
        g2.setPaint(gradient);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 40, 40); // Rounded corners
        super.paintComponent(g); // Paint the text and other components
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(new Color(0, 102, 204)); // Border color
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 40, 40); // Rounded border
        g2.dispose();
    }
}

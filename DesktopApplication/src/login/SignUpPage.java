package login;

import desktopapplication.databaseConn.DatabaseCon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpPage extends JFrame implements ActionListener {

    private final JTextField emailField;
    private final JTextField newUsernameField;
    private final JPasswordField newPasswordField;
    private final JPasswordField confirmPasswordField;
    private final JCheckBox showPassword;
    private final RoundedButton registerButton;

    public SignUpPage() {
        setTitle("Sign Up Page");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel mainPanel = new JPanel(new GridLayout(1, 2));

        JPanel leftPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/beach1.jpg"));
                Image img = icon.getImage();
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };
        leftPanel.setLayout(new BorderLayout());

        JPanel rightPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(0, 0, new Color(255, 255, 200), 0, getHeight(), new Color(200, 255, 200));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        rightPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel titleLabel = new JLabel("Create Account");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titleLabel.setForeground(new Color(0, 102, 102));

        JLabel emailLabel = new JLabel("Email:");
        JLabel userLabel = new JLabel("Username:");
        JLabel passLabel = new JLabel("Password:");
        JLabel confirmPassLabel = new JLabel("Confirm Password:");

        emailField = new JTextField(15);
        newUsernameField = new JTextField(15);
        newPasswordField = new JPasswordField(15);
        confirmPasswordField = new JPasswordField(15);

        // Style the text fields
        styleTextField(emailField);
        styleTextField(newUsernameField);
        styleTextField(newPasswordField);
        styleTextField(confirmPasswordField);

        showPassword = new JCheckBox("Show Password");
        showPassword.addActionListener(e -> {
            char echoChar = showPassword.isSelected() ? (char) 0 : '•';
            newPasswordField.setEchoChar(echoChar);
            confirmPasswordField.setEchoChar(echoChar);
        });

        // Style the show password checkbox
        showPassword.setOpaque(false);
        showPassword.setForeground(new Color(0, 102, 102));
        showPassword.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));

        // Register button with improved design
        registerButton = new RoundedButton("Register");
        registerButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        registerButton.setBackground(new Color(255, 140, 0)); // Set initial color
        registerButton.setForeground(Color.WHITE);
        registerButton.setFocusPainted(false);
        registerButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Padding inside the button

        // Hover effect for button
        registerButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                registerButton.setBackground(new Color(255, 165, 0)); // Change color on hover
            }

            public void mouseExited(MouseEvent evt) {
                registerButton.setBackground(new Color(255, 140, 0)); // Revert to original color
            }
        });

        registerButton.addActionListener(this);

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        rightPanel.add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.gridy++;
        rightPanel.add(emailLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        rightPanel.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.LINE_END;
        rightPanel.add(userLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        rightPanel.add(newUsernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.LINE_END;
        rightPanel.add(passLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        rightPanel.add(newPasswordField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.LINE_END;
        rightPanel.add(confirmPassLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        rightPanel.add(confirmPasswordField, gbc);

        gbc.gridy++;
        rightPanel.add(showPassword, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        rightPanel.add(registerButton, gbc);

        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);
        add(mainPanel);
    }

    // Method to style the text fields (Adjusted height)
    private void styleTextField(JTextField textField) {
        textField.setBackground(new Color(245, 245, 245)); // Light gray background
        textField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        textField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 2));
        textField.setPreferredSize(new Dimension(250, 30)); // Reduced height

        // Adding a focus effect: Change border color when focused
        textField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                textField.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 102), 2)); // Change border color when focused
            }

            public void focusLost(FocusEvent e) {
                textField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 2)); // Revert border color when not focused
            }
        });
    }

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String email = emailField.getText();
        String newUsername = newUsernameField.getText();
        String newPassword = String.valueOf(newPasswordField.getPassword());
        String confirmPassword = String.valueOf(confirmPasswordField.getPassword());

        if (isValidEmail(email)) {
            if (email.isEmpty() || newUsername.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!newPassword.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(this, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    Connection conn = DatabaseCon.getConnection();
                    String sql = "INSERT INTO user_data (Email, userName, password) VALUES (?, ?, ?)";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, email);
                    pstmt.setString(2, newUsername);
                    pstmt.setString(3, newPassword);

                    int result = pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Registered Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

                    dispose();
                    new LoginPage().setVisible(true);
                } catch (SQLException error) {
                    JOptionPane.showMessageDialog(SignUpPage.this, "Database Error !!!");
                    System.out.println(error);
                }
            }
        } else {
            JOptionPane.showMessageDialog(SignUpPage.this, "Invalid Email !!!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SignUpPage().setVisible(true);
        });
    }
}

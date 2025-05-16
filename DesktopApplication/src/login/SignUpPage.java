package login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUpPage extends JFrame implements ActionListener {

    private JTextField emailField;
    private JTextField newUsernameField;
    private JPasswordField newPasswordField;
    private JPasswordField confirmPasswordField;
    private JCheckBox showPassword;
    private RoundedButton registerButton;

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
                ImageIcon icon = new ImageIcon("beach1.jpg"); 
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

        showPassword = new JCheckBox("Show Password");
        showPassword.addActionListener(e -> {
            char echoChar = showPassword.isSelected() ? (char) 0 : '•';
            newPasswordField.setEchoChar(echoChar);
            confirmPasswordField.setEchoChar(echoChar);
        });

        registerButton = new RoundedButton("Register");
        registerButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        registerButton.setBackground(new Color(255, 140, 0));
        registerButton.setForeground(Color.WHITE);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        String email = emailField.getText();
        String newUsername = newUsernameField.getText();
        String newPassword = String.valueOf(newPasswordField.getPassword());
        String confirmPassword = String.valueOf(confirmPasswordField.getPassword());

        if (email.isEmpty() || newUsername.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!newPassword.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Registered Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

           
            
            dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SignUpPage().setVisible(true);
        });
    }
}


//class RoundedButton extends JButton {
//    public RoundedButton(String text) {
//        super(text);
//        setContentAreaFilled(false);
//        setFocusPainted(false);
//        setOpaque(false);
//        setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
//    }
//
//    @Override
//    protected void paintComponent(Graphics g) {
//        Graphics2D g2 = (Graphics2D) g.create();
//        g2.setColor(getBackground());
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 40, 40);
//        super.paintComponent(g);
//        g2.dispose();
//    }
//
//    @Override
//    protected void paintBorder(Graphics g) {
//        Graphics2D g2 = (Graphics2D) g.create();
//        g2.setColor(getForeground());
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 40, 40);
//        g2.dispose();
//    }
//}

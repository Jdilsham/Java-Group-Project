package login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage extends JFrame implements ActionListener {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JCheckBox showPassword;
    private RoundedButton loginButton;
    private RoundedButton signupButton;
    private RoundedButton forgotPasswordButton;
    private float opacity = 0f;

    public LoginPage() {
        setTitle("Login Page");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);

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
                Color color1 = new Color(255, 200, 200);
                Color color2 = new Color(200, 200, 255);
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        rightPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel titleLabel = new JLabel("Welcome");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titleLabel.setForeground(new Color(80, 0, 80));

        JLabel userLabel = new JLabel("Username:");
        userLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        JLabel passLabel = new JLabel("Password:");
        passLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        usernameField = new JTextField(10);
       // usernameField.setOpaque(true);
        //  usernameField.setBackground(Color.WHITE);

        passwordField = new JPasswordField(15);
       /*
         passwordField.setOpaque(true);
        passwordField.setBackground(Color.WHITE);
        */


        showPassword = new JCheckBox("Show Password");
        showPassword.addActionListener(e -> passwordField.setEchoChar(showPassword.isSelected() ? (char) 0 : '•'));

        loginButton = new RoundedButton("Login");
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        loginButton.setBackground(new Color(0, 153, 255));
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(this);

        signupButton = new RoundedButton("Sign Up");
        signupButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        signupButton.setBackground(new Color(0, 204, 102));
        signupButton.setForeground(Color.WHITE);
        signupButton.addActionListener(e -> {
            new SignUpPage().setVisible(true);
            dispose();
        });

        forgotPasswordButton = new RoundedButton("Forgot Password?");
        forgotPasswordButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        forgotPasswordButton.setForeground(Color.WHITE);
        forgotPasswordButton.setBackground(new Color(153, 0, 153));
        forgotPasswordButton.addActionListener(e -> {
            new ForgotPasswordPage().setVisible(true);
            dispose();
        });

        gbc.insets = new Insets(10, 10, 10, 10);
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

        gbc.gridx = 1;
        gbc.gridy = 3;
        rightPanel.add(showPassword, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        rightPanel.add(loginButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 4;
        rightPanel.add(signupButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
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

        if (username.equals("admin") && password.equals("password")) {
            JOptionPane.showMessageDialog(this, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Credentials", "Error", JOptionPane.ERROR_MESSAGE);
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





class ForgotPasswordPage extends JFrame implements ActionListener {

    private JTextField emailField;
    private RoundedButton recoverButton;

    public ForgotPasswordPage() {
        setTitle("Forgot Password");
        setSize(450, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(0, 0, new Color(200, 255, 255), 0, getHeight(), new Color(255, 200, 110));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel titleLabel = new JLabel("Recover Password");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(new Color(102, 0, 102));

        JLabel emailLabel = new JLabel("Enter your email:");

        emailField = new JTextField(15);

        recoverButton = new RoundedButton("Recover");
        recoverButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        recoverButton.setBackground(new Color(255, 102, 102));
        recoverButton.setForeground(Color.WHITE);
        recoverButton.addActionListener(this);

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        panel.add(emailLabel, gbc);

        gbc.gridx = 1;
        panel.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        panel.add(recoverButton, gbc);

        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String email = emailField.getText();
        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your email", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Recovery email sent (simulation)", "Success", JOptionPane.INFORMATION_MESSAGE);
            new LoginPage().setVisible(true);
            dispose();
        }
    }
}

class RoundedButton extends JButton {
    public RoundedButton(String text) {
        super(text);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(getBackground());
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 40, 40);
        super.paintComponent(g);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(getForeground());
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 40, 40);
        g2.dispose();
    }
}

package project;

import desktopapplication.databaseConn.DatabaseCon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Bookpackage extends JFrame implements ActionListener {

    Choice cpackage;
    JTextField tperson, tfname, tlname, tnic, tphone;
    JLabel labeluname1, labeluname2, labelid, labelphone;
    JButton bookpackage, back;

    Connection conn;

    public Bookpackage() {
        // Set window properties
        setBounds(500, 150, 500, 600); // Adjust window size
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null); // Center the window on the screen

        // Create a gradient background panel
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                int width = getWidth();
                int height = getHeight();
                Color color1 = new Color(173, 216, 230); // Light Blue
                Color color2 = new Color(224, 255, 255); // Light Cyan
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, height, color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, width, height);
            }
        };
        backgroundPanel.setLayout(null);
        setContentPane(backgroundPanel);

        // Package Title
        JLabel pack = new JLabel("BOOK PACKAGE");
        pack.setFont(new Font("Segoe UI Emoji", Font.BOLD, 24));
        pack.setForeground(Color.BLACK);
        pack.setBounds(150, 20, 200, 30);
        add(pack);

        // First Name Label and JTextField
        JLabel uname1 = new JLabel("First Name");
        uname1.setFont(new Font("Segoe UI Emoji", Font.BOLD, 16));
        uname1.setBounds(30, 70, 150, 25);
        add(uname1);

        tfname = new JTextField();  // Changed to JTextField
        tfname.setBounds(200, 70, 250, 30);
        tfname.setFont(new Font("Segoe UI", Font.PLAIN, 14)); 
        tfname.setBackground(new Color(240, 248, 255)); 
        tfname.setForeground(Color.BLACK);
        tfname.setBorder(BorderFactory.createLineBorder(new Color(173, 216, 230), 2)); 
        add(tfname);

        // Last Name Label and JTextField
        JLabel uname2 = new JLabel("Last Name");
        uname2.setFont(new Font("Segoe UI Emoji", Font.BOLD, 16));
        uname2.setBounds(30, 120, 150, 25);
        add(uname2);

        tlname = new JTextField();  // Changed to JTextField
        tlname.setBounds(200, 120, 250, 30);
        tlname.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tlname.setBackground(new Color(240, 248, 255));
        tlname.setForeground(Color.BLACK);
        tlname.setBorder(BorderFactory.createLineBorder(new Color(173, 216, 230), 2));
        add(tlname);

        // NIC Label and JTextField
        JLabel id = new JLabel("NIC");
        id.setFont(new Font("Segoe UI Emoji", Font.BOLD, 16));
        id.setBounds(30, 170, 150, 25);
        add(id);

        tnic = new JTextField();  // Changed to JTextField
        tnic.setBounds(200, 170, 250, 30);
        tnic.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tnic.setBackground(new Color(240, 248, 255));
        tnic.setForeground(Color.BLACK);
        tnic.setBorder(BorderFactory.createLineBorder(new Color(173, 216, 230), 2));
        add(tnic);

        // Phone Number Label and JTextField
        JLabel phone = new JLabel("Phone No");
        phone.setFont(new Font("Segoe UI Emoji", Font.BOLD, 16));
        phone.setBounds(30, 220, 150, 25);
        add(phone);

        tphone = new JTextField();  // Changed to JTextField
        tphone.setBounds(200, 220, 250, 30);
        tphone.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tphone.setBackground(new Color(240, 248, 255));
        tphone.setForeground(Color.BLACK);
        tphone.setBorder(BorderFactory.createLineBorder(new Color(173, 216, 230), 2));
        add(tphone);

        // Select Package Label and Choice
        JLabel sec = new JLabel("Select Package");
        sec.setFont(new Font("Segoe UI Emoji", Font.BOLD, 16));
        sec.setBounds(30, 270, 150, 25);
        add(sec);

        cpackage = new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(200, 270, 250, 30);
        add(cpackage);

        // Total Person Label and JTextField
        JLabel number = new JLabel("Total Person");
        number.setFont(new Font("Segoe UI Emoji", Font.BOLD, 16));
        number.setBounds(30, 320, 150, 25);
        add(number);

        tperson = new JTextField();  // Changed to JTextField
        tperson.setBounds(200, 320, 250, 30);
        tperson.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tperson.setBackground(new Color(240, 248, 255));
        tperson.setForeground(Color.BLACK);
        tperson.setBorder(BorderFactory.createLineBorder(new Color(173, 216, 230), 2));
        add(tperson);

        // Align buttons with a custom JPanel layout using GridBagLayout
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout()); // Use GridBagLayout for more control
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add spacing between buttons
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1; // Make sure buttons do not overlap

        // Book Package Button
        bookpackage = new JButton("Book Package");
        styleButton(bookpackage, new Color(60, 179, 113), Color.WHITE);
        bookpackage.addActionListener(this);
        buttonPanel.add(bookpackage, gbc);

        // Back Button
        gbc.gridx = 1; // Position back button next to the first one
        back = new JButton("Back");
        styleButton(back, new Color(70, 130, 180), Color.WHITE);
        back.addActionListener(this);
        buttonPanel.add(back, gbc);

        // Set bounds for the button panel
        buttonPanel.setBounds(0, 380, 500, 60);  // Ensure proper positioning
        add(buttonPanel);

        setVisible(true);
    }

    private void styleButton(JButton button, Color bgColor, Color fgColor) {
        button.setBackground(bgColor);
        button.setForeground(fgColor);
        button.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button.setFocusPainted(false);  // Remove focus paint
        // No borders here, we avoid them completely
        button.setPreferredSize(new Dimension(150, 40));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                // Keep background color the same on hover
                button.setBackground(bgColor);  // No color change on hover
            }

            public void mouseExited(MouseEvent evt) {
                // Keep background color the same when mouse exits
                button.setBackground(bgColor);  // No color change when hover ends
            }
        });
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == bookpackage) {
            String fname = tfname.getText();
            String lname = tlname.getText();
            String nic = tnic.getText();
            String phone = tphone.getText();
            String packageSelected = cpackage.getSelectedItem();
            String totalPerson = tperson.getText();
            
            try {
                Connection conn = DatabaseCon.getConnection();
                
                String query = "INSERT INTO bookings(first_name, last_name, nic, contact_number, package, persons) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, fname);
                pstmt.setString(2, lname);
                pstmt.setString(3, nic);
                pstmt.setString(4, phone);
                pstmt.setString(5, packageSelected);
                pstmt.setString(6, totalPerson);
                pstmt.executeUpdate();
                
                pstmt.close();
                JOptionPane.showMessageDialog(this, "Booked Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            }

        } else if (ae.getSource() == back) {
            new desktopapplication.DashBoard().setVisible(true);
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Bookpackage();
    }
}

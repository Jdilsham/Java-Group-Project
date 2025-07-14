package project;

import desktopapplication.databaseConn.DatabaseCon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Bookpackage extends JFrame implements ActionListener {

    Choice cpackage;
    TextField tperson, tfname, tlname, tnic, tphone;
    JLabel labeluname1, labeluname2, labelid, labelphone;
    JButton bookpackage, back;

    Connection conn;

    public Bookpackage() {
        setBounds(500, 200, 500, 500);
        setLayout(null);
        setResizable(false);

      
        

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

        JLabel pack = new JLabel("BOOK PACKAGE");
        pack.setFont(new Font("Segoe UI Emoji", Font.BOLD, 20));
        pack.setForeground(Color.BLACK);
        pack.setBounds(150, 10, 200, 30);
        add(pack);

        JLabel uname1 = new JLabel("First Name");
        uname1.setFont(new Font("Segoe UI Emoji", Font.BOLD, 16));
        uname1.setBounds(30, 60, 150, 25);
        add(uname1);

        tfname = new TextField();
        tfname.setBounds(200, 60, 150, 25);
        tfname.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        add(tfname);

        JLabel uname2 = new JLabel("Last Name");
        uname2.setFont(new Font("Segoe UI Emoji", Font.BOLD, 16));
        uname2.setBounds(30, 110, 150, 25);
        add(uname2);

        tlname = new TextField();
        tlname.setBounds(200, 110, 150, 25);
        tlname.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        add(tlname);

        JLabel id = new JLabel("NIC");
        id.setFont(new Font("Segoe UI Emoji", Font.BOLD, 16));
        id.setBounds(30, 160, 150, 25);
        add(id);

        tnic = new TextField();
        tnic.setBounds(200, 160, 150, 25);
        tnic.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        add(tnic);

        JLabel phone = new JLabel("Phone No");
        phone.setFont(new Font("Segoe UI Emoji", Font.BOLD, 16));
        phone.setBounds(30, 210, 150, 25);
        add(phone);

        tphone = new TextField();
        tphone.setBounds(200, 210, 150, 25);
        tphone.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        add(tphone);

        JLabel sec = new JLabel("Select Package");
        sec.setFont(new Font("Segoe UI Emoji", Font.BOLD, 16));
        sec.setBounds(30, 260, 150, 25);
        add(sec);

        cpackage = new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(200, 260, 150, 25);
        add(cpackage);

        JLabel number = new JLabel("Total Person");
        number.setFont(new Font("Segoe UI Emoji", Font.BOLD, 16));
        number.setBounds(30, 310, 150, 25);
        add(number);

        tperson = new TextField();
        tperson.setBounds(200, 310, 150, 25);
        tperson.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        add(tperson);

        bookpackage = new JButton("Book Package");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(50, 380, 150, 30);
        bookpackage.addActionListener(this);
        add(bookpackage);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(220, 380, 150, 30);
        back.addActionListener(this);
        add(back);

        setVisible(true);
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
                
                JOptionPane.showMessageDialog(this, "Booked Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error !!!", "Error", JOptionPane.INFORMATION_MESSAGE);
            }

            /*JOptionPane.showMessageDialog(null, "Package Booked Successfully:\n" +
                    "First Name: " + fname +
                    "\nLast Name: " + lname +
                    "\nNIC: " + nic +
                    "\nPhone: " + phone +
                    "\nPackage: " + packageSelected +
                    "\nPersons: " + totalPerson);*/
        } else if (ae.getSource() == back) {
            new desktopapplication.DashBoard().setVisible(true);
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Bookpackage();
    }
}

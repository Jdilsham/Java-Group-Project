
package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Bookpackage extends JFrame implements ActionListener{
    
    Choice cpackage;
    TextField tperson;
    String fname;
    String lname;
    JLabel labeluname1,labeluname2,labelid,labelphone;
    JButton bookpackage,back;
    Bookpackage(String fname, String lname){
        this.fname = fname;
        this.lname = lname;
        setBounds(350,300,1100,500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel pack = new JLabel("BOOK PACKAGE");
        pack.setFont(new Font("Segoe UI Emoji", Font.BOLD, 20)); 
        pack.setBounds(100,10, 200, 30);
        add(pack);
        
        JLabel uname1 = new JLabel("Frist Name ");
        uname1.setFont(new Font("Segoe UI Emoji", Font.BOLD, 16));
        uname1.setBounds(30,50, 150, 25);
        add(uname1);
        
        labeluname1 = new JLabel();
        labeluname1.setFont(new Font("Segoe UI Emoji", Font.BOLD, 16));
        labeluname1.setBounds(220,70, 100, 20);
        add(labeluname1);
        
        
        JLabel uname2 = new JLabel("Last Name");
        uname2.setFont(new Font("Segoe UI Emoji", Font.BOLD, 16));
        uname2.setBounds(30, 110, 150, 25);
        add(uname2);
        
        labeluname2 = new JLabel();
        labeluname2.setFont(new Font("Segoe UI Emoji", Font.BOLD, 16));
        labeluname2.setBounds(220, 110, 150, 25);
        add(labeluname2);
        
        JLabel id = new JLabel("NIC");
        id.setFont(new Font("Segoe UI Emoji", Font.BOLD, 16));
        id.setBounds(30, 170, 150, 25);
        add(id);
        
        labelid = new JLabel();
        labelid.setFont(new Font("Segoe UI Emoji", Font.BOLD, 16));
        labelid.setBounds(220, 150, 150, 25);
        add(labelid);
        
        JLabel phone = new JLabel("Phone No");
        phone.setFont(new Font("Segoe UI Emoji", Font.BOLD, 16));
        phone.setBounds(30, 230, 150, 25);
        add(phone);
        
        labelphone = new JLabel();
        labelphone.setFont(new Font("Segoe UI Emoji", Font.BOLD, 16));
        labelphone.setBounds(220, 210, 150, 25);
        add(labelphone);
        
        JLabel sec = new JLabel("Select Package"); 
        sec.setFont(new Font("Segoe UI Emoji", Font.BOLD, 16));
        sec.setBounds(30, 290, 150, 25);
        add(sec);
        
        cpackage  = new Choice();  
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(230, 290,150,25);
        add(cpackage);
        
        JLabel number = new JLabel("Total Person");
        number.setFont(new Font("Segoe UI Emoji", Font.BOLD, 16));
        number.setBounds(30, 350, 150, 25);
        add(number);
        
        tperson = new TextField();
        tperson.setBounds(230,350,150,25);
        add(tperson);
        
        try{
            Connection connection = new Connection();
            String sr = "Select * from customer where username = '"+username+"'";
            ResultSet rs = connection.s.executeQuery(sr);
            while(rs.next()){
                labeluname1.setText(rs.getString("Frist Name"));
                labeluname2.setText(rs.getString("Last Name"));
                labelid.setText(rs.getString("NIC"));
                labelphone.setText(rs.getString("Phone No"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        bookpackage = new JButton("Book Package");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(50,400,150,25);
        bookpackage.addActionListener(this);
        add(bookpackage);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(210,400,150,25);
        back.addActionListener(this);
        add(back);
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == bookpackage ){
            try{
                Connection c = new Connection();
                c.s.executeUpdate("insert into bookpackage value('"+labeluname1.getText()+"','"+labeluname2.getText()+"','"+labelid.getText()+"','"+labelphone.getText()+"','"+cpackage.getSelectedItem()+"','"+tperson.getText()+"')"); 
                
                JOptionPane.showMessageDialog(null, "package booked succssfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else{setVisible(false);}
    }
    
    public static void main(String[] args) {
        new Bookpackage("mashi","wc");
    }
}

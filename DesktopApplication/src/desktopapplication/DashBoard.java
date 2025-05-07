package desktopapplication;

import java.awt.Color; //used to get colors
import java.awt.Font;   // used to ge various fonts
import java.awt.Image;  // used to handle images
import java.awt.Insets; // used to set margins
import javax.swing.ImageIcon; 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DashBoard extends JFrame{
    public DashBoard() {
        setSize(1280, 900);
        setLocationRelativeTo(null);//setting up the window to fill the screen at 1280 x 900 p.
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE); //after closing the program the process will be terminated
        setLayout(null);
        
        //top panel
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0,0,1920,65);
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5,0,70,70);
        p1.add(icon);
        
        
        
        
        JLabel heading = new JLabel("DashBoard");
        heading.setBounds(80,10,300,40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma" , Font.BOLD , 30));
        p1.add(heading);
        
        
        //search button structure
        JButton search = new JButton("Search");
        search.setBounds(1580,10,150,40);
        //login.setForeground(Color.WHITE);
        search.setFont(new Font("Tahoma" , Font.BOLD , 20));
        p1.add(search);
        search.addActionListener(e -> {
            //new AddDetails();
            setVisible(false);
        });
        
        
        //Log out button structure
        JButton logout = new JButton("Log Out");
        logout.setBounds(1750,10,150,40);
        //signup.setForeground(Color.WHITE);
        logout.setFont(new Font("Tahoma" , Font.BOLD , 20));
        p1.add(logout);
        logout.addActionListener(e -> {
           // new AddDetails();
            setVisible(false);
        });
        
        
        
        //side panel structure containing the navigation buttons
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0,65,300,1015);
        add(p2);
        
        
        //add details button structure
        JButton addDetails = new JButton("Add  Details");
        addDetails.setBounds(0,0,300,50);
        addDetails.setBackground(new Color(0,0,102));
        addDetails.setForeground(Color.WHITE);
        addDetails.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        addDetails.setMargin(new Insets(0,0,0,130));
        p2.add(addDetails);
        addDetails.addActionListener(e -> {
//            new AddDetails();
            setVisible(false);
        });
        
        
        //update details button structure
        JButton updateDetails = new JButton("Update  Details");
        updateDetails.setBounds(0,60,300,50);
        updateDetails.setBackground(new Color(0,0,102));
        updateDetails.setForeground(Color.WHITE);
        updateDetails.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        updateDetails.setMargin(new Insets(0,0,0,110));
        p2.add(updateDetails);
        updateDetails.addActionListener(e -> {
//            new AddDetails();
            setVisible(false);
        });
        
        
        //view details button structure
        JButton viewDetails = new JButton("View  Details");
        viewDetails.setBounds(0,120,300,50);
        viewDetails.setBackground(new Color(0,0,102));
        viewDetails.setForeground(Color.WHITE);
        viewDetails.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        viewDetails.setMargin(new Insets(0,0,0,130));
        p2.add(viewDetails);
        viewDetails.addActionListener(e -> {
//            new AddDetails();
            setVisible(false);
        });
        
        
        //delete details button structure
        JButton DeleteDetails = new JButton("Delete  Details");
        DeleteDetails.setBounds(0,180,300,50);
        DeleteDetails.setBackground(new Color(0,0,102));
        DeleteDetails.setForeground(Color.WHITE);
        DeleteDetails.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        DeleteDetails.setMargin(new Insets(0,0,0,110));
        p2.add(DeleteDetails);
        DeleteDetails.addActionListener(e -> {
//            new AddDetails();
            setVisible(false);
        });
        
        
        //check package button structure
        JButton checkPackage = new JButton("Check Packages");
        checkPackage.setBounds(0,240,300,50);
        checkPackage.setBackground(new Color(0,0,102));
        checkPackage.setForeground(Color.WHITE);
        checkPackage.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        checkPackage.setMargin(new Insets(0,0,0,110));
        p2.add(checkPackage);
        checkPackage.addActionListener(e -> {
//            new AddDetails();
            setVisible(false);
        });       
        
        
        //update package button structure
        JButton updatePackage = new JButton("Update Packages");
        updatePackage.setBounds(0,300,300,50);
        updatePackage.setBackground(new Color(0,0,102));
        updatePackage.setForeground(Color.WHITE);
        updatePackage.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        updatePackage.setMargin(new Insets(0,0,0,100));
        p2.add(updatePackage);
        updatePackage.addActionListener(e -> {
//            new AddDetails();
            setVisible(false);
        });
        
        
        //view package button structure
        JButton viewPackage = new JButton("View Packages");
        viewPackage.setBounds(0,360,300,50);
        viewPackage.setBackground(new Color(0,0,102));
        viewPackage.setForeground(Color.WHITE);
        viewPackage.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        viewPackage.setMargin(new Insets(0,10,0,130));
        p2.add(viewPackage);
        viewPackage.addActionListener(e -> {
//            new AddDetails();
            setVisible(false);
        });
        
        
        //add destination button structure
        JButton bookDestination = new JButton("Book Destination");
        bookDestination.setBounds(0,420,300,50);
        bookDestination.setBackground(new Color(0,0,102));
        bookDestination.setForeground(Color.WHITE);
        bookDestination.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        bookDestination.setMargin(new Insets(0,0,0,105));
        p2.add(bookDestination);
        bookDestination.addActionListener(e -> {
            new destination.ui.Book();
            setVisible(false);
        });
        
        
        //update map button structure
        JButton checkMap = new JButton("Check Map");
        checkMap.setBounds(0,480,300,50);
        checkMap.setBackground(new Color(0,0,102));
        checkMap.setForeground(Color.WHITE);
        checkMap.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        checkMap.setMargin(new Insets(0,0,0,140));
        p2.add(checkMap);
        checkMap.addActionListener(e -> {
//            new AddDetails();
            setVisible(false);
        });
        
        
        //view destination button structure
        JButton viewBooking = new JButton("View Booking");
        viewBooking.setBounds(0,540,300,50);
        viewBooking.setBackground(new Color(0,0,102));
        viewBooking.setForeground(Color.WHITE);
        viewBooking.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        viewBooking.setMargin(new Insets(0,0,0,110));
        p2.add(viewBooking);
        viewBooking.addActionListener(e -> {
            new destination.ui.ViewDetails();
            setVisible(false);
        });
        
        
        //view hotel button structure
        JButton viewHotel = new JButton("View Hotels");
        viewHotel.setBounds(0,600,300,50);
        viewHotel.setBackground(new Color(0,0,102));
        viewHotel.setForeground(Color.WHITE);
        viewHotel.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        viewHotel.setMargin(new Insets(0,0,0,140));
        p2.add(viewHotel);
        viewHotel.addActionListener(e -> {
//            new AddDetails();
            setVisible(false);
        });
        
        
        //transport button structure
        JButton viewTransport = new JButton("Transport");
        viewTransport.setBounds(0,660,300,50);
        viewTransport.setBackground(new Color(0,0,102));
        viewTransport.setForeground(Color.WHITE);
        viewTransport.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        viewTransport.setMargin(new Insets(0,0,0,160));
        p2.add(viewTransport);
        viewTransport.addActionListener(e -> {
//            new AddDetails();
            setVisible(false);
        });
        
        //about us button structure
        JButton about = new JButton("About Us");
        about.setBounds(0,890,300,50);
        about.setBackground(new Color(0,0,102));
        about.setForeground(Color.WHITE);
        about.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        about.setMargin(new Insets(0,10,0,180));
        p2.add(about);
        about .addActionListener(e -> {
//            new AddDetails();
            setVisible(false);
        });
        

        
        setVisible(true);  
    }
    
     
    public static void main(String[] args) {
        new DashBoard();
    }
}

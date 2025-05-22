package desktopapplication;


import java.awt.*;
import javax.swing.*;
import MAPmain.Main;

public class DashBoard extends JFrame{
    public DashBoard() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(1000,700));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE); //after closing the program the process will be terminated
        setLayout(null);
        
        //top panel
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0,0,1920,65);
        add(p1);
        

        
        
        
        
        JLabel heading = new JLabel("DashBoard");
        heading.setBounds(15,10,300,40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma" , Font.BOLD , 30));
        p1.add(heading);
        
        
        //search button structure
        JButton search = new JButton("Search");
        search.setBounds(1580,10,150,40);
        search.setFont(new Font("Tahoma" , Font.BOLD , 20));
        p1.add(search);
        search.addActionListener(e -> {
            new destination.ui.Search().setVisible(true);
            dispose();
        });
        
        
        //Log out button structure
        JButton logout = new JButton("Log Out");
        logout.setBounds(1750,10,150,40);
        logout.setFont(new Font("Tahoma" , Font.BOLD , 20));
        p1.add(logout);
        logout.addActionListener(e -> {
            new login.LoginPage().setVisible(true);
            dispose();
        });
        
        
        
        //side panel structure containing the navigation buttons
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0,65,300,1015);
        add(p2);


        //add customer details button structure
        JButton addCustomer = new JButton("Add  Customer");
        addCustomer.setBounds(0,0,300,50);
        addCustomer.setBackground(new Color(0,0,102));
        addCustomer.setForeground(Color.WHITE);
        addCustomer.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        addCustomer.setHorizontalAlignment(SwingConstants.LEFT);
        addCustomer.setMargin(new Insets(0,15,0,0));
        p2.add(addCustomer);
        addCustomer.addActionListener(e -> {
            new desktopapplication.databaseConn.NewCustomer().setVisible(true);
            dispose();
        });


        //view customer details button structure
        JButton viewCustomer = new JButton("View Customer");
        viewCustomer.setBounds(0,60,300,50);
        viewCustomer.setBackground(new Color(0,0,102));
        viewCustomer.setForeground(Color.WHITE);
        viewCustomer.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        viewCustomer.setHorizontalAlignment(SwingConstants.LEFT);
        viewCustomer.setMargin(new Insets(0,15,0,0));
        p2.add(viewCustomer);
        viewCustomer.addActionListener(e -> {
//            new desktopapplication.databaseConn.
            dispose();
        });


        //view details button structure
        JButton viewDetails = new JButton("View Details");
        viewDetails.setBounds(0,120,300,50);
        viewDetails.setBackground(new Color(0,0,102));
        viewDetails.setForeground(Color.WHITE);
        viewDetails.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        viewDetails.setHorizontalAlignment(SwingConstants.LEFT);
        viewDetails.setMargin(new Insets(0,15,0,0));
        p2.add(viewDetails);
        viewDetails.addActionListener(e -> {

            dispose();
        });


        //book package button structure
        JButton bookHotel = new JButton("Book Hotels");
        bookHotel.setBounds(0,180,300,50);
        bookHotel.setBackground(new Color(0,0,102));
        bookHotel.setForeground(Color.WHITE);
        bookHotel.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        bookHotel.setHorizontalAlignment(SwingConstants.LEFT);
        bookHotel.setMargin(new Insets(0,15,0,0));
        p2.add(bookHotel);
        bookHotel.addActionListener(e -> {
            new project.Bookpackage().setVisible(true);
            dispose();
        });

        //book destination button structure
        JButton bookDestinations = new JButton("Book Destinations");
        bookDestinations.setBounds(0,240,300,50);
        bookDestinations.setBackground(new Color(0,0,102));
        bookDestinations.setForeground(Color.WHITE);
        bookDestinations.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        bookDestinations.setHorizontalAlignment(SwingConstants.LEFT);
        bookDestinations.setMargin(new Insets(0,15,0,0));
        p2.add(bookDestinations);
        bookDestinations.addActionListener(e -> {
            new destination.ui.Book().setVisible(true);
            dispose();
        });


        //check package button structure
        JButton checkPackage = new JButton("Check Packages");
        checkPackage.setBounds(0,300,300,50);
        checkPackage.setBackground(new Color(0,0,102));
        checkPackage.setForeground(Color.WHITE);
        checkPackage.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        checkPackage.setHorizontalAlignment(SwingConstants.LEFT);
        checkPackage.setMargin(new Insets(0,15,0,0));
        p2.add(checkPackage);
        checkPackage.addActionListener(e -> {
            new project.Checkpackage().setVisible(true);
            dispose();
        });


        //view destination button structure
        JButton viewDestination = new JButton("View Destination");
        viewDestination.setBounds(0,360,300,50);
        viewDestination.setBackground(new Color(0,0,102));
        viewDestination.setForeground(Color.WHITE);
        viewDestination.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        viewDestination.setHorizontalAlignment(SwingConstants.LEFT);
        viewDestination.setMargin(new Insets(0,15,0,0));
        p2.add(viewDestination);
        viewDestination.addActionListener(e -> {
            new destination.ui.ViewDetails().setVisible(true);
            dispose();
        });


        //view package button structure
        JButton checkMap = new JButton("Check Map");
        checkMap.setBounds(0,420,300,50);
        checkMap.setBackground(new Color(0,0,102));
        checkMap.setForeground(Color.WHITE);
        checkMap.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        checkMap.setHorizontalAlignment(SwingConstants.LEFT);
        checkMap.setMargin(new Insets(0,15,0,0));
        p2.add(checkMap);
        checkMap.addActionListener(e -> {
            Main map = new Main();
            map.setVisible(true);
            this.dispose();
            
        });


        //add destination button structure
        JButton viewHotel = new JButton("View Hotels");
        viewHotel.setBounds(0,480,300,50);
        viewHotel.setBackground(new Color(0,0,102));
        viewHotel.setForeground(Color.WHITE);
        viewHotel.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        viewHotel.setHorizontalAlignment(SwingConstants.LEFT);
        viewHotel.setMargin(new Insets(0,15,0,0));
        p2.add(viewHotel);
        viewHotel.addActionListener(e -> {
            new destination.ui.Book();
            dispose();
        });


        //about us button structure
        JButton aboutUS = new JButton("About US");
        aboutUS.setBounds(0,540,300,50);
        aboutUS.setBackground(new Color(0,0,102));
        aboutUS.setForeground(Color.WHITE);
        aboutUS.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        aboutUS.setHorizontalAlignment(SwingConstants.LEFT);
        aboutUS.setMargin(new Insets(0,15,0,0));
        p2.add(aboutUS);
        aboutUS.addActionListener(e -> {
            new login.AboutPage().setVisible(true);
            setVisible(false);
        });

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("imagepath/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1620, 1015, Image.SCALE_SMOOTH);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(300, 0, 1620, 1015);
        add(image);

        
        setVisible(true);  
    }
    
     
    public static void main(String[] args) {
        new DashBoard();
    }
}

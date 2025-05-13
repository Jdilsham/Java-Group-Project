 
package project;

import javax.swing.*;
import java.awt.*;

public class Checkpackage extends JFrame {
    
    Checkpackage(){
        //setBounds(450,200,900,600);
        
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setLocation(0, 0);
        
        String[] package1 ={"GOLD PACKAGE","🏝 Duration: 7 Days and 6 Nights","📍 Locations: Colombo, Galle, Bentota, Mirissa","🛎 Included Services:","✅ - Airport Pickup & Drop","🍽 - Daily Breakfast + Dinner Buffets","🏨 - 4-Star Hotel Accommodation","🧃 - Welcome Drinks on Arrival","🗣 - English / Sinhala Speaking Tour Guide","💰 Price: Rs. 12,000/- per person (All Inclusive)","📞 Book via tab or call: ‪+94 77 123 4567‬","Book Now"};
        String[] package2 ={"SILVER PACKAGE","🏝 Duration: 5 Days and 6 Nights","📍 Locations: Colombo, Galle, Bentota, Mirissa","🛎 Included Services:","✅ - Airport Pickup & Drop", "🍽 - All Meals Included","🏨 - 5-Star Hotel Accommodation","🧖‍♂ - Spa & Wellness Sessions","🗣 - Multilingual Tour Guide","💰 Price: Rs. 25,000/- per person (All Inclusive)","📞 Book via tab or call: ‪‪+94 76 987 6543‬‬","Book Now"};

        String[] package3 ={"BRONZE PACKAGE","🏝 Duration: 5 Days and 4 Nights","📍 Locations: Colombo, Galle, Bentota, Mirissa","🛎 Included Services:","🎁 Special Offers: Free Entry Tickets for Turtle Hatchery & Museum","🍽 - All Meals Included","🏨 - 5-Star Hotel Accommodation", "📸 Professional Photography Session","🔖 Summer Promo – 10% Off for Groups (3+)","💰 Price: Rs. 30,000/- per person (All Inclusive)","📞 Book via tab or call: ‪‪+94 76 987 6543‬‬","Book Now"};


        
        JTabbedPane tab = new JTabbedPane();
             
        JPanel p1 = createPackage(package1);
        tab.addTab("Package 1", null,p1);
                
        JPanel p2 = createPackage(package2);
        tab.addTab("Package 2", null,p2);
        
        JPanel p3 = createPackage(package3);
        tab.addTab("Package 3", null,p3);
        add(tab);
        
        setVisible(true);
    }
    
    public JPanel createPackage(String[] pack){
        
        JPanel p1 = new JPanel();
        p1.setBackground(Color.WHITE);
        p1.setLayout(null);
     
        
        
        JLabel title = new JLabel(pack[0]);
        title.setFont(new Font("Segoe UI Emoji", Font.BOLD, 45)); 
        title.setForeground(new Color(218, 165, 32)); // gold color
        title.setBounds(600, 60, 1500, 50);
        p1.add(title);
        
        
        JLabel duration = new JLabel(pack[1]);
        duration.setFont(new Font("Segoe UI Emoji", Font.BOLD, 25));
        duration.setBounds(50, 100, 1500, 25);
        p1.add(duration);
        
        JLabel locations = new JLabel(pack[2]);
        locations.setFont(new Font("Segoe UI Emoji", Font.BOLD, 25));
        locations.setBounds(50, 150, 1500, 25);
        p1.add(locations);

        JLabel serviceTitle = new JLabel(pack[3]);
        serviceTitle.setFont(new Font("Segoe UI Emoji", Font.BOLD, 25));
        serviceTitle.setBounds(50, 200, 1500, 25);
        p1.add(serviceTitle);
        
        
        JLabel service1 = new JLabel(pack[4]);
        service1.setFont(new Font("Segoe UI Emoji", Font.BOLD, 20));
        service1.setForeground(new Color(0, 128, 0));
        service1.setBounds(80, 250, 1400, 25);
        p1.add(service1);
        
        JLabel service2 = new JLabel(pack[5]);
        service2.setFont(new Font("Segoe UI Emoji", Font.BOLD, 20));
        service2.setForeground(new Color(0, 128, 0));
        service2.setBounds(80, 290, 1400, 25);
        p1.add(service2);
        
        JLabel service3 = new JLabel(pack[6]);
        service3.setFont(new Font("Segoe UI Emoji", Font.BOLD, 20));
        service3.setForeground(new Color(0, 128, 0));
        service3.setBounds(80, 330, 1400, 25);
        p1.add(service3);
        
        JLabel service4 = new JLabel(pack[7]);
        service4.setFont(new Font("Segoe UI Emoji", Font.BOLD, 20));
        service4.setForeground(new Color(0, 128, 0));
        service4.setBounds(80, 370, 1400, 25);
        p1.add(service4);
        
        JLabel service5 = new JLabel(pack[8]);
        service5.setFont(new Font("Segoe UI Emoji", Font.BOLD, 20));
        service5.setForeground(new Color(0, 128, 0));
        service5.setBounds(80, 410, 1400, 25);
        p1.add(service5);
        
        


        JLabel price = new JLabel(pack[9]);
        price.setFont(new Font("Segoe UI Emoji", Font.BOLD, 25));
        //price.setForeground(new Color(0, 128, 0)); // dark green
        price.setBounds(50, 500, 1500, 30);
        p1.add(price);
        
        JLabel contact = new JLabel(pack[10]);
        contact.setFont(new Font("Segoe UI Emoji", Font.BOLD, 25));
        contact.setBounds(50, 600, 1500, 25);
        p1.add(contact);
        
        JLabel book = new JLabel(pack[11]);
        book.setFont(new Font("Tahoma", Font.BOLD, 30));
        book.setBounds(50, 750, 1500, 25);
        p1.add(book);
        
        return p1;
    }
    

    public static void main(String[] args) {
        new Checkpackage();
    }
}

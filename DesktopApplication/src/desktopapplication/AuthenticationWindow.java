
package desktopapplication;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author mkvn
 */
public class AuthenticationWindow extends JFrame{

    public AuthenticationWindow() {
        
        setUndecorated(true);
        
        setTitle("authentication");
        setSize(500,300);
        
        setLocationRelativeTo(null);
        setOpacity(0.85f);
        
        setShape(new RoundRectangle2D.Double(0,0,getWidth(),getHeight(),45,45));
        
        setBackground(new Color(0,0,0,50));
        
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(0,0,0,200));
        
        JLabel text = new JLabel("TOURIST MANAGEMENT SYSTEM",JLabel.CENTER);
        JButton login = new JButton("LOG IN");
        JButton signup = new JButton("SIGN UP");
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 20, 10, 20);
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif", Font.BOLD, 18)) ;
        gbc.gridy=0;
        panel.add(text,gbc);
        
        login.setForeground(Color.BLUE);
        login.setFont(new Font("",Font.BOLD,14));
        gbc.gridy=2;
        panel.add(login,gbc);
        login.addActionListener( e -> {
            new login.LoginPage().setVisible(true);
            setVisible(false);
        });
        
        
        signup.setForeground(Color.BLUE);
        signup.setFont(new Font("",Font.BOLD,14));
        gbc.gridy =3 ; 
        panel.add(signup,gbc);
        
              
           
            
     
        
        add(panel);
        
        
    }
    
    
}

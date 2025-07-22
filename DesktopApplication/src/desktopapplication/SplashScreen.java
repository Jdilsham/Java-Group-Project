
package desktopapplication;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;

/**
 *
 * @author mkvn
 */
public class SplashScreen extends javax.swing.JFrame {

    /**
     * Creates new form SplashScreen
     */
    
    int position = 0 ;
    Timer timer;
    
    
    //array that contains the images in the slideshow in splash screen
    private final String[] Images= {
            "slide-0.jpg",
            "slide-1.jpg",
            "slide-2.jpg",
            "slide-3.jpg",
            "slide-4.jpg",
            "slide-5.jpg",
            "slide-6.jpg",
            "slide-7.jpg",
            "slide-8.jpg",
            "slide-9.jpg",
            "slide-10.jpg",
            "slide-11.jpg",
        };
    
    
    
    public SplashScreen() {
        initComponents();

        setExtendedState(JFrame.MAXIMIZED_BOTH);
//        setSize(1280, 900); //seting the window size to 1280x900 p 
//        setLocationRelativeTo(null);
        setLayout(null);
        java.awt.EventQueue.invokeLater(() ->{
            show(position);
            play();
            StartAfterDelay();
            
        });
    }
    
    private void show(int index) {
        //check wheather the array is empty or not
        if (Images.length == 0 || index >= Images.length) {
            System.out.println("No images to show");
            return ;
        }
        
        String img = Images[index];
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagepath/"+ img));
        Image image = icon.getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
        frame.setIcon(new ImageIcon(image)); // set the icon to fill the frame
        
    }

    private void play() {
    
        //timer for 2sec for each picture in the slide show
        timer = new Timer(2000, e ->{
            position++;
            if (position >= Images.length) {
                position = 0;
            }
            show(position);
        });
        timer.start();
        
    }

    private void StartAfterDelay() {
        
        //making the delay that causes the authentication window to fade in after 2 seconds
        Timer delay = new Timer(2000, e -> {
            fadeInWindow();
            
        });
        delay.setRepeats(false);
        delay.start();
    
    }
    
    private void fadeInWindow() {
        
        //this function is responsible for the fade in  animation 
        AuthenticationWindow auth = new AuthenticationWindow(this);
        auth.setOpacity(0f);
        auth.setVisible(true);
        
        new Thread(() -> {
          try{
              for(float i=0;i<=0.85f;i+=0.05f){
                  Thread.sleep(50);
                  auth.setOpacity(i);
              }
          }catch(InterruptedException ex){
              ex.printStackTrace();
          }
        }).start();
    
    }


    class AuthenticationWindow extends JFrame{

        public AuthenticationWindow(SplashScreen splashScreen) {

            setUndecorated(true);
            setTitle("Authentication");
            setSize(500, 300);
            setLocationRelativeTo(null);
            setOpacity(0.95f);
            setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 40, 40)); 

            
            JPanel panel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D g2d = (Graphics2D) g;
                    GradientPaint gradient = new GradientPaint(0, 0, new Color(0, 0, 0, 150), 0, getHeight(), new Color(0, 0, 0, 200));
                    g2d.setPaint(gradient);
                    g2d.fillRect(0, 0, getWidth(), getHeight());
                }
            };
            panel.setLayout(new GridBagLayout());
            panel.setOpaque(false);

            
            JLabel text = new JLabel("TOURIST MANAGEMENT SYSTEM", JLabel.CENTER);
            JLabel text1 = new JLabel("Welcome to Sri Lanka", JLabel.CENTER);
            JButton login = new JButton("LOG IN");
            JButton signup = new JButton("SIGN UP");

            
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 20, 10, 20);
            gbc.gridx = 0;
            gbc.fill = GridBagConstraints.HORIZONTAL;

           
            text.setForeground(Color.WHITE);
            text.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
            gbc.gridy = 0;
            panel.add(text, gbc);

            text1.setForeground(Color.WHITE);
            text1.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
            gbc.gridy = 1;
            panel.add(text1, gbc);

            
            login.setForeground(Color.WHITE);
            login.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
            login.setBackground(new Color(0, 123, 255)); 
            login.setFocusPainted(false);
            login.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            login.setCursor(new Cursor(Cursor.HAND_CURSOR));
            login.setPreferredSize(new Dimension(200, 40));

            gbc.gridy = 2;
            panel.add(login, gbc);
            login.addActionListener(e -> {
                new login.LoginPage().setVisible(true);
                this.dispose();
                splashScreen.setVisible(false);
            });

            
            signup.setForeground(Color.WHITE);
            signup.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
            signup.setBackground(new Color(40, 167, 69)); 
            signup.setFocusPainted(false);
            signup.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            signup.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
            signup.setPreferredSize(new Dimension(200, 40));

            gbc.gridy = 3;
            panel.add(signup, gbc);
            signup.addActionListener(e -> {
                new login.SignUpPage().setVisible(true);
                this.dispose();
                splashScreen.setVisible(false);
            });

            add(panel);

        }


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frame = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        frame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/desktopapplication/orange_sky.jpg"))); // NOI18N
        getContentPane().add(frame, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() ->{
            new SplashScreen().setVisible(true);
        });
        
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel frame;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

   
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package destination.ui;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;


public class ViewDetails extends javax.swing.JFrame {

private class GradientPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        

        Color color1 = Color.decode("#5b247a");
        Color color2 = Color.decode("#1bcedf");
        
        GradientPaint gp = new GradientPaint(0, 0, color1, 0, height, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, width, height);
    }
}

    public ViewDetails() {
        initComponents();
         SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                startSlideshow(); // Now starts after the GUI is shown
    }
});

    }
    
     private Timer timer;
    
    private int imageIndex = 0;
    
    private String[] imageUnawatuna = {
        "/images/unawatuna/u2.jpg",
        "/images/unawatuna/u3.jpg",
        "/images/unawatuna/u1.jpg",
        "/images/unawatuna/u4.jpg"
    };
    
    private String[] imageNilaveli = {
       "/images/nilaveli/n1.jpg",
       "/images/nilaveli/n2.jpg",
       "/images/nilaveli/n3.jpg",
       "/images/nilaveli/n4.jpg"
    };
    
    private String[] imageMirissa = {
        "/images/mirissa/m2.jpg",
        "/images/mirissa/m3.jpg",
        "/images/mirissa/m1.jpg",
        "/images/mirissa/m4.jpg"
    };
    
    private String[] imageArugam = {
        "/images/arugam/a2.jpg",
        "/images/arugam/a3.jpg",
        "/images/arugam/a1.jpg",
        "/images/arugam/a4.jpg"
    };
    
   private void startSlideshow() {
    showImage(); // show the first image right away

    timer = new Timer(3000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            imageIndex = (imageIndex + 1) % 4;
            showImage();
        }
    });
    timer.start();
}

   private void showImage() {
    ImageIcon icon = null;
    
    if (namelbl.getText().equalsIgnoreCase("unawatuna beach")) {
        icon = new ImageIcon(getClass().getResource(imageUnawatuna[imageIndex]));
    } else if (namelbl.getText().equalsIgnoreCase("nilaveli beach")) {
        icon = new ImageIcon(getClass().getResource(imageNilaveli[imageIndex]));
    } else if (namelbl.getText().equalsIgnoreCase("arugam bay")) {
        icon = new ImageIcon(getClass().getResource(imageArugam[imageIndex]));
    } else if (namelbl.getText().equalsIgnoreCase("mirissa beach")) {
        icon = new ImageIcon(getClass().getResource(imageMirissa[imageIndex]));
    }

    if (icon != null) {
        Image scaledImage = icon.getImage().getScaledInstance(slideshowLbl.getWidth(), slideshowLbl.getHeight(), Image.SCALE_SMOOTH);
        slideshowLbl.setIcon(new ImageIcon(scaledImage));
    }
    
    slideshowLbl.revalidate();
slideshowLbl.repaint();

}





 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new GradientPanel();
        slideshowLbl = new javax.swing.JLabel();
        namelbl = new javax.swing.JLabel();
        bookinglbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionlbl = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        activitieslbl = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        weatherbtn = new javax.swing.JButton();
        backbtn = new javax.swing.JButton();
        bookbtn = new javax.swing.JButton();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Destination");
        setBackground(new java.awt.Color(44, 62, 80));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        slideshowLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        slideshowLbl.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        slideshowLbl.setPreferredSize(new java.awt.Dimension(400, 300));
        jPanel2.add(slideshowLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 67, 390, -1));

        namelbl.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        namelbl.setForeground(new java.awt.Color(204, 204, 255));
        namelbl.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel2.add(namelbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 410, 50));

        bookinglbl.setForeground(new java.awt.Color(0, 51, 102));
        bookinglbl.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel2.add(bookinglbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 400, 174, 20));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);

        descriptionlbl.setEditable(false);
        descriptionlbl.setBackground(new java.awt.Color(0, 0, 0,0));
        descriptionlbl.setColumns(20);
        descriptionlbl.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        descriptionlbl.setForeground(new java.awt.Color(204, 204, 255));
        descriptionlbl.setLineWrap(true);
        descriptionlbl.setRows(5);
        descriptionlbl.setWrapStyleWord(true);
        descriptionlbl.setBorder(null);
        descriptionlbl.setDisabledTextColor(new java.awt.Color(242, 242, 242));
        descriptionlbl.setFocusable(false);
        descriptionlbl.setOpaque(false);
        jScrollPane1.setViewportView(descriptionlbl);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, 280, 310));

        jScrollPane2.getViewport().setOpaque(false);
        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jScrollPane2.setOpaque(false);

        activitieslbl.setEditable(false);
        activitieslbl.setColumns(20);
        activitieslbl.setBackground(new java.awt.Color(0, 0, 0, 0));
        activitieslbl.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        activitieslbl.setForeground(new java.awt.Color(0, 51, 102));
        activitieslbl.setLineWrap(true);
        activitieslbl.setRows(5);
        activitieslbl.setWrapStyleWord(true);
        activitieslbl.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        activitieslbl.setFocusable(false);
        activitieslbl.setOpaque(false);
        jScrollPane2.setViewportView(activitieslbl);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, 290, 130));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setText("Activities : ");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, 110, -1));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 102));
        jLabel2.setText("Bookings :");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 400, -1, -1));

        weatherbtn.setBackground(new java.awt.Color(0, 51, 51));
        weatherbtn.setForeground(new java.awt.Color(255, 255, 255));
        weatherbtn.setText(" Check Weather");
        jPanel2.add(weatherbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 540, -1, -1));

        backbtn.setBackground(new java.awt.Color(0, 51, 51));
        backbtn.setForeground(new java.awt.Color(255, 255, 255));
        backbtn.setText("Back");
        backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbtnActionPerformed(evt);
            }
        });
        jPanel2.add(backbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 540, -1, -1));

        bookbtn.setBackground(new java.awt.Color(0, 51, 51));
        bookbtn.setForeground(new java.awt.Color(255, 255, 255));
        bookbtn.setText("Book");
        bookbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookbtnActionPerformed(evt);
            }
        });
        jPanel2.add(bookbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 540, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed
        dispose();
    }//GEN-LAST:event_backbtnActionPerformed

    private void bookbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookbtnActionPerformed
        Book book =new Book(namelbl.getText());
        book.setVisible(true);
    }//GEN-LAST:event_bookbtnActionPerformed

   
    public static void main(String args[]) {
     
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException error) {
            System.out.println(error.getMessage());
        } catch (InstantiationException error) {
            System.out.println(error.getMessage());
        } catch (IllegalAccessException error) {
            System.out.println(error.getMessage());
        } catch (javax.swing.UnsupportedLookAndFeelException error) {
            System.out.println(error.getMessage());
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewDetails().setVisible(true);
            }
        });
    }
    
    public void setInformation(String name,String description,int bookings,String Activities){
        namelbl.setText(name);
        descriptionlbl.setText(description);
        bookinglbl.setText( Integer.toString(bookings));
        activitieslbl.setText(Activities);
    }
    



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea activitieslbl;
    private javax.swing.JButton backbtn;
    private javax.swing.JButton bookbtn;
    private javax.swing.JLabel bookinglbl;
    private javax.swing.JTextArea descriptionlbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel namelbl;
    private javax.swing.JLabel slideshowLbl;
    private javax.swing.JButton weatherbtn;
    // End of variables declaration//GEN-END:variables
}

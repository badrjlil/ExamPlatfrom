package main;

import etudiantInterfaces.loginE;
import ensignantIterfaces.loginP;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Home extends javax.swing.JFrame {
    String imagesPath = System.getProperty("user.dir") + "\\images";
    public Home() {
        look();
        initComponents();
        setSize(725, 450); 
        this.setLocationRelativeTo(null);
        Image img = new ImageIcon(imagesPath + "\\Teacher.png").getImage();
        img = img.getScaledInstance(iconLabelProf.getWidth(), iconLabelProf.getHeight(), Image.SCALE_AREA_AVERAGING);
        iconLabelProf.setIcon(new ImageIcon(img));
        img = new ImageIcon(imagesPath + "\\Student.png").getImage();
        img = img.getScaledInstance(iconLabelProf.getWidth(), iconLabelProf.getHeight(), Image.SCALE_AREA_AVERAGING);
        iconLabelEtud.setIcon(new ImageIcon(img));
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        iconLabelEtud = new javax.swing.JLabel();
        iconLabelProf = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        loginProf = new javax.swing.JButton();
        loginEtud = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        iconLabelEtud.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(iconLabelEtud);
        iconLabelEtud.setBounds(404, 79, 150, 150);

        iconLabelProf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(iconLabelProf);
        iconLabelProf.setBounds(143, 79, 150, 150);

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Espace d'ensignant");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(168, 241, 101, 16);

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Espace d'étudiant");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(434, 241, 93, 16);

        loginProf.setText("Se connecter");
        loginProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginProfActionPerformed(evt);
            }
        });
        getContentPane().add(loginProf);
        loginProf.setBounds(167, 294, 102, 27);

        loginEtud.setText("Se connecter");
        loginEtud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginEtudActionPerformed(evt);
            }
        });
        getContentPane().add(loginEtud);
        loginEtud.setBounds(434, 294, 102, 27);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\P3dR0\\Downloads\\Download Technology Background Design in White Color for free.jpg")); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 710, 430);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginProfActionPerformed
        new loginP().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_loginProfActionPerformed

    private void loginEtudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginEtudActionPerformed
        new loginE().setVisible(true);
    }//GEN-LAST:event_loginEtudActionPerformed

    private void look(){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]) {

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel iconLabelEtud;
    private javax.swing.JLabel iconLabelProf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton loginEtud;
    private javax.swing.JButton loginProf;
    // End of variables declaration//GEN-END:variables
}

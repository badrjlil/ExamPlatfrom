package ensignantIterfaces;

import ensignantIterfaces.dashboard;
import java.sql.*;
import javax.swing.JOptionPane;
import main.Home;
import main.connection;

public class loginP extends javax.swing.JFrame {

    public loginP() {
        initComponents();
        look();
        setSize(757, 450); 
        this.setLocationRelativeTo(null);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        connecter = new javax.swing.JButton();
        mdp = new javax.swing.JPasswordField();
        back = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 0));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Authentification du professeur");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(200, 30, 342, 31);

        jLabel2.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 255));
        jLabel2.setText("Email");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(150, 130, 60, 17);

        jLabel3.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 255));
        jLabel3.setText("Mot de passe");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(140, 200, 100, 17);

        email.setBackground(new java.awt.Color(255, 255, 255));
        email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(email);
        email.setBounds(260, 130, 356, 18);

        connecter.setBackground(new java.awt.Color(51, 255, 0));
        connecter.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        connecter.setForeground(new java.awt.Color(255, 255, 255));
        connecter.setText("Se connecter");
        connecter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connecterActionPerformed(evt);
            }
        });
        getContentPane().add(connecter);
        connecter.setBounds(590, 300, 120, 31);

        mdp.setBackground(new java.awt.Color(255, 255, 255));
        mdp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(mdp);
        mdp.setBounds(260, 190, 356, 18);

        back.setText("retour");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back);
        back.setBounds(600, 350, 114, 27);

        jLabel4.setForeground(new java.awt.Color(0, 51, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\P3dR0\\Downloads\\Download White background with Blue Geometric and white line pattern for free.jpg")); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 740, 410);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void connecterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connecterActionPerformed
        try{
            Statement request = connection.connectDB().createStatement();
            ResultSet r = request.executeQuery("SELECT id, prenom, nom FROM enseignant "
                    + "WHERE email = '" + email.getText() + "' "
                    + "AND motDePasse = '" + String.valueOf(mdp.getPassword()) +"'");
            if(r.next()){
                new dashboard(r.getInt(1), r.getString(2), r.getString(3)).setVisible(true);
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(this, "L'émail ou le mot de passe est incorrect, réssayer");
            }
        }catch(Exception e){
            e.getStackTrace();
        }
        
    }//GEN-LAST:event_connecterActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        this.dispose();
        new Home().setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void look(){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(loginP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]) {
        

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton connecter;
    private javax.swing.JTextField email;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField mdp;
    // End of variables declaration//GEN-END:variables
}

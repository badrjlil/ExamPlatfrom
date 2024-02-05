package etudiantInterfaces;

import ensignantIterfaces.*;
import ensignantIterfaces.gestionMatieres;
import ensignantIterfaces.planificateurExamen;
import ensignantIterfaces.listeEtudiants;
import ensignantIterfaces.assocMatClasse;
import main.Home;

public class dashboardE extends javax.swing.JFrame {

    int idEtudiant;
    String prenom, nom;

    public dashboardE(int idEtd, String prenom, String nom) {
        this.idEtudiant = idEtd;
        this.prenom = prenom;
        this.nom = nom;
        initComponents();
         this.setSize(740, 410);
        look();
        this.setLocationRelativeTo(null);
        welcomeLabel.setText(welcomeLabel.getText() + " " + prenom + " " + nom);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        welcomeLabel = new javax.swing.JLabel();
        logOut = new javax.swing.JButton();
        logOut1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jButton1.setText("Planification des éxamens");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(120, 130, 229, 74);

        jButton4.setText("Passer un éxamens");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(432, 125, 229, 74);

        welcomeLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        welcomeLabel.setForeground(new java.awt.Color(255, 255, 255));
        welcomeLabel.setText("Bonjour");
        getContentPane().add(welcomeLabel);
        welcomeLabel.setBounds(170, 30, 520, 48);

        logOut.setText("Se déconnecter");
        logOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutActionPerformed(evt);
            }
        });
        getContentPane().add(logOut);
        logOut.setBounds(420, 340, 132, 23);

        logOut1.setText("Quitter");
        logOut1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOut1ActionPerformed(evt);
            }
        });
        getContentPane().add(logOut1);
        logOut1.setBounds(580, 340, 132, 23);

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\Downloads\\Cool Simple Blue Backgrounds.jpg")); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 740, 410);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logOut1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOut1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_logOut1ActionPerformed

    private void logOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutActionPerformed
        this.dispose();
        new Home().setVisible(true);
    }//GEN-LAST:event_logOutActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
            new examen().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        new PlanExam(idEtudiant).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    public void look() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(dashboardE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dashboardE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dashboardE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dashboardE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dashboardE(1, "test", "test").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton logOut;
    private javax.swing.JButton logOut1;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}

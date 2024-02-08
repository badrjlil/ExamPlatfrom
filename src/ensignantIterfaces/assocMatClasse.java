package ensignantIterfaces;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import main.connection;

public class assocMatClasse extends javax.swing.JFrame {

    private int idEnseignant;

    public assocMatClasse(int idEns) {
        this.idEnseignant = idEns;
        initComponents();
        look();
        setSize(564, 392); 
        this.setLocationRelativeTo(null);
        populateSubjectDropdown();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        classComb = new javax.swing.JComboBox<>();
        matComb = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        assocButton = new javax.swing.JButton();
        quit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(classComb);
        classComb.setBounds(294, 119, 184, 26);

        matComb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                matCombItemStateChanged(evt);
            }
        });
        getContentPane().add(matComb);
        matComb.setBounds(71, 119, 184, 26);

        jLabel2.setForeground(new java.awt.Color(0, 153, 255));
        jLabel2.setText("Classe:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(303, 97, 36, 16);

        jLabel3.setForeground(new java.awt.Color(0, 153, 255));
        jLabel3.setText("Matiére:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(79, 97, 43, 16);

        assocButton.setBackground(new java.awt.Color(0, 102, 0));
        assocButton.setText("Assoccier");
        assocButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assocButtonActionPerformed(evt);
            }
        });
        getContentPane().add(assocButton);
        assocButton.setBounds(203, 192, 148, 27);

        quit.setBackground(new java.awt.Color(255, 0, 51));
        quit.setText("Quitter");
        quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitActionPerformed(evt);
            }
        });
        getContentPane().add(quit);
        quit.setBounds(390, 300, 148, 27);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\P3dR0\\Downloads\\gg.jpg")); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 570, 380);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void populateSubjectDropdown() {
        matComb.removeAllItems();
        try {
            Statement stmt = connection.connectDB().createStatement();
            String sql = "SELECT m.id, m.nom FROM matiere m "
                    + "WHERE m.enseignant_id = " + this.idEnseignant;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String subjectInfo = rs.getInt("id") + " - " + rs.getString("nom");
                matComb.addItem(subjectInfo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void populateClassDropdown(String a) {
        classComb.removeAllItems();
        try {
            Statement stmt = connection.connectDB().createStatement();
            String sql = "SELECT c.id, c.niveau FROM classe c "
                    + "WHERE NOT EXISTS ( "
                    + "    SELECT * FROM matiere_classe mc "
                    + "    WHERE mc.class_id = c.id "
                    + "    AND mc.matiere_id = " + a
                    + ")";

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String classInfo = rs.getInt("id") + " - " + rs.getString("niveau");
                classComb.addItem(classInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void assocButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assocButtonActionPerformed
        String a[] = String.valueOf(matComb.getSelectedItem()).split("-");
        String b[] = String.valueOf(classComb.getSelectedItem()).split("-");
        try {
            Statement stmt = connection.connectDB().createStatement();
            String sql = "INSERT INTO matiere_classe VALUES("
                    + b[0] + "," + a[0]
                    + ")";
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(this, "Matiére associée avecc success");
            populateSubjectDropdown();
        } catch (Exception e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_assocButtonActionPerformed

    private void matCombItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_matCombItemStateChanged
        String a[] = String.valueOf(matComb.getSelectedItem()).split("-");
        populateClassDropdown(a[0]);
    }//GEN-LAST:event_matCombItemStateChanged

    private void quitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitActionPerformed
        this.dispose();
    }//GEN-LAST:event_quitActionPerformed

    public void look() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new assocMatClasse(1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assocButton;
    private javax.swing.JComboBox<String> classComb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox<String> matComb;
    private javax.swing.JButton quit;
    // End of variables declaration//GEN-END:variables
}

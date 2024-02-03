package interfaces;

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        matComb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                matCombItemStateChanged(evt);
            }
        });

        jLabel2.setText("Classe:");

        jLabel3.setText("Matiére:");

        assocButton.setText("Assoccier");
        assocButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assocButtonActionPerformed(evt);
            }
        });

        quit.setText("Quitter");
        quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(matComb, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(classComb, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel2)
                        .addGap(139, 139, 139)))
                .addGap(86, 86, 86))
            .addGroup(layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(assocButton, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(quit, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(classComb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(matComb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47)
                .addComponent(assocButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addComponent(quit)
                .addGap(25, 25, 25))
        );

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
            java.util.logging.Logger.getLogger(dashEnseignant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dashEnseignant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dashEnseignant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dashEnseignant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new assocMatClasse(1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assocButton;
    private javax.swing.JComboBox<String> classComb;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox<String> matComb;
    private javax.swing.JButton quit;
    // End of variables declaration//GEN-END:variables
}

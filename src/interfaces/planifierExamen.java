package interfaces;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
import main.connection;

public class planifierExamen extends javax.swing.JFrame {

    int idEnseignant;
    private String classe, matiere;
    private int duree;
    java.sql.Date date;

    public planifierExamen(int idEns) {
        this.idEnseignant = idEns;
        look();
        initComponents();
        this.setLocationRelativeTo(null);
        populateSubjectDropdown();
    }

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
                    + "JOIN matiere_classe mc ON mc.class_id = c.id "
                    + "WHERE mc.matiere_id = " + a;

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String classInfo = rs.getInt("id") + " - " + rs.getString("niveau");
                classComb.addItem(classInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        matComb = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        classComb = new javax.swing.JComboBox<>();
        dateText = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        dureeValue = new javax.swing.JSlider();
        heureLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Matiére :");

        matComb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                matCombItemStateChanged(evt);
            }
        });

        jLabel2.setText("Classe: ");

        classComb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                classCombItemStateChanged(evt);
            }
        });

        dateText.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateTextPropertyChange(evt);
            }
        });

        jLabel3.setText("Date: ");

        jLabel4.setText("Durée:");

        jButton1.setText("Planifier l'examen");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        dureeValue.setMaximum(180);
        dureeValue.setMinimum(5);
        dureeValue.setToolTipText("");
        dureeValue.setValue(0);
        dureeValue.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                dureeValueStateChanged(evt);
            }
        });

        heureLabel.setText("0 minutes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(matComb, 0, 170, Short.MAX_VALUE)
                            .addComponent(classComb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel4)
                        .addGap(27, 27, 27)
                        .addComponent(dureeValue, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(heureLabel)))
                .addContainerGap(62, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(matComb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(classComb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(dureeValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(heureLabel)))
                .addGap(93, 93, 93)
                .addComponent(jButton1)
                .addContainerGap(128, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void matCombItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_matCombItemStateChanged
        String a[] = String.valueOf(matComb.getSelectedItem()).split("-");
        matiere = a[0].replace(" ", "");
        populateClassDropdown(a[0]);
    }//GEN-LAST:event_matCombItemStateChanged

    private void dateTextPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateTextPropertyChange
        Date dateValue = dateText.getDate();
        if (dateValue != null) {
            date = new java.sql.Date(dateValue.getTime());
        }

    }//GEN-LAST:event_dateTextPropertyChange

    private void dureeValueStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_dureeValueStateChanged
        heureLabel.setText(dureeValue.getValue() + " minutes");
        duree = dureeValue.getValue();
    }//GEN-LAST:event_dureeValueStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (matiere.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Veuillez d’abord choisir le sujet");
        } else if (classe.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Veuillez choisir la classe en premier");
        } else if (date == null) {
            JOptionPane.showMessageDialog(this, "Veuillez choisir la date d'examen");
        } else if (duree == 0) {
            JOptionPane.showMessageDialog(this, "Veuillez choisir la duree");
        } else {
            new formulaire_prof(idEnseignant, Integer.parseInt(matiere), Integer.parseInt(classe), duree, String.valueOf(date)).setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void classCombItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_classCombItemStateChanged
        String a[] = String.valueOf(classComb.getSelectedItem()).split("-");
        classe = a[0].replace(" ", "");
    }//GEN-LAST:event_classCombItemStateChanged

    public void look() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(planifierExamen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(planifierExamen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(planifierExamen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(planifierExamen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new planifierExamen(1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> classComb;
    private com.toedter.calendar.JDateChooser dateText;
    private javax.swing.JSlider dureeValue;
    private javax.swing.JLabel heureLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JComboBox<String> matComb;
    // End of variables declaration//GEN-END:variables
}

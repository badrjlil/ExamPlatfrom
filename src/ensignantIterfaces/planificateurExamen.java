package ensignantIterfaces;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
import main.connection;

public class planificateurExamen extends javax.swing.JFrame {

    int idEnseignant;
    private String classe, matiere;
    private int duree;
    java.sql.Date date;

    public planificateurExamen(int idEns) {
        this.idEnseignant = idEns;
        look();
        initComponents();
       setSize(725, 450); 
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
        quit = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setText("Matiére :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(223, 67, 46, 16);

        matComb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                matCombItemStateChanged(evt);
            }
        });
        getContentPane().add(matComb);
        matComb.setBounds(302, 62, 170, 26);

        jLabel2.setForeground(new java.awt.Color(0, 102, 255));
        jLabel2.setText("Classe: ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(223, 119, 39, 16);

        classComb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                classCombItemStateChanged(evt);
            }
        });
        getContentPane().add(classComb);
        classComb.setBounds(302, 114, 170, 26);

        dateText.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateTextPropertyChange(evt);
            }
        });
        getContentPane().add(dateText);
        dateText.setBounds(164, 185, 204, 26);

        jLabel3.setForeground(new java.awt.Color(0, 102, 255));
        jLabel3.setText("Date: ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(116, 185, 30, 16);

        jLabel4.setForeground(new java.awt.Color(0, 102, 255));
        jLabel4.setText("Durée:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(404, 187, 34, 16);

        jButton1.setBackground(new java.awt.Color(0, 153, 0));
        jButton1.setText("Planifier l'examen");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(465, 304, 170, 27);

        dureeValue.setMaximum(180);
        dureeValue.setMinimum(5);
        dureeValue.setToolTipText("");
        dureeValue.setValue(0);
        dureeValue.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                dureeValueStateChanged(evt);
            }
        });
        getContentPane().add(dureeValue);
        dureeValue.setBounds(465, 185, 153, 22);

        heureLabel.setForeground(new java.awt.Color(0, 102, 255));
        heureLabel.setText("0 minutes");
        getContentPane().add(heureLabel);
        heureLabel.setBounds(520, 210, 52, 16);

        quit.setBackground(new java.awt.Color(255, 0, 51));
        quit.setText("Annuler");
        quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitActionPerformed(evt);
            }
        });
        getContentPane().add(quit);
        quit.setBounds(465, 349, 170, 27);

        jLabel5.setForeground(new java.awt.Color(0, 51, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\P3dR0\\Downloads\\Download White background with Blue Geometric and white line pattern for free.jpg")); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 740, 410);

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
            new questionnaire(idEnseignant, Integer.parseInt(matiere), Integer.parseInt(classe), duree, String.valueOf(date)).setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void classCombItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_classCombItemStateChanged
        String a[] = String.valueOf(classComb.getSelectedItem()).split("-");
        classe = a[0].replace(" ", "");
    }//GEN-LAST:event_classCombItemStateChanged

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
            java.util.logging.Logger.getLogger(planificateurExamen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(planificateurExamen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(planificateurExamen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(planificateurExamen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new planificateurExamen(1).setVisible(true);
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JComboBox<String> matComb;
    private javax.swing.JButton quit;
    // End of variables declaration//GEN-END:variables
}

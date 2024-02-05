package ensignantIterfaces;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import main.connection;

public class gestionMatieres extends javax.swing.JFrame {

    private DefaultTableModel tableModel;
    int idEns;

    public gestionMatieres(int idEns) {
         this.setSize(740, 410);
        this.idEns = idEns;
        initComponents();
        this.setLocationRelativeTo(null);
        refreshAffichage();
    }

    private void refreshAffichage() {
        try {
            Statement request = connection.connectDB().createStatement();
            ResultSet r = request.executeQuery("SELECT * FROM matiere WHERE enseignant_id = " + idEns);
            String[] columnNames = {"Id", "Nom"};
            tableModel = new DefaultTableModel(columnNames, 0);
            jTable1.setModel(tableModel);
            jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            while (r.next()) {
                Object[] rowData = {r.getInt(1), r.getString(2)};
                tableModel.addRow(rowData);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nv_matiere = new javax.swing.JTextField();
        suppMat = new javax.swing.JButton();
        ajoutMat = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        quit = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestion des matières");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(180, 10, 342, 35);

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jLabel4.setText("Liste des matiéres :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 60, 120, 16);

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jLabel3.setText("Ajouter une matiére :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(371, 80, 130, 16);
        getContentPane().add(nv_matiere);
        nv_matiere.setBounds(510, 80, 201, 22);

        suppMat.setBackground(new java.awt.Color(255, 0, 0));
        suppMat.setForeground(new java.awt.Color(242, 242, 242));
        suppMat.setText("Supprimer");
        suppMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suppMatActionPerformed(evt);
            }
        });
        getContentPane().add(suppMat);
        suppMat.setBounds(256, 329, 85, 23);

        ajoutMat.setBackground(new java.awt.Color(51, 255, 0));
        ajoutMat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ajoutMat.setForeground(new java.awt.Color(255, 255, 255));
        ajoutMat.setText("Ajouter");
        ajoutMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajoutMatActionPerformed(evt);
            }
        });
        getContentPane().add(ajoutMat);
        ajoutMat.setBounds(630, 110, 80, 27);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(33, 92, 308, 225);

        quit.setText("Quitter");
        quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitActionPerformed(evt);
            }
        });
        getContentPane().add(quit);
        quit.setBounds(600, 360, 128, 38);

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\Downloads\\Pastel Light Blue Wallpaper High Resolution.jpg")); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 740, 410);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ajoutMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajoutMatActionPerformed
        //Matiere m = new Matiere(nv_matiere.getText(), ens);
        try {
            Statement req = connection.connectDB().createStatement();
            req.executeUpdate("INSERT INTO matiere (nom, enseignant_id) VALUES('"
                    + nv_matiere.getText() + "', " + idEns
                    + ")");
            JOptionPane.showMessageDialog(this, "Matière ajoutée avec success");
            nv_matiere.setText("");
            refreshAffichage();

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_ajoutMatActionPerformed

    private void quitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitActionPerformed
        this.dispose();
    }//GEN-LAST:event_quitActionPerformed

    private void suppMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suppMatActionPerformed
        int rowIndice = -1;
        rowIndice = jTable1.getSelectedRow();
        if (rowIndice != -1) {
            try {

                Statement req = connection.connectDB().createStatement();
                req.executeUpdate("DELETE FROM matiere WHERE id = " + (int) tableModel.getValueAt(rowIndice, 0));
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
        refreshAffichage();

    }//GEN-LAST:event_suppMatActionPerformed

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(gestionMatieres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gestionMatieres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gestionMatieres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gestionMatieres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new gestionMatieres().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajoutMat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nv_matiere;
    private javax.swing.JButton quit;
    private javax.swing.JButton suppMat;
    // End of variables declaration//GEN-END:variables
}

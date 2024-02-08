package ensignantIterfaces;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import main.connection;

public class listeEtudiants extends javax.swing.JFrame {

    int idEnseignant;
    private DefaultTableModel tableModel;

    public listeEtudiants(int idEns) {
        this.idEnseignant = idEns;
        look();
        initComponents();
        
        setSize(655, 530); 
        this.setLocationRelativeTo(null);
        String defaultSQL = "SELECT e.id, e.prenom, e.nom, e.email, c.niveau FROM etudiant e "
                + "JOIN classe c ON e.classe_id = c.id "
                + "JOIN matiere_classe mc ON c.id = mc.class_id "
                + "WHERE mc.matiere_id IN (SELECT id FROM matiere WHERE enseignant_id = " + idEnseignant + ")";
        refreshAffichage(defaultSQL);
        //populateClassDropdown();
        //populateSubjectDropdown();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        quit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

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
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 140, 510, 290);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 204));
        jLabel1.setText("Liste des étudiants associées");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 30, 304, 32);

        quit.setBackground(new java.awt.Color(255, 0, 51));
        quit.setText("Quitter");
        quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitActionPerformed(evt);
            }
        });
        getContentPane().add(quit);
        quit.setBounds(500, 450, 135, 27);

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\P3dR0\\Downloads\\Ppt Clipart Transparent PNG Hd, Blue Ppt Template, Blue, Template, Background PNG Image For Free Download.jpg")); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, -20, 660, 520);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void quitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitActionPerformed
        this.dispose();
    }//GEN-LAST:event_quitActionPerformed

    private void refreshAffichage(String sql) {
        try {
            Statement request = connection.connectDB().createStatement();
            ResultSet r = request.executeQuery(sql);
            String[] columnNames = {"Id", "Prnom", "Nom", "email", "Niveau"};
            tableModel = new DefaultTableModel(columnNames, 0);
            jTable1.setModel(tableModel);
            jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            while (r.next()) {
                Object[] rowData = {r.getInt(1), r.getString(2), r.getString(3), r.getString(4), r.getString(5)};
                tableModel.addRow(rowData);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

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
                new listeEtudiants(1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton quit;
    // End of variables declaration//GEN-END:variables
}

package ensignantIterfaces;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import main.connection;

public class questionnaire extends javax.swing.JFrame {

    private int idEnseignant, classe, matiere, duree, generatedExamenId = -1;
    private String date;
    private DefaultListModel<String> suggestionListModel = new DefaultListModel<>();
    private Map<String, Integer> questions = new HashMap<>();

    public questionnaire(int idEns, int matiere, int classe, int duree, String date) {
        this.idEnseignant = idEns;
        this.matiere = matiere;
        this.classe = classe;
        this.duree = duree;
        this.date = date;
        initComponents();
         this.setSize(740, 410);
        this.setLocationRelativeTo(null);
    }

    public questionnaire() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private void addSuggestionToList() {
        String suggestionText = suggestion.getText();
        if (!suggestionText.isEmpty()) {
            suggestionListModel.addElement(suggestionText);
            suggestionList.setModel(suggestionListModel);
            suggestion.setText("");  // Clear the text field after adding suggestion
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        question = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        suggestion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        suggestionList = new javax.swing.JList<>();
        reponse = new javax.swing.JTextField();
        ajouterSuggestion = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(242, 242, 242));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Formulaire du professeur ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(210, 10, 342, 35);

        jLabel2.setText("Entrez votre questions ici s'il vous plait :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 50, 208, 16);

        question.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        question.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionActionPerformed(evt);
            }
        });
        getContentPane().add(question);
        question.setBounds(140, 70, 480, 26);

        jLabel3.setText("Entrez les suggestions de cette question :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 120, 215, 16);

        jLabel4.setText("Suggestion :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(90, 150, 65, 16);
        getContentPane().add(suggestion);
        suggestion.setBounds(160, 150, 330, 22);

        jLabel5.setText("Entrer la réponse correcte de ce question : ");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 340, 223, 16);

        jButton1.setText("Valider et ajouter une nouvelle question");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(160, 390, 289, 23);

        jButton2.setBackground(new java.awt.Color(0, 51, 255));
        jButton2.setForeground(new java.awt.Color(242, 242, 242));
        jButton2.setText("Terminer");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(610, 390, 110, 37);

        jScrollPane1.setViewportView(suggestionList);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(130, 180, 460, 142);
        getContentPane().add(reponse);
        reponse.setBounds(270, 340, 450, 22);

        ajouterSuggestion.setText("Ajouter");
        ajouterSuggestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterSuggestionActionPerformed(evt);
            }
        });
        getContentPane().add(ajouterSuggestion);
        ajouterSuggestion.setBounds(500, 180, 72, 23);

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\Downloads\\Pastel Light Blue Wallpaper High Resolution.jpg")); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, -50, 780, 560);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void questionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_questionActionPerformed

    private void ajouterSuggestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterSuggestionActionPerformed
        addSuggestionToList();
    }//GEN-LAST:event_ajouterSuggestionActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String qst = question.getText();
        String rep = reponse.getText();
        int generatedQuestionId;

        if (qst.isEmpty() && rep.isEmpty() && suggestionListModel.size() == 0) {
            JOptionPane.showMessageDialog(this, "Remplir toutes les champs");
        } else {
            if (generatedExamenId == -1) {
                try {
                    Connection c = connection.connectDB();
                    String insertQuery = "INSERT INTO examen (date, duree, matiereid, classeid) VALUES (?, ?, ?, ?)";
                    try (PreparedStatement stmt = c.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
                        stmt.setString(1, date);
                        stmt.setInt(2, duree);
                        stmt.setInt(3, matiere);
                        stmt.setInt(4, classe);
                        stmt.executeUpdate();
                        ResultSet generatedKeys = stmt.getGeneratedKeys();
                        generatedKeys.next();
                        int generatedId = generatedKeys.getInt(1);
                        this.generatedExamenId = generatedId;
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

            try {
                String query = "INSERT INTO question (question, reponse, examen_id) VALUES (?, ?, ?)";
                PreparedStatement stmt = connection.connectDB().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, qst);
                stmt.setString(2, rep);
                stmt.setInt(3, generatedExamenId);
                stmt.executeUpdate();
                ResultSet r = stmt.getGeneratedKeys();
                r.next();
                generatedQuestionId = r.getInt(1);
                for (int i = 0; i < suggestionListModel.getSize(); i++) {
                    query = "INSERT INTO question_reponses VALUES( ?,?)";
                    stmt = connection.connectDB().prepareStatement(query);
                    stmt.setInt(1, generatedQuestionId);
                    stmt.setString(2, suggestionListModel.get(i));
                    stmt.executeUpdate();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            question.setText("");
            suggestionListModel.removeAllElements();
            reponse.setText("");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(questionnaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(questionnaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(questionnaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(questionnaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new formulaire_prof(1, 11, 1, 50, "2024-02-20").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajouterSuggestion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField question;
    private javax.swing.JTextField reponse;
    private javax.swing.JTextField suggestion;
    private javax.swing.JList<String> suggestionList;
    // End of variables declaration//GEN-END:variables
}

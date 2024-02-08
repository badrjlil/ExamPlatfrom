package etudiantInterfaces;

import java.awt.Color;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import main.connection;

public class examen extends javax.swing.JFrame {

    private int examenID, idEtud, matiereID;
    private int totalQuestions;
    private Timer countdownTimer;
    private int secondsLeft;
    private int currentQuestion = 0;
    private List<Integer> questionIDs = new ArrayList<>();

    public examen(int examenID, int idEtud, int matiereID) {
        this.examenID = examenID;
        this.matiereID = matiereID;
        //this.classeID = classeID;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setSize(740, 410);

        try {
            String query = "SELECT duree FROM examen WHERE matiereid = " + matiereID ;
            System.out.println(query);
            Statement request = connection.connectDB().createStatement();
            ResultSet r = request.executeQuery(query);
            r.next();
            this.secondsLeft = r.getInt("duree");

            query = "SELECT COUNT(*) FROM question WHERE examen_id = " + examenID;
            r = request.executeQuery(query);
            r.next();
            this.totalQuestions = r.getInt(1);
            query = "SELECT id FROM question WHERE examen_id = " + examenID;
            r = request.executeQuery(query);
            while (r.next()) {
                questionIDs.add(r.getInt("id"));
            }

            Collections.shuffle(questionIDs);

            countdownTimer = new Timer(1000, e -> updateCountdown());
            query = "INSERT INTO etudiant_examen VALUES(" + idEtud + ", " + examenID + ", " + 0 + ")";
            request.executeUpdate(query);
            countdownTimer.start();

            fetchQuestionFromDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    

    private void fetchQuestionFromDatabase() {
        try {
            String sql = "SELECT question, reponse FROM question WHERE examen_id = " + examenID + " AND id = " + questionIDs.get(currentQuestion);
            Statement request = connection.connectDB().createStatement();
            ResultSet r = request.executeQuery(sql);
            r.next();
            String question = r.getString("question");
            List<String> reponses = new ArrayList<>();
            reponses.add(r.getString("reponse"));
            sql = "SELECT qr.reponsespossibles FROM question_reponses qr "
                    + "JOIN question q ON qr.question_id = q.id "
                    + "WHERE q.examen_id = " + examenID + " AND q.id = " + questionIDs.get(currentQuestion)
                    + " ORDER BY RANDOM() LIMIT 3";
            currentQuestion++;

            request = connection.connectDB().createStatement();
            r = request.executeQuery(sql);

            while (r.next()) {
                reponses.add(r.getString("reponsespossibles"));
            }
            Collections.shuffle(reponses);

            questionLabel.setText(question);

            jRadioButton2.setText(reponses.get(0));
            jRadioButton3.setText(reponses.get(1));
            jRadioButton4.setText(reponses.get(2));
            jRadioButton1.setText(reponses.get(3));
            
            reponses.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    private void updateCountdown() {
        if (secondsLeft > 0) {
            secondsLeft--;
            int minutes = secondsLeft / 60;
            int seconds = secondsLeft % 60;
            String countdownText = String.format("%02d:%02d", minutes, seconds);

            // Mettez à jour votre interface utilisateur avec countdownText
            conteRebour.setText("Compte à rebours : " + countdownText);
        } else {
            // Le compte à rebours est terminé, vous pouvez prendre des mesures ici (par exemple, fermer la fenêtre)
            countdownTimer.stop();
            JOptionPane.showMessageDialog(this, "Le temps est écoulé !");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        questionLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        next = new javax.swing.JButton();
        conteRebour = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QCM");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(170, 10, 342, 35);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 255));
        jLabel2.setText("Question :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(90, 110, 56, 16);

        questionLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(questionLabel);
        questionLabel.setBounds(170, 130, 467, 25);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 255));
        jLabel3.setText("Cohcez la ou les bonnes réponses :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(100, 60, 231, 20);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 255));
        jLabel4.setText("Suggestions :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(90, 170, 73, 16);

        next.setBackground(new java.awt.Color(51, 255, 0));
        next.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        next.setForeground(new java.awt.Color(255, 255, 255));
        next.setText("Suivant");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });
        getContentPane().add(next);
        next.setBounds(573, 330, 110, 31);

        conteRebour.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        conteRebour.setForeground(new java.awt.Color(0, 102, 255));
        conteRebour.setText("Conte à rebour");
        conteRebour.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(conteRebour);
        conteRebour.setBounds(520, 50, 210, 16);

        buttonGroup.add(jRadioButton1);
        jRadioButton1.setForeground(new java.awt.Color(0, 102, 255));
        getContentPane().add(jRadioButton1);
        jRadioButton1.setBounds(210, 280, 350, 20);

        buttonGroup.add(jRadioButton2);
        jRadioButton2.setForeground(new java.awt.Color(0, 102, 255));
        getContentPane().add(jRadioButton2);
        jRadioButton2.setBounds(210, 190, 360, 20);

        buttonGroup.add(jRadioButton3);
        jRadioButton3.setForeground(new java.awt.Color(0, 102, 255));
        getContentPane().add(jRadioButton3);
        jRadioButton3.setBounds(210, 220, 360, 20);

        buttonGroup.add(jRadioButton4);
        jRadioButton4.setForeground(new java.awt.Color(0, 102, 255));
        getContentPane().add(jRadioButton4);
        jRadioButton4.setBounds(210, 250, 360, 21);

        jLabel6.setForeground(new java.awt.Color(0, 102, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\P3dR0\\Downloads\\Vector graphic of gradient abstract background.jpg")); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 735, 410);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        if (currentQuestion < totalQuestions) {
            fetchQuestionFromDatabase();
            for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
                AbstractButton button = buttons.nextElement();
                if (button.isSelected()) {
                    String selectedAnswer = button.getText();
                }
            }
            buttonGroup.clearSelection();
            if(currentQuestion == totalQuestions){
                next.setText("Terminer");
                next.setBackground(Color.red);
            }
        }else{
            this.dispose();
        }
    }//GEN-LAST:event_nextActionPerformed

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
            java.util.logging.Logger.getLogger(examen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(examen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(examen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(examen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new examen(1, 1, 11).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JLabel conteRebour;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JButton next;
    private javax.swing.JLabel questionLabel;
    // End of variables declaration//GEN-END:variables
}

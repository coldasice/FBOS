/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fbos.clientpkg;

import fbos.UserAcctInterface;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author Robin
 */
public class uiUserEdit extends javax.swing.JFrame {
    String UserName;
    ArrayList proFileInfo;
    /**
     * Creates new form uiUserEdit
     */
    public uiUserEdit() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        uiProPan = new javax.swing.JPanel();
        uiPassTF1 = new javax.swing.JTextField();
        uiPassTF2 = new javax.swing.JTextField();
        uiProfTF = new javax.swing.JTextField();
        uiCityTF = new javax.swing.JTextField();
        uiCompTF = new javax.swing.JTextField();
        uiCollTF = new javax.swing.JTextField();
        uiYearTF = new javax.swing.JTextField();
        uiPassLab1 = new javax.swing.JLabel();
        uiPassLab2 = new javax.swing.JLabel();
        uiProfLab = new javax.swing.JLabel();
        uiCityLab = new javax.swing.JLabel();
        uiCompLab = new javax.swing.JLabel();
        uiCollLab = new javax.swing.JLabel();
        uiYearLab = new javax.swing.JLabel();
        uiProfButt = new javax.swing.JButton();
        uiExitButt = new javax.swing.JButton();
        yearLab = new javax.swing.JLabel();
        uiFailLab = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        uiProPan.setBorder(javax.swing.BorderFactory.createTitledBorder("User Profile Page"));
        uiProPan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        uiPassTF1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        uiPassTF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uiPassTF1ActionPerformed(evt);
            }
        });

        uiPassTF2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        uiProfTF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        uiCityTF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        uiCompTF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        uiCollTF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        uiCollTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uiCollTFActionPerformed(evt);
            }
        });

        uiYearTF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        uiPassLab1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        uiPassLab1.setText("Password");

        uiPassLab2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        uiPassLab2.setText("Reenter Password");

        uiProfLab.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        uiProfLab.setText("Profession");

        uiCityLab.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        uiCityLab.setText("Living City");

        uiCompLab.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        uiCompLab.setText("Company");

        uiCollLab.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        uiCollLab.setText("College Name");

        uiYearLab.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        uiYearLab.setText("Year Graduated");

        uiProfButt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        uiProfButt.setText("Enter New Data");
        uiProfButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uiProfButtActionPerformed(evt);
            }
        });

        uiExitButt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        uiExitButt.setText("Exit Profile Page");
        uiExitButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uiExitButtActionPerformed(evt);
            }
        });

        yearLab.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        uiFailLab.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout uiProPanLayout = new javax.swing.GroupLayout(uiProPan);
        uiProPan.setLayout(uiProPanLayout);
        uiProPanLayout.setHorizontalGroup(
            uiProPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(uiProPanLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(uiProPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(uiPassLab1)
                    .addComponent(uiPassLab2)
                    .addComponent(uiProfLab)
                    .addComponent(uiCityLab)
                    .addComponent(uiCompLab)
                    .addComponent(uiCollLab)
                    .addComponent(uiYearLab))
                .addGap(31, 31, 31)
                .addGroup(uiProPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(uiPassTF2, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uiPassTF1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uiProfTF, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uiCityTF, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uiCompTF, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uiCollTF, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(uiProPanLayout.createSequentialGroup()
                        .addComponent(uiYearTF, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(yearLab, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(uiProPanLayout.createSequentialGroup()
                        .addGroup(uiProPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(uiExitButt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(uiProfButt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(53, 53, 53)
                        .addComponent(uiFailLab, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(246, Short.MAX_VALUE))
        );
        uiProPanLayout.setVerticalGroup(
            uiProPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(uiProPanLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(uiProPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uiPassTF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uiPassLab1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(uiProPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uiPassTF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uiPassLab2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(uiProPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uiProfTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uiProfLab))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(uiProPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uiCityTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uiCityLab))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(uiProPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uiCompTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uiCompLab))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(uiProPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uiCollTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uiCollLab))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(uiProPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uiYearTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uiYearLab)
                    .addComponent(yearLab))
                .addGap(18, 18, 18)
                .addGroup(uiProPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uiProfButt)
                    .addComponent(uiFailLab, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(uiExitButt)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(uiProPan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(uiProPan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void uiPassTF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uiPassTF1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uiPassTF1ActionPerformed

    private void uiCollTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uiCollTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uiCollTFActionPerformed

    private void uiProfButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uiProfButtActionPerformed
                String uiPass1, uiPass2, uiProf, uiCity, uiComp, uiColl, uiYear;

        uiPass1=uiPassTF1.getText();
        uiPass2=uiPassTF2.getText();
        if(uiPass1.length()<6){
            uiPassTF1.setText("Minimum Length of 6 characters is required.");
            uiPassTF2.setText("");
        }
        if(uiPass1.equals(uiPass2)){
            uiProf=uiProfTF.getText();
            uiCity=uiCityTF.getText();
            uiComp=uiCompTF.getText();
            uiColl=uiCollTF.getText();
            uiYear=uiYearTF.getText();
            int numYear = 0;
            try{
                numYear = Integer.parseInt(uiYear);
                UserAcctInterface newAcct = FBOSClient.FBOSServer.createAccount(UserName, uiPass1, uiProf, uiCity, uiComp, uiColl, numYear);
                if(newAcct == null) {
                    uiFailLab.setText("Failed to create account");
                }
                else {
                    uiWall newUserFrame = new uiWall(newAcct);
                    newUserFrame.setVisible(true);
                    this.dispose();
                }
            } catch (Exception e){
                yearLab.setText("Needs to be a Valid Number");
            }
       }else{
            uiPassTF1.setText("Passwords do not match.");
            uiPassTF2.setText("");
        }
        
        
    }//GEN-LAST:event_uiProfButtActionPerformed

    private void uiExitButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uiExitButtActionPerformed
        JFrame newUserFrame = new uiLog();
        this.setVisible(false);
        newUserFrame.setVisible(true);
    }//GEN-LAST:event_uiExitButtActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(uiUserEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(uiUserEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(uiUserEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(uiUserEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new uiUserEdit().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel uiCityLab;
    private javax.swing.JTextField uiCityTF;
    private javax.swing.JLabel uiCollLab;
    private javax.swing.JTextField uiCollTF;
    private javax.swing.JLabel uiCompLab;
    private javax.swing.JTextField uiCompTF;
    private javax.swing.JButton uiExitButt;
    private javax.swing.JLabel uiFailLab;
    private javax.swing.JLabel uiPassLab1;
    private javax.swing.JLabel uiPassLab2;
    private javax.swing.JTextField uiPassTF1;
    private javax.swing.JTextField uiPassTF2;
    private javax.swing.JPanel uiProPan;
    private javax.swing.JButton uiProfButt;
    private javax.swing.JLabel uiProfLab;
    private javax.swing.JTextField uiProfTF;
    private javax.swing.JLabel uiYearLab;
    private javax.swing.JTextField uiYearTF;
    private javax.swing.JLabel yearLab;
    // End of variables declaration//GEN-END:variables
}

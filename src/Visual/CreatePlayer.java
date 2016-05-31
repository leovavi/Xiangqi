/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;

/**
 *
 * @author Leovavi
 */
public class CreatePlayer extends javax.swing.JPanel {

    /**
     * Creates new form CreateUser
     */
    public CreatePlayer() {
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

        userTF = new javax.swing.JTextField();
        passTF = new javax.swing.JTextField();
        UserFormLabel = new javax.swing.JLabel();
        btnCreatePlayer = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        MainLabel = new javax.swing.JLabel();

        setLayout(null);

        userTF.setFont(new java.awt.Font("Chinese Takeaway", 2, 18)); // NOI18N
        userTF.setBorder(null);
        add(userTF);
        userTF.setBounds(450, 320, 260, 40);

        passTF.setFont(new java.awt.Font("Chinese Takeaway", 2, 18)); // NOI18N
        passTF.setBorder(null);
        add(passTF);
        passTF.setBounds(450, 430, 260, 30);

        UserFormLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/userForm.png"))); // NOI18N
        add(UserFormLabel);
        UserFormLabel.setBounds(430, 240, 310, 260);

        btnCreatePlayer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/miniCreatePlayer.png"))); // NOI18N
        btnCreatePlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreatePlayerActionPerformed(evt);
            }
        });
        add(btnCreatePlayer);
        btnCreatePlayer.setBounds(480, 510, 200, 40);

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/back.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack);
        btnBack.setBounds(933, 603, 200, 40);

        MainLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/MainBackground.png"))); // NOI18N
        add(MainLabel);
        MainLabel.setBounds(0, 0, 1150, 650);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreatePlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreatePlayerActionPerformed
        Menu.menu.setPanel(new MenuInicio());
    }//GEN-LAST:event_btnCreatePlayerActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        Menu.menu.setPanel(new MenuInicio());
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MainLabel;
    private javax.swing.JLabel UserFormLabel;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreatePlayer;
    private javax.swing.JTextField passTF;
    private javax.swing.JTextField userTF;
    // End of variables declaration//GEN-END:variables
}

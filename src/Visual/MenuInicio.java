package Visual;

public class MenuInicio extends javax.swing.JPanel {
    /**
     * Creates new form MenuInicio
     */
    
    public MenuInicio() {
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

        exit = new javax.swing.JButton();
        userTF = new javax.swing.JTextField();
        btnLogIn = new javax.swing.JButton();
        btnCreatePlayer = new javax.swing.JButton();
        passTF = new javax.swing.JPasswordField();
        LabelUserForm = new javax.swing.JLabel();
        MainLabel = new javax.swing.JLabel();

        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLayout(null);

        exit.setFont(new java.awt.Font("Chinese Takeaway", 2, 36)); // NOI18N
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/exit.png"))); // NOI18N
        exit.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        exit.setOpaque(false);
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        add(exit);
        exit.setBounds(933, 603, 200, 40);

        userTF.setFont(new java.awt.Font("Chinese Takeaway", 2, 18)); // NOI18N
        userTF.setBorder(null);
        add(userTF);
        userTF.setBounds(450, 310, 260, 40);

        btnLogIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/minilogin.png"))); // NOI18N
        btnLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogInActionPerformed(evt);
            }
        });
        add(btnLogIn);
        btnLogIn.setBounds(380, 490, 200, 40);

        btnCreatePlayer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/miniCreatePlayer.png"))); // NOI18N
        btnCreatePlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreatePlayerActionPerformed(evt);
            }
        });
        add(btnCreatePlayer);
        btnCreatePlayer.setBounds(590, 490, 200, 40);

        passTF.setFont(new java.awt.Font("Comic Sans MS", 2, 18)); // NOI18N
        passTF.setBorder(null);
        add(passTF);
        passTF.setBounds(450, 420, 260, 30);

        LabelUserForm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/userForm.png"))); // NOI18N
        add(LabelUserForm);
        LabelUserForm.setBounds(430, 240, 310, 240);

        MainLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/MainBackground.png"))); // NOI18N
        add(MainLabel);
        MainLabel.setBounds(0, 0, 1150, 650);
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void btnLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogInActionPerformed
        String user = userTF.getText();
        String pass = String.valueOf(passTF.getPassword());
        Menu.xia.Login(user, pass);
    }//GEN-LAST:event_btnLogInActionPerformed

    private void btnCreatePlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreatePlayerActionPerformed
        String user = userTF.getText();
        String pass = String.valueOf(passTF.getPassword());
        Menu.xia.createPlayer(user, pass);
    }//GEN-LAST:event_btnCreatePlayerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelUserForm;
    private javax.swing.JLabel MainLabel;
    private javax.swing.JButton btnCreatePlayer;
    private javax.swing.JButton btnLogIn;
    private javax.swing.JButton exit;
    private javax.swing.JPasswordField passTF;
    private javax.swing.JTextField userTF;
    // End of variables declaration//GEN-END:variables
}
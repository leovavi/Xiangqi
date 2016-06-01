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
public class PlayersAvailable extends javax.swing.JPanel {

    /**
     * Creates new form PlayersAvailable
     */
    public PlayersAvailable() {
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

        PlayersLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        playersList = new javax.swing.JList<>();
        btnBack = new javax.swing.JButton();
        MainLabel = new javax.swing.JLabel();

        setLayout(null);

        PlayersLabel.setFont(new java.awt.Font("Chinese Takeaway", 2, 24)); // NOI18N
        PlayersLabel.setForeground(new java.awt.Color(153, 0, 0));
        PlayersLabel.setText("Players Available");
        add(PlayersLabel);
        PlayersLabel.setBounds(470, 260, 220, 40);

        playersList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(playersList);

        add(jScrollPane1);
        jScrollPane1.setBounds(470, 320, 210, 220);

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

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        Menu.menu.setPanel(new JugarXiangqi());
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MainLabel;
    private javax.swing.JLabel PlayersLabel;
    private javax.swing.JButton btnBack;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> playersList;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;

import java.io.IOException;
import javax.swing.DefaultListModel;

/**
 *
 * @author Leovavi
 */
public class PlayersAvailable extends javax.swing.JPanel {
    public static DefaultListModel dlm;
    /**
     * Creates new form PlayersAvailable
     */
    public PlayersAvailable() {
        initComponents();
        dlm = new DefaultListModel();
        Menu.xia.listUsers();
        playersList.setModel(dlm);
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

        playersList.setFont(new java.awt.Font("Chinese Takeaway", 2, 14)); // NOI18N
        playersList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playersListMouseClicked(evt);
            }
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

    private void playersListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playersListMouseClicked
        if(!playersList.getSelectedValue().equals("")){
            try {
                Tablero.newGame(playersList.getSelectedValue());
                Menu.menu.setPanel(new Game());
            } catch (IOException e) {}
        }            
    }//GEN-LAST:event_playersListMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MainLabel;
    private javax.swing.JLabel PlayersLabel;
    private javax.swing.JButton btnBack;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> playersList;
    // End of variables declaration//GEN-END:variables
}

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
public class DeleteGame extends javax.swing.JPanel {

    /**
     * Creates new form DeleteGame
     */
    public DeleteGame() {
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

        gamesLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        deleteGameList = new javax.swing.JList<>();
        btnBack = new javax.swing.JButton();
        MainLabel = new javax.swing.JLabel();

        setLayout(null);

        gamesLabel.setFont(new java.awt.Font("Chinese Takeaway", 2, 24)); // NOI18N
        gamesLabel.setForeground(new java.awt.Color(153, 0, 0));
        gamesLabel.setText("Games");
        add(gamesLabel);
        gamesLabel.setBounds(520, 260, 80, 40);

        deleteGameList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(deleteGameList);

        add(jScrollPane1);
        jScrollPane1.setBounds(360, 320, 440, 240);

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
    private javax.swing.JButton btnBack;
    private javax.swing.JList<String> deleteGameList;
    private javax.swing.JLabel gamesLabel;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;

import javax.swing.DefaultListModel;

/**
 *
 * @author Leovavi
 */
public class Logs extends javax.swing.JPanel {
    DefaultListModel dlm;
    /**
     * Creates new form Logs
     */
    public Logs() {
        initComponents();
        dlm = new DefaultListModel();
        Menu.xia.listLogs(dlm);
        logList.setModel(dlm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        logList = new javax.swing.JList<>();
        btnBack = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        MainLabel = new javax.swing.JLabel();

        setLayout(null);

        logLabel.setFont(new java.awt.Font("Chinese Takeaway", 2, 24)); // NOI18N
        logLabel.setForeground(new java.awt.Color(153, 0, 0));
        logLabel.setText("Logs");
        add(logLabel);
        logLabel.setBounds(550, 260, 60, 30);

        logList.setFont(new java.awt.Font("Chinese Takeaway", 0, 14)); // NOI18N
        logList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(logList);

        add(jScrollPane1);
        jScrollPane1.setBounds(380, 320, 400, 240);

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/back.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack);
        btnBack.setBounds(933, 603, 200, 40);

        btnExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/exportLogs.png"))); // NOI18N
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });
        add(btnExport);
        btnExport.setBounds(933, 540, 200, 40);

        MainLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/MainBackground.png"))); // NOI18N
        add(MainLabel);
        MainLabel.setBounds(0, 0, 1150, 650);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        Menu.menu.setPanel(new Reportes());
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        Menu.xia.exportLogs();
    }//GEN-LAST:event_btnExportActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MainLabel;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnExport;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logLabel;
    private javax.swing.JList<String> logList;
    // End of variables declaration//GEN-END:variables
}

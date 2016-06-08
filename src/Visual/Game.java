/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;

import Fichas.Ficha;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author Leovavi
 */
public final class Game extends javax.swing.JPanel {
    Tablero tab = new Tablero();
    BufferedImage bi;
    /**
     * Creates new form Game
     */
    public Game() {
        initComponents();
        setTableroPanel(tab);
    }

    public void setTableroPanel(JPanel panel){
        tablero.removeAll();
        tablero.add(panel);
        tablero.repaint();
        tablero.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tablero = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnSaveQuit = new javax.swing.JButton();
        btnSurrender = new javax.swing.JButton();
        MainLabel = new javax.swing.JLabel();

        setLayout(null);

        tablero.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/tablero.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        tablero.add(jLabel1);
        jLabel1.setBounds(0, 0, 540, 600);

        add(tablero);
        tablero.setBounds(330, 30, 540, 600);

        btnSaveQuit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/saveQuit.png"))); // NOI18N
        btnSaveQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveQuitActionPerformed(evt);
            }
        });
        add(btnSaveQuit);
        btnSaveQuit.setBounds(20, 590, 200, 40);

        btnSurrender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/surrender.png"))); // NOI18N
        btnSurrender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSurrenderActionPerformed(evt);
            }
        });
        add(btnSurrender);
        btnSurrender.setBounds(20, 530, 200, 40);

        MainLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/background.png"))); // NOI18N
        add(MainLabel);
        MainLabel.setBounds(0, 0, 1150, 650);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSurrenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSurrenderActionPerformed
        Menu.menu.showMessage((Ficha.turno==1 ? Menu.userLogged : Menu.userLogged2)+" has retired, congratulations "+
                (Ficha.turno==1 ? Menu.userLogged2 : Menu.userLogged));
        Menu.menu.setPanel(new MenuPrincipal());
    }//GEN-LAST:event_btnSurrenderActionPerformed

    private void btnSaveQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveQuitActionPerformed
        //Aunque por los momentos solo se sale de la pantalla
        Menu.menu.setPanel(new MenuPrincipal());
    }//GEN-LAST:event_btnSaveQuitActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MainLabel;
    private javax.swing.JButton btnSaveQuit;
    private javax.swing.JButton btnSurrender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel tablero;
    // End of variables declaration//GEN-END:variables
}

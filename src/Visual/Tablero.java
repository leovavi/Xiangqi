package Visual;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tablero extends JFrame{
    public static void main(String[] args) {        
        JFrame tablero = new JFrame("Xiangqi");
        tablero.setDefaultCloseOperation(EXIT_ON_CLOSE);
        tablero.setSize(450, 500);
        
        JLabel label = new JLabel("Mi first GUI");
        label.setSize(500, 600);
        
        JButton login = new JButton("Log in");
        login.setLocation(400, 200);
        
        JPanel panel = new JPanel();
        panel.setSize(50, 50);
        panel.add(label);
        panel.add(login);
        panel.setBackground(Color.red);
        
        tablero.getContentPane().add(panel);
        tablero.setVisible(true);
    }
}

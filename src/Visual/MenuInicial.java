package Visual;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuInicial extends JPanel{
    
    JFrame menu = new JFrame("MENU INICIAL");
    JPanel buttons = new JPanel();
    JButton login = new JButton("Log In");
    JButton createPlayer = new JButton("Create Player");
    JButton exit = new JButton("Exit");
    
    public MenuInicial(){
        menu.setSize(450, 500);
        menu.setVisible(true);        
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        buttons.setLayout(null);
        buttons.setBounds(0, 0, menu.getWidth(), menu.getHeight());
        
        login.setBounds(160, 250, 125, 30);
        createPlayer.setBounds(160, 300, 125, 30);  
        exit.setBounds(160, 350, 125, 30);
        
        buttons.setBackground(Color.CYAN);
        buttons.add(login);
        buttons.add(createPlayer);
        buttons.add(exit);
                
        menu.getContentPane().add(buttons);
    }
    
    public static void main(String[] args) {
        MenuInicial mi = new MenuInicial();
    }
}
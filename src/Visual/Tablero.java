package Visual;

import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tablero extends JLabel{
    static JFrame tablero = new JFrame("Xiangqi");
    Container cont = new Container();
    ArrayList<JLabel> cuadros = new ArrayList<>();
    GridLayout gridLayout = new GridLayout(0, 9);
    JPanel panelCuadros = new JPanel();

    
    public Tablero(){
        initComponents();
    }
    
    public void initComponents(){
        cont.setLayout(gridLayout);
        
        panelCuadros.setLayout(new GridLayout(10, 9));
        panelCuadros.setBounds(0, 0, 450, 500);
        
        tablero.getContentPane().add(panelCuadros);
        
        //cont.add(tablero);
    }
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable(){
            @Override
            public void run() {
                tablero.setVisible(true);
            }
        });
    }
}

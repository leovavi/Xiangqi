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
        initCuadros(panelCuadros);
        panelCuadros.setBounds(0, 0, 450, 500);
        
        tablero.getContentPane().add(panelCuadros);
        
        //cont.add(tablero);
    }
    
    public void initCuadros(JPanel panel){
        for(int x = 0; x<10; x++){
            for(int y = 0; y<9; y++){
                cuadros.add(new JLabel());
                cuadros.get(x).setBackground(new java.awt.Color(0, 153, 153));
                cuadros.get(x).setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/"+
                        (x%2==0 ? "cuadroRojo.png" : "cuadroBlanco.png"))));
                cuadros.get(x).setBounds(0, 0, x*50, y*50);
                panel.add(cuadros.get(x));
            }
        }
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

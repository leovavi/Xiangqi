package Visual;

import Fichas.Advisor;
import Fichas.Cannon;
import Fichas.Chariot;
import Fichas.Elephant;
import Fichas.Ficha;
import Fichas.FichaVacia;
import Fichas.General;
import Fichas.Horse;
import Fichas.Soldier;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public final class Tablero extends JPanel{
    JLabel[][] pieces = new Ficha[10][9];
    JFrame tablero = new JFrame("Xiangqi");
    Container cont = new Container();
    GridLayout gridLayout = new GridLayout(10, 9);
    Image background = Toolkit.getDefaultToolkit().createImage("src/Imagenes/tablero.png");
    
    public Tablero(){
        initComps();
        setBounds(0, 0, 540, 600);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(background, 0, 0, this);
    }
    
    public final void initComps(){
        setLayout(gridLayout);
        int contTurnos = 0;
        for(int x = 0; x<10; x++){
            for(int y = 0; y<9; y++){
                if((x==0 && y==0) || (x==0 && y==8) || (x==9 && y==0) || (x==9 && y==8)){
                    pieces[x][y] = new Chariot("Chariot");
                    pieces[x][y].setIcon(new ImageIcon(((Chariot)pieces[x][y]).icon()));
                }
                else if((x==0 && y ==1) || (x==0 && y==7) || (x==9 && y==1) || (x==9 && y==7)){
                    pieces[x][y] = new Horse("Horse");
                    pieces[x][y].setIcon(new ImageIcon(((Horse)pieces[x][y]).icon()));
                }
                else if((x==0 && y==2) || (x==0 && y ==6) || (x==9 && y==2) || (x==9 && y==6)){
                    pieces[x][y] = new Elephant("Elephant");
                    pieces[x][y].setIcon(new ImageIcon(((Elephant)pieces[x][y]).icon()));
                }
                else if((x==0 && y==3) || (x==0 && y==5) || (x==9 && y==3) || (x==9 && y==5)){
                    pieces[x][y] = new Advisor("Advisor");
                    pieces[x][y].setIcon(new ImageIcon(((Advisor)pieces[x][y]).icon()));
                }
                else if((x==0 && y==4) || (x==9 && y==4)){
                    pieces[x][y] = new General("General");
                    pieces[x][y].setIcon(new ImageIcon(((General)pieces[x][y]).icon()));
                }
                else if((x==2 && y==1) || (x==2 && y==7) || (x==7 && y==1) || (x==7 && y==7)){
                    pieces[x][y] = new Cannon("Cannon");
                    pieces[x][y].setIcon(new ImageIcon(((Cannon)pieces[x][y]).icon()));
                }
                else if((x==3 && y==0) || (x==3 && y==2) || (x==3 && y==4) || (x==3 && y==6) || (x==3 && y==8) ||
                        (x==6 && y==0) || (x==6 && y==2) || (x==6 && y==4) || (x==6 && y==6) || (x==6 && y==8)){
                    pieces[x][y] = new Soldier("Soldier");
                    pieces[x][y].setIcon(new ImageIcon(((Soldier)pieces[x][y]).icon()));
                }
                else{
                    pieces[x][y] = new FichaVacia("Fecha Vacia");
                    contTurnos--;
                }
                contTurnos++;
                add(pieces[x][y]);
                pieces[x][y].setBounds(y*50, x*50, 60, 60);
            }
            if(contTurnos == 16)
                Ficha.turno = 2;
        }
    }
}

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
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public final class Tablero extends JPanel implements Serializable{
    public int currentX, currentY, t;
    boolean chosenPiece = false;
    JLabel[][] pieces = new Ficha[10][9];
    GridLayout gridLayout = new GridLayout(10, 9);
    Image background = Toolkit.getDefaultToolkit().createImage("src/Imagenes/tablero.png");
    
    public Tablero(){
        initCuadros();
        setBounds(0, 0, 540, 600);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(background, 0, 0, this);
    }
    
    public final void initCuadros(){
        setLayout(gridLayout);
        int contTurnos = 0;
        t = 1;
        for(int y = 0; y<10; y++){
            for(int x = 0; x<9; x++){
                if((y==0 && x==0) || (y==0 && x==8) || (y==9 && x==0) || (y==9 && x==8))
                    pieces[y][x] = new Chariot("Chariot", t);
                
                else if((y==0 && x==1) || (y==0 && x==7) || (y==9 && x==1) || (y==9 && x==7))
                    pieces[y][x] = new Horse("Horse", t);
                
                else if((y==0 && x==2) || (y==0 && x==6) || (y==9 && x==2) || (y==9 && x==6))
                    pieces[y][x] = new Elephant("Elephant", t);
                
                else if((y==0 && x==3) || (y==0 && x==5) || (y==9 && x==3) || (y==9 && x==5))
                    pieces[y][x] = new Advisor("Advisor", t);
                
                else if((y==0 && x==4) || (y==9 && x==4))
                    pieces[y][x] = new General("General", t);

                else if((y==2 && x==1) || (y==2 && x==7) || (y==7 && x==1) || (y==7 && x==7))
                    pieces[y][x] = new Cannon("Cannon", t);
                
                else if((y==3 && x==0) || (y==3 && x==2) || (y==3 && x==4) || (y==3 && x==6) || (y==3 && x==8) ||
                        (y==6 && x==0) || (y==6 && x==2) || (y==6 && x==4) || (y==6 && x==6) || (y==6 && x==8))
                    pieces[y][x] = new Soldier("Soldier", t);
                
                else
                    pieces[y][x] = new FichaVacia("Ficha Vacia", 0);
                
                contTurnos++;
                pieces[y][x].setIcon(new ImageIcon(((Ficha)pieces[y][x]).icon()));
                pieces[y][x].addMouseListener(new PressedMouse());
                add(pieces[y][x]);
            }
            if(contTurnos == 36)
                changeTurn();
        }changeTurn();
    }
    
    public void changeTurn(){
        if(t==1)
            t = 2;
        else
            t = 1;
    }
    
    class PressedMouse implements MouseListener, Serializable{
        @Override
        public void mousePressed(MouseEvent me) {}
        @Override
        public void mouseReleased(MouseEvent me) {}
        @Override
        public void mouseEntered(MouseEvent me) {}
        @Override
        public void mouseExited(MouseEvent me) {}
        @Override
        public void mouseClicked(MouseEvent me) {
            Object source = me.getSource();
            for(int y = 0; y<10; y++){
                for(int x = 0; x<9; x++){
                    if(source==pieces[y][x] && !(source instanceof FichaVacia) && ((Ficha)pieces[y][x]).turno==t){
                        currentX = x;
                        currentY = y;
                        chosenPiece = true;
                    }
                    else if(source==pieces[y][x] && source instanceof FichaVacia && chosenPiece){
                        moverPieza(x, y);
                    }
                    else if(source==pieces[y][x] && !(source instanceof FichaVacia) && chosenPiece){
                        
                    }
                }
            }
        }
    }
    
    public void moverPieza(int x, int y){
        if(((Ficha)pieces[currentY][currentX]).validarMove(currentX, currentY, x, y)){
            if(pieces[currentY][currentX] instanceof Advisor || pieces[currentY][currentX] instanceof General){
                if(((Ficha)pieces[y][x]).insideFort(x, y))
                    setNewFicha(x, y);
            }
            else if(pieces[currentY][currentX] instanceof Elephant){
                if(currentX+2==x && currentY+2==y){
                    if(pieces[currentY+1][currentX+1] instanceof FichaVacia)
                        setNewFicha(x, y);
                }

                else if(currentX+2==x && currentY-2==y){
                    if(pieces[currentY-1][currentX+1] instanceof FichaVacia)
                        setNewFicha(x, y);
                }

                else if(currentX-2==x && currentY+2==y){
                    if(pieces[currentY+1][currentX-1] instanceof FichaVacia)
                        setNewFicha(x, y);
                }

                else if(currentX-2==x && currentY-2==y){
                    if(pieces[currentY-1][currentX-1] instanceof FichaVacia)
                        setNewFicha(x, y);
                }
            }
            else if(pieces[currentY][currentX] instanceof Horse){
                if(currentX+1==x && currentY+2==y){
                    if(pieces[currentY+1][currentX] instanceof FichaVacia)
                        setNewFicha(x, y);
                }
                else if(currentX+1==x && currentY-2==y){
                    if(pieces[currentY-1][currentX] instanceof FichaVacia)
                        setNewFicha(x, y);
                }
                else if(currentX-1==x && currentY+2==y){
                    if(pieces[currentY+1][currentX] instanceof FichaVacia)
                        setNewFicha(x, y);
                }
                else if(currentX-1==x && currentY-2==y){
                    if(pieces[currentY-1][currentX] instanceof FichaVacia)
                        setNewFicha(x, y);
                }
                else if(currentX+2==x && currentY+1==y){
                    if(pieces[currentY][currentX+1] instanceof FichaVacia)
                        setNewFicha(x, y);
                }
                else if(currentX+2==x && currentY-1==y){
                    if(pieces[currentY][currentX+1] instanceof FichaVacia)
                        setNewFicha(x, y);
                }
                else if(currentX-2==x && currentY+1==y){
                    if(pieces[currentY][currentX-1] instanceof FichaVacia)
                        setNewFicha(x, y);
                }
                else if(currentX-2==x && currentY-1==y){
                    if(pieces[currentY][currentX-1] instanceof FichaVacia)
                        setNewFicha(x, y);
                }
            }
            else if(pieces[currentY][currentX] instanceof Chariot || pieces[currentY][currentX] instanceof Cannon){
                int intermmediatePiece = 0;
                if(x>currentX && currentY==y){
                    for(int x1 = currentX; x1<x; x1++){
                        System.out.println("x++");
                        if(!(pieces[currentY][x1] instanceof FichaVacia))
                            intermmediatePiece++;
                    }System.out.println();
                }
                else if(x<currentX && currentY==y){
                    for(int x1 = currentX; x1>x; x1--){
                        System.out.println("x--");
                        if(!(pieces[currentY][x1] instanceof FichaVacia))
                            intermmediatePiece++;
                    }System.out.println("");
                }
                else if(x==currentX && y>currentY){
                    for(int y1 = currentY; y1<y; y1++){
                        System.out.println("y++");
                        if(!(pieces[y1][currentX] instanceof FichaVacia))
                            intermmediatePiece++;
                    }System.out.println("");
                }
                else if(x==currentX && y<currentY){
                    for(int y1 = currentY; y1>x; y1--){
                        System.out.println("y--");
                        if(!(pieces[y1][currentX] instanceof FichaVacia))
                            intermmediatePiece++;
                    }System.out.println("");
                }
                if(intermmediatePiece==0)
                    setNewFicha(x, y);
            }
            else
                setNewFicha(x, y);
        }
    }
    
    public void refresh(){
        removeAll();
        for(int y = 0; y<10; y++){
            for(int x = 0; x<9; x++){
                pieces[y][x].addMouseListener(new PressedMouse());
                add(pieces[y][x]);
            }
        }
        System.out.println("Turno de: "+t);
        revalidate();
    }
    
    public void setNewFicha(int x, int y){
        pieces[y][x] = pieces[currentY][currentX];
        newFichaVacia(currentX, currentY);
        currentX = 0;
        currentY = 0;
        chosenPiece = false;
        changeTurn();
        refresh();
    }
    
    public void newFichaVacia(int x, int y){
        pieces[y][x] = new FichaVacia("Ficha Vacia", t);
        pieces[y][x].addMouseListener(new PressedMouse());
    }
    
    public boolean endGame(){
        int cantGeneral = 0;
        for(int y = 0; y<10; y++)
            for(int x = 0; x<9; x++)
                if(pieces[y][x] instanceof General)
                    cantGeneral++;
        if(cantGeneral==2)
            return false;
        return true;
    }
    
    public boolean notFichasAround(int x, int y, int x1, int y1){
        for(int f = y; f<y1; f++){
            for(int c = x; c<x1; c++){
                if(!(pieces[f][c] instanceof FichaVacia))
                    return false;
            }
        }
        return true;
    }
}

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
import Xiangqi.Games;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public final class Tablero extends JPanel implements Serializable{
    public int currentX, currentY, t;
    boolean chosenPiece = false;
    File gameFile;
    JLabel[][] pieces = new Ficha[10][9];
    GridLayout gridLayout = new GridLayout(10, 9);
    Image background = Toolkit.getDefaultToolkit().createImage("src/Imagenes/tablero.png");
    
    public Tablero(){
        try{
            gameFile = new File("Players/"+Menu.userLogged+"/"+Menu.xia.getCode()+"-"+Menu.userLogged2);
            gameFile.createNewFile();
            initCuadros();
            setBounds(0, 0, 540, 600);
        }catch(IOException e){}
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
                        attackPiece(x, y);
                    }
                }
            }
        }
    }
    
    public void movementGenAdv(int x, int y){
        if(((Ficha)pieces[y][x]).insideFort(x, y))
            setNewFicha(x, y);
    }
    
    public void movementEle(int x, int y){
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
    
    public void movementHorse(int x, int y){
        if((currentX+1==x && currentY+2==y) ||(currentX-1==x && currentY+2==y)){
            if(pieces[currentY+1][currentX] instanceof FichaVacia)
                setNewFicha(x, y);
        }
        else if((currentX+1==x && currentY-2==y) || (currentX-1==x && currentY-2==y)){
            if(pieces[currentY-1][currentX] instanceof FichaVacia)
                setNewFicha(x, y);
        }
        else if((currentX+2==x && currentY+1==y) || (currentX+2==x && currentY-1==y)){
            if(pieces[currentY][currentX+1] instanceof FichaVacia)
                setNewFicha(x, y);
        }
        else if((currentX-2==x && currentY+1==y) || (currentX-2==x && currentY-1==y)){
            if(pieces[currentY][currentX-1] instanceof FichaVacia)
                setNewFicha(x, y);
        }
    }
    
    public void movementCharCan(int x, int y, int MOA){
        int intermmediatePiece = 0;
        if(x>currentX && currentY==y){
            for(int x1 = currentX+1; x1<x; x1++)
                if(!(pieces[currentY][x1] instanceof FichaVacia))
                    intermmediatePiece++;
        }
        else if(x<currentX && currentY==y){
            for(int x1 = currentX-1; x1>x; x1--)
                if(!(pieces[currentY][x1] instanceof FichaVacia))
                    intermmediatePiece++;
        }
        else if(x==currentX && y>currentY){
            for(int y1 = currentY+1; y1<y; y1++)
                if(!(pieces[y1][currentX] instanceof FichaVacia))
                    intermmediatePiece++;
        }
        else if(x==currentX && y<currentY){
            for(int y1 = currentY-1; y1>y; y1--)
                if(!(pieces[y1][currentX] instanceof FichaVacia))
                    intermmediatePiece++;
        }
        if(intermmediatePiece==MOA && MOA==1)
            setNewFicha(x, y);
        else if(intermmediatePiece==0 && MOA==0)
            setNewFicha(x, y);
    }
    
    public void movements(int x, int y){
        Ficha tempCurrent = (Ficha)pieces[currentY][currentX];
        Ficha tempNew = (Ficha)pieces[y][x];
        if(pieces[currentY][currentX] instanceof Advisor || pieces[currentY][currentX] instanceof General)
            movementGenAdv(x, y);

        else if(pieces[currentY][currentX] instanceof Elephant)
            movementEle(x, y);

        else if(pieces[currentY][currentX] instanceof Horse)
            movementHorse(x, y);

        else if((pieces[currentY][currentX] instanceof Chariot) || (pieces[currentY][currentX] instanceof Cannon))
            movementCharCan(x, y, 0);

        else
            setNewFicha(x, y);
        
        if(facingGenerals()){
            pieces[currentY][currentX] = tempCurrent;
            pieces[y][x] = tempNew;
            refresh();
            changeTurn();
        }
    }
    
    public void moverPieza(int x, int y){
        if(((Ficha)pieces[currentY][currentX]).validarMove(currentX, currentY, x, y))
            movements(x, y);
    }
    
    public void attacks(int x, int y){
        Ficha tempCurrent = (Ficha)pieces[currentY][currentX];
        Ficha tempNew = (Ficha)pieces[y][x];
        if(pieces[currentY][currentX] instanceof Advisor || pieces[currentY][currentX] instanceof General)
            movementGenAdv(x, y);

        else if(pieces[currentY][currentX] instanceof Elephant)
            movementEle(x, y);

        else if(pieces[currentY][currentX] instanceof Horse)
            movementHorse(x, y);

        else if(pieces[currentY][currentX] instanceof Chariot)
            movementCharCan(x, y, 0);
        
        else if(pieces[currentY][currentX] instanceof Cannon)
            movementCharCan(x, y, 1);

        else
            setNewFicha(x, y);
        
        if(facingGenerals()){
            pieces[currentY][currentX] = tempCurrent;
            pieces[y][x] = tempNew;
            refresh();
            changeTurn();
        }
    }
    
    public void attackPiece(int x, int y){
        if(((Ficha)pieces[currentY][currentX]).validarMove(currentX, currentY, x, y))
            attacks(x, y);
    }
    
    public boolean facingGenerals(){
        boolean encontrado = false, facing = false;
        for(int y = 0; y<3; y++){
            for(int x = 3; x<6; x++){
                if(pieces[y][x] instanceof General){
                    encontrado = true;
                    for(int z = y+1; z<10; z++){
                        if(!(pieces[z][x] instanceof FichaVacia)){
                            if(pieces[z][x] instanceof General)
                                facing = true;
                            else
                                facing = false;
                            break;
                        }
                    }
                }
            }
            if(encontrado) break;
        }
        if(facing)
            return true;
        return false;
    }
    
    public void refresh(){
        removeAll();
        for(int y = 0; y<10; y++){
            for(int x = 0; x<9; x++){
                pieces[y][x].addMouseListener(new PressedMouse());
                add(pieces[y][x]);
            }
        }
        revalidate();
    }
    
    public void setNewFicha(int x, int y){
        pieces[y][x] = pieces[currentY][currentX];
        newFichaVacia(currentX, currentY);
        chosenPiece = false;
        changeTurn();
        refresh();
        endGame();
    }
    
    public void newFichaVacia(int x, int y){
        pieces[y][x] = new FichaVacia("Ficha Vacia", t);
        pieces[y][x].addMouseListener(new PressedMouse());
    }
    
    public boolean generalsAlive(){
        int cantGeneral = 0;
        for(int y = 0; y<10; y++)
            for(int x = 3; x<6; x++)
                if(pieces[y][x] instanceof General)
                    cantGeneral++;
        if(cantGeneral==2)
            return true;
        return false;
    }
    
    public void endGame(){
        if(!generalsAlive()){
            String winner = (t==1 ? Menu.userLogged2 : Menu.userLogged);
            String loser = (t==1 ? Menu.userLogged : Menu.userLogged2);
            
            String victory = winner+" has won the game against "+loser+". "+winner+" has gained 3 points.";
            
            Menu.xia.addPoints(winner, victory);
            Menu.xia.saveLogs(victory);
            Menu.menu.setPanel(new MenuPrincipal());
        }
    }
    
    public void saveGame(){
        try(FileOutputStream file = new FileOutputStream(gameFile); 
            ObjectOutputStream data = new ObjectOutputStream(file)){
            Ficha[][] fichas = new Ficha[10][9];
            for(int y = 0; y<10; y++)
                for(int x = 0; x<9; x++)
                    fichas[y][x] = (Ficha)pieces[y][x];
            
            data.writeObject(new Games(Menu.userLogged2, t, gameFile, fichas));
        }catch(IOException | NullPointerException e){System.out.println("Error: "+e.getMessage());}
    }
    
    public void loadGame(String path) throws IOException, ClassNotFoundException{
        String[] game = path.split("-");
        FileInputStream file = new FileInputStream(Menu.xia.getFile(game));
        ObjectInputStream data = new ObjectInputStream(file);
        Games games = (Games)data.readObject();
        Menu.userLogged2 = games.oppUser;
        t = games.turno;
        gameFile = games.file;
        pieces = games.fichas;
        refresh();
    }
}
package Fichas;

import javax.swing.JLabel;

public abstract class Ficha extends JLabel{
    public static int turno = 1;
    String name;
    
    public Ficha(String name){
        super();
        this.name = name;
    }
    
    public final String getFichaName(){
        return name;
    }
    
    public final int getTurno(){
        return turno;
    }
    
    public final void cambiarTurnos(){
        if(turno==1)
            turno = 2;
        else
            turno = 1;
    }
    
    public abstract void move();
    public abstract boolean validarMove(int x, int y, int x1, int y1);
    public abstract String icon();
}
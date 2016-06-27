package Fichas;

import javax.swing.JLabel;

public abstract class Ficha extends JLabel implements Fortressable{
    public String color;
    public int turno;
    String name;
    
    public Ficha(String name, int turno){
        super();
        this.name = name;
        this.turno = turno;
        color = (turno == 1 ? "R" : "B");
    }
    
    public final String getFichaName(){
        return name;
    }
    
    public final int getTurno(){
        return turno;
    }
    
    public final String getColor(){
        return color;
    }
    
    public abstract boolean validarMove(int x, int y, int x1, int y1);
    public abstract String icon();
}
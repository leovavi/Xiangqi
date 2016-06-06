package Fichas;

public abstract class Ficha {
    int turno;
    String name;
    
    public Ficha(String name){
        turno = 1;
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public int getTurno(){
        return turno;
    }
    
    public abstract void move();
    public abstract boolean validarMove();
    public abstract String icon();
}
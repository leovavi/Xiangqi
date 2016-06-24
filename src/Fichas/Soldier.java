/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fichas;

/**
 *
 * @author Leovavi
 */
public final class Soldier extends Ficha{    
    public Soldier(String name, int turno){
        super(name, turno);
    }

    @Override
    public boolean validarMove(int x, int y, int x1, int y1){
        if(turno == 1){//Jugador 1 se mueve
             if(y>4)//Jugador 1 ha cruzado el rio
                return (y==y1 && (((x+1)==x1) || ((x-1)==x1))) || (x==x1 && (y+1)==y1);
            return (x==x1 && (y+1)==y1);
        }
        if(y<5)//Jugador 2 se mueve hacia arriba y ya ha cruzado el rio
            return ((y==y1 && ((x+1)==x1 || (x-1)==x1)) || (x==x1 && (y-1)==y1));
        return (x==x1 && y-1==y1);
    }

    @Override
    public String icon() {
        return "src/Imagenes/Fichas/Soldier"+getColor()+".png";
    }
    
    @Override
    public boolean insideFort(int x, int y){            
        return (x==3 && (y==0 || y==9)) || (x==4 && (y==0 || y==9)) || (x==5 && (y==0 || y==9)) ||
               (x==3 && (y==1 || y==8)) || (x==4 && (y==1 || y==8)) || (x==5 && (y==1 || y==8)) ||
               (x==3 && (y==2 || y==7)) || (x==4 && (y==2 || y==7)) || (x==5 && (y==2 || y==7));
    }
}

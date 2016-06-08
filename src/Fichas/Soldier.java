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
public class Soldier extends Ficha{
    public Soldier(String name){
        super(name);
    }

    @Override
    public void move() {

    }

    @Override
    public boolean validarMove(int x, int y, int x1, int y1){
        if(turno==1){//Jugador 1 se mueve
            if(x>5)//Jugador 1 ha cruzado el rio
                return ((x+1==x1 && y==y1) || (x==x1 && y-1==y1) || (x==x1 && y+1==y1));
            return (x+1==x1 && y==y1);
        }
        if(x>5)//Jugador 2 se mueve hacia arriba y ya ha cruzado el rio
            return ((x+1==x1 && y==y1) || (x==x1 && y+1==y1) || (x==x1 && y-1==y1));
        return (x+1==x1 && y==y1);
    }

    @Override
    public String icon() {
        if(turno == 1)
            return "src/Imagenes/Fichas/SoldierR.png";
        return "src/Imagenes/Fichas/SoldierB.png";
    }
    
    
}

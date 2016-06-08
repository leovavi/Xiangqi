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
public class General extends Ficha{
    public General(String name){
        super(name);
    }

    @Override
    public void move() {

    }

    @Override
    public boolean validarMove(int x, int y, int x1, int y1) {
        return ((x+1==x1 && y==y1) || (x-1==x1 && y==y1) || (x==x1 && y+1==y1) || (x==x1 && y-1==y1));
    }

    @Override
    public String icon() {
        if(turno == 1)
            return "src/Imagenes/Fichas/GeneralR.png";
        return "src/Imagenes/Fichas/GeneralB.png";
    }
    
    
}

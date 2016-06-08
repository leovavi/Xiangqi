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
public class Cannon extends Ficha{

    public Cannon(String name){
        super(name);
    }
    
    @Override
    public void move() {

    }

    @Override
    public boolean validarMove(int x, int y, int x1, int y1){
        return ((x>x1 && y==y1) || (x<x1 && y==y1) || (x==x1 && y>y1) || (x==x1 && y<y1));
    }

    @Override
    public String icon() {
        if(turno == 1)
            return "src/Imagenes/Fichas/CannonR.png";
        return "src/Imagenes/Fichas/CannonB.png";
    }
    
}

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
public class Elephant extends Ficha{
    public Elephant(String name){
        super(name);
    }

    @Override
    public void move() {

    }

    @Override
    public boolean validarMove(int x, int y, int x1, int y1) {
        return ((x+2==x1 && y+2==y1) || (x+2==x1 && y-2==y1) || (x-2==x1 && y-2==y1) || (x-2==x1 && y+2==y1));
    }

    @Override
    public String icon() {
        if(turno == 1)
            return "src/Imagenes/Fichas/ElephantR.png";
        return "src/Imagenes/Fichas/ElephantB.png";
    }
    
    
}

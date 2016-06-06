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
public class Chariot extends Ficha{
    public Chariot(String name){
        super(name);
    }
    
    @Override
    public void move() {

    }

    @Override
    public boolean validarMove() {
        return true;
    }

    @Override
    public String icon() {
        if(turno == 1)
            return "/Imagenes/Fichas/ChariotR.png";
        return "/Imagenes/Fichas/ChariotB.png";
    }
}

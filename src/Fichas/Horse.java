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
public class Horse extends Ficha{
    public Horse(String name){
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
            return "/Imagenes/Fichas/HorseR.png";
        return "/Imagenes/Fichas/HorseB.png";
    }
}

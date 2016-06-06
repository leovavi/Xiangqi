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
    public boolean validarMove() {
        return true;
    }

    @Override
    public String icon() {
        if(turno == 1)
            return "/Imagenes/Fichas/SoldierR.png";
        return "/Imagenes/Fichas/SoldierB.png";
    }
    
    
}

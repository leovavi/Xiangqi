/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fichas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Leovavi
 */
public final class Advisor extends Ficha{
    JLabel advisor = new JLabel();
    
    public Advisor(String name){
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
    public String icon(){
        return "/Imagenes/Fichas/Advisor.png";
    }
}
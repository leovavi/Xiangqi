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
    public General(String name, int turno){
        super(name, turno);
    }

    @Override
    public boolean validarMove(int x, int y, int x1, int y1) {
        return ((x==x1 && (y+1==y1) || y-1==y1) || (y==y1 && (x+1==x1 || x-1==x1)));
    }

    @Override
    public String icon() {
        return "src/Imagenes/Fichas/General"+getColor()+".png";
    }
    
    @Override
    public boolean insideFort(int x, int y){
        return true;
    }
    
}

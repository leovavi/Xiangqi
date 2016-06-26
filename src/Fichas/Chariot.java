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
public final class Chariot extends Ficha{
    public Chariot(String name, int turno){
        super(name, turno);
    }
    
    @Override
    public boolean validarMove(int x, int y, int x1, int y1) {
        return (y==y1 && (x>x1 || x<x1)) || (x==x1 && (y>y1 || y<y1));
    }

    @Override
    public String icon() {
        return "src/Imagenes/Fichas/Chariot"+getColor()+".png";
    }
    
    @Override
    public boolean insideFort(int x, int y){            
        return (x==3 && (y==0 || y==9)) || (x==4 && (y==0 || y==9)) || (x==5 && (y==0 || y==9)) ||
               (x==3 && (y==1 || y==8)) || (x==4 && (y==1 || y==8)) || (x==5 && (y==1 || y==8)) ||
               (x==3 && (y==2 || y==7)) || (x==4 && (y==2 || y==7)) || (x==5 && (y==2 || y==7));
    }
}

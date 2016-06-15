package Fichas;

import javax.swing.JLabel;

public class FichaVacia extends Ficha{
    String name;
    
    public FichaVacia(String name){
        super(name);
    }

    @Override
    public void move() {
    }

    @Override
    public boolean validarMove(int x, int y, int x1, int y1) {
        return false;
    }

    @Override
    public String icon() {
        return "Icon";
    }
}

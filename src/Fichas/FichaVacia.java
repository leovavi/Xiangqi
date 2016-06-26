package Fichas;

public final class FichaVacia extends Ficha{
    public FichaVacia(String name, int turno){
        super(name, turno);
    }
    @Override
    public boolean validarMove(int x, int y, int x1, int y1) {
        return false;
    }

    @Override
    public String icon() {
        return "Icon";
    }
    
    @Override
    public boolean insideFort(int x, int y){            
        return (x==3 && (y==0 || y==9)) || (x==4 && (y==0 || y==9)) || (x==5 && (y==0 || y==9)) ||
               (x==3 && (y==1 || y==8)) || (x==4 && (y==1 || y==8)) || (x==5 && (y==1 || y==8)) ||
               (x==3 && (y==2 || y==7)) || (x==4 && (y==2 || y==7)) || (x==5 && (y==2 || y==7));
    }
}

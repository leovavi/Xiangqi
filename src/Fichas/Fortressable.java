/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fichas;

import java.io.Serializable;

/**
 *
 * @author Leovavi
 */
public interface Fortressable  extends Serializable{
    //Utilizado para saber si los Generales y Consejeros pueden moverse ahí.
    public abstract boolean insideFort(int x, int y);
}

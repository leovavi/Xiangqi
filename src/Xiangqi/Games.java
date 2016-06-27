/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Xiangqi;

import Fichas.Ficha;
import java.io.File;
import java.io.Serializable;

/**
 *
 * @author Leovavi
 */
public class Games implements Serializable{
    public String oppUser;
    public int turno;
    public File file;
    public Ficha[][] fichas;
    
    public Games(String oppUser, int turno, File file, Ficha[][] fichas){
        this.oppUser = oppUser;
        this.turno = turno;
        this.file = file;
        this.fichas = fichas;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Xiangqi;

import java.util.Calendar;
import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author Leovavi
 */
public class Games {
    int turno;
    JLabel[][] pieces;
    Date lastModified;
    
    public Games(JLabel[][] pieces, int t){
        turno = t;
        this.pieces = pieces;
        lastModified = new Date(Calendar.getInstance().getTimeInMillis());
    }
}

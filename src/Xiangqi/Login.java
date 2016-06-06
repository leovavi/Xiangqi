/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Xiangqi;

import Errores.PasswordLengthException;
import java.util.Date;
/**
 *
 * @author Renan
 */
public class Login {
    Date fechaCreado;
    private final String user;
    private String pass;
    public static final int PASS_LENGTH = 5;
    
    public Login (String u, String p) throws PasswordLengthException{
        fechaCreado = new Date();
        user = u;
        setPass(p);
    }
    
    public Date getDate(){
        return fechaCreado;
    }
    
    public String getUser() {
        return user;
    }
    
    public String getPass() {
        return pass;
    }
    
    public void setPass(String pass) throws PasswordLengthException{
        if(verifyPass(pass))
            this.pass = pass;
        else
            throw new PasswordLengthException(PASS_LENGTH);
    }
    
    private boolean verifyPass(String pass) throws PasswordLengthException {
        if (pass.length() != PASS_LENGTH) {
            throw new PasswordLengthException(PASS_LENGTH);
        }
        return true;
    }
}

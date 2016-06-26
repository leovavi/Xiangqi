/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Errores;

/**
 *
 * @author Renan
 */
public class PasswordLengthException extends Exception {
    public PasswordLengthException(int passLength){
        super("Password must have "+passLength+" characters.");
    }
}

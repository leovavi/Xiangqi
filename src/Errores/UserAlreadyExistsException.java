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
public class UserAlreadyExistsException extends Exception{
    public UserAlreadyExistsException(String u){
        super("User "+u+" already exists. Please choose another one");
    }
}

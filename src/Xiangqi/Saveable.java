/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Xiangqi;

import Errores.PasswordLengthException;
import Errores.UserAlreadyExistsException;

/**
 *
 * @author Leovavi
 */
public interface Saveable {
    void saveUser(String u, String pass) throws UserAlreadyExistsException, PasswordLengthException;
    void listUsers();
}

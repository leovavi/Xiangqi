/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Xiangqi;

import Errores.PasswordLengthException;
import Errores.UserAlreadyExistsException;
import java.io.IOException;
import java.io.Serializable;

/**
 *
 * @author Leovavi
 */
public interface Saveable  extends Serializable{
    boolean searchUser(String u) throws IOException;
    void saveUser(String u, String pass) throws UserAlreadyExistsException, PasswordLengthException, IOException;
    void deleteUser(String u) throws IOException;
    void listUsers();
    void saveLogs(String msg);
}

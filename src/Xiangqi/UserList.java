/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Xiangqi;

import Errores.PasswordLengthException;
import Errores.UserAlreadyExistsException;
import java.util.ArrayList;

/**
 *
 * @author Renan
 */
public class UserList implements Saveable{
    public ArrayList<Login> users;
    public UserList(){
        users = new ArrayList<>();
    }
    
    public Login searchUser(String u) throws UserAlreadyExistsException{
        for (Login user : users){
            if (user.getUser().equals(u)) {
                return user;
            }   
        }
        return null;
    }
    
    @Override
    public void saveUser(String u, String pass) throws UserAlreadyExistsException, PasswordLengthException {
        if(searchUser(u)==null)
            users.add(new Login(u, pass));
        else
            throw new UserAlreadyExistsException(u);
    }
    @Override
    public void listUsers() {
        for (Login u : users){
            u.getUser();
        }
    }
}

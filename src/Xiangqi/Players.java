/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Xiangqi;

import Errores.PasswordLengthException;
import Errores.UserAlreadyExistsException;
import Visual.Menu;
import Visual.MenuPrincipal;
import Visual.PlayersAvailable;
import Visual.Tablero;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author Renan
 */
public class Players implements Saveable{
    public RandomAccessFile players, games, logs;
    public static final int PASS_LENGTH = 5;
    private static Date fechaIngreso;
    Tablero tab = new Tablero();
    
    /**
     * Crear el archivo players.xia cuyo formato será
     * 
     * Players.xia
     * Username
     * Password (5 caracteres únicamente)
     * Puntos(int)
     * Fecha de Ingreso (Formato Date)
     * Actividad (por default true)
     */
    
    public Players(){
        try{
            new File("Players").mkdir();
            File game = new File("Players/"+Menu.userLogged);
            players = new RandomAccessFile("Players/players.xia", "rw");
            games = new RandomAccessFile(game.getName()+"/", "rw");
        }catch(FileNotFoundException e){}
    }
    
    @Override
    public final boolean searchUser(String u) throws IOException{
        players.seek(0);
        while(players.getFilePointer()<players.length()){
            String user = players.readUTF();
            long pos = players.getFilePointer(); 
            players.readUTF();
            players.skipBytes(12);
            boolean activo = players.readBoolean();
            if(user.equals(u) && activo){
                players.seek(pos);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public final void saveUser(String u, String pass) throws UserAlreadyExistsException,PasswordLengthException,IOException,NullPointerException{
        if(u.length()>0){
            if(!searchUser(u)){
                if(pass.length() == PASS_LENGTH){
                    players.seek(players.length());
                    players.writeUTF(u);
                    players.writeUTF(pass);
                    players.writeInt(0);
                    players.writeLong(Calendar.getInstance().getTimeInMillis());
                    players.writeBoolean(true);
                }else
                    throw new PasswordLengthException(PASS_LENGTH);
            }else
                throw new UserAlreadyExistsException(u);
        }else
            throw new NullPointerException("Ingrese un usuario");
    }
    
    public final void Login(String user, String pass){
        try{
            if(searchUser(user)){
                if(players.readUTF().equals(pass)){
                    Menu.userLogged = user;
                    Menu.menu.setPanel(new MenuPrincipal());
                }else
                    Menu.menu.showMessage("Invalid Password");
            }else
                Menu.menu.showMessage("User "+user+" not found");
        }catch(NullPointerException e){
            Menu.menu.showMessage("Ingrese un usuario");
        }catch(IOException e){}
    }
    
    public final void createPlayer(String user, String pass){
        try{
            saveUser(user, pass);
            Menu.menu.showMessage("User Created!");
            Menu.userLogged = user;
            Menu.menu.setPanel(new MenuPrincipal());
        }catch(PasswordLengthException | UserAlreadyExistsException | NullPointerException | IOException e){
            Menu.menu.showMessage(e.getMessage());
        }
    }
    
    @Override
    public final void listUsers() {
        try{
            players.seek(0);
            while(players.getFilePointer()<players.length()){
                String user = players.readUTF();
                if(!user.equals(Menu.userLogged))
                    PlayersAvailable.dlm.addElement(user);
                players.readUTF();
                players.skipBytes(13);
            }
        }catch(IOException e){}
    }
    
    public final void changePassword(){
        try{
            searchUser(Menu.userLogged);
            long pos = players.getFilePointer();
            String currentPass = JOptionPane.showInputDialog(Menu.menu, "Current Password: ");
            if(currentPass.equals(players.readUTF())){
                players.seek(pos);
                String newPass = JOptionPane.showInputDialog(Menu.menu, "New Password: ");
                if(newPass.length()==PASS_LENGTH){
                    players.writeUTF(newPass);
                    Menu.menu.showMessage("Password Changed!");
                }else
                    Menu.menu.showMessage("Password must contain "+PASS_LENGTH+" characters");
            }else
                Menu.menu.showMessage("Invalid Password");
        }catch(IOException e){}   
    }
    
    public final void surrender(int t){
        try{
            String user1 = (t==1 ? Menu.userLogged : Menu.userLogged2);
            String user2 = (t==1 ? Menu.userLogged2 : Menu.userLogged);
            searchUser(user2);
            players.readUTF();
            long pos = players.getFilePointer();
            int puntos = players.readInt();
            players.seek(pos);
            players.writeInt(puntos+3);
            Menu.menu.showMessage(user1+" has retired, congratulations "+user2);
        }catch(IOException e){}
    }
    
    @Override
    public final void saveLogs(String u1, String u2, String msg){
        try{
            new File("Players/"+u1).mkdirs();
            new File("Players/"+u2).mkdirs();
            
            File logU1 = new File("Players/"+u1+"/logs.log");
            File logU2 = new File("Players/"+u2+"/logs.log");
            
            logU1.createNewFile();
            logU2.createNewFile();
            
            logs = new RandomAccessFile(logU1, "rw");
            
            logs.seek(logs.length());
            logs.writeLong(Calendar.getInstance().getTimeInMillis());
            logs.writeUTF(msg);
            
            logs = new RandomAccessFile(logU2, "rw");
            
            logs.seek(logs.length());
            logs.writeLong(Calendar.getInstance().getTimeInMillis());
            logs.writeUTF(msg);
        }catch(IOException e){}
    }
}

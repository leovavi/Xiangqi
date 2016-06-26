/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Xiangqi;

import Errores.PasswordLengthException;
import Errores.UserAlreadyExistsException;
import Visual.JugarXiangqi;
import Visual.Menu;
import Visual.MenuInicio;
import Visual.MenuPrincipal;
import Visual.PlayersAvailable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
/**
 *
 * @author Renan
 */
public class Xiangqi implements Saveable{
    public RandomAccessFile players, logsU1, logsU2, code;
    private static final int PASS_LENGTH = 5;
    private static Date fechaIngreso;
    private static String ROOT = "Players/";
    
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
    
    public Xiangqi(){
        try{
            new File("Players").mkdir();
            players = new RandomAccessFile(ROOT+"players.xia", "rw");
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void initRAF(String u) throws IOException{
        new File(ROOT+u).mkdirs();
        logsU1 = new RandomAccessFile(ROOT+u+"/logs", "rw");
        code = new RandomAccessFile(ROOT+u+"/codes", "rw");
    }
    
    public void closeRAF() throws IOException{
        logsU1.close();
        if(logsU2!=null)
            logsU2.close();
        code.close();
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
    
    public final void createPlayer(String user, String pass){
        try{
            saveUser(user, pass);
            new File(ROOT+user).mkdirs();
            File logs = new File(ROOT+user+"/logs");
            logs.createNewFile();
            File codes = new File(ROOT+user+"/codes");
            codes.createNewFile();
            initRAF(user);
            Menu.userLogged = user;
            Menu.menu.showMessage("User Created!");
            Menu.menu.setPanel(new MenuPrincipal());
        }catch(PasswordLengthException | UserAlreadyExistsException | NullPointerException | IOException e){
            Menu.menu.showMessage(e.getMessage());
        }
    }
    
    public final void Login(String user, String pass){
        try{
            if(searchUser(user)){
                if(players.readUTF().equals(pass)){
                    initRAF(user);
                    Menu.userLogged = user;
                    Menu.menu.setPanel(new MenuPrincipal());
                }else
                    Menu.menu.showMessage("Invalid Password");
            }else
                Menu.menu.showMessage("User "+user+" not found");
        }catch(IOException e){}
    }
    
    public final void changePassword() throws PasswordLengthException{
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
                    throw new PasswordLengthException(PASS_LENGTH);
            }else
                Menu.menu.showMessage("Invalid Password");
        }catch(IOException e){}   
    }
        
    @Override
    public final void deleteUser(String u) throws IOException{
        searchUser(u);
        String pass = JOptionPane.showInputDialog(Menu.menu, "Password: ");
        if(pass.equals(players.readUTF())){
            closeRAF();
            deleteGamesInvolved(new File(ROOT), u);
            deleteFiles(new File(ROOT+u));
            players.skipBytes(12);
            players.writeBoolean(false);
            Menu.userLogged = null;
            Menu.menu.showMessage("Account Deleted");
            Menu.menu.setPanel(new MenuInicio());
        }else
            Menu.menu.showMessage("Invalid Password!");
    }
    
    public final void deleteFiles(File file) throws IOException{
        if(file.isDirectory())
            for(File f : file.listFiles()){
                deleteFiles(f);
                f.delete();
            }
        file.delete();
    }
    
    public void deleteGamesInvolved(File path, String user){ 
        if(path.isDirectory()){
            for(File child : path.listFiles()){
                deleteGamesInvolved(child, user);
                String[] fileName = child.getName().split("-");
                if(fileName.length>1 && user.equals(fileName[1]))
                    child.delete();
            }
        }
    }
    
    public void deleteGame(String game){
        String[] gameName = game.split("-");
        String g = gameName[0]+"-"+gameName[1];
        String path = ROOT+Menu.userLogged+"/"+g;
        File gameFile = new File(path);
        int confirm = JOptionPane.showConfirmDialog(Menu.menu, "Are you sure?", "Delete Game", JOptionPane.YES_NO_CANCEL_OPTION);
        
        if(confirm==JOptionPane.YES_OPTION){
            if(gameFile.delete()){
                String user1 = Menu.userLogged;
                String user2 = Menu.userLogged2;
                String message = user1+" has retired, congratulations "+user2+". "+user2+" has gained 3 points";
                addPoints(user2, message);
                saveLogs(message);
                Menu.menu.setPanel(new JugarXiangqi());
            }
        }
    }
    
    public final void addPoints(String u, String msg){
        try{
            searchUser(u);
            players.readUTF();
            long pos = players.getFilePointer();
            int puntos = players.readInt();
            players.seek(pos);
            players.writeInt(puntos+3);
            Menu.menu.showMessage(msg);
        }catch(IOException e){}
    }
    
    public final void surrender(int t){
        int confirm = JOptionPane.showConfirmDialog(Menu.menu, "Are You Sure?", "Surrender",JOptionPane.YES_NO_CANCEL_OPTION);
        if(confirm==JOptionPane.YES_OPTION){
            String user1 = (t==1 ? Menu.userLogged : Menu.userLogged2);
            String user2 = (t==1 ? Menu.userLogged2 : Menu.userLogged);
            String msg = user1+" has retired, congratulations "+user2+". "+user2+" has gained 3 points";
            addPoints(user2, msg);
            saveLogs(msg);
            Menu.menu.setPanel(new MenuPrincipal());
        }
    }
    
    @Override
    public final void listUsers() {
        try{
            players.seek(0);
            while(players.getFilePointer()<players.length()){
                String user = players.readUTF();
                players.readUTF();
                players.skipBytes(12);
                if(players.readBoolean() && !user.equals(Menu.userLogged))
                    PlayersAvailable.dlm.addElement(user);
            }
        }catch(IOException e){}
    }
    
    public void initCode(String u){
        try{
            code = new RandomAccessFile(ROOT+u+"/codes", "rw");
            if(code.length()==0)
                code.writeInt(1);
        }catch(IOException e){}
    }
    
    public int getCode(String u){
        try{
            initCode(u);code.seek(0);
            int cod = code.readInt();
            code.seek(0);
            code.writeInt(cod+1);
            code.close();
            return cod;
        }catch(IOException e){}
        return 0;
    }
    
    @Override
    public final void saveLogs(String msg){
        try{
            initRAF(Menu.userLogged);
            logsU2 = new RandomAccessFile(ROOT+Menu.userLogged2+"/logs", "rw");
            
            logsU1.seek(logsU1.length());
            logsU1.writeLong(Calendar.getInstance().getTimeInMillis());
            logsU1.writeUTF(msg);
            
            logsU2.seek(logsU2.length());
            logsU2.writeLong(Calendar.getInstance().getTimeInMillis());
            logsU2.writeUTF(msg);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    
    public final void listLogs(DefaultListModel dlm){
        try{
            ArrayList<Date> dates = new ArrayList<>();
            ArrayList<String> msgs = new ArrayList<>();
            while(logsU1.getFilePointer()<logsU1.length()){
                Date date = new Date(logsU1.readLong());
                String msg = logsU1.readUTF();
                
                dates.add(date);
                msgs.add(msg);
            }
            for(int x = dates.size()-1; x>=0; x--){
                dlm.addElement(dates.get(x)+" "+msgs.get(x));
            }
        }catch(IOException e){}
    }
    
    public final void exportLogs(){
        String path = JOptionPane.showInputDialog(Menu.menu, "Path for txt File: ");
        if(path.length()>0){
            try(FileWriter fw = new FileWriter(path+".txt")){
                logsU1.seek(0);
                while(logsU1.getFilePointer()<logsU1.length()){
                    fw.write(new Date(logsU1.readLong()).toString());
                    fw.write(" "+logsU1.readUTF()+"\n");
                }
                Menu.menu.showMessage("Logs Exported!");
            }catch(IOException e){}
        }else
            Menu.menu.showMessage("Invalid Path!");
    }
    
    public void listGames(DefaultListModel dlm){
        File game = new File("Players/"+Menu.userLogged);
        int cont = 1;
        game.mkdirs();
        
        for(File g : game.listFiles()){
            if(!(g.getName().equals("codes")) && !(g.getName().equals("logs"))){
                String[] gameName = g.getName().split("-");
                dlm.addElement(cont+"-"+gameName[1]+"-"+new Date(g.lastModified()));
                cont++;
            }
        }
    }
}

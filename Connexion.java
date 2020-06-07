/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;
import java.sql.*;
/**
 *
 * @author ZianL
 */
public class Connexion {
    private String lien="jdbc:mysql://localhost:3306/projet_java";
    private String utilisateur="root";
    private String mdp="";
    private static Connection co;
    
    public Connexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver etablie");
            co=DriverManager.getConnection(lien,utilisateur,mdp);
            System.out.println("connexion etablie");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static Connection getInstance(){
        if(co == null){
            new Connexion();
        }
        return co;   
    }
}

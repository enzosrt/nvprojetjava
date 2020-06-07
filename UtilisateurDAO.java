/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.sql.*;
import java.util.*;

/**
 *
 * @author ZianL
 */
public class UtilisateurDAO extends DAO<Utilisateur>{
    public UtilisateurDAO(Connection conn) {
        super(conn);
    }

    @Override
    public void ajouter() {
        PreparedStatement pst=null;
        
        try {
            int a=nbligne();
            a=a+1;
            Scanner sc=new Scanner(System.in);
            System.out.println("Veuillez saisir l'email :");
            String e = sc.nextLine();
            System.out.println("Veuillez saisir le mot de passe :");
            String m = sc.nextLine();
            System.out.println("Veuillez saisir le nom :");
            String n = sc.nextLine();
            System.out.println("Veuillez saisir le prenom :");
            String p = sc.nextLine();
            System.out.println("Veuillez saisir le droit :");
            int d = sc.nextInt();
            pst=con.prepareStatement
            ("INSERT INTO utilisateur(ID,EMAIL,PASSWORD,NOM,PRENOM,DROIT) VALUES(?,?,?,?,?,?);");
            pst.setInt(1,a);
            pst.setString(2,e);
            pst.setString(3,m);
            pst.setString(4,n);
            pst.setString(5,p);
            pst.setInt(6,d);
            pst.executeUpdate();
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete() {
        Statement pst=null;
        
        try{
            Scanner sc=new Scanner(System.in);
            System.out.println("Veuillez saisir l'id de l'utilisateur a supprimer :");
            int s = sc.nextInt();
            String query="DELETE FROM utilisateur WHERE id="+s;
            pst=con.createStatement();
            pst.executeUpdate(query);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void modifier() {
        try{
            Scanner sc=new Scanner(System.in);
            System.out.println("Veuillez saisir l'id de l'utilisateur a modifier :");
            int i = sc.nextInt();
            ResultSet result =con.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_UPDATABLE).executeQuery("SELECT * FROM utilisateur WHERE ID = " + i);
            result.first();
            sc.nextLine();
            System.out.println("Utilisateur : " + result.getString("EMAIL")+" "
            + result.getString("PASSWORD")+" "+ result.getString("NOM")+" "+ 
            result.getString("PRENOM")+" "+ result.getString("DROIT"));
            System.out.println("Veuillez saisir le nouveau email :");
            String  e= sc.nextLine();
            result.updateString("EMAIL",e);
            System.out.println("Veuillez saisir le nouveau mot de passe :");
            String  m= sc.nextLine();
            result.updateString("PASSWORD",m);
            System.out.println("Veuillez saisir le nouveau nom :");
            String  n= sc.nextLine();
            result.updateString("NOM",n);
            System.out.println("Veuillez saisir le nouveau prenom :");
            String  p= sc.nextLine();
            result.updateString("PRENOM",p);
            System.out.println("Veuillez saisir le nouveau droit :");
            int  d= sc.nextInt();
            result.updateInt("DROIT",d);
            result.updateRow();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Utilisateur find(int id) {
        Utilisateur utilisateur=new Utilisateur();
        
        try {
            ResultSet result = this.con.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM utilisateur WHERE ID = " + id);
            if(result.first())
                utilisateur = new Utilisateur(id,result.getString("EMAIL"),
                result.getString("PASSWORD"),result.getString("NOM"),
                result.getString("PRENOM"),result.getInt("DROIT"));         
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateur;
    }

    @Override
    public int nbligne() {
        int a=0;
        
        try {
            ResultSet result = this.con.createStatement().executeQuery("SELECT count(*) AS a FROM utilisateur ");
            result.next();
            a=result.getInt("a");
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        return a;
    }
    
    
}

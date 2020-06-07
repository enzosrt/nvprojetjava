/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author ZianL
 */
public class SalleDAO extends DAO<Salle>{
    
    public SalleDAO(Connection conn) {
        super(conn);
    }

    @Override
    public void ajouter() {
        PreparedStatement pst=null;
        
        try {
            int a=nbligne();
            a=a+1;
            Scanner sc=new Scanner(System.in);
            System.out.println("Veuillez saisir une nouvelle salle :");
            String s = sc.nextLine();
            System.out.println("Veuillez saisir sa capacite :");
            int b = sc.nextInt();
            sc.nextLine();
            System.out.println("Veuillez saisir l'id du site ou elle se trouve :");
            int c = sc.nextInt(); 
            pst=con.prepareStatement("INSERT INTO salle(ID,NOM,CAPACITE,ID_SITE) "
            + "VALUES(?,?,?,?);");
            pst.setInt(1,a);
            pst.setString(2,s);
            pst.setInt(3,b);
            pst.setInt(4,c);
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
            System.out.println("Veuillez saisir l'id de la salle a supprimer :");
            int s = sc.nextInt();
            String query="DELETE FROM salle WHERE id="+s;
            pst=con.createStatement();
            pst.executeUpdate(query);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void modifier(){
        try{
            Scanner sc=new Scanner(System.in);
            System.out.println("Veuillez saisir l'id de la salle a modifier :");
            int i = sc.nextInt();
            ResultSet result =con.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_UPDATABLE).executeQuery("SELECT * FROM salle WHERE ID = " + i);
            result.first();
            sc.nextLine();
            System.out.println("Salle : " + result.getString("NOM")+" capacite :"
            +result.getInt("CAPACITE")+" id site :"+result.getInt("ID_SITE"));
            System.out.println("Veuillez saisir la nouvelle capacite :");
            int s = sc.nextInt();
            result.updateInt("CAPACITE",s);
            System.out.println("Veuillez saisir l'id du site ou elle se trouve :");
            int a = sc.nextInt();
            result.updateInt("ID_SITE",a);
            result.updateRow();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Salle find(int id) {
        Salle salle=new Salle();
        
        try {
            ResultSet result = this.con.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM salle WHERE ID = " + id);
            if(result.first())
                salle = new Salle(id,result.getString("NOM"),result.getInt("CAPACITE"),result.getInt("ID_SITE"));         
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        return salle;
    }
    
    @Override
    public int nbligne(){
        int a=0;
        
        try {
            ResultSet result = this.con.createStatement().executeQuery("SELECT count(*) AS a FROM salle ");
            result.next();
            a=result.getInt("a");
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        return a;
    }
}

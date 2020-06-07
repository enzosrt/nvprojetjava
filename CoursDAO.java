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
public class CoursDAO extends DAO<Cours>{
    
    public CoursDAO(Connection conn) {
        super(conn);
    }

    @Override
    public void ajouter() {
        PreparedStatement pst=null;
        
        try {
            int a=nbligne();
            a=a+1;
            Scanner sc=new Scanner(System.in);
            System.out.println("Veuillez saisir un nouveau cours :");
            String s = sc.nextLine(); 
            pst=con.prepareStatement("INSERT INTO cours(ID,NOM) VALUES(?,?);");
            pst.setInt(1,a);
            pst.setString(2,s);
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
            System.out.println("Veuillez saisir l'id du cours a supprimer :");
            int s = sc.nextInt();
            String query="DELETE FROM cours WHERE id="+s;
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
            System.out.println("Veuillez saisir l'id du cours a modifier :");
            int i = sc.nextInt();
            ResultSet result =con.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_UPDATABLE).executeQuery("SELECT * FROM cours WHERE ID = " + i);
            result.first();
            sc.nextLine();
            System.out.println("Cours : " + result.getString("NOM"));
            System.out.println("Veuillez saisir un nouveau cours :");
            String s = sc.nextLine();
            result.updateString("NOM",s);
            result.updateRow();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Cours find(int id) {
        Cours cours=new Cours();
        
        try {
            ResultSet result = this.con.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM cours WHERE ID = " + id);
            if(result.first())
                cours = new Cours(id,result.getString("NOM"));         
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        return cours;
    }
    
    @Override
    public int nbligne(){
        int a=0;
        
        try {
            ResultSet result = this.con.createStatement().executeQuery("SELECT count(*) AS a FROM cours ");
            result.next();
            a=result.getInt("a");
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        return a;
    }
}

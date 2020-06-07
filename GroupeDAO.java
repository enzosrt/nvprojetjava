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
public class GroupeDAO extends DAO<Groupe>{
    
    public GroupeDAO(Connection conn) {
        super(conn);
    }

    @Override
    public void ajouter() {
        PreparedStatement pst=null;
        
        try {
            int a=nbligne();
            a=a+1;
            Scanner sc=new Scanner(System.in);
            System.out.println("Veuillez saisir un nouveau groupe :");
            String s = sc.nextLine();
            System.out.println("Veuillez saisir la promotion :");
            int b = sc.nextInt(); 
            pst=con.prepareStatement("INSERT INTO groupe(ID,NOM,ID_PROMOTION) "
            + "VALUES(?,?,?);");
            pst.setInt(1,a);
            pst.setString(2,s);
            pst.setInt(3,b);
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
            System.out.println("Veuillez saisir l'id du groupe a supprimer :");
            int s = sc.nextInt();
            String query="DELETE FROM groupe WHERE id="+s;
            pst=con.createStatement();
            pst.executeUpdate(query);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void modifier(){
        
    }

    @Override
    public Groupe find(int id) {
        Groupe groupe=new Groupe();
        
        try {
            ResultSet result = this.con.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM groupe WHERE ID = " + id);
            if(result.first())
                groupe = new Groupe(id,result.getString("NOM"),result.getInt("ID_PROMOTION"));         
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        return groupe;
    }
    
    @Override
    public int nbligne(){
        int a=0;
        
        try {
            ResultSet result = this.con.createStatement().executeQuery("SELECT count(*) AS a FROM groupe ");
            result.next();
            a=result.getInt("a");
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        return a;
    }
}

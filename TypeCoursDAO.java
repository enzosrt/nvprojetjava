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
public class TypeCoursDAO extends DAO<TypeCours>{
    
    public TypeCoursDAO(Connection conn) {
        super(conn);
    }

    @Override
    public void ajouter() {
        PreparedStatement pst=null;
        
        try {
            int a=nbligne();
            a=a+1;
            Scanner sc=new Scanner(System.in);
            System.out.println("Veuillez saisir un nouveau type de cours :");
            String s = sc.nextLine(); 
            pst=con.prepareStatement("INSERT INTO type_cours(ID,NOM) VALUES(?,?);");
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
            System.out.println("Veuillez saisir l'id du type de cours a supprimer :");
            int s = sc.nextInt();
            String query="DELETE FROM type_cours WHERE id="+s;
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
    public TypeCours find(int id) {
        TypeCours cours=new TypeCours();
        
        try {
            ResultSet result = this.con.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM type_cours WHERE ID = " + id);
            if(result.first())
                cours = new TypeCours(id,result.getString("NOM"));         
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
            ResultSet result = this.con.createStatement().executeQuery("SELECT count(*) AS a FROM type_cours ");
            result.next();
            a=result.getInt("a");
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        return a;
    }
}

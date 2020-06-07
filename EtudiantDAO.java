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
public class EtudiantDAO extends DAO<Etudiant>{
    int num;
    
    public EtudiantDAO(Connection conn) {
        super(conn);
    }

    @Override
    public void ajouter() {
        PreparedStatement pst=null;
        
        try {
            Scanner sc=new Scanner(System.in);
            System.out.println("Veuillez saisir l'id de l'etudiant :");
            int a = sc.nextInt(); 
            sc.nextLine();
            System.out.println("Veuillez saisir l'id du groupe :");
            int s = sc.nextInt();
            sc.nextLine();
            ResultSet result = con.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM etudiant");
            while(result.next()){
                num=result.getInt("NUMERO");
            }
            num=num+1;
            pst=con.prepareStatement("INSERT INTO etudiant(ID_UTILISATEUR,NUMERO,ID_GROUPE)"
            + " VALUES(?,?,?);");
            pst.setInt(1,a);
            pst.setInt(2,num);
            pst.setInt(3,s);
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
            System.out.println("Veuillez saisir l'id de l'étudiant a supprimer :");
            int s = sc.nextInt();
            String query="DELETE FROM etudiant WHERE ID_UTILISATEUR="+s;
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
            System.out.println("Veuillez saisir l'id de l'etudiant qui change de groupe :");
            int i = sc.nextInt();
            ResultSet result =con.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_UPDATABLE).executeQuery("SELECT * FROM etudiant WHERE ID_UTILISATEUR = " + i);
            result.first();
            sc.nextLine();
            System.out.println("Etudiant : " + result.getInt("ID_UTILISATEUR")
            +"-- Numero : "+result.getInt("NUMERO")+"-- groupe : "
            +result.getInt("ID_GROUPE"));
            System.out.println("Veuillez saisir le nouveau groupe :");
            int s = sc.nextInt();
            result.updateInt("ID_GROUPE",s);
            result.updateRow();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Etudiant find(int id) {
        Etudiant etudiant=new Etudiant();
        
        try {
            ResultSet result = this.con.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM etudiant WHERE ID_UTILISATEUR = " + id);
            if(result.first())
                etudiant = new Etudiant(id,result.getInt("NUMERO"),result.getInt("ID_GROUPE"));         
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        return etudiant;
    }
    
    @Override
    public int nbligne(){
        int a=0;
        
        try {
            ResultSet result = this.con.createStatement().executeQuery("SELECT count(*) AS a FROM etudiant ");
            result.next();
            a=result.getInt("a");
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        return a;
    }
}

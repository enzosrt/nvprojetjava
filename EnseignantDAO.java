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
public class EnseignantDAO extends DAO<Enseignant>{
    
    public EnseignantDAO(Connection conn) {
        super(conn);
    }

    @Override
    public void ajouter() {
        PreparedStatement pst=null;
        
        try {
            int c=1;
            int d;
            int b=nbligne();
            b=b+1;
            ResultSet result = this.con.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM enseignant");
            while(result.next()){
                d=result.getInt("ID");
                if (d!=c){
                    b=c;
                }
                else{
                    c=c+1;
                }
            }
            Scanner sc=new Scanner(System.in);
            System.out.println("Veuillez saisir l'ID de l'utilisateur à ajouter :");
            int a = sc.nextInt(); 
            sc.nextLine();
            System.out.println("Veuillez saisir l'ID du cours à laquelle seras affecter l'enseignant :");
            int  s= sc.nextInt(); 
            pst=con.prepareStatement("INSERT INTO Enseignant(ID,ID_UTILISATEUR,ID_COURS)"
            + " VALUES(?,?,?);");
            pst.setInt(1,b);
            pst.setInt(2,a);
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
            System.out.println("Veuillez saisir l'id de l'enseignant a supprimer :");
            int s = sc.nextInt();
            sc.nextLine();
            String query="DELETE FROM enseignant WHERE ID ="+s;
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
            System.out.println("Veuillez saisir l'id de l'enseignant :");
            int i = sc.nextInt();
            sc.nextLine();
            ResultSet result =con.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_UPDATABLE).executeQuery("SELECT * FROM enseignant WHERE ID_UTILISATEUR="+i);
            result.first();
            sc.nextLine();
            System.out.println("Id enseignant : " + result.getInt("ID")+
            "-- Id utilisateur"+result.getInt("ID_UTILISATEUR")+
            "-- Id cours : "+result.getInt("ID_COURS"));
            System.out.println("Veuillez saisir l'id de l'utilisateur:");
            int s = sc.nextInt();
            result.updateInt("ID_UTILISATEUR",s);
            sc.nextLine();
            System.out.println("Veuillez saisir l'id du cours:");
            int r = sc.nextInt();
            result.updateInt("ID_COURS",r);
            result.updateRow();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Enseignant find(int id) {
        Enseignant enseignant=new Enseignant();
        
        try {
            ResultSet result = this.con.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM enseignant WHERE ID = " + id);
            while(result.next()){
                enseignant = new Enseignant(id,result.getInt("ID_UTILISATEUR"),
                result.getInt("ID_COURS"));
                System.out.println("Cours N°" + enseignant.getId() + "  - " + 
                enseignant.getId1()+" - "+ enseignant.getId2());
            }
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        return enseignant;
    }
    
    @Override
    public int nbligne(){
        int a=0;
        
        try {
            ResultSet result = this.con.createStatement().executeQuery("SELECT count(*) AS a FROM enseignant ");
            result.next();
            a=result.getInt("a");
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        return a;
    }
}

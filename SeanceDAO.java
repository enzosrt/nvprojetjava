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
public class SeanceDAO extends DAO<Seance>{
    
    public SeanceDAO(Connection conn) {
        super(conn);
    }

    @Override
    public void ajouter() {
        PreparedStatement pst=null;
        PreparedStatement pst1=null;
        PreparedStatement pst2=null;
        PreparedStatement pst3=null;
        
        try {
            int o=1;
            int v;
            int a=nbligne();
            a=a+1;
            ResultSet result = this.con.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM seance");
            while(result.next()){
                v=result.getInt("ID");
                if (v!=o){
                    a=o;
                }
                else{
                    o=o+1;
                }
            }
            Scanner sc=new Scanner(System.in);
            System.out.println("Veuillez saisir la semaine de la seance :");
            int s = sc.nextInt(); 
            sc.nextLine();
            System.out.println("Veuillez saisir la date de la seance :");
            String b = sc.nextLine();
            System.out.println("Veuillez saisir l'heure de debut de la seance :");
            String c = sc.nextLine();
            System.out.println("Veuillez saisir l'heure de fin de la seance :");
            String d = sc.nextLine();
            System.out.println("Veuillez saisir l'etat de la seance :");
            String e = sc.nextLine();
            System.out.println("Veuillez saisir l'id du cours :");
            int f = sc.nextInt();
            sc.nextLine();
            System.out.println("Veuillez saisir l'id du type de cours :");
            int g = sc.nextInt();
            sc.nextLine();
            System.out.println("Veuillez saisir l'id de l'enseignant en charge de la seance :");
            int h = sc.nextInt();
            sc.nextLine();
            System.out.println("Veuillez saisir l'id du groupe qui participe a la seance :");
            int i = sc.nextInt();
            sc.nextLine();
            System.out.println("Veuillez saisir l'id de la salle qui acceuille la seance  :");
            int j = sc.nextInt();
            pst=con.prepareStatement("INSERT INTO seance"
            + "(ID,SEMAINE,DATE,HEURE_DEBUT,HEURE_FIN,ETAT,ID_COURS,ID_TYPE)"
            + "VALUES(?,?,?,?,?,?,?,?);");
            pst.setInt(1,a);
            pst.setInt(2,s);
            pst.setString(3,b);
            pst.setString(4,c);
            pst.setString(5,d);
            pst.setString(6,e);
            pst.setInt(7,f);
            pst.setInt(8,g);
            pst.executeUpdate();
            pst1=con.prepareStatement("INSERT INTO seance_enseignants(ID_SEANCE,ID_ENSEIGNANT)"
            + "VALUES(?,?)");
            pst1.setInt(1,a);
            pst1.setInt(2,h);
            pst1.executeUpdate();
            pst2=con.prepareStatement("INSERT INTO seance_groupes(ID_SEANCE,ID_GROUPE)"
            + "VALUES(?,?)");
            pst2.setInt(1,a);
            pst2.setInt(2,i);
            pst2.executeUpdate();
            pst3=con.prepareStatement("INSERT INTO seance_salle(ID_SEANCE,ID_SALLE)"
            + "VALUES(?,?)");
            pst3.setInt(1,a);
            pst3.setInt(2,j);
            pst3.executeUpdate();
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete() {
        
    }
    
    @Override
    public void modifier(){
        try{
            Scanner sc=new Scanner(System.in);
            System.out.println("Veuillez saisir l'id de la seance a modifier :");
            int i = sc.nextInt();
            ResultSet result =con.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_UPDATABLE).executeQuery("SELECT * FROM seance WHERE ID = " + i);
            result.first();
            sc.nextLine();
            System.out.println("Seance : " + result.getInt("SEMAINE")+" Date : "
            +result.getString("DATE")+" DEBUT : "+ result.getString("HEURE_DEBUT")
            +" FIN : "+result.getString("HEURE_FIN")+" etat : "+result.getString("ETAT")
            +"id cours : "+result.getString("ID_COURS")+"id type : "
            +result.getString("ID_TYPE"));
            System.out.println("Veuillez saisir une semaine :");
            int s = sc.nextInt();
            sc.nextLine();
            System.out.println("Veuillez saisir une date :");
            String a = sc.nextLine();
            System.out.println("Veuillez saisir une heure de debut:");
            String b = sc.nextLine();
            System.out.println("Veuillez saisir une heure de fin:");
            String c = sc.nextLine();
            System.out.println("Veuillez saisir l'etat:");
            String d = sc.nextLine();
            System.out.println("Veuillez saisir l'id du cours:");
            int e = sc.nextInt();
            sc.nextLine();
            System.out.println("Veuillez saisir l'id du type de cours:");
            int f = sc.nextInt();
            sc.nextLine();
            result.updateInt("SEMAINE",s);
            result.updateString("DATE",a);
            result.updateString("HEURE_DEBUT",b);
            result.updateString("HEURE_FIN",c);
            result.updateString("ETAT",d);
            result.updateInt("ID_COURS",e);
            result.updateInt("ID_TYPE",f);
            result.updateRow();
            result =con.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_UPDATABLE).executeQuery("SELECT * FROM seance_enseignants "
            + "WHERE ID_SEANCE= " + i);
            result.first();
            System.out.println("Id enseignant : " + result.getInt("ID_ENSEIGNANT"));
            System.out.println("Veuillez saisir l'id de l'enseignant en charge de la seance:");
            int g = sc.nextInt();
            sc.nextLine();
            result.updateInt("ID_ENSEIGNANT",g);
            result.updateRow();
            result =con.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_UPDATABLE).executeQuery("SELECT * FROM seance_groupes "
            + "WHERE ID_SEANCE = " + i);
            result.first();
            System.out.println("Id groupe : " + result.getInt("ID_GROUPE"));
            System.out.println("Veuillez saisir l'id du groupe qui assiste à la seance:");
            int h = sc.nextInt();
            sc.nextLine();
            result.updateInt("ID_GROUPE",h);
            result.updateRow();
            result =con.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_UPDATABLE).executeQuery("SELECT * FROM seance_salle "
            + "WHERE ID_SEANCE =" + i);
            result.first();
            System.out.println("Id salle : " + result.getInt("ID_SALLE"));
            System.out.println("Veuillez saisir l'id de la salle qui acceuuille la seance:");
            int j = sc.nextInt();
            sc.nextLine();
            result.updateInt("ID_SALLE",j);
            result.updateRow();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Seance find(int id) {
        Seance seance=new Seance();
        
        try {
            ResultSet result = this.con.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM seance WHERE ID = " + id);
            if(result.first())
                seance = new Seance(id,result.getInt("SEMAINE"),result.getString("DATE"),
                result.getString("HEURE_DEBUT"),result.getString("HEURE_FIN"),
                result.getString("ETAT"),result.getInt("ID_COURS"),result.getInt("ID_TYPE"));         
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        return seance;
    }
    
    @Override
    public int nbligne(){
        int a=0;
        
        try {
            ResultSet result = this.con.createStatement().executeQuery("SELECT count(*) AS a FROM seance ");
            result.next();
            a=result.getInt("a");
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        return a;
    }
}

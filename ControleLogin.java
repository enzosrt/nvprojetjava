/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modele.*;
import Vue.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JMenuItem;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author ZianL
 */
public class ControleLogin implements ActionListener{
    Login l,m;
    JTextField champ;
    JPasswordField mdp;
    Connection con;
    int i,j,k,a,b;
    Object[][] Data1,Data2,Data3,Data4,Data5,Data6,Data7,Data8,Data9,Data10;
    String groupe,salle,site,cours,type;
    
    public ControleLogin(Login l,Login m,JTextField champ,JPasswordField mdp,Connection conn){
        this.l=l;
        this.m=m;
        this.champ=champ;
        this.mdp=mdp;
        this.con=conn;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        l.setLogin(champ.getText());
        m.setLogin(mdp.getText());
        String lo=champ.getText();
        String mo=mdp.getText();
        
        try {
            ResultSet result = con.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM utilisateur");
            while(result.next()){
                String LoginRecup = result.getString("EMAIL");
                String MPRecup = result.getString("PASSWORD");
                int idrecup=result.getInt("ID");
                int recupdroit=result.getInt("DROIT");
                if (LoginRecup.equals(lo)&& MPRecup.equals(mo)){
                    System.out.println("Connexion reussi");
                    Main.user=idrecup;
                    Main.droit=recupdroit;
                    Main.f.dispose();
                    switch (Main.droit){
                        case 1:
                            
                        case 2:
                            
                        case 3:
                            result = con.createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_READ_ONLY).executeQuery
                            ("SELECT * FROM seance_enseignants WHERE ID_ENSEIGNANT="+Main.user);
                            while(result.next()){
                                ResultSet result1 = con.createStatement(
                                ResultSet.TYPE_SCROLL_INSENSITIVE,
                                ResultSet.CONCUR_READ_ONLY).executeQuery
                                ("SELECT * FROM seance_groupes WHERE ID_SEANCE="
                                +result.getInt("ID_SEANCE"));
                                if(result1.first()){
                                    ResultSet result2 = con.createStatement(
                                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                                    ResultSet.CONCUR_READ_ONLY).executeQuery
                                    ("SELECT * FROM groupe WHERE ID="
                                    +result1.getInt("ID_GROUPE"));
                                    if(result2.first()){
                                        groupe=result2.getString("NOM");
                                    }
                                }
                                result1 = con.createStatement(
                                ResultSet.TYPE_SCROLL_INSENSITIVE,
                                ResultSet.CONCUR_READ_ONLY).executeQuery
                                ("SELECT * FROM seance_salle WHERE ID_SEANCE="
                                +result.getInt("ID_SEANCE"));
                                if(result1.first()){
                                    ResultSet result2 = con.createStatement(
                                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                                    ResultSet.CONCUR_READ_ONLY).executeQuery
                                    ("SELECT * FROM salle WHERE ID="
                                    +result1.getInt("ID_SALLE"));
                                    if(result2.first()){
                                        salle=result2.getString("NOM");
                                        ResultSet result3 = con.createStatement(
                                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                                        ResultSet.CONCUR_READ_ONLY).executeQuery
                                        ("SELECT * FROM site WHERE ID="
                                        +result2.getInt("ID_SITE"));
                                        if(result3.first()){
                                            site=result3.getString("NOM");
                                        }
                                    }
                                }
                                result1 = con.createStatement(
                                ResultSet.TYPE_SCROLL_INSENSITIVE,
                                ResultSet.CONCUR_READ_ONLY).executeQuery
                                ("SELECT * FROM seance WHERE ID="
                                +result.getInt("ID_SEANCE"));
                                if(result1.first()){
                                    ResultSet result2 = con.createStatement(
                                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                                    ResultSet.CONCUR_READ_ONLY).executeQuery
                                    ("SELECT * FROM cours WHERE ID="
                                    +result1.getInt("ID_COURS"));
                                    if(result2.first()){
                                        cours=result2.getString("NOM");
                                    }
                                    result2 = con.createStatement(
                                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                                    ResultSet.CONCUR_READ_ONLY).executeQuery
                                    ("SELECT * FROM type_cours WHERE ID="
                                    +result1.getInt("ID_TYPE"));
                                    if(result2.first()){
                                        type=result2.getString("NOM");
                                    }
                                    switch (result1.getInt("SEMAINE")){
                                        case 1:
                                            Data1=Main.f1.getData1();
                                            for(i=0;i<8;i++){
                                                if (result1.getString("DATE").equals(Data1[0][i])){
                                                    j=i;
                                                }
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("8:30")){
                                                k=1;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("10:15")){
                                                k=2;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("12:00")){
                                                k=3;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("13:45")){
                                                k=4;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("15:30")){
                                                k=5;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("17:15")){
                                                k=6;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("19:00")){
                                                k=7;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("10:00")){
                                                a=2;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("11:45")){
                                                a=3;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("13:30")){
                                                a=4;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("15:15")){
                                                a=5;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("17:00")){
                                                a=6;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("18:45")){
                                                a=7;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("20:30")){
                                                a=8;
                                            }
                                            for (i=k;i<a;i++){
                                                Data1[i][j]=cours+" "+type+" "+groupe+" "+salle+" "+site;
                                            }
                                        case 2:
                                            Data2=Main.f1.getData1();
                                            for(i=0;i<8;i++){
                                                if (result1.getString("DATE").equals(Data2[0][i])){
                                                    j=i;
                                                }
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("8:30")){
                                                k=1;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("10:15")){
                                                k=2;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("12:00")){
                                                k=3;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("13:45")){
                                                k=4;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("15:30")){
                                                k=5;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("17:15")){
                                                k=6;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("19:00")){
                                                k=7;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("10:00")){
                                                a=2;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("11:45")){
                                                a=3;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("13:30")){
                                                a=4;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("15:15")){
                                                a=5;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("17:00")){
                                                a=6;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("18:45")){
                                                a=7;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("20:30")){
                                                a=8;
                                            }
                                            for (i=k;i<a;i++){
                                                Data2[i][j]=cours+" "+type+" "+groupe+" "+salle+" "+site;
                                            }
                                        case 3:
                                            Data3=Main.f1.getData1();
                                            for(i=0;i<8;i++){
                                                if (result1.getString("DATE").equals(Data3[0][i])){
                                                    j=i;
                                                }
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("8:30")){
                                                k=1;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("10:15")){
                                                k=2;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("12:00")){
                                                k=3;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("13:45")){
                                                k=4;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("15:30")){
                                                k=5;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("17:15")){
                                                k=6;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("19:00")){
                                                k=7;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("10:00")){
                                                a=2;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("11:45")){
                                                a=3;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("13:30")){
                                                a=4;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("15:15")){
                                                a=5;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("17:00")){
                                                a=6;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("18:45")){
                                                a=7;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("20:30")){
                                                a=8;
                                            }
                                            for (i=k;i<a;i++){
                                                Data3[i][j]=cours+" "+type+" "+groupe+" "+salle+" "+site;
                                            }
                                        case 4:
                                            Data4=Main.f1.getData1();
                                            for(i=0;i<8;i++){
                                                if (result1.getString("DATE").equals(Data4[0][i])){
                                                    j=i;
                                                }
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("8:30")){
                                                k=1;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("10:15")){
                                                k=2;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("12:00")){
                                                k=3;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("13:45")){
                                                k=4;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("15:30")){
                                                k=5;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("17:15")){
                                                k=6;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("19:00")){
                                                k=7;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("10:00")){
                                                a=2;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("11:45")){
                                                a=3;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("13:30")){
                                                a=4;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("15:15")){
                                                a=5;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("17:00")){
                                                a=6;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("18:45")){
                                                a=7;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("20:30")){
                                                a=8;
                                            }
                                            for (i=k;i<a;i++){
                                                Data4[i][j]=cours+" "+type+" "+groupe+" "+salle+" "+site;
                                            }
                                        case 5:
                                            Data5=Main.f1.getData1();
                                            for(i=0;i<8;i++){
                                                if (result1.getString("DATE").equals(Data5[0][i])){
                                                    j=i;
                                                }
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("8:30")){
                                                k=1;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("10:15")){
                                                k=2;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("12:00")){
                                                k=3;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("13:45")){
                                                k=4;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("15:30")){
                                                k=5;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("17:15")){
                                                k=6;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("19:00")){
                                                k=7;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("10:00")){
                                                a=2;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("11:45")){
                                                a=3;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("13:30")){
                                                a=4;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("15:15")){
                                                a=5;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("17:00")){
                                                a=6;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("18:45")){
                                                a=7;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("20:30")){
                                                a=8;
                                            }
                                            for (i=k;i<a;i++){
                                                Data5[i][j]=cours+" "+type+" "+groupe+" "+salle+" "+site;
                                            }
                                        case 6:
                                            Data6=Main.f1.getData1();
                                            for(i=0;i<8;i++){
                                                if (result1.getString("DATE").equals(Data6[0][i])){
                                                    j=i;
                                                }
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("8:30")){
                                                k=1;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("10:15")){
                                                k=2;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("12:00")){
                                                k=3;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("13:45")){
                                                k=4;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("15:30")){
                                                k=5;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("17:15")){
                                                k=6;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("19:00")){
                                                k=7;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("10:00")){
                                                a=2;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("11:45")){
                                                a=3;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("13:30")){
                                                a=4;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("15:15")){
                                                a=5;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("17:00")){
                                                a=6;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("18:45")){
                                                a=7;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("20:30")){
                                                a=8;
                                            }
                                            for (i=k;i<a;i++){
                                                Data6[i][j]=cours+" "+type+" "+groupe+" "+salle+" "+site;
                                            }
                                        case 7:
                                            Data7=Main.f1.getData1();
                                            for(i=0;i<8;i++){
                                                if (result1.getString("DATE").equals(Data7[0][i])){
                                                    j=i;
                                                }
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("8:30")){
                                                k=1;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("10:15")){
                                                k=2;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("12:00")){
                                                k=3;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("13:45")){
                                                k=4;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("15:30")){
                                                k=5;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("17:15")){
                                                k=6;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("19:00")){
                                                k=7;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("10:00")){
                                                a=2;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("11:45")){
                                                a=3;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("13:30")){
                                                a=4;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("15:15")){
                                                a=5;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("17:00")){
                                                a=6;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("18:45")){
                                                a=7;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("20:30")){
                                                a=8;
                                            }
                                            for (i=k;i<a;i++){
                                                Data7[i][j]=cours+" "+type+" "+groupe+" "+salle+" "+site;
                                            }
                                        case 8:
                                            Data8=Main.f1.getData1();
                                            for(i=0;i<8;i++){
                                                if (result1.getString("DATE").equals(Data8[0][i])){
                                                    j=i;
                                                }
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("8:30")){
                                                k=1;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("10:15")){
                                                k=2;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("12:00")){
                                                k=3;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("13:45")){
                                                k=4;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("15:30")){
                                                k=5;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("17:15")){
                                                k=6;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("19:00")){
                                                k=7;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("10:00")){
                                                a=2;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("11:45")){
                                                a=3;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("13:30")){
                                                a=4;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("15:15")){
                                                a=5;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("17:00")){
                                                a=6;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("18:45")){
                                                a=7;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("20:30")){
                                                a=8;
                                            }
                                            for (i=k;i<a;i++){
                                                Data8[i][j]=cours+" "+type+" "+groupe+" "+salle+" "+site;
                                            }
                                        case 9:
                                            Data9=Main.f1.getData1();
                                            for(i=0;i<8;i++){
                                                if (result1.getString("DATE").equals(Data9[0][i])){
                                                    j=i;
                                                }
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("8:30")){
                                                k=1;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("10:15")){
                                                k=2;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("12:00")){
                                                k=3;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("13:45")){
                                                k=4;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("15:30")){
                                                k=5;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("17:15")){
                                                k=6;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("19:00")){
                                                k=7;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("10:00")){
                                                a=2;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("11:45")){
                                                a=3;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("13:30")){
                                                a=4;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("15:15")){
                                                a=5;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("17:00")){
                                                a=6;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("18:45")){
                                                a=7;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("20:30")){
                                                a=8;
                                            }
                                            for (i=k;i<a;i++){
                                                Data9[i][j]=cours+" "+type+" "+groupe+" "+salle+" "+site;
                                            }
                                        case 10:
                                            Data10=Main.f1.getData1();
                                            for(i=0;i<8;i++){
                                                if (result1.getString("DATE").equals(Data10[0][i])){
                                                    j=i;
                                                }
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("8:30")){
                                                k=1;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("10:15")){
                                                k=2;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("12:00")){
                                                k=3;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("13:45")){
                                                k=4;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("15:30")){
                                                k=5;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("17:15")){
                                                k=6;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("19:00")){
                                                k=7;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("10:00")){
                                                a=2;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("11:45")){
                                                a=3;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("13:30")){
                                                a=4;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("15:15")){
                                                a=5;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("17:00")){
                                                a=6;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("18:45")){
                                                a=7;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("20:30")){
                                                a=8;
                                            }
                                            for (i=k;i<a;i++){
                                                Data10[i][j]=cours+" "+type+" "+groupe+" "+salle+" "+site;
                                            }
                                    }
                                }
                            }
                        case 4:
                            result = con.createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_READ_ONLY).executeQuery
                            ("SELECT * FROM etudiant WHERE ID_UTILISATEUR="+Main.user);
                            while(result.next()){
                                ResultSet result1 = con.createStatement(
                                ResultSet.TYPE_SCROLL_INSENSITIVE,
                                ResultSet.CONCUR_READ_ONLY).executeQuery
                                ("SELECT * FROM seance_groupes WHERE ID_GROUPE="
                                +result.getInt("ID_GROUPE"));
                                if(result1.first()){
                                    b=result1.getInt("ID_SEANCE");
                                    ResultSet result2 = con.createStatement(
                                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                                    ResultSet.CONCUR_READ_ONLY).executeQuery
                                    ("SELECT * FROM groupe WHERE ID="
                                    +result1.getInt("ID_GROUPE"));
                                    if(result2.first()){
                                        groupe=result2.getString("NOM");
                                    }
                                }
                                result1 = con.createStatement(
                                ResultSet.TYPE_SCROLL_INSENSITIVE,
                                ResultSet.CONCUR_READ_ONLY).executeQuery
                                ("SELECT * FROM seance_salle WHERE ID_SEANCE="+b);
                                if(result1.first()){
                                    ResultSet result2 = con.createStatement(
                                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                                    ResultSet.CONCUR_READ_ONLY).executeQuery
                                    ("SELECT * FROM salle WHERE ID="
                                    +result1.getInt("ID_SALLE"));
                                    if(result2.first()){
                                        salle=result2.getString("NOM");
                                        ResultSet result3 = con.createStatement(
                                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                                        ResultSet.CONCUR_READ_ONLY).executeQuery
                                        ("SELECT * FROM site WHERE ID="
                                        +result2.getInt("ID_SITE"));
                                        if(result3.first()){
                                            site=result3.getString("NOM");
                                        }
                                    }
                                }
                                result1 = con.createStatement(
                                ResultSet.TYPE_SCROLL_INSENSITIVE,
                                ResultSet.CONCUR_READ_ONLY).executeQuery
                                ("SELECT * FROM seance WHERE ID="+b);
                                if(result1.first()){
                                    ResultSet result2 = con.createStatement(
                                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                                    ResultSet.CONCUR_READ_ONLY).executeQuery
                                    ("SELECT * FROM cours WHERE ID="
                                    +result1.getInt("ID_COURS"));
                                    if(result2.first()){
                                        cours=result2.getString("NOM");
                                    }
                                    result2 = con.createStatement(
                                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                                    ResultSet.CONCUR_READ_ONLY).executeQuery
                                    ("SELECT * FROM type_cours WHERE ID="
                                    +result1.getInt("ID_TYPE"));
                                    if(result2.first()){
                                        type=result2.getString("NOM");
                                    }
                                    switch (result1.getInt("SEMAINE")){
                                        case 1:
                                            Data1=Main.f1.getData1();
                                            for(i=0;i<8;i++){
                                                if (result1.getString("DATE").equals(Data1[0][i])){
                                                    j=i;
                                                }
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("8:30")){
                                                k=1;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("10:15")){
                                                k=2;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("12:00")){
                                                k=3;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("13:45")){
                                                k=4;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("15:30")){
                                                k=5;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("17:15")){
                                                k=6;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("19:00")){
                                                k=7;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("10:00")){
                                                a=2;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("11:45")){
                                                a=3;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("13:30")){
                                                a=4;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("15:15")){
                                                a=5;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("17:00")){
                                                a=6;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("18:45")){
                                                a=7;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("20:30")){
                                                a=8;
                                            }
                                            for (i=k;i<a;i++){
                                                Data1[i][j]=cours+" "+type+" "+groupe+" "+salle+" "+site;
                                            }
                                        case 2:
                                            Data2=Main.f1.getData1();
                                            for(i=0;i<8;i++){
                                                if (result1.getString("DATE").equals(Data2[0][i])){
                                                    j=i;
                                                }
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("8:30")){
                                                k=1;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("10:15")){
                                                k=2;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("12:00")){
                                                k=3;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("13:45")){
                                                k=4;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("15:30")){
                                                k=5;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("17:15")){
                                                k=6;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("19:00")){
                                                k=7;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("10:00")){
                                                a=2;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("11:45")){
                                                a=3;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("13:30")){
                                                a=4;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("15:15")){
                                                a=5;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("17:00")){
                                                a=6;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("18:45")){
                                                a=7;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("20:30")){
                                                a=8;
                                            }
                                            for (i=k;i<a;i++){
                                                Data2[i][j]=cours+" "+type+" "+groupe+" "+salle+" "+site;
                                            }
                                        case 3:
                                            Data3=Main.f1.getData1();
                                            for(i=0;i<8;i++){
                                                if (result1.getString("DATE").equals(Data3[0][i])){
                                                    j=i;
                                                }
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("8:30")){
                                                k=1;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("10:15")){
                                                k=2;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("12:00")){
                                                k=3;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("13:45")){
                                                k=4;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("15:30")){
                                                k=5;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("17:15")){
                                                k=6;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("19:00")){
                                                k=7;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("10:00")){
                                                a=2;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("11:45")){
                                                a=3;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("13:30")){
                                                a=4;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("15:15")){
                                                a=5;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("17:00")){
                                                a=6;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("18:45")){
                                                a=7;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("20:30")){
                                                a=8;
                                            }
                                            for (i=k;i<a;i++){
                                                Data3[i][j]=cours+" "+type+" "+groupe+" "+salle+" "+site;
                                            }
                                        case 4:
                                            Data4=Main.f1.getData1();
                                            for(i=0;i<8;i++){
                                                if (result1.getString("DATE").equals(Data4[0][i])){
                                                    j=i;
                                                }
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("8:30")){
                                                k=1;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("10:15")){
                                                k=2;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("12:00")){
                                                k=3;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("13:45")){
                                                k=4;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("15:30")){
                                                k=5;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("17:15")){
                                                k=6;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("19:00")){
                                                k=7;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("10:00")){
                                                a=2;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("11:45")){
                                                a=3;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("13:30")){
                                                a=4;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("15:15")){
                                                a=5;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("17:00")){
                                                a=6;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("18:45")){
                                                a=7;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("20:30")){
                                                a=8;
                                            }
                                            for (i=k;i<a;i++){
                                                Data4[i][j]=cours+" "+type+" "+groupe+" "+salle+" "+site;
                                            }
                                        case 5:
                                            Data5=Main.f1.getData1();
                                            for(i=0;i<8;i++){
                                                if (result1.getString("DATE").equals(Data5[0][i])){
                                                    j=i;
                                                }
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("8:30")){
                                                k=1;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("10:15")){
                                                k=2;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("12:00")){
                                                k=3;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("13:45")){
                                                k=4;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("15:30")){
                                                k=5;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("17:15")){
                                                k=6;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("19:00")){
                                                k=7;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("10:00")){
                                                a=2;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("11:45")){
                                                a=3;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("13:30")){
                                                a=4;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("15:15")){
                                                a=5;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("17:00")){
                                                a=6;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("18:45")){
                                                a=7;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("20:30")){
                                                a=8;
                                            }
                                            for (i=k;i<a;i++){
                                                Data5[i][j]=cours+" "+type+" "+groupe+" "+salle+" "+site;
                                            }
                                        case 6:
                                            Data6=Main.f1.getData1();
                                            for(i=0;i<8;i++){
                                                if (result1.getString("DATE").equals(Data6[0][i])){
                                                    j=i;
                                                }
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("8:30")){
                                                k=1;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("10:15")){
                                                k=2;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("12:00")){
                                                k=3;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("13:45")){
                                                k=4;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("15:30")){
                                                k=5;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("17:15")){
                                                k=6;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("19:00")){
                                                k=7;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("10:00")){
                                                a=2;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("11:45")){
                                                a=3;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("13:30")){
                                                a=4;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("15:15")){
                                                a=5;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("17:00")){
                                                a=6;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("18:45")){
                                                a=7;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("20:30")){
                                                a=8;
                                            }
                                            for (i=k;i<a;i++){
                                                Data6[i][j]=cours+" "+type+" "+groupe+" "+salle+" "+site;
                                            }
                                        case 7:
                                            Data7=Main.f1.getData1();
                                            for(i=0;i<8;i++){
                                                if (result1.getString("DATE").equals(Data7[0][i])){
                                                    j=i;
                                                }
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("8:30")){
                                                k=1;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("10:15")){
                                                k=2;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("12:00")){
                                                k=3;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("13:45")){
                                                k=4;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("15:30")){
                                                k=5;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("17:15")){
                                                k=6;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("19:00")){
                                                k=7;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("10:00")){
                                                a=2;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("11:45")){
                                                a=3;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("13:30")){
                                                a=4;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("15:15")){
                                                a=5;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("17:00")){
                                                a=6;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("18:45")){
                                                a=7;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("20:30")){
                                                a=8;
                                            }
                                            for (i=k;i<a;i++){
                                                Data7[i][j]=cours+" "+type+" "+groupe+" "+salle+" "+site;
                                            }
                                        case 8:
                                            Data8=Main.f1.getData1();
                                            for(i=0;i<8;i++){
                                                if (result1.getString("DATE").equals(Data8[0][i])){
                                                    j=i;
                                                }
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("8:30")){
                                                k=1;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("10:15")){
                                                k=2;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("12:00")){
                                                k=3;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("13:45")){
                                                k=4;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("15:30")){
                                                k=5;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("17:15")){
                                                k=6;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("19:00")){
                                                k=7;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("10:00")){
                                                a=2;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("11:45")){
                                                a=3;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("13:30")){
                                                a=4;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("15:15")){
                                                a=5;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("17:00")){
                                                a=6;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("18:45")){
                                                a=7;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("20:30")){
                                                a=8;
                                            }
                                            for (i=k;i<a;i++){
                                                Data8[i][j]=cours+" "+type+" "+groupe+" "+salle+" "+site;
                                            }
                                        case 9:
                                            Data9=Main.f1.getData1();
                                            for(i=0;i<8;i++){
                                                if (result1.getString("DATE").equals(Data9[0][i])){
                                                    j=i;
                                                }
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("8:30")){
                                                k=1;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("10:15")){
                                                k=2;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("12:00")){
                                                k=3;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("13:45")){
                                                k=4;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("15:30")){
                                                k=5;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("17:15")){
                                                k=6;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("19:00")){
                                                k=7;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("10:00")){
                                                a=2;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("11:45")){
                                                a=3;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("13:30")){
                                                a=4;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("15:15")){
                                                a=5;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("17:00")){
                                                a=6;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("18:45")){
                                                a=7;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("20:30")){
                                                a=8;
                                            }
                                            for (i=k;i<a;i++){
                                                Data9[i][j]=cours+" "+type+" "+groupe+" "+salle+" "+site;
                                            }
                                        case 10:
                                            Data10=Main.f1.getData1();
                                            for(i=0;i<8;i++){
                                                if (result1.getString("DATE").equals(Data10[0][i])){
                                                    j=i;
                                                }
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("8:30")){
                                                k=1;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("10:15")){
                                                k=2;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("12:00")){
                                                k=3;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("13:45")){
                                                k=4;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("15:30")){
                                                k=5;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("17:15")){
                                                k=6;
                                            }
                                            if(result1.getString("HEURE_DEBUT").equals("19:00")){
                                                k=7;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("10:00")){
                                                a=2;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("11:45")){
                                                a=3;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("13:30")){
                                                a=4;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("15:15")){
                                                a=5;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("17:00")){
                                                a=6;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("18:45")){
                                                a=7;
                                            }
                                            if(result1.getString("HEURE_FIN").equals("20:30")){
                                                a=8;
                                            }
                                            for (i=k;i<a;i++){
                                                Data10[i][j]=cours+" "+type+" "+groupe+" "+salle+" "+site;
                                            }
                                    }
                                }
                            }
                    }
                    Main.f1.setVisible(true);
                    break;
                }
                else{
                }
            }
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}

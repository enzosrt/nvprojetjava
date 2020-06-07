/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author ZianL
 */
public class Seance {
    private int id,semaine,idcours,idtype;
    private String date,heuredebut,heurefin,etat;
    
    public Seance(int id, int semaine, String date, String heuredebut,String heurefin,
    String etat, int idcours,int idtype) {
        this.id = id;
        this.semaine = semaine;
        this.date = date;
        this.heuredebut = heuredebut;
        this.heurefin = heurefin;
        this.etat = etat;
        this.idcours = idcours;
        this.idtype = idtype;
    }
    public Seance(){};
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getSemaine(){
        return semaine;
    }
    
    public void setSemaine(int semaine){
        this.semaine=semaine;
    }
    
    public String getDate(){
        return date;
    }
    
    public void setDate(String date){
        this.date=date;
    }
    
    public String getHeuredebut(){
        return heuredebut;
    }
    
    public void setHeuredebut(String heuredebut){
        this.heuredebut=heuredebut;
    }
    
    public String getHeurefin(){
        return heurefin;
    }
    
    public void setHeurefin(String heurefin){
        this.heurefin=heurefin;
    }
    
    public String getEtat(){
        return heurefin;
    }
    
    public void setEtat(String etat){
        this.etat=etat;
    }
    
    public int getIdcours(){
        return idcours;
    }
    
    public void setIdcours(int idcours){
        this.idcours=idcours;
    }
    
    public int getIdtype(){
        return idtype;
    }
    
    public void setIdtype(int idtype){
        this.idtype=idtype;
    }
}

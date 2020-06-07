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
public class Salle {
    private int id,capa,site;
    private String nom;
    
    public Salle(int id, String nom,int capa,int site) {
        this.id = id;
        this.nom = nom;
        this.capa = capa;
        this.site = site;
    }
    public Salle(){};
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNom(){
        return nom;
    }
    
    public void setNom(String nom){
        this.nom=nom;
    }
    
    public int getCapa() {
        return capa;
    }

    public void setCapa(int capa) {
        this.capa = capa;
    }
    
    public int getSite() {
        return site;
    }

    public void setSite(int site) {
        this.site = site;
    }
}

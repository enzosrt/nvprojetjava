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
public class Groupe {
    private int id,promo;
    private String nom;
    
    public Groupe(int id, String nom,int promo) {
        this.id = id;
        this.nom = nom;
        this.promo = promo;
    }
    public Groupe(){};
    
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
    
    public int getPromo() {
        return promo;
    }

    public void setPromo(int promo) {
        this.promo = promo;
    }
}

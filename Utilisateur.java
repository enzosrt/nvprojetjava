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
public class Utilisateur {
    private int id,droit;
    private String email,mdp,nom,prenom;
    
    public Utilisateur(int id,String email,String mdp, String nom, String prenom,int droit ) {
        this.id = id;
        this.email=email;
        this.mdp=mdp;
        this.nom = nom;
        this.prenom=prenom;
        this.droit=droit;
    }
    
    public Utilisateur(){};
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    
    public String getNom(){
        return nom;
    }
    
    public void setNom(String nom){
        this.nom=nom;
    }
    
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public int getDroit() {
        return droit;
    }

    public void setDroit(int droit) {
        this.droit = droit;
    }
}

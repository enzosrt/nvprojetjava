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
public class Enseignant {
    private int id,id1,id2;
    
    public Enseignant(int id, int id1,int id2) {
        this.id = id;
        this.id1 = id1;
        this.id2 = id2;
    }
    public Enseignant(){};
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getId1(){
        return id1;
    }
    
    public void setId1(int id1){
        this.id1=id1;
    }
    
    public int getId2(){
        return id2;
    }
    
    public void setId2(int id2){
        this.id2=id2;
    }
}

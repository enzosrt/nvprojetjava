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
public class Etudiant {
    private int id,num,gr;
    
    public Etudiant(int id, int num,int gr) {
        this.id = id;
        this.num = num;
        this.gr = gr;
    }
    public Etudiant(){};
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getNum(){
        return num;
    }
    
    public void setNum(int num){
        this.num=num;
    }
    
    public int getGr(){
        return gr;
    }
    
    public void setGr(int gr){
        this.gr=gr;
    }
}

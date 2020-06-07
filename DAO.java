/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.sql.*;

/**
 *
 * @author ZianL
 * @param <T>
 */
public abstract class DAO<T> {
    protected Connection con=null;
    
    public DAO(Connection conn){
        this.con=conn;
    }
    
    public abstract void ajouter();

    public abstract void delete();
    
    public abstract void modifier();

    public abstract T find(int id);
    
    public abstract int nbligne();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author Anisos
 */
public class Participation {
    
    int iduser,id ;
    Offre idtrajet;
    String bool;

    @Override
    public String toString() {
        return "Participation{" + "iduser=" + iduser + ", id=" + id + ", idtrajet=" + idtrajet + ", bool=" + bool + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Participation() {
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public Offre getIdtrajet() {
        return idtrajet;
    }

    public void setIdtrajet(Offre idtrajet) {
        this.idtrajet = idtrajet;
    }

    public String getBool() {
        return bool;
    }

    public void setBool(String bool) {
        this.bool = bool;
    }

   

   

    
    
    
    
}

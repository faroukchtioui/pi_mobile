/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

import java.util.Objects;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Amine
 */
public class Cours {
    private int id;
    private String nom_complet_cours, nom_aberge_cours , categorie  ;
    private String date_debut_cours ;
    private String date_fin_cours ;
    public Cours() {}
    public Cours(int id, String nom_complet_cours, String nom_aberge_cours, String categorie, String date_debut_cours, String  date_fin_cours  ) 
    {
    this.id=id;
    this.nom_complet_cours=nom_complet_cours;
    this.nom_aberge_cours=nom_aberge_cours;
    this.date_debut_cours=date_debut_cours;
    this.date_fin_cours=date_fin_cours;
    this.categorie=categorie;
    }

    public Cours(String nom_complet_cours, String nom_aberge_cours, String categorie, String date_debut_cours, String  date_fin_cours) {
        //To change body of generated methods, choose Tools | Templates.
        
    this.nom_complet_cours=nom_complet_cours;
    this.nom_aberge_cours=nom_aberge_cours;
    this.date_debut_cours=date_debut_cours;
    this.date_fin_cours=date_fin_cours;
    this.categorie=categorie;
    }
    
        public Cours(String nom_complet_cours, String categorie, String date_debut_cours, String  date_fin_cours) {
        //To change body of generated methods, choose Tools | Templates.
        
    this.nom_complet_cours=nom_complet_cours;
    this.nom_aberge_cours=nom_aberge_cours;
    this.date_debut_cours=date_debut_cours;
    this.date_fin_cours=date_fin_cours;
    this.categorie=categorie;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_complet_cours() {
        return nom_complet_cours;
    }

    public void setNom_complet_cours(String nom_complet_cours) {
        this.nom_complet_cours = nom_complet_cours;
    }

    public String getNom_aberge_cours() {
        return nom_aberge_cours;
    }

    public void setNom_aberge_cours(String nom_aberge_cours) {
        this.nom_aberge_cours = nom_aberge_cours;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getDate_debut_cours() {
        return date_debut_cours;
    }

    public void setDate_debut_cours(String date_debut_cours) {
        this.date_debut_cours = date_debut_cours;
    }

    public String getDate_fin_cours() {
        return date_fin_cours;
    }

    public void setDate_fin_cours(String date_fin_cours) {
        this.date_fin_cours = date_fin_cours;
    }

    @Override
    public String toString() {
        return "Cours{" + "id=" + id + ", nom_complet_cours=" + nom_complet_cours + ", nom_aberge_cours=" + nom_aberge_cours + ", categorie=" + categorie + ", date_debut_cours=" + date_debut_cours + ", date_fin_cours=" + date_fin_cours + '}';
    }
 
    
}

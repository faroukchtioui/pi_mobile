/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Offre {
    
    private int id,Tel,Experience,NombreHeure,Salaire;
    private String NomEntreprise,Description,Localisation,
            TypeContrat,NiveauEtude,Langue,Email;
    private Date Date;
    private int categ;
    
    public Offre(){
    
    }
    
    public Offre(int id, int Tel, int Experience, int NombreHeure, int Salaire, String NomEntreprise, String Description, String Localisation, String TypeContrat, String NiveauEtude, String Langue, String Email, Date Date, int categ) {
        this.id = id;
        this.Tel = Tel;
        this.Experience = Experience;
        this.NombreHeure = NombreHeure;
        this.Salaire = Salaire;
        this.NomEntreprise = NomEntreprise;
        this.Description = Description;
        this.Localisation = Localisation;
        this.TypeContrat = TypeContrat;
        this.NiveauEtude = NiveauEtude;
        this.Langue = Langue;
        this.Email = Email;
        this.Date = Date;
        this.categ = categ;
    }

    public Offre(int Tel, int Experience, int NombreHeure, int Salaire, String NomEntreprise, String Description, String Localisation, String TypeContrat, String NiveauEtude, String Langue, String Email, Date Date, int categ) {
        this.Tel = Tel;
        this.Experience = Experience;
        this.NombreHeure = NombreHeure;
        this.Salaire = Salaire;
        this.NomEntreprise = NomEntreprise;
        this.Description = Description;
        this.Localisation = Localisation;
        this.TypeContrat = TypeContrat;
        this.NiveauEtude = NiveauEtude;
        this.Langue = Langue;
        this.Email = Email;
        this.Date = Date;
        this.categ = categ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTel() {
        return Tel;
    }

    public void setTel(int Tel) {
        this.Tel = Tel;
    }

    public int getExperience() {
        return Experience;
    }

    public void setExperience(int Experience) {
        this.Experience = Experience;
    }

    public int getNombreHeure() {
        return NombreHeure;
    }

    public void setNombreHeure(int NombreHeure) {
        this.NombreHeure = NombreHeure;
    }

    public int getSalaire() {
        return Salaire;
    }

    public void setSalaire(int Salaire) {
        this.Salaire = Salaire;
    }

    public String getNomEntreprise() {
        return NomEntreprise;
    }

    public void setNomEntreprise(String NomEntreprise) {
        this.NomEntreprise = NomEntreprise;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getLocalisation() {
        return Localisation;
    }

    public void setLocalisation(String Localisation) {
        this.Localisation = Localisation;
    }

    public String getTypeContrat() {
        return TypeContrat;
    }

    public void setTypeContrat(String TypeContrat) {
        this.TypeContrat = TypeContrat;
    }

    public String getNiveauEtude() {
        return NiveauEtude;
    }

    public void setNiveauEtude(String NiveauEtude) {
        this.NiveauEtude = NiveauEtude;
    }

    public String getLangue() {
        return Langue;
    }

    public void setLangue(String Langue) {
        this.Langue = Langue;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public int getCateg() {
        return categ;
    }

    public void setCateg(int categ) {
        this.categ = categ;
    }
}

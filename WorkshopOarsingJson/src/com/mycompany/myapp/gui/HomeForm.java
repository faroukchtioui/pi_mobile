/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author bhk
 */
public class HomeForm extends Form {

    Form current;
    /*Garder traçe de la Form en cours pour la passer en paramètres 
    aux interfaces suivantes pour pouvoir y revenir plus tard en utilisant
    la méthode showBack*/
    
    public HomeForm(Form previous) {
        current = this; //Récupération de l'interface(Form) en cours
        setTitle("Bienvenue");
        setLayout(BoxLayout.y());

        add(new Label("Choisir une option"));
        
        Button btnAddCours = new Button("Ajouter Cours");
        Button btnListCours = new Button("Listes des Cours");
        Button btnListOffres = new Button("Listes des Offres");

        
        btnAddCours.addActionListener(e -> new AddCoursForm(current).show());
        
        btnListCours.addActionListener(e -> new ListCoursForm(current).show());
        
        btnListOffres.addActionListener(e -> new AfficherTrajets(current).show());

        //btnListTasks.addActionListener(e -> new ListCoursForm(current).show());
        addAll(btnAddCours,btnListCours,btnListOffres);

    }

}

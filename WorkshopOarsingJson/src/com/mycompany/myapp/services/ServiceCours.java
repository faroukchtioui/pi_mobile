/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Cours;
import com.mycompany.myapp.entities.Task;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bhk
 */
public class ServiceCours {

    public ArrayList<Cours> cours;
    
    public static ServiceCours instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceCours() {
         req = new ConnectionRequest();
    }

    public static ServiceCours getInstance() {
        if (instance == null) {
            instance = new ServiceCours();
        }
        return instance;
    }

    public boolean addCours(Cours c) {
        String url = Statics.BASE_URL +"/AddCours/?"+"nom_complet_cours="+c.getNom_complet_cours()+"&"+"nom_aberge_cours="+"cccc"+"&"+"date_debut_cours="+c.getDate_debut_cours()+"&"+"date_fin_cours="+c.getCategorie()+"&"+"Categorie="+c.getDate_fin_cours();
        System.out.println(url);
        System.out.println("-----------------"+c.getDate_debut_cours());
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK4
                req.removeResponseListener(this); //Supprimer cet actionListener
                /* une fois que nous avons terminé de l'utiliser.
                La ConnectionRequest req est unique pour tous les appels de 
                n'importe quelle méthode du Service task, donc si on ne supprime
                pas l'ActionListener il sera enregistré et donc éxécuté même si 
                la réponse reçue correspond à une autre URL(get par exemple)*/
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public ArrayList<Cours> parseTasks(String jsonText){
        try {
            cours=new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            System.out.println(tasksListJson);
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            System.out.println(list);
            //Parcourir la liste des tâches Json
            for(Map<String,Object> obj : list){
                //Création des tâches et récupération de leurs données
                Cours t = new Cours();
                float id = Float.parseFloat(obj.get("id").toString());
                t.setId((int)id);
                //t.setDescription(((int)Float.parseFloat(obj.get("status").toString())));
                t.setDate_fin_cours(obj.get("DateFinCours").toString());
                t.setNom_complet_cours(obj.get("NomCompletCours").toString());
                t.setDate_debut_cours(obj.get("DateDebutCours").toString());
                t.setNom_aberge_cours(obj.get("NomAbergeCours").toString());
                t.setCategorie(obj.get("Categorie").toString());

                //Ajouter la tâche extraite de la réponse Json à la liste
                cours.add(t);
            }
            
            
        } catch (IOException ex) {
            
        }
         /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        return cours;
    }
    
    public ArrayList<Cours> getAllCours(){
        String url = Statics.BASE_URL+"/jsonMaisonAll/";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                cours = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return cours;
    }
     public boolean deleteCours(int id){
        String url = Statics.BASE_URL+"/delete/"+id;
        req.setUrl(url);
         req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
            return resultOK;   
                     
    }
       public boolean updateCours(Cours c,int id) {
        //String url = Statics.BASE_URL + "/avis/update_avis/"+id+"?" +"text="+ a.getText()+ "&" + "rating="+ a.getRating()+"&" + "titre="+ a.getTitre(); ; //création de l'URL
        String url = Statics.BASE_URL +"/updatecours/"+id+"?" +"nom_complet_cours="+c.getNom_complet_cours()+"&"+"nom_aberge_cours="+"cccc"+"&"+"date_debut_cours="+c.getDate_debut_cours()+"&"+"date_fin_cours="+c.getCategorie()+"&"+"Categorie="+c.getDate_fin_cours();
           System.out.println(url);
        System.out.println(url);
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this); //Supprimer cet actionListener                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
}

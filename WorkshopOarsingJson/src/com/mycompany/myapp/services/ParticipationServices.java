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
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.messaging.Message;
import com.codename1.ui.Display;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Participation;
import com.mycompany.myapp.entities.Offre;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Anisos
 */
public class ParticipationServices {
    
     public ArrayList<Offre> trajetList;
     public ArrayList<String> parList;
    public boolean test = false;
    public static ParticipationServices instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ParticipationServices() {
         req = new ConnectionRequest();
    }

    public static ParticipationServices getInstance() {
        if (instance == null) {
            instance = new ParticipationServices();
        }
        return instance;
    }
    
    
    public Participation is_Done(int idT,int idU)
    {
         ConnectionRequest con = new ConnectionRequest();
        Participation t = new Participation();
          String url = Statics.BASE_URL+"/transport/participTJson/"+idT+"/"+idU+"/";
        con.setUrl(url);
        con.setPost(false);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                String json = new String(con.getResponseData());
                JSONParser j = new JSONParser();

                Map<String, Object> obj;
                try {
                    obj = j.parseJSON(new CharArrayReader(json.toCharArray()));

                t.setBool(obj.get("bool").toString());
                    
                } catch (IOException ex) {
                    System.out.println(ex);
                }

            }
        });
          NetworkManager.getInstance().addToQueueAndWait(con);
        return t;
    }
    public void ParticiperAction(int idT , int idU)
    {
        ConnectionRequest con = new ConnectionRequest();
          String url = Statics.BASE_URL+"/transport/participerTJson/"+idT+"/"+idU+"/";
        con.setUrl(url);
        con.setPost(false);
          NetworkManager.getInstance().addToQueueAndWait(con);
         /*  Message m = new Message("Bonsoir Mr " + 
              "username" + "votre Participation est Enregistrer Avec success");
        Display.getInstance().sendMessage(new String[]{"rami.htira@esprit.tn"}, "A propos de votre Participation Pack&go", m);*/
       
    }
    
   
    
  public Offre afficheTrajet(int x) {
       
      ConnectionRequest con = new ConnectionRequest();
        Offre t = new Offre();
         String url = Statics.BASE_URL+"/offreshowTrajetJson/"+x+"/";
        con.setUrl(url);
        con.setPost(false);
        con.addResponseListener((NetworkEvent evt) -> {
            String json = new String(con.getResponseData());
            JSONParser j = new JSONParser();
            
            Map<String, Object> obj;
            try {
                obj = j.parseJSON(new CharArrayReader(json.toCharArray()));
                //String s = obj.get("dateDepart").toString();
                
               // String sousChaine = s.substring(0, 10);
               // String s1 = obj.get("dateArrive").toString();
            
               // String sousChaine1 = s1.substring(0, 10);
                float id = Float.parseFloat(obj.get("id").toString());
                t.setId((int)id);
                        t.setNomEntreprise(obj.get("NomEntreprise").toString());
                        t.setDescription(obj.get("Description").toString());
                        t.setLocalisation(obj.get("Localisation").toString());
                        t.setTypeContrat(obj.get("TypeContrat").toString());
                        t.setNiveauEtude(obj.get("NiveauEtude").toString());
                        t.setLangue(obj.get("Langue").toString());
                        t.setEmail(obj.get("Email").toString());
                        t.setTel((int)Float.parseFloat(obj.get("Tel").toString()));
                        t.setExperience((int)Float.parseFloat(obj.get("Experience").toString()));
                        t.setNombreHeure((int)Float.parseFloat(obj.get("NombreHeure").toString()));
                        t.setSalaire((int)Float.parseFloat(obj.get("Salaire").toString()));
                //t.setD_depart(sousChaine);
                //t.setD_arriver(sousChaine1);
               /* t.setP_arriver(obj.get("ptArrive").toString());
                t.setP_depart(obj.get("ptDepart").toString());
                t.setPrix(Float.parseFloat(obj.get("prix").toString()));*/
                
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
          
        
        return t;
  }
  
  public Offre afficheTrajetMesP(int x) {
       
        ConnectionRequest con = new ConnectionRequest();
        Offre t = new Offre();
         String url = Statics.BASE_URL+"/offreshowTrajetJsonMp/"+x+"/";
        con.setUrl(url);
        con.setPost(false);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                String json = new String(con.getResponseData());
                JSONParser j = new JSONParser();

                Map<String, Object> obj;
                try {
                    obj = j.parseJSON(new CharArrayReader(json.toCharArray()));
                    float id = Float.parseFloat(obj.get("id").toString());
                        t.setId((int)id);
                        t.setNomEntreprise(obj.get("NomEntreprise").toString());
                        t.setDescription(obj.get("Description").toString());
                        t.setLocalisation(obj.get("Localisation").toString());
                        t.setTypeContrat(obj.get("TypeContrat").toString());
                        t.setNiveauEtude(obj.get("NiveauEtude").toString());
                        t.setLangue(obj.get("Langue").toString());
                        t.setEmail(obj.get("Email").toString());
                        t.setTel((int)Float.parseFloat(obj.get("Tel").toString()));
                        t.setExperience((int)Float.parseFloat(obj.get("Experience").toString()));
                        t.setNombreHeure((int)Float.parseFloat(obj.get("NombreHeure").toString()));
                        t.setSalaire((int)Float.parseFloat(obj.get("Salaire").toString()));
              /*  String s = obj.get("dateDepart").toString();
            
                String sousChaine = s.substring(0, 10);
                String s1 = obj.get("dateArrive").toString();
            
                String sousChaine1 = s1.substring(0, 10);
                     float id = Float.parseFloat(obj.get("idTrajet").toString());
                t.setId((int)id);
                t.setD_depart(sousChaine);
                t.setD_arriver(sousChaine1);
                t.setP_arriver(obj.get("ptArrive").toString());
                t.setP_depart(obj.get("ptDepart").toString());
                t.setPrix(Float.parseFloat(obj.get("prix").toString()));*/

                } catch (IOException ex) {
                    System.out.println(ex);
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
          
        
        return t;
  }
  

    public ArrayList<Offre> parseTasks(String jsonText){
        try {
             trajetList=new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
          
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
          
            for(Map<String,Object> obj : list){
                
               /* String s = obj.get("dateDepart").toString();
            
                String sousChaine = s.substring(0, 10);*/
               
                
                Offre t = new Offre();
                 float id = Float.parseFloat(obj.get("id").toString());
                        t.setId((int)id);
                        t.setNomEntreprise(obj.get("NomEntreprise").toString());
                        t.setDescription(obj.get("Description").toString());
                        t.setLocalisation(obj.get("Localisation").toString());
                        t.setTypeContrat(obj.get("TypeContrat").toString());
                        t.setNiveauEtude(obj.get("NiveauEtude").toString());
                        t.setLangue(obj.get("Langue").toString());
                        t.setEmail(obj.get("Email").toString());
                        t.setTel((int)Float.parseFloat(obj.get("Tel").toString()));
                        t.setExperience((int)Float.parseFloat(obj.get("Experience").toString()));
                        t.setNombreHeure((int)Float.parseFloat(obj.get("NombreHeure").toString()));
                        t.setSalaire((int)Float.parseFloat(obj.get("Salaire").toString()));
              
                 trajetList.add(t);
            }
            
            
        } catch (IOException ex) {
            
        }
     
        return  trajetList;
    }
    
    public ArrayList<String> parseTasksII(String jsonText){
        try {
            
             parList=new ArrayList<String>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            //System.out.println(tasksListJson);
            ArrayList<Map<String,Object>> list = (ArrayList<Map<String,Object>>)tasksListJson.get("root");
           // System.out.println(list);
            for(Map<String,Object> obj : list){

                 String s = obj.get("id").toString();
               // String s = obj.get("idTrajet").toString();
               
                 parList.add(s);
                 
                 
                 
           }
            
            
        } catch (IOException ex) {
            
        }
     
        return  parList;
    }
    
    public ArrayList<Offre> getAllTrajets(){
        String url = Statics.BASE_URL+"/offrelist_trajet_frontJson/";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                 trajetList = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return  trajetList;
    }
    
     public ArrayList<String> getMesTrajets(int idU){
        String url = Statics.BASE_URL+"/transport/participMJson/"+idU+"/";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                 parList = parseTasksII(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return  parList;
    }
    
   
            

   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import static com.codename1.ui.plaf.Style.BACKGROUND_NONE;
import com.mycompany.myapp.entities.Participation;
import com.mycompany.myapp.entities.Offre;
import com.mycompany.myapp.services.ParticipationServices;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.Map;
import com.mycompany.myapp.utils.mailing;


/**
 *
 * @author Anisos
 */
public class AfficherTrajet extends Form{
    Container c10, c2, c9, c6, c7, c8;
    boolean test;
    ///////////CurrentUser////////////////
    int CurrentUser = 5;
    //////////////////////////////////////
    Offre t = new Offre();
    Participation p= new Participation();
    public AfficherTrajet(int id,Form previous)
    {
        
         setTitle("Détails trajet");
        
        //  getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> new AfficherMesTrajets(current));
         Container c1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
         
        /* Button T_mesT = new Button("Mes Participations");        
         T_mesT.getAllStyles().setBorder(Border.createEmpty());
         T_mesT.getAllStyles().setBackgroundType(BACKGROUND_NONE);
         T_mesT.getAllStyles().setBgTransparency(255);
         T_mesT.getAllStyles().setBgColor(0x03fc0f);
         T_mesT.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                         Form hi = new AfficherMesTrajets(previous);
                          
                        hi.show();
                    }});
         
        
         c1.add(T_mesT);*/
         
          Button T_mesTs = new Button("Choisir Un Offre");        
         T_mesTs.getAllStyles().setBorder(Border.createEmpty());
         T_mesTs.getAllStyles().setBackgroundType(BACKGROUND_NONE);
         T_mesTs.getAllStyles().setBgTransparency(255);
         T_mesTs.getAllStyles().setBgColor(0xfce803);
         T_mesTs.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                         Form hi = new AfficherTrajets(previous);
                          
                        hi.show();
                    }});
         
        
         c1.add(T_mesTs);
         
         add(c1);
      ParticipationServices PrServ = ParticipationServices.getInstance();
      
       t = PrServ.afficheTrajet(id);
        
                 c2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                 c6 = new Container(new BoxLayout(BoxLayout.X_AXIS));
                 c7 = new Container(new BoxLayout(BoxLayout.X_AXIS));
                 c8 = new Container(new BoxLayout(BoxLayout.X_AXIS));
                 c9 = new Container(new BoxLayout(BoxLayout.X_AXIS));
                 c10 = new Container(new BoxLayout(BoxLayout.X_AXIS));
                
               // c1.add(iv);
                Label d_dep = new Label(t.getNomEntreprise());
                c8.add(new Label("Nom Entreprise:"));
                c8.add(d_dep);
                
                Label d_arr = new Label( t.getLocalisation()/*String.valueOf(d.getScore())*/);
                c6.add(new Label("Localisation:"));
                c6.add(d_arr);
                
                 Label p_dep = new Label( t.getDescription()/*String.valueOf(d.getScore())*/);
                c9.add(new Label("Description:"));
                c9.add(p_dep);
                
                 Label p_arr = new Label( t.getEmail()/*String.valueOf(d.getScore())*/);
                c10.add(new Label("Email:"));
                c10.add(p_arr);

                Label prix = new Label(String.valueOf(t.getSalaire()));
               // Label prixx = new Label(String.valueOf(String.valueOf(d.getPrix() - ((d.getPrix() * d.getTred()) / 100))));
                c7.add(new Label("Salaire:"));
                c7.add(prix);
              /*  c7.add(new Label("TND"));
                c7.add(prixx);*/
          
               p =is_done(id, CurrentUser);
              if(!p.getBool().equals("true"))
              {
                 Button aff = new Button("Postuler");
                  aff.getAllStyles().setBorder(Border.createEmpty());
         aff.getAllStyles().setBackgroundType(BACKGROUND_NONE);
         aff.getAllStyles().setBgTransparency(255);
         aff.getAllStyles().setBgColor(0x00eb04);
         
           Button ann = new Button("Annuler");
                  ann.getAllStyles().setBorder(Border.createEmpty());
        ann.getAllStyles().setBackgroundType(BACKGROUND_NONE);
         ann.getAllStyles().setBgTransparency(255);
         ann.getAllStyles().setBgColor(0x70000);
         ann.setVisible(false);
         
               aff.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                       
                        mailing.sendEmail("farouk.chtioui@esprit.tn", "Postulation", "Vous avez postuler avec succes au "+t.getNomEntreprise());
                       PrServ.ParticiperAction(t.getId(),CurrentUser);
                       aff.setVisible(false);
                       ann.setVisible(true);
                       repaint();
                       refreshTheme();
                    }
                }); 
               
               ann.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                         ParticiperAnn(t.getId(),CurrentUser);
                       aff.setVisible(true);
                       ann.setVisible(false);
                       repaint();
                       refreshTheme();
                    }
                }); 
               
               c2.add(c8);
                c2.add(c6);
                c2.add(c9);
                c2.add(c10);
                c2.add(c7);
                c2.add(aff);
                c2.add(ann);
                add(c2);
               
              }
              else
              {
                Button aff = new Button("Participer");
                  aff.getAllStyles().setBorder(Border.createEmpty());
         aff.getAllStyles().setBackgroundType(BACKGROUND_NONE);
         aff.getAllStyles().setBgTransparency(255);
         aff.getAllStyles().setBgColor(0x00eb04);
         
           Button ann = new Button("Annuler");
                  ann.getAllStyles().setBorder(Border.createEmpty());
        ann.getAllStyles().setBackgroundType(BACKGROUND_NONE);
         ann.getAllStyles().setBgTransparency(255);
         ann.getAllStyles().setBgColor(0x70000);
         aff.setVisible(false);
               ann.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                         ParticiperAnn(t.getId(),CurrentUser);
                       aff.setVisible(true);
                       ann.setVisible(false);
                       repaint();
                       refreshTheme();
                    }
                }); 
               
               
               aff.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {

                       PrServ.ParticiperAction(t.getId(),CurrentUser);
                       aff.setVisible(false);
                       ann.setVisible(true);
                       repaint();
                       refreshTheme();
                    }
                }); 
         
              
               
               c2.add(c8);
                c2.add(c6);
                c2.add(c9);
                c2.add(c10);
                c2.add(c7);
                c2.add(aff);
                c2.add(ann);
                add(c2);
                
              }
               
                
            }
     public void ParticiperAnn(int idT, int idU )
    {
        ConnectionRequest con = new ConnectionRequest();
          String url = Statics.BASE_URL+"/transport/annulerparticipationJson/"+idT+"/"+idU+"/";
        con.setUrl(url);
        con .setPost(false);
          NetworkManager.getInstance().addToQueueAndWait(con);
    }
     public Participation is_done(int idT,int idU)
     {
         ConnectionRequest con = new ConnectionRequest();
        Participation p = new Participation();
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

                p.setBool(obj.get("bool").toString());
                    
                } catch (IOException ex) {
                    System.out.println(ex);
                }

            }
        });
          NetworkManager.getInstance().addToQueueAndWait(con);
          return p;
     }
     
    }
    


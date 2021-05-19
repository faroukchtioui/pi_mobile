/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;


import com.codename1.components.ImageViewer;
import com.mycompany.myapp.services.ParticipationServices;
import com.codename1.components.SpanLabel;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import static com.codename1.ui.plaf.Style.BACKGROUND_NONE;
import com.mycompany.myapp.entities.Offre;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Anisos
 */
public class AfficherTrajets extends Form {
    Form current;
    Container c2,c6,c7,c8,c9,c10;
    int CurrentUser = 5;
     public AfficherTrajets(Form previous) {
       setTitle("Details trajet");
        current=this;
        SpanLabel sp = new SpanLabel();
        Container c1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
         
        /* Button T_mesT = new Button("Mes Participations");        
         T_mesT.getAllStyles().setBorder(Border.createEmpty());
         T_mesT.getAllStyles().setBackgroundType(BACKGROUND_NONE);
         T_mesT.getAllStyles().setBgTransparency(255);
         T_mesT.getAllStyles().setBgColor(0x00eb04);
         T_mesT.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        Form hi = new AfficherMesTrajets(current);
                        //  AfficherMesTrajets ad = new AfficherMesTrajets(current);
                        hi.show();
                    }});
         
        
         c1.add(T_mesT);*/

          add(c1);
          getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK,e -> new HomeForm(current).show()); // Revenir vers l'interface précédente

       /* sp.setText(ParticipationServices.getInstance().getAllTrajets().toString());
        add(sp);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
        */
         
        if (!ParticipationServices.getInstance().getAllTrajets().isEmpty()) {
            for (Offre d : ParticipationServices.getInstance().getAllTrajets()) {
              
               
                
                 c2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                c6 = new Container(new BoxLayout(BoxLayout.X_AXIS));
                 c7 = new Container(new BoxLayout(BoxLayout.X_AXIS));
                 c8 = new Container(new BoxLayout(BoxLayout.X_AXIS));
                c9 = new Container(new BoxLayout(BoxLayout.X_AXIS));
                 c10 = new Container(new BoxLayout(BoxLayout.X_AXIS));
               // c1.add(iv);
                Label d_dep = new Label(d.getNomEntreprise());
                c8.add(new Label("Nom Entreprise:"));
                c8.add(d_dep);
                
                Label d_arr = new Label( d.getLocalisation()/*String.valueOf(d.getScore())*/);
                c6.add(new Label("Localisation:"));
                c6.add(d_arr);
                
                 Label p_dep = new Label( d.getTypeContrat()/*String.valueOf(d.getScore())*/);
                c9.add(new Label("Type de contrat:"));
                c9.add(p_dep);
                
                 Label p_arr = new Label( d.getEmail()/*String.valueOf(d.getScore())*/);
                c10.add(new Label("Email de l'entreprise:"));
                c10.add(p_arr);

                Label prix = new Label(String.valueOf(d.getTel()));
               // Label prixx = new Label(String.valueOf(String.valueOf(d.getPrix() - ((d.getPrix() * d.getTred()) / 100))));
                c7.add(new Label("Numero de tel:"));
                c7.add(prix);
              /*  c7.add(new Label("TND"));
                c7.add(prixx);*/
               
                Button aff = new Button("Consulter");
              // aff.setSize(new Dimension(1000, 100));
               aff.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {

                       AfficherTrajet ad = new AfficherTrajet(d.getId(),current);
                        ad.show();
                    }
                });
                 c2.add(c8);
              //  c2.add(c6);
              //  c2.add(c9);
                c2.add(c10);
              //  c2.add(c7);
                c2.add(aff);
                add(c2);
            }
        } else {
            add(new Label("Aucun deal a afficher"));

        }

    }
     
      
    }

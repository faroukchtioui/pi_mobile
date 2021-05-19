/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.mycompany.myapp.entities.Cours;
import com.mycompany.myapp.services.ServiceCours;
import com.mycompany.myapp.services.ServiceTask;
import java.util.ArrayList;

/**
 *
 * @author bhk
 */
public class ListCoursForm extends Form{
    Form current;

    public ListCoursForm(Form previous) {
        setTitle("Listes des Cours");
        ArrayList<Cours> list =ServiceCours.getInstance().getAllCours();

        SpanLabel sp = new SpanLabel();
       // sp.setText(ServiceCours.getInstance().getAllCours().toString());
        for(Cours av : list)
        {  //String s=av.getImage();
           // System.out.println(s+"-------------------------");
            String urlm="http://localhost/projet/76931541_862746537475073_1999362329178800128_n.png";
           // String urlm="file:///"+av.getUrl();
           // System.out.println("-------------------------"+urlm);
            Image placeholder = Image.createImage(120,90);
            EncodedImage enc= EncodedImage.createFromImage(placeholder, false);
            URLImage urlimage = URLImage.createToStorage(enc, urlm, urlm,URLImage.RESIZE_SCALE);
  
            addButton(urlimage,av);
       
        }
        add(sp);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK,e -> new HomeForm(current).show()); // Revenir vers l'interface précédente

    }
     private void addButton(Image img, Cours c) {
          
       int height = Display.getInstance().convertToPixels(25.5f);
       int width = Display.getInstance().convertToPixels(27);
       Button image = new Button(img.fill(width, height));
       image.setUIID("Label");
       Container cnt = BorderLayout.west(image);
      // cnt.setLeadComponent(image);
         Label id = new Label("id:"+c.getId(),"NewsBottomLine");
         Label dated = new Label("date debut:"+c.getDate_debut_cours(),"NewsBottomLine");
         Label datef = new Label("date fin:"+c.getDate_fin_cours(),"NewsBottomLine");
        // Label nom1 = new Label("nom complet: "+c.getAuthor(),"NewsBottomLine");
         Label nom2 = new Label("nom cour: "+c.getNom_complet_cours(),"NewsBottomLine");
         Label cat = new Label("categorie : "+c.getCategorie(),"NewsBottomLine");


           //   FontImage.setMaterialIcon(titre, FontImage.MATERIAL_TITLE);
           //   FontImage.setMaterialIcon(text, FontImage.MATERIAL_TEXT_FIELDS);
    
            Label supp=new Label("Supprimer");  
            supp.setUIID("NewsTopLine");
            Style suppStyle = new Style(supp.getUnselectedStyle());
            suppStyle.setFgColor(0xf21f1f);
            FontImage suppImage=FontImage.createMaterial(FontImage.MATERIAL_DELETE, suppStyle);
            supp.setIcon(suppImage);
            supp.setTextPosition(RIGHT);
             supp.addPointerPressedListener(e -> {
            Dialog dig = new Dialog("Supprimer");
            if(dig.show("Supprimer","vous voulez le cour ?","Annuler","oui")){ dig.dispose();}
            else{dig.dispose();}
                 System.out.println("supp");
            if(ServiceCours.getInstance().deleteCours(c.getId()));
            }
            );
             //button update
            Label update=new Label("Modifier");  
            update.setUIID("NewsTopLine");
            Style updateStyle = new Style(supp.getUnselectedStyle());
            suppStyle.setFgColor(0xf21f1f);
            FontImage updateImage=FontImage.createMaterial(FontImage.MATERIAL_UPDATE, updateStyle);
            update.setIcon(updateImage);
            update.setTextPosition(RIGHT);
            update.addPointerPressedListener(e5 -> {
             new UpdateCoursForm(current,c,c.getId()).show();
            }
            );
        
       cnt.add(BorderLayout.CENTER, 
               BoxLayout.encloseY(
                        BoxLayout.encloseX(nom2),
                        BoxLayout.encloseX(cat),

                        BoxLayout.encloseX(dated),
                        BoxLayout.encloseX(datef),

                        
                        BoxLayout.encloseX(supp,update)


               ));
        
       add(cnt);
      // image.addActionListener(e -> ToastBar.showMessage( FontImage.MATERIAL_INFO));
   }
    
    
}

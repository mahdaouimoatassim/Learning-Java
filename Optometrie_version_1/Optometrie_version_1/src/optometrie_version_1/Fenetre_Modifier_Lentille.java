/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optometrie_version_1;

import javafx.scene.layout.AnchorPane;

import com.mysql.jdbc.Connection;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import static optometrie_version_1.Fenetre_Modifier_Enfant.LOCAL_DATE;

/**
 *
 * @author Milano
 */
public class Fenetre_Modifier_Lentille extends Stage{
  
    private AnchorPane grand_conteneur = new AnchorPane();
    private Scene scene3 = new Scene(grand_conteneur,932, 546);
    private  Button ajouter_lentille=new  Button("");
     private  Button annuler_lentille=new  Button("");
     
     
    private GridPane information_generale=new GridPane();
    private TextField nom_field=new TextField();
    private TextField prenom_field=new TextField();
    private TextField age_field=new TextField();
    private TextField telephone_field=new TextField(); 
    private TextField montant_verse_field=new TextField(); 
    private TextField montant_restant_field=new TextField();
    private DatePicker date_field=new DatePicker();
    private TextArea adresse_field=new TextArea();        

    
    
    
    private HBox kerato_droite=new HBox(10);
    private HBox kerato_gauche=new HBox(10);
    private GridPane kerato_grid_pane=new GridPane();
    private TextField kerato_RH_D_field=new TextField(); 
    private TextField kerato_RH_G_field=new TextField();
    private TextField kerato_RV_D_field=new TextField(); 
    private TextField kerato_RV_G_field=new TextField();
    private TextField kerato_Inconu_D_field=new TextField();
    private TextField kerato_Inconu_G_field=new TextField();
    private TextField kerato_axe_D_field=new TextField(); 
    private TextField kerato_axe_G_field=new TextField();
    private TextField kerato_Difference_D_field=new TextField();
    private TextField kerato_Difference_G_field=new TextField();
    private TextField kerato_P_D_field=new TextField(); 
    private TextField kerato_P_G_field=new TextField();
    
   
    
    private VBox biomicroscopie_vbox=new VBox(5);
    private TextField biomicroscopie_D_field=new TextField(); 
    private TextField biomicroscopie_G_field=new TextField();
    private VBox fond_oeil_vbox=new VBox(5);
    private TextField fond_oeil_D_field=new TextField(); 
    private TextField fond_oeil_G_field=new TextField();
    
    private HBox diagnostic_hbox=new HBox(100);
    private TextField diagnostic_D_field=new TextField(); 
    private TextField diagnostic_G_field=new TextField();
    
    
    
    private HBox Ancienne_Correction_loin_droite=new HBox(10);
    private HBox Ancienne_Correction_loin_gauche=new HBox(10);
    private HBox Ancienne_Correction_pres_droite=new HBox(10);
    private HBox Ancienne_Correction_pres_gauche=new HBox(10);
    private GridPane ancienne_correction_grid_pane=new GridPane();
    
    private TextField Ancienne_Correction_VLDs_field=new TextField();
    private TextField Ancienne_Correction_VLDc_field=new TextField();
    private TextField Ancienne_Correction_VLDax_field=new TextField();
    private TextField Ancienne_Correction_VLDav_field=new TextField();
    
    private TextField Ancienne_Correction_VLGs_field=new TextField();
    private TextField Ancienne_Correction_VLGc_field=new TextField();
    private TextField Ancienne_Correction_VLGax_field=new TextField();
    private TextField Ancienne_Correction_VLGav_field=new TextField();
    
    private TextField Ancienne_Correction_VPDs_field=new TextField();
    private TextField Ancienne_Correction_VPDc_field=new TextField();
    private TextField Ancienne_Correction_VPDax_field=new TextField();
    private TextField Ancienne_Correction_VPDp_field=new TextField();
    
    private TextField Ancienne_Correction_VPGs_field=new TextField();
    private TextField Ancienne_Correction_VPGc_field=new TextField();
    private TextField Ancienne_Correction_VPGax_field=new TextField();
    private TextField Ancienne_Correction_VPGp_field=new TextField();
    
    private GridPane aquite_visuelle_grid_pane=new GridPane();
    private TextField aquite_visuelle_brut_L_D=new TextField();
    private TextField aquite_visuelle_brut_L_G=new TextField();
    private TextField aquite_visuelle_brut_P_D=new TextField();
    private TextField aquite_visuelle_brut_P_G=new TextField();
    
    
    private HBox Essei_Correction_loin_droite=new HBox(10);
    private HBox Essei_Correction_loin_gauche=new HBox(10);
    private HBox Essei_Correction_pres_droite=new HBox(10);
    private HBox Essei_Correction_pres_gauche=new HBox(10);
    private GridPane Essei_Correction_grid_pane=new GridPane();
    
    
    private TextField Essei_Correction_VLDs_field=new TextField();
    private TextField Essei_Correction_VLDc_field=new TextField();
    private TextField Essei_Correction_VLDax_field=new TextField();
    private TextField Essei_Correction_VLDav_field=new TextField();
    
    private TextField Essei_Correction_VLGs_field=new TextField();
    private TextField Essei_Correction_VLGc_field=new TextField();
    private TextField Essei_Correction_VLGax_field=new TextField();
    private TextField Essei_Correction_VLGav_field=new TextField();
    
    private TextField Essei_Correction_VPDs_field=new TextField();
    private TextField Essei_Correction_VPDc_field=new TextField();
    private TextField Essei_Correction_VPDax_field=new TextField();
    private TextField Essei_Correction_VPDav_field=new TextField();
    
    private TextField Essei_Correction_VPGs_field=new TextField();
    private TextField Essei_Correction_VPGc_field=new TextField();
    private TextField Essei_Correction_VPGax_field=new TextField();
    private TextField Essei_Correction_VPGav_field=new TextField();
    
    
    private HBox Correction_Final_loin_droite=new HBox(10);
    private HBox Correction_Final_loin_gauche=new HBox(10);
    private HBox Correction_Final_pres_droite=new HBox(10);
    private HBox Correction_Final_pres_gauche=new HBox(10);
    private GridPane Correction_Final_grid_pane=new GridPane();
    
    
     private TextField Correction_Final_VLDs_field=new TextField();
    private TextField Correction_Final_VLDc_field=new TextField();
    private TextField Correction_Final_VLDax_field=new TextField();
    private TextField Correction_Final_VLDav_field=new TextField();
    
    private TextField Correction_Final_VLGs_field=new TextField();
    private TextField Correction_Final_VLGc_field=new TextField();
    private TextField Correction_Final_VLGax_field=new TextField();
    private TextField Correction_Final_VLGav_field=new TextField();
    
    private TextField Correction_Final_VPDs_field=new TextField();
    private TextField Correction_Final_VPDc_field=new TextField();
    private TextField Correction_Final_VPDax_field=new TextField();
    private TextField Correction_Final_VPDav_field=new TextField();
    
    private TextField Correction_Final_VPGs_field=new TextField();
    private TextField Correction_Final_VPGc_field=new TextField();
    private TextField Correction_Final_VPGax_field=new TextField();
    private TextField Correction_Final_VPGav_field=new TextField();
    
    
    HBox typeu_verre_hbox=new HBox(70);
    private TextField type_de_verre=new TextField();
    private TextField teinte=new TextField();
    private TextArea Suivi_Medical_essai=new TextArea();
    
    private TextField type_lentille=new TextField();
    
    
     private HBox correction_lentille_droite=new HBox(10);
      private HBox correction_lentille_gauche=new HBox(10);
    private GridPane correction_lentille_grid_pane=new GridPane();
    private TextField correction_lentille_D_R=new TextField();
    private TextField correction_lentille_D_D=new TextField();
    private TextField correction_lentille_D_P=new TextField();
    private TextField correction_lentille_D_AV=new TextField();    
    private TextField correction_lentille_G_R=new TextField();
    private TextField correction_lentille_G_D=new TextField();
    private TextField correction_lentille_G_P=new TextField();
    private TextField correction_lentille_G_AV=new TextField(); 
    
    private GridPane option_lentille_grid_pane=new GridPane();
    private TextField marque_field=new TextField();
    private DatePicker date_debut_port_field=new DatePicker();
     private TextField alergies_field=new TextField();
    private TextField test_de_schimer_field=new TextField();
   
    
    
     private HBox prescription_final_droite=new HBox(10);
      private HBox prescription_final_gauche=new HBox(10);
    private GridPane prescription_final_grid_pane=new GridPane();
    private TextField prescription_final_D_R=new TextField();
    private TextField prescription_final_D_D=new TextField();
    private TextField prescription_final_D_P=new TextField();
    private TextField prescription_final_D_AV=new TextField();     
    private TextField prescription_final_G_R=new TextField();
    private TextField prescription_final_G_D=new TextField();
    private TextField prescription_final_G_P=new TextField();
    private TextField prescription_final_G_AV=new TextField();
    
    private TextArea suivi_medical_lentille=new TextArea();
    
    private Tab info_generale_tab=new Tab("Informations Generales");
    private AnchorPane info_generale_anchor_pane=new AnchorPane();
    private Tab Diagnostic_tab=new Tab("Diagnostic");
     private AnchorPane Diagnostic_anchor_pane=new AnchorPane();
    private Tab Essai_Corection_tab=new Tab("Essai De Correction");
     private AnchorPane Essai_Corection_anchor_pane=new AnchorPane();
    private Tab Contactologie_tab=new Tab("Contactologie");
     private AnchorPane Contactologie_anchor_pane=new AnchorPane();
    
    private TabPane Conteneur_tab_pane=new TabPane();
    
    String anciene_nom="";
    String anciene_prenom="";
    public Fenetre_Modifier_Lentille(ResultSet set1, ResultSet set2,ResultSet set3, ResultSet set4){
    
    initialiser_fenetre();
    evenement_fenetre();
    initialiser_field(set1,set2,set3,set4);
    this.setResizable(false); 
    this.setTitle("Modification Lentille");
    this.setScene(scene3);
    this.show();
    
    }
    
     /***************************************************************************************************************************/ 
    public void evenement_fenetre(){
    
    
    
     ajouter_lentille.setOnAction( (event) -> {
   modifier_lentille_fonction();
    
    
    
    
    });
      annuler_lentille.setOnAction((event) -> {           
         
         this.close();
         
        }); 
     
     
     ajouter_lentille.setOnMouseEntered((event) -> {           
         
         scene3.setCursor(Cursor.HAND);
         
        }); 
     annuler_lentille.setOnMouseEntered((event) -> {           
         
         scene3.setCursor(Cursor.HAND);
         
        }); 
     
     ajouter_lentille.setOnMouseExited((event)-> {
         
         scene3.setCursor(Cursor.DEFAULT);
     
     });
     
     
     annuler_lentille.setOnMouseExited((event)-> {
         
         scene3.setCursor(Cursor.DEFAULT);
     
     });
    
    }
    
   /***************************************************************************************************************************/   
      public void initialiser_fenetre(){
  
    grand_conteneur.setId("grand_conteneur_css2");

    scene3.getStylesheets().addAll(this.getClass().getResource("css/ajouter_lentille.css").toExternalForm()); 
    Conteneur_tab_pane.getTabs().addAll(info_generale_tab,Diagnostic_tab,Essai_Corection_tab,Contactologie_tab);
    grand_conteneur.getChildren().add(Conteneur_tab_pane);
    AnchorPane.setTopAnchor(Conteneur_tab_pane, 59.00);
    AnchorPane.setLeftAnchor(Conteneur_tab_pane, 263.00);
    Conteneur_tab_pane.setMaxHeight(480.00);
    Conteneur_tab_pane.setMinHeight(480.00);
    Conteneur_tab_pane.setMaxWidth(630.00);
    Conteneur_tab_pane.setMinWidth(630.00);
    
    info_generale_tab.setStyle("-fx-font-size:14px;-fx-font-weight:bold;-fx-font-family: \"Times New Roman\"; ");
    Diagnostic_tab.setStyle("-fx-font-size:14px;-fx-font-weight:bold;-fx-font-family: \"Times New Roman\"; ");
    Essai_Corection_tab.setStyle("-fx-font-size:14px;-fx-font-weight:bold;-fx-font-family: \"Times New Roman\";");
    Contactologie_tab.setStyle("-fx-font-size:14px;-fx-font-weight:bold;-fx-font-family: \"Times New Roman\";");    
        
    
      /****************************************************Infos generale TAB*************************************************************************/ 
 /*****************************   kerato_ grid************************/
    info_generale_anchor_pane.getChildren().add(information_generale);
     info_generale_tab.setContent(info_generale_anchor_pane);
     info_generale_anchor_pane.setId("info_generale_anchor_pane_css");
     kerato_droite.getChildren().addAll(kerato_RH_D_field,kerato_RV_D_field,kerato_Inconu_D_field,kerato_axe_D_field,kerato_Difference_D_field,kerato_P_D_field);
     kerato_gauche.getChildren().addAll(kerato_RH_G_field,kerato_RV_G_field,kerato_Inconu_G_field,kerato_axe_G_field,kerato_Difference_G_field,kerato_P_G_field);
     
     kerato_RH_D_field.setId("case_css");kerato_RV_D_field.setId("case_css");kerato_Inconu_D_field.setId("case_css");kerato_axe_D_field.setId("case_css");kerato_Difference_D_field.setId("case_css");kerato_P_D_field.setId("case_css");
     kerato_RH_G_field.setId("case_css");kerato_RV_G_field.setId("case_css");kerato_Inconu_G_field.setId("case_css");kerato_axe_G_field.setId("case_css");kerato_Difference_G_field.setId("case_css");kerato_P_G_field.setId("case_css");
     kerato_grid_pane.add(kerato_droite, 0,0 );
     kerato_grid_pane.add(kerato_gauche, 0,1);
     kerato_grid_pane.setHgap(10);  
      kerato_grid_pane.setVgap(5);
      info_generale_anchor_pane.getChildren().addAll(kerato_grid_pane);
      AnchorPane.setTopAnchor(kerato_grid_pane, 238.00); 
      AnchorPane.setLeftAnchor(kerato_grid_pane, 120.00); 
    
        
      /*****************************  information_generale grid************************/
      
     information_generale.add(nom_field,1,0,2,1);     
     information_generale.add(prenom_field,4,0,2,1);     
     information_generale.add(age_field,1,1,2,1);  
     information_generale.add(telephone_field,4,1,2,1);
     information_generale.add(montant_verse_field,1,2,2,1);
     information_generale.add(montant_restant_field,1,3,2,1);    
     information_generale.add(date_field,1,4,2,1);
     information_generale.add(adresse_field,4,2,2,3);    
     nom_field.setId("info_field_css");prenom_field.setId("info_field_css");age_field.setId("info_field_css");telephone_field.setId("info_field_css");
     montant_verse_field.setId("info_field_css");montant_restant_field.setId("info_field_css");date_field.setId("info_field_css");adresse_field.setId("info_field_2_css");
     information_generale.setVgap(5);
     information_generale.setHgap(70);
     
      AnchorPane.setTopAnchor(information_generale, 14.00);  
      AnchorPane.setLeftAnchor(information_generale, 72.00);  
       /***************************** fond_oeil biomicroscopie grid************************/
      
      fond_oeil_vbox.getChildren().addAll(fond_oeil_D_field,fond_oeil_G_field);
      biomicroscopie_vbox.getChildren().addAll(biomicroscopie_D_field,biomicroscopie_G_field); 
      
      fond_oeil_D_field.setId("case_css");fond_oeil_G_field.setId("case_css");biomicroscopie_D_field.setId("case_css");biomicroscopie_G_field.setId("case_css");
      info_generale_anchor_pane.getChildren().addAll(biomicroscopie_vbox,fond_oeil_vbox,ajouter_lentille,annuler_lentille);
      AnchorPane.setTopAnchor(fond_oeil_vbox, 350.00); 
      AnchorPane.setLeftAnchor(fond_oeil_vbox, 400.00); 
      AnchorPane.setTopAnchor(biomicroscopie_vbox, 350.00); 
      AnchorPane.setLeftAnchor(biomicroscopie_vbox, 110.00); 
      
       AnchorPane.setTopAnchor(ajouter_lentille, 323.00); 
       AnchorPane.setLeftAnchor(ajouter_lentille, 506.00); 
       ajouter_lentille.setStyle("-fx-min-width:102;-fx-max-width:102;-fx-min-height:28;-fx-max-height:28;-fx-background-color:transparent;");
       annuler_lentille.setStyle("-fx-min-width:102;-fx-max-width:102;-fx-min-height:28;-fx-max-height:28;-fx-background-color:transparent;");
       AnchorPane.setTopAnchor(annuler_lentille, 364.00); 
       AnchorPane.setLeftAnchor(annuler_lentille, 506.00);
     
      /********************************************diagnostic tab****************************************************************/
      /***************************** diagnostic grid************************/
      Diagnostic_anchor_pane.setId("Diagnostic_anchor_pane_css");
      
      diagnostic_D_field.setMaxWidth(190.00);diagnostic_D_field.setMinWidth(190.00);diagnostic_G_field.setMaxWidth(190.00);diagnostic_G_field.setMinWidth(190.00);
      diagnostic_hbox.getChildren().addAll(diagnostic_D_field,diagnostic_G_field);
      Diagnostic_anchor_pane.getChildren().add(diagnostic_hbox);
       AnchorPane.setTopAnchor(diagnostic_hbox, 65.00); 
      AnchorPane.setLeftAnchor(diagnostic_hbox, 100.00); 
      /*****************************ancienne correction grid************************/
     Diagnostic_tab.setContent(Diagnostic_anchor_pane);
     Ancienne_Correction_loin_droite.getChildren().addAll(Ancienne_Correction_VLDs_field,Ancienne_Correction_VLDc_field,Ancienne_Correction_VLDax_field,Ancienne_Correction_VLDav_field);
     Ancienne_Correction_loin_gauche.getChildren().addAll(Ancienne_Correction_VLGs_field,Ancienne_Correction_VLGc_field,Ancienne_Correction_VLGax_field,Ancienne_Correction_VLGav_field);
     Ancienne_Correction_pres_droite.getChildren().addAll(Ancienne_Correction_VPDs_field,Ancienne_Correction_VPDc_field,Ancienne_Correction_VPDax_field,Ancienne_Correction_VPDp_field);
     Ancienne_Correction_pres_gauche.getChildren().addAll(Ancienne_Correction_VPGs_field,Ancienne_Correction_VPGc_field,Ancienne_Correction_VPGax_field,Ancienne_Correction_VPGp_field); 
     Ancienne_Correction_VLDs_field.setId("case_css");Ancienne_Correction_VLDc_field.setId("case_css");Ancienne_Correction_VLDax_field.setId("case_css");Ancienne_Correction_VLDav_field.setId("case_av_css");
     Ancienne_Correction_VLGs_field.setId("case_css");Ancienne_Correction_VLGc_field.setId("case_css");Ancienne_Correction_VLGax_field.setId("case_css");Ancienne_Correction_VLGav_field.setId("case_av_css");
     Ancienne_Correction_VPDs_field.setId("case_css");Ancienne_Correction_VPDc_field.setId("case_css");Ancienne_Correction_VPDax_field.setId("case_css");Ancienne_Correction_VPDp_field.setId("case_css");
     Ancienne_Correction_VPGs_field.setId("case_css");Ancienne_Correction_VPGc_field.setId("case_css");Ancienne_Correction_VPGax_field.setId("case_css");Ancienne_Correction_VPGp_field.setId("case_css");
     
     ancienne_correction_grid_pane.add(Ancienne_Correction_loin_droite, 0,1 );
     ancienne_correction_grid_pane.add(Ancienne_Correction_loin_gauche, 0,2);
     ancienne_correction_grid_pane.add(Ancienne_Correction_pres_droite, 1,1);
     ancienne_correction_grid_pane.add(Ancienne_Correction_pres_gauche, 1,2);
     ancienne_correction_grid_pane.setVgap(5);
     ancienne_correction_grid_pane.setHgap(70);
    Diagnostic_anchor_pane.getChildren().add(ancienne_correction_grid_pane);
      AnchorPane.setTopAnchor(ancienne_correction_grid_pane, 198.00);
        AnchorPane.setLeftAnchor(ancienne_correction_grid_pane, 74.00);
     /*****************************aquite_visuelle grid***************************************/
     aquite_visuelle_brut_L_D.setId("case_av_css");aquite_visuelle_brut_L_G.setId("case_av_css");aquite_visuelle_brut_P_D.setId("case_av_css");aquite_visuelle_brut_P_G.setId("case_av_css");
     aquite_visuelle_grid_pane.add(aquite_visuelle_brut_L_D, 0,1 );
     aquite_visuelle_grid_pane.add(aquite_visuelle_brut_L_G, 0,2);
     aquite_visuelle_grid_pane.add(aquite_visuelle_brut_P_D, 1,1);
     aquite_visuelle_grid_pane.add(aquite_visuelle_brut_P_G, 1,2);
     aquite_visuelle_grid_pane.setVgap(10);
     aquite_visuelle_grid_pane.setHgap(60);
     Diagnostic_anchor_pane.getChildren().add(aquite_visuelle_grid_pane);
      AnchorPane.setTopAnchor(aquite_visuelle_grid_pane, 329.00); 
      AnchorPane.setLeftAnchor(aquite_visuelle_grid_pane,230.00); 
     /*********************************************************************Essai correction  TAB**************************************************************/
     
      Essai_Corection_anchor_pane.setId("Essai_Corection_anchor_pane_css");
      /*****************************Essai_Corection grid***************************************/
      Essai_Corection_tab.setContent(Essai_Corection_anchor_pane);
     Essei_Correction_loin_droite.getChildren().addAll(Essei_Correction_VLDs_field,Essei_Correction_VLDc_field,Essei_Correction_VLDax_field,Essei_Correction_VLDav_field);
     Essei_Correction_loin_gauche.getChildren().addAll(Essei_Correction_VLGs_field,Essei_Correction_VLGc_field,Essei_Correction_VLGax_field,Essei_Correction_VLGav_field);
     Essei_Correction_pres_droite.getChildren().addAll(Essei_Correction_VPDs_field,Essei_Correction_VPDc_field,Essei_Correction_VPDax_field,Essei_Correction_VPDav_field);
     Essei_Correction_pres_gauche.getChildren().addAll(Essei_Correction_VPGs_field,Essei_Correction_VPGc_field,Essei_Correction_VPGax_field,Essei_Correction_VPGav_field); 
  
          Essei_Correction_VLDs_field.setId("case_css");Essei_Correction_VLDc_field.setId("case_css");Essei_Correction_VLDax_field.setId("case_css");Essei_Correction_VLDav_field.setId("case_av_css");
     Essei_Correction_VLGs_field.setId("case_css");Essei_Correction_VLGc_field.setId("case_css");Essei_Correction_VLGax_field.setId("case_css");Essei_Correction_VLGav_field.setId("case_av_css");
     Essei_Correction_VPDs_field.setId("case_css");Essei_Correction_VPDc_field.setId("case_css");Essei_Correction_VPDax_field.setId("case_css");Essei_Correction_VPDav_field.setId("case_av_css");
     Essei_Correction_VPGs_field.setId("case_css");Essei_Correction_VPGc_field.setId("case_css");Essei_Correction_VPGax_field.setId("case_css");Essei_Correction_VPGav_field.setId("case_av_css");
     Essei_Correction_grid_pane.add(Essei_Correction_loin_droite, 0,1 );
     Essei_Correction_grid_pane.add(Essei_Correction_loin_gauche, 0,2);
     Essei_Correction_grid_pane.add(Essei_Correction_pres_droite, 1,1);
     Essei_Correction_grid_pane.add(Essei_Correction_pres_gauche, 1,2);
     Essei_Correction_grid_pane.setVgap(5);
     Essei_Correction_grid_pane.setHgap(70);
    
     AnchorPane.setTopAnchor(Essei_Correction_grid_pane, 70.00);
     AnchorPane.setLeftAnchor(Essei_Correction_grid_pane, 90.00);
       /*****************************Correction_Final grid***************************************/
     Correction_Final_loin_droite.getChildren().addAll(Correction_Final_VLDs_field,Correction_Final_VLDc_field,Correction_Final_VLDax_field,Correction_Final_VLDav_field);
     Correction_Final_loin_gauche.getChildren().addAll(Correction_Final_VLGs_field,Correction_Final_VLGc_field,Correction_Final_VLGax_field,Correction_Final_VLGav_field);
     Correction_Final_pres_droite.getChildren().addAll(Correction_Final_VPDs_field,Correction_Final_VPDc_field,Correction_Final_VPDax_field,Correction_Final_VPDav_field);
     Correction_Final_pres_gauche.getChildren().addAll(Correction_Final_VPGs_field,Correction_Final_VPGc_field,Correction_Final_VPGax_field,Correction_Final_VPGav_field); 
      Correction_Final_VLDs_field.setId("case_css");Correction_Final_VLDc_field.setId("case_css");Correction_Final_VLDax_field.setId("case_css");Correction_Final_VLDav_field.setId("case_av_css");
     Correction_Final_VLGs_field.setId("case_css");Correction_Final_VLGc_field.setId("case_css");Correction_Final_VLGax_field.setId("case_css");Correction_Final_VLGav_field.setId("case_av_css");
     Correction_Final_VPDs_field.setId("case_css");Correction_Final_VPDc_field.setId("case_css");Correction_Final_VPDax_field.setId("case_css");Correction_Final_VPDav_field.setId("case_av_css");
     Correction_Final_VPGs_field.setId("case_css");Correction_Final_VPGc_field.setId("case_css");Correction_Final_VPGax_field.setId("case_css");Correction_Final_VPGav_field.setId("case_av_css");
     
     Correction_Final_grid_pane.add(Correction_Final_loin_droite, 0,1 );
     Correction_Final_grid_pane.add(Correction_Final_loin_gauche, 0,2);
     Correction_Final_grid_pane.add(Correction_Final_pres_droite, 1,1);
     Correction_Final_grid_pane.add(Correction_Final_pres_gauche, 1,2);
     Correction_Final_grid_pane.setVgap(5);
     Correction_Final_grid_pane.setHgap(70);
     Essai_Corection_anchor_pane.getChildren().addAll(Essei_Correction_grid_pane,Correction_Final_grid_pane);
      AnchorPane.setTopAnchor(Correction_Final_grid_pane, 192.00);
       AnchorPane.setLeftAnchor(Correction_Final_grid_pane, 90.00);
      /*****************************type de verre et suivi grid***************************************/
      type_de_verre.setId("info_field_css");teinte.setId("info_field_css");
      typeu_verre_hbox.getChildren().addAll(type_de_verre,teinte);
      Essai_Corection_anchor_pane.getChildren().addAll(typeu_verre_hbox,Suivi_Medical_essai);
       AnchorPane.setTopAnchor(typeu_verre_hbox, 270.00); 
      AnchorPane.setLeftAnchor(typeu_verre_hbox, 160.00); 
       AnchorPane.setTopAnchor(Suivi_Medical_essai, 315.00); 
      AnchorPane.setLeftAnchor(Suivi_Medical_essai, 130.00);
      Suivi_Medical_essai.setMaxHeight(90.00);
      Suivi_Medical_essai.setMinHeight(90.00);
      Suivi_Medical_essai.setMaxWidth(400.00);
      Suivi_Medical_essai.setMinWidth(400.00);
      /****************************************************Contactologie TAB*************************************************************************/ 
      
      Contactologie_anchor_pane.setId("Contactologie_anchor_pane_css");
     /*****************************correction_lentille grid***************************************/
       
     correction_lentille_droite.getChildren().addAll( correction_lentille_D_R,correction_lentille_D_D,correction_lentille_D_P,correction_lentille_D_AV);
     correction_lentille_gauche.getChildren().addAll(correction_lentille_G_R,correction_lentille_G_D,correction_lentille_G_P,correction_lentille_G_AV);
     
     correction_lentille_D_R.setId("case_css");correction_lentille_D_D.setId("case_css");correction_lentille_D_P.setId("case_css");correction_lentille_D_AV.setId("case_av_css");
     correction_lentille_G_R.setId("case_css");correction_lentille_G_D.setId("case_css");correction_lentille_G_P.setId("case_css");correction_lentille_G_AV.setId("case_av_css");
     correction_lentille_grid_pane.add(correction_lentille_droite, 0,0 );
     correction_lentille_grid_pane.add(correction_lentille_gauche, 0,1);
     correction_lentille_grid_pane.setHgap(10);  
     correction_lentille_grid_pane.setVgap(5);
     
     AnchorPane.setTopAnchor(correction_lentille_grid_pane, 106.00); 
       AnchorPane.setLeftAnchor(correction_lentille_grid_pane, 186.00);
     
     /*****************************prescription_final grid***************************************/
     
    
     option_lentille_grid_pane.add(marque_field, 0,1 );
     option_lentille_grid_pane.add(test_de_schimer_field, 1,1);
     
     option_lentille_grid_pane.setVgap(5);
     option_lentille_grid_pane.setHgap(130);
   
        AnchorPane.setTopAnchor(option_lentille_grid_pane, 185.00);
        AnchorPane.setLeftAnchor(option_lentille_grid_pane, 130.00);
     
       /*****************************prescription_final grid***************************************/
     Contactologie_tab.setContent(Contactologie_anchor_pane);
     prescription_final_droite.getChildren().addAll( prescription_final_D_R,prescription_final_D_D,prescription_final_D_P,prescription_final_D_AV);
     prescription_final_gauche.getChildren().addAll(prescription_final_G_R,prescription_final_G_D,prescription_final_G_P,prescription_final_G_AV);
     
     prescription_final_D_R.setId("case_css");prescription_final_D_D.setId("case_css");prescription_final_D_P.setId("case_css");prescription_final_D_AV.setId("case_av_css");
     prescription_final_G_R.setId("case_css");prescription_final_G_D.setId("case_css");prescription_final_G_P.setId("case_css");prescription_final_G_AV.setId("case_av_css");
     prescription_final_grid_pane.add(prescription_final_droite, 0,0 );
     prescription_final_grid_pane.add(prescription_final_gauche, 0,1);
     prescription_final_grid_pane.setHgap(10);  
     prescription_final_grid_pane.setVgap(5);
     Contactologie_anchor_pane.getChildren().addAll(type_lentille,correction_lentille_grid_pane,date_debut_port_field,option_lentille_grid_pane,alergies_field,prescription_final_grid_pane,suivi_medical_lentille);
     AnchorPane.setTopAnchor(prescription_final_grid_pane, 332.00); 
      AnchorPane.setLeftAnchor(prescription_final_grid_pane, 88.00);
      
       AnchorPane.setTopAnchor(type_lentille, 18.00); 
      AnchorPane.setLeftAnchor(type_lentille, 250.00);
      
      AnchorPane.setTopAnchor(alergies_field, 232.00); 
      AnchorPane.setLeftAnchor(alergies_field, 180.00);
      alergies_field.setMaxWidth(220.00);
       alergies_field.setMinWidth(220.00);
        date_debut_port_field.setMaxWidth(120.00);
         date_debut_port_field.setMaxWidth(120.00);
         marque_field.setMaxWidth(170.00);
         marque_field.setMaxWidth(170.00); 
      AnchorPane.setTopAnchor(date_debut_port_field, 130.00); 
      AnchorPane.setLeftAnchor(date_debut_port_field, 478.00);
      
       AnchorPane.setTopAnchor(suivi_medical_lentille, 320.00); 
      AnchorPane.setLeftAnchor(suivi_medical_lentille, 355.00);
      suivi_medical_lentille.setMaxHeight(70.00);
      suivi_medical_lentille.setMinHeight(70.00);
      suivi_medical_lentille.setMaxWidth(230.00);
      suivi_medical_lentille.setMinWidth(230.00);
      
      
  
  
  }
    
   
  /***************************************************************************************************************************/  
    public Connection getconnaction() throws Exception{
    
        try {
            String url="jdbc:mysql://localhost:3306/optometrie";
            String user="root";
            String password="lailahailalah";
            Class.forName("com.mysql.jdbc.Driver");            
            Connection connection=(Connection) DriverManager.getConnection(url,user,password);            
            return connection;
        } catch (Exception e) {            
            e.printStackTrace();
        }
        return null;
    }
    
        
 /*********************************************************************************************************************************/
    
  
    private void initialiser_field(ResultSet set,ResultSet set2,ResultSet set3,ResultSet set4) {
        
        
        
        try {
            
            
         /************************************************ Initialiser la premierer requete****************************************************************/   
               
        
               nom_field.setText(set.getString(2));  
               anciene_nom=set.getString(2);
               prenom_field.setText(set.getString(3));
               anciene_prenom=set.getString(3);
               age_field.setText(set.getString(4));
               telephone_field.setText(set.getString(5));
               montant_verse_field.setText(set.getString(6));
               montant_restant_field.setText(set.getString(7));
               adresse_field.setText(set.getString(8));             
               kerato_RH_D_field.setText(set.getString(10));
               kerato_RH_G_field.setText(set.getString(11));
               kerato_RV_D_field.setText(set.getString(12));
               kerato_RV_G_field.setText(set.getString(13));
               kerato_Inconu_D_field.setText(set.getString(14));
               kerato_Inconu_G_field.setText(set.getString(15));
               kerato_axe_D_field.setText(set.getString(16));
               kerato_axe_G_field.setText(set.getString(17));
               kerato_Difference_D_field.setText(set.getString(18));
               kerato_Difference_G_field.setText(set.getString(19));
               kerato_P_D_field.setText(set.getString(20));              
               kerato_P_G_field.setText(set.getString(21));
               biomicroscopie_D_field.setText(set.getString(22));
               biomicroscopie_G_field.setText(set.getString(23));
               fond_oeil_D_field.setText(set.getString(24));
               fond_oeil_G_field.setText(set.getString(25));
            /************************************************ Initialiser la deuxième requete****************************************************************/ 
              
               diagnostic_D_field.setText(set2.getString(3));
               diagnostic_G_field.setText(set2.getString(4));
               Ancienne_Correction_VLDs_field.setText(set2.getString(5));
               Ancienne_Correction_VLDc_field.setText(set2.getString(6));
               Ancienne_Correction_VLDax_field.setText(set2.getString(7));
               Ancienne_Correction_VLDav_field.setText(set2.getString(8));
               Ancienne_Correction_VLGs_field.setText(set2.getString(9));
               Ancienne_Correction_VLGc_field.setText(set2.getString(10));
               Ancienne_Correction_VLGax_field.setText(set2.getString(11));
               Ancienne_Correction_VLGav_field.setText(set2.getString(12));
               Ancienne_Correction_VPDs_field.setText(set2.getString(13));
               Ancienne_Correction_VPDc_field.setText(set2.getString(14));
               Ancienne_Correction_VPDax_field.setText(set2.getString(15));
               Ancienne_Correction_VPDp_field.setText(set2.getString(16));
               Ancienne_Correction_VPGs_field.setText(set2.getString(17));
               Ancienne_Correction_VPGc_field.setText(set2.getString(18));
               Ancienne_Correction_VPGax_field.setText(set2.getString(19));
               Ancienne_Correction_VPGp_field.setText(set2.getString(20));              
               aquite_visuelle_brut_L_D.setText(set2.getString(21));
               aquite_visuelle_brut_L_G.setText(set2.getString(22));
               aquite_visuelle_brut_P_D.setText(set2.getString(23));
               aquite_visuelle_brut_P_G.setText(set2.getString(24));
              
            /************************************************ Initialiser la troisième requete****************************************************************/
          
               Essei_Correction_VLDs_field.setText(set3.getString(3));
               Essei_Correction_VLDc_field.setText(set3.getString(4));
               Essei_Correction_VLDax_field.setText(set3.getString(5));
               Essei_Correction_VLDav_field.setText(set3.getString(6));
               Essei_Correction_VLGs_field.setText(set3.getString(7));
               Essei_Correction_VLGc_field.setText(set3.getString(8));
               Essei_Correction_VLGax_field.setText(set3.getString(9));
               Essei_Correction_VLGav_field.setText(set3.getString(10));
               Essei_Correction_VPDs_field.setText(set3.getString(11));
               Essei_Correction_VPDc_field.setText(set3.getString(12));
               Essei_Correction_VPDax_field.setText(set3.getString(13));
               Essei_Correction_VPDav_field.setText(set3.getString(14));
               Essei_Correction_VPGs_field.setText(set3.getString(15));
               Essei_Correction_VPGc_field.setText(set3.getString(16));
               Essei_Correction_VPGax_field.setText(set3.getString(17));
               Essei_Correction_VPGav_field.setText(set3.getString(18));
               Correction_Final_VLDs_field.setText(set3.getString(19));
               Correction_Final_VLDc_field.setText(set3.getString(20));
               Correction_Final_VLDax_field.setText(set3.getString(21));
               Correction_Final_VLDav_field.setText(set3.getString(22));
               Correction_Final_VLGs_field.setText(set3.getString(23));
               Correction_Final_VLGc_field.setText(set3.getString(24));
               Correction_Final_VLGax_field.setText(set3.getString(25));
               Correction_Final_VLGav_field.setText(set3.getString(26));
               Correction_Final_VPDs_field.setText(set3.getString(27));
               Correction_Final_VPDc_field.setText(set3.getString(28));
               Correction_Final_VPDax_field.setText(set3.getString(29));
               Correction_Final_VPDav_field.setText(set3.getString(30));
              Correction_Final_VPGs_field.setText(set3.getString(31));
               Correction_Final_VPGc_field.setText(set3.getString(32));
               Correction_Final_VPGax_field.setText(set3.getString(33));
               Correction_Final_VPGav_field.setText(set3.getString(34));
               type_de_verre.setText(set3.getString(35));
               teinte.setText(set3.getString(36));
               Suivi_Medical_essai.setText(set3.getString(37));
             
            /************************************************ Initialiser la Qautrième requete****************************************************************/ 
             
               
               type_lentille.setText(set4.getString(3));
               correction_lentille_D_R.setText(set4.getString(4));
               correction_lentille_D_D.setText(set4.getString(5));
               correction_lentille_D_P.setText(set4.getString(6));
               correction_lentille_D_AV.setText(set4.getString(7));
               correction_lentille_G_R.setText(set4.getString(8));
               correction_lentille_G_D.setText(set4.getString(9));
               correction_lentille_G_P.setText(set4.getString(10));
               correction_lentille_G_AV.setText(set4.getString(11));
               date_field.setValue(LOCAL_DATE(set.getString(12)));
               marque_field.setText(set4.getString(13));
               test_de_schimer_field.setText(set4.getString(14));
               alergies_field.setText(set4.getString(15));
               prescription_final_D_R.setText(set4.getString(16));
               prescription_final_D_D.setText(set4.getString(17));
               prescription_final_D_P.setText(set4.getString(18));
               prescription_final_D_AV.setText(set4.getString(19));
               prescription_final_G_R.setText(set4.getString(20));              
               prescription_final_G_D.setText(set4.getString(21));
               prescription_final_G_P.setText(set4.getString(22));
               prescription_final_G_AV.setText(set4.getString(23));
               suivi_medical_lentille.setText(set4.getString(24));
        } catch (Exception e) {
        }
        
        
        
        
        
    }
  
  
    
     /********************************************************************************************************************************/
      public void modifier_lentille_fonction(){
       

   
    String modifier_requete="UPDATE `lentille` SET `Nom`='"+nom_field.getText().trim()+"',`Prenom`='"+prenom_field.getText().trim()+"',`Age`='"+age_field.getText().trim()+"',`Numero_Telephone`='"+telephone_field.getText().trim()+"',`Montant_verse`=";
       if (montant_verse_field.getText().trim().isEmpty()) modifier_requete+=000+",`Montant_restant`="; 
       else   modifier_requete+= Integer.parseInt(montant_verse_field.getText().trim())+",`Montant_restant`=";  
      
        if (montant_restant_field.getText().trim().isEmpty()) modifier_requete+=000+",`Adresse`='"; 
       else   modifier_requete+= Integer.parseInt(montant_restant_field.getText().trim())+",`Adresse`='"; 
           
        modifier_requete+=adresse_field.getText().trim()+"',`Date_consultation`='";  
        
       if (date_field.getValue()==null) modifier_requete+="1444-12-01',`Kerato_D_RH`='";
       else modifier_requete+=date_field.getValue().toString().trim()+"',`Kerato_D_RH`='";
       
       modifier_requete+=kerato_RH_D_field.getText().trim()+"',`Kerato_G_RH`='"+kerato_RH_G_field.getText().trim()+"',`Kerato_D_RV`='"+kerato_RV_D_field.getText().trim()+"',`Kerato_G_RV`='"+kerato_RV_G_field.getText().trim()+"',`Kerato_D_inconu`='";
       modifier_requete+=kerato_Inconu_D_field.getText().trim()+"',`Kerato_G_inconu`='"+kerato_Inconu_G_field.getText().trim()+"',`Kerato_D_axe`='"+kerato_axe_D_field.getText().trim()+"',`Kerato_G_axe`='"+kerato_axe_G_field.getText().trim()+"',`Kerato_D_difference`='";
       modifier_requete+=kerato_Difference_D_field.getText().trim()+"',`Kerato_G_difference`='"+kerato_Difference_G_field.getText().trim()+"',`Kerato_D_p`='"+kerato_P_D_field.getText().trim()+"',`Kerato_G_p`='"+kerato_P_G_field.getText().trim()+"',`Biomicro_D`='";   
       modifier_requete+=biomicroscopie_D_field.getText().trim()+"',`Biomicro_G`='"+biomicroscopie_G_field.getText().trim()+"',`Fond_oeil_D`='"+fond_oeil_D_field.getText().trim()+"',`Fond_oeil_G`='";

       modifier_requete+=fond_oeil_G_field.getText().trim()+"' where `Nom`='"+anciene_nom+"'AND `Prenom`='"+anciene_prenom+"'";
       
    
    /**********************************************************************************************************************************************/
 
 
       String modifier_requete2="UPDATE `diagnostic` SET `Nom`='"+nom_field.getText().trim()+"',`Prenom`='"+prenom_field.getText().trim()+"',`Diagnostic_D`='";
  
       modifier_requete2+=diagnostic_D_field.getText().trim()+"',`Diagnostic_G`='"+diagnostic_G_field.getText().trim()+"',`AC_LD_S`='"+Ancienne_Correction_VLDs_field.getText().trim()+"',`AC_LD_C`='"+Ancienne_Correction_VLDc_field.getText().trim()+"',`AC_LD_Ax`='";
       modifier_requete2+=Ancienne_Correction_VLDax_field.getText().trim()+"',`AC_LD_Av`='"+Ancienne_Correction_VLDav_field.getText().trim()+"',`AC_LG_S`='"+Ancienne_Correction_VLGs_field.getText().trim()+"',`AC_LG_C`='"+Ancienne_Correction_VLGc_field.getText().trim()+"',`AC_LG_Ax`='";
       modifier_requete2+=Ancienne_Correction_VLGax_field.getText().trim()+"',`AC_LG_Av`='"+Ancienne_Correction_VLGav_field.getText().trim()+"',`AC_PD_S`='"+Ancienne_Correction_VPDs_field.getText().trim()+"',`AC_PD_C`='"+Ancienne_Correction_VPDc_field.getText().trim()+"',`AC_PD_Ax`='";   
       modifier_requete2+=Ancienne_Correction_VPDax_field.getText().trim()+"',`AC_PD_P`='"+Ancienne_Correction_VPDp_field.getText().trim()+"',`AC_PG_S`='"+Ancienne_Correction_VPGs_field.getText().trim()+"',`AC_PG_C`='"+Ancienne_Correction_VPGc_field.getText().trim()+"',`AC_PG_Ax`='"+Ancienne_Correction_VPGax_field.getText().trim()+"',`AC_PG_P`='";
       modifier_requete2+=Ancienne_Correction_VPGp_field.getText().trim()+"',`AVB_LD`='"+aquite_visuelle_brut_L_D.getText().trim()+"',`AVB_LG`='"+aquite_visuelle_brut_L_G.getText().trim()+"',`AVB_PD`='"+aquite_visuelle_brut_P_D.getText().trim()+"',`AVB_PG`='"+aquite_visuelle_brut_P_G.getText().trim()+"' where `Nom`='"+anciene_nom+"'AND `Prenom`='"+anciene_prenom+"'";       

    
    /**********************************************************************************************************************************************/
    

        String modifier_requete3="UPDATE `essai_correction` SET `Nom`='"+nom_field.getText().trim()+"',`Prenom`='"+prenom_field.getText().trim();
  
       modifier_requete3+="',`EC_LD_S`='"+Essei_Correction_VLDs_field.getText().trim()+"',`EC_LD_C`='"+Essei_Correction_VLDc_field.getText().trim()+"',`EC_LD_Ax`='";
       modifier_requete3+=Essei_Correction_VLDax_field.getText().trim()+"',`EC_LD_Av`='"+Essei_Correction_VLDav_field.getText().trim()+"',`EC_LG_S`='"+Essei_Correction_VLGs_field.getText().trim()+"',`EC_LG_C`='"+Essei_Correction_VLGc_field.getText().trim()+"',`EC_LG_Ax`='";
       modifier_requete3+=Essei_Correction_VLGax_field.getText().trim()+"',`EC_LG_Av`='"+Essei_Correction_VLGav_field.getText().trim()+"',`EC_PD_S`='"+Essei_Correction_VPDs_field.getText().trim()+"',`EC_PD_C`='"+Essei_Correction_VPDc_field.getText().trim()+"',`EC_PD_Ax`='";   
       modifier_requete3+=Essei_Correction_VPDax_field.getText().trim()+"',`EC_PD_Av`='"+Essei_Correction_VPDav_field.getText().trim()+"',`EC_PG_S`='"+Essei_Correction_VPGs_field.getText().trim()+"',`EC_PG_C`='"+Essei_Correction_VPGc_field.getText().trim()+"',`EC_PG_Ax`='"+Essei_Correction_VPGax_field.getText().trim()+"',`EC_PG_Av`='";
       modifier_requete3+=Essei_Correction_VPGav_field.getText().trim();
       
       modifier_requete3+="',`CF_LD_S`='"+Correction_Final_VLDs_field.getText().trim()+"',`CF_LD_C`='"+Correction_Final_VLDc_field.getText().trim()+"',`CF_LD_Ax`='";
       modifier_requete3+=Correction_Final_VLDax_field.getText().trim()+"',`CF_LD_Av`='"+Correction_Final_VLDav_field.getText().trim()+"',`CF_LG_S`='"+Correction_Final_VLGs_field.getText().trim()+"',`CF_LG_C`='"+Correction_Final_VLGc_field.getText().trim()+"',`CF_LG_Ax`='";
       modifier_requete3+=Correction_Final_VLGax_field.getText().trim()+"',`CF_LG_Av`='"+Correction_Final_VLGav_field.getText().trim()+"',`CF_PD_S`='"+Correction_Final_VPDs_field.getText().trim()+"',`CF_PD_C`='"+Correction_Final_VPDc_field.getText().trim()+"',`CF_PD_Ax`='";   
       modifier_requete3+=Correction_Final_VPDax_field.getText().trim()+"',`CF_PD_Av`='"+Correction_Final_VPDav_field.getText().trim()+"',`CF_PG_S`='"+Correction_Final_VPGs_field.getText().trim()+"',`CF_PG_C`='"+Correction_Final_VPGc_field.getText().trim()+"',`CF_PG_Ax`='"+Correction_Final_VPGax_field.getText().trim()+"',`CF_PG_Av`='";
       modifier_requete3+=Correction_Final_VPGav_field.getText().trim();
       
       modifier_requete3+="',`Type_verre`='"+type_de_verre.getText().trim()+"',`Teinte`='"+teinte.getText().trim()+"',`Suivi_medical`='"+Suivi_Medical_essai.getText().trim()+"' where `Nom`='"+anciene_nom+"'AND `Prenom`='"+anciene_prenom+"'";

     
    
    /**********************************************************************************************************************************************/
       String modifier_requete4="UPDATE `contactologie` SET `Nom`='"+nom_field.getText().trim()+"',`Prenom`='"+prenom_field.getText().trim();
  
       modifier_requete4+="',`Type_lentille`='"+type_lentille.getText().trim()+"',`CL_D_R`='"+correction_lentille_D_R.getText().trim()+"',`CL_D_D`='";
       modifier_requete4+=correction_lentille_D_D.getText().trim()+"',`CL_D_P`='"+correction_lentille_D_P.getText().trim()+"',`CL_D_Av`='"+correction_lentille_D_AV.getText().trim()+"',`CL_G_R`='"+correction_lentille_G_R.getText().trim()+"',`CL_G_D`='";
       modifier_requete4+=correction_lentille_G_D.getText().trim()+"',`CL_G_P`='"+correction_lentille_G_P.getText().trim()+"',`CL_G_Av`='"+correction_lentille_G_AV.getText().trim()+"',`Date_port`='";
       
       if (date_debut_port_field.getValue()==null) modifier_requete4+="1444-12-01',`Marque`='";
       else modifier_requete4+=date_debut_port_field.getValue().toString().trim()+"',`Marque`='";
       
       modifier_requete4+=marque_field.getText().trim()+"',`Test_shcimer`='"+test_de_schimer_field.getText().trim()+"',`Allergies`='"+alergies_field.getText().trim();
      
       modifier_requete4+="',`PF_D_R`='"+prescription_final_D_R.getText().trim()+"',`PF_D_D`='";
       modifier_requete4+=prescription_final_D_D.getText().trim()+"',`PF_D_P`='"+prescription_final_D_P.getText().trim()+"',`PF_D_Av`='"+prescription_final_D_AV.getText().trim()+"',`PF_G_R`='"+prescription_final_G_R.getText().trim()+"',`PF_G_D`='";
       modifier_requete4+=prescription_final_G_D.getText().trim()+"',`PF_G_P`='"+prescription_final_G_P.getText().trim()+"',`PF_G_Av`='"+prescription_final_G_AV.getText().trim()+"',`Suivi_medical`='"+suivi_medical_lentille.getText().trim()+"' where `Nom`='"+anciene_nom+"'AND `Prenom`='"+anciene_prenom+"'";
       
      
  
       
       
   
       Statement st1;
          try {
              
                 if(getconnaction()!=null ) {
                        
                    st1 = getconnaction().createStatement();
                    st1.executeUpdate(modifier_requete);
                    st1.executeUpdate(modifier_requete2);
                    st1.executeUpdate(modifier_requete3);
                    st1.executeUpdate(modifier_requete4);
                    
                             Alert dialogE = new Alert(Alert.AlertType.INFORMATION);
                             dialogE.setTitle("Modification Terminé ");
                             dialogE.setHeaderText("Malade Modifié");
                             dialogE.setContentText("la modification des informations du malade a été effectuée avec succes");
                             dialogE.showAndWait();
                    
                    
                    this.close();
                  }
                 else{
                             Alert dialogE = new Alert(Alert.AlertType.ERROR);
                             dialogE.setTitle("Modification éronné ");
                             dialogE.setHeaderText("Malade Non Modifié");
                             dialogE.setContentText("la modification des informations du malade n'a pas été effectuée, veuillez vérifier la connexion avec la base de données");
                             dialogE.showAndWait();
                          }
          
            } catch (Exception ex) {
              
                 
                             Alert dialogE = new Alert(Alert.AlertType.ERROR);
                             dialogE.setTitle("Ajout éronné ");
                             dialogE.setHeaderText("Malade Non Ajouté");
                             dialogE.setContentText("léajout du malade n'a pas été effectuée, veuillez vérifier leur inforamtion");
                             dialogE.showAndWait();
                                         
          }
   
   
   
  
   }
  /*****************************************************************************************************************************/  
    public static final LocalDate LOCAL_DATE (String dateString){
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
    LocalDate localDate = LocalDate.parse(dateString, formatter);
    return localDate;
  }  
    
}

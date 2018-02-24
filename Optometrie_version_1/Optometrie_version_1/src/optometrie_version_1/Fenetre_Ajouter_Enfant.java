/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optometrie_version_1;

import com.mysql.jdbc.Connection;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 *
 * @author Milano
 */
public class Fenetre_Ajouter_Enfant extends Stage{
    
    
    
    
    private AnchorPane grand_conteneur = new AnchorPane();
    private Scene scene3 = new Scene(grand_conteneur,932, 546);
    private Button ajouter_enfant=new Button("");
    private Button annuler_enfant=new Button("");
    
    
    private GridPane information_generale=new GridPane();
    private TextField nom_field=new TextField();
    private TextField prenom_field=new TextField();
    private TextField age_field=new TextField();
    private TextArea adresse_field=new TextArea();   
    private TextField medecin_field=new TextField(); 
    private TextField telephone_field=new TextField(); 
    private TextField montant_verse_field=new TextField();
    private TextField montant_reste_field=new TextField(); 
    private DatePicker date_field=new DatePicker();
    private TextField predominance_field=new TextField();
    private TextArea antecedent_field=new TextArea();
    private TextArea diagnostic_field=new TextArea();
    
    
    private HBox aquite_visuelle_hbox =new HBox(142);
    private TextField aquite_visuelle_brut_D_field=new TextField();
    private TextField aquite_visuelle_brut_G_field=new TextField();
    
    private HBox Ancienne_Correction_droite=new HBox(10);
    private HBox Ancienne_Correction_gauche=new HBox(10);
    private GridPane ancienne_correction_grid_pane=new GridPane();
    
    private TextField Ancienne_Correction_VDs_field=new TextField();
    private TextField Ancienne_Correction_VDc_field=new TextField();
    private TextField Ancienne_Correction_VDax_field=new TextField();
    private TextField Ancienne_Correction_VDav_field=new TextField();
    
    private TextField Ancienne_Correction_VGs_field=new TextField();
    private TextField Ancienne_Correction_VGc_field=new TextField();
    private TextField Ancienne_Correction_VGax_field=new TextField();
    private TextField Ancienne_Correction_VGav_field=new TextField();
    
    private GridPane javal_grid_pane=new GridPane();
     private TextField Javal_VDa_field=new TextField();
     private TextField Javal_VDc_field=new TextField();
     private TextField Javal_VGa_field=new TextField();
     private TextField Javal_VGc_field=new TextField();
    
     private GridPane Fond_oeil_grid_pane=new GridPane();
     private GridPane Biomicro_grid_pane=new GridPane();
     private TextField Fond_oeil_D_field=new TextField();
     private TextField Fond_oeil_G_field=new TextField();    
     private TextField Biomicro_D_field=new TextField();
     private TextField Biomicro_G_field=new TextField();
     
     
     private VBox Skiascopie_froid_vbox=new VBox(10);
    private TextField Skiascopie_froid_DMV_field=new TextField();
    private TextField Skiascopie_froid_DMH_field=new TextField();
    private TextField Skiascopie_froid_GMV_field=new TextField();
    private TextField Skiascopie_froid_GMH_field=new TextField();
    
    private VBox Skiascopie_dilatation_vbox=new VBox(10);
    private TextField Skiascopie_dilatation_DMV_field=new TextField();
    private TextField Skiascopie_dilatation_DMH_field=new TextField();
    private TextField Skiascopie_dilatation_GMV_field=new TextField();
    private TextField Skiascopie_dilatation_GMH_field=new TextField();
    
    private HBox diagnostic_hbox=new HBox(40);
    private TextField Diagnostic_D_field=new TextField();
    private TextField Diagnostic_G_field=new TextField();
    
    private Tab infos_generale_tab=new Tab("Infos Générales");
    private AnchorPane infos_generale_anchor_pane=new AnchorPane();    
    private Tab Aquite_tab=new Tab("Aquité");
    private AnchorPane Aquité_anchor_pane=new AnchorPane();
    private Tab Skiascopie_tab=new Tab("Skiascopie");
    private AnchorPane Skiascopie_anchor_pane=new AnchorPane();
    
    private TabPane Conteneur_tab_pane=new TabPane();
  
    public Fenetre_Ajouter_Enfant(){
    
  
        
        
        initialiser_fenetre();
        evenement_fenetre();
       
        
    /*****************************************************************************************************************************/
    this.setResizable(false);
    this.setTitle("Ajout Pédiatrie");    
    this.setScene(scene3);
    this.show();
    }
   

    /*****************************************************************************************************************************/
    
    public void evenement_fenetre(){
    
    ajouter_enfant.setOnAction( (event) -> {
    System.out.println("debut");
    ajouter_enfant_fonction();
    
    
    
    });
    
     annuler_enfant.setOnAction((event) -> {           
         
         this.close();
         
        }); 
    
       ajouter_enfant.setOnMouseEntered((event) -> {           
         
         scene3.setCursor(Cursor.HAND);
         
        }); 
     annuler_enfant.setOnMouseEntered((event) -> {           
         
         scene3.setCursor(Cursor.HAND);
         
        }); 
     
     ajouter_enfant.setOnMouseExited((event)-> {
         
         scene3.setCursor(Cursor.DEFAULT);
     
     });
     
     
     annuler_enfant.setOnMouseExited((event)-> {
         
         scene3.setCursor(Cursor.DEFAULT);
     
     });
   
    }
    
     /*****************************************************************************************************************************/ 
    
    
      public void initialiser_fenetre()
      {
    
    
         
    grand_conteneur.setId("grand_conteneur_css");
    scene3.getStylesheets().addAll(this.getClass().getResource("css/ajouter_enfant.css").toExternalForm()); 
    Conteneur_tab_pane.getTabs().addAll(infos_generale_tab,Aquite_tab,Skiascopie_tab);
    grand_conteneur.getChildren().add(Conteneur_tab_pane);
    AnchorPane.setTopAnchor(Conteneur_tab_pane, 59.00);
    AnchorPane.setLeftAnchor(Conteneur_tab_pane, 264.00);
    Conteneur_tab_pane.setMaxHeight(480.00);
    Conteneur_tab_pane.setMinHeight(480.00);
    Conteneur_tab_pane.setMaxWidth(630.00);
    Conteneur_tab_pane.setMinWidth(630.00);
    
    infos_generale_tab.setStyle("-fx-font-size:14px;-fx-font-weight:bold;-fx-font-family: \"Times New Roman\"; ");
    Aquite_tab.setStyle("-fx-font-size:14px;-fx-font-weight:bold;-fx-font-family: \"Times New Roman\"; ");
    Skiascopie_tab.setStyle("-fx-font-size:14px;-fx-font-weight:bold;-fx-font-family: \"Times New Roman\";");

     
    
    
    infos_generale_tab.setContent(infos_generale_anchor_pane);
    Aquite_tab.setContent(Aquité_anchor_pane);
    Skiascopie_tab.setContent(Skiascopie_anchor_pane);
    
    /****************************************************Infos generale TAB*************************************************************************/
    
      
      /*****************************  information_generale grid************************/
      infos_generale_anchor_pane.setId("infos_generale_anchor_pane_css2");
     information_generale.add(nom_field,1,0,2,1);     
     information_generale.add(prenom_field,4,0,2,1);     
     information_generale.add(age_field,1,1,2,1);  
     information_generale.add(telephone_field,4,1,2,1);
     information_generale.add(montant_verse_field,1,2,2,1);
      information_generale.add(medecin_field,4,2,2,1);
     information_generale.add(montant_reste_field,1,3,2,1);    
     information_generale.add(predominance_field,1,4,2,1); 
     information_generale.add(date_field,1,5,2,1);
     information_generale.add(adresse_field,4,3,2,3);    
     nom_field.setId("info_field_css");prenom_field.setId("info_field_css");age_field.setId("info_field_css");predominance_field.setId("info_field_css");telephone_field.setId("info_field_css");
     medecin_field.setId("info_field_css");montant_verse_field.setId("info_field_css");montant_reste_field.setId("info_field_css");date_field.setId("info_field_css");adresse_field.setId("info_field_2_css");
     information_generale.setVgap(5);
     information_generale.setHgap(70);
     infos_generale_anchor_pane.getChildren().addAll(information_generale,diagnostic_field,antecedent_field,ajouter_enfant,annuler_enfant);
      AnchorPane.setTopAnchor(information_generale, 75.00);  
       AnchorPane.setLeftAnchor(information_generale, 60.00);
         
       AnchorPane.setTopAnchor(ajouter_enfant, 304.00); 
       AnchorPane.setLeftAnchor(ajouter_enfant, 501.00); 
       ajouter_enfant.setStyle("-fx-min-width:102;-fx-max-width:102;-fx-min-height:28;-fx-max-height:28;-fx-background-color:transparent;");
       annuler_enfant.setStyle("-fx-min-width:102;-fx-max-width:102;-fx-min-height:28;-fx-max-height:28;-fx-background-color:transparent;");
       AnchorPane.setTopAnchor(annuler_enfant, 345.00); 
       AnchorPane.setLeftAnchor(annuler_enfant, 501.00);
        
      AnchorPane.setTopAnchor(diagnostic_field,297.00); 
      AnchorPane.setLeftAnchor(diagnostic_field,261.00); 
      AnchorPane.setTopAnchor(antecedent_field,297.00); 
      AnchorPane.setLeftAnchor(antecedent_field,28.00); 
      
    diagnostic_field.setMaxHeight(80.00);
    diagnostic_field.setMinHeight(80.00);
    diagnostic_field.setMaxWidth(200.00);
    diagnostic_field.setMinWidth(200.00);
    
    antecedent_field.setMaxHeight(80.00);
    antecedent_field.setMinHeight(80.00);
    antecedent_field.setMaxWidth(200.00);
    antecedent_field.setMinWidth(200.00);
    /****************************************************Aquite TAB*************************************************************************/
    Aquité_anchor_pane.setId("Aquite_anchor_pane_css");
      aquite_visuelle_hbox.getChildren().addAll(aquite_visuelle_brut_D_field,aquite_visuelle_brut_G_field);
      Aquité_anchor_pane.getChildren().add(aquite_visuelle_hbox);
      aquite_visuelle_brut_G_field.setId("case_av_css");
     aquite_visuelle_brut_D_field.setId("case_av_css");
      AnchorPane.setTopAnchor(aquite_visuelle_hbox, 65.00); 
      AnchorPane.setLeftAnchor(aquite_visuelle_hbox, 210.00); 
      
     
     /******************************Ancienne_Correction********************************************************/
      Ancienne_Correction_droite.getChildren().addAll( Ancienne_Correction_VDs_field,Ancienne_Correction_VDc_field,Ancienne_Correction_VDax_field,Ancienne_Correction_VDav_field);
     Ancienne_Correction_gauche.getChildren().addAll(Ancienne_Correction_VGs_field,Ancienne_Correction_VGc_field,Ancienne_Correction_VGax_field,Ancienne_Correction_VGav_field);
     
     Ancienne_Correction_VDs_field.setId("case_css");Ancienne_Correction_VDc_field.setId("case_css");Ancienne_Correction_VDax_field.setId("case_css");Ancienne_Correction_VDav_field.setId("case_av_css");
     Ancienne_Correction_VGs_field.setId("case_css");Ancienne_Correction_VGc_field.setId("case_css");Ancienne_Correction_VGax_field.setId("case_css");Ancienne_Correction_VGav_field.setId("case_av_css");
     ancienne_correction_grid_pane.add(Ancienne_Correction_droite, 0,0 );
     ancienne_correction_grid_pane.add(Ancienne_Correction_gauche, 0,1);
     ancienne_correction_grid_pane.setHgap(10);  
     ancienne_correction_grid_pane.setVgap(5);
     Aquité_anchor_pane.getChildren().addAll(ancienne_correction_grid_pane);
     AnchorPane.setTopAnchor(ancienne_correction_grid_pane, 180.00);
     AnchorPane.setLeftAnchor(ancienne_correction_grid_pane, 196.00);
     
      /******************************javal grid********************************************************/
     
    Javal_VDa_field.setId("case_css");Javal_VGa_field.setId("case_css");Javal_VDc_field.setId("case_css");Javal_VGc_field.setId("case_css");
      javal_grid_pane.add(Javal_VDa_field, 0,1 );
      javal_grid_pane.add(Javal_VDc_field, 1,1);
      javal_grid_pane.add(Javal_VGa_field, 0,2); 
      javal_grid_pane.add(Javal_VGc_field, 1,2);
      javal_grid_pane.setVgap(5);
      javal_grid_pane.setHgap(10);
      
      Aquité_anchor_pane.getChildren().add( Biomicro_grid_pane);
      
      Aquité_anchor_pane.getChildren().add( javal_grid_pane);
       AnchorPane.setTopAnchor( javal_grid_pane, 300.00);
        AnchorPane.setLeftAnchor( javal_grid_pane, 265.00);
       /******************************javal grid********************************************************/
        
        
         Biomicro_D_field.setId("info_field_css");Biomicro_G_field.setId("info_field_css");Fond_oeil_D_field.setId("info_field_css");Fond_oeil_G_field.setId("info_field_css");
      Biomicro_grid_pane.add(Biomicro_D_field, 0,1 );
      Biomicro_grid_pane.add(Biomicro_G_field, 0,2);
      Fond_oeil_grid_pane.add(Fond_oeil_D_field, 0,1);
      Fond_oeil_grid_pane.add(Fond_oeil_G_field, 0,2);
      Fond_oeil_grid_pane.setVgap(5);
      Biomicro_grid_pane.setVgap(5);
       Aquité_anchor_pane.getChildren().add( Fond_oeil_grid_pane);
      
       AnchorPane.setTopAnchor( Fond_oeil_grid_pane, 320.00);
       AnchorPane.setLeftAnchor( Fond_oeil_grid_pane, 450.00);
        AnchorPane.setTopAnchor( Biomicro_grid_pane, 322.00);
       AnchorPane.setLeftAnchor( Biomicro_grid_pane, 59.00);
    /****************************************************Skiascopie TAB*************************************************************************/
        
         Skiascopie_anchor_pane.setId("Skiascopie_anchor_pane_css");
        
        
    Skiascopie_froid_vbox.getChildren().addAll(Skiascopie_froid_DMV_field,Skiascopie_froid_DMH_field,Skiascopie_froid_GMV_field,Skiascopie_froid_GMH_field);
    Skiascopie_dilatation_vbox.getChildren().addAll(Skiascopie_dilatation_DMV_field,Skiascopie_dilatation_DMH_field,Skiascopie_dilatation_GMV_field,Skiascopie_dilatation_GMH_field);    
    Skiascopie_froid_DMV_field.setId("case_c_css");Skiascopie_froid_DMH_field.setId("case_c_css");Skiascopie_froid_GMV_field.setId("case_c_css");Skiascopie_froid_GMH_field.setId("case_c_css");    
    Skiascopie_dilatation_DMV_field.setId("case_c_css");Skiascopie_dilatation_DMH_field.setId("case_c_css");Skiascopie_dilatation_GMV_field.setId("case_c_css");Skiascopie_dilatation_GMH_field.setId("case_c_css");    
    diagnostic_hbox.getChildren().addAll(Diagnostic_D_field,Diagnostic_G_field);
    Diagnostic_G_field.setMaxWidth(180.00);
    Diagnostic_G_field.setMinWidth(180.00);
    Diagnostic_D_field.setMaxWidth(180.00);
    Diagnostic_D_field.setMinWidth(180.00);
    Skiascopie_anchor_pane.getChildren().addAll(Skiascopie_froid_vbox,Skiascopie_dilatation_vbox,diagnostic_hbox);
    
        AnchorPane.setTopAnchor( Skiascopie_froid_vbox, 104.00);
        AnchorPane.setLeftAnchor( Skiascopie_froid_vbox, 120.00);
        AnchorPane.setTopAnchor( Skiascopie_dilatation_vbox, 104.00);
        AnchorPane.setLeftAnchor( Skiascopie_dilatation_vbox,420.00);
        AnchorPane.setTopAnchor( diagnostic_hbox, 314.00);
        AnchorPane.setLeftAnchor( diagnostic_hbox, 112.00);
        
        
        
    
      }
   /*****************************************************************************************************************************/ 
    
  public void ajouter_enfant_fonction(){
 
      /*************************************************************le première requete******************************************************************/
       
   String ajouter_requete="INSERT INTO `enfant`( `Nom`, `Prenom`, `Age`, `Numero_Telephone`, `Montant_verse`, `Montant_restant`, `Medecin`, `Adresse`, `Predominance`, `Date_consultation`, `Antecedent`, `Diagnostic`, `SF_D_MV`, `SF_D_MH`, `SF_G_MV`, `SF_G_MH`, `SD_D_MV`, `SD_D_MH`, `SD_G_MV`, `SD_G_MH`, `Diagnostic_D`, `Diagnostic_G`) VALUES ('"+nom_field.getText().trim()+"','"+prenom_field.getText().trim()+"','"+age_field.getText().trim()+"','"+telephone_field.getText().trim()+"',";
       if (montant_verse_field.getText().trim().isEmpty()) ajouter_requete+=000+","; 
       else   ajouter_requete+= Integer.parseInt(montant_verse_field.getText().trim())+",";  
       
       if (montant_reste_field.getText().trim().isEmpty()) ajouter_requete+=000+",'"; 
       else   ajouter_requete+= Integer.parseInt(montant_reste_field.getText().trim())+",'";  
              
       ajouter_requete+=medecin_field.getText().trim()+"','";
       ajouter_requete+=adresse_field.getText().trim()+"','";  
       ajouter_requete+=predominance_field.getText().trim()+"','"; 
       
      
       
       if (date_field.getValue()==null) ajouter_requete+="2017-01-01','";
       else ajouter_requete+=date_field.getValue().toString().trim()+"','";

       ajouter_requete+=antecedent_field.getText().trim()+"','";
       ajouter_requete+=diagnostic_field.getText().trim()+"','";
       
       ajouter_requete+=Skiascopie_froid_DMV_field.getText().trim()+"','"+Skiascopie_froid_DMH_field.getText().trim()+"','";
       ajouter_requete+=Skiascopie_froid_GMV_field.getText().trim()+"','"+Skiascopie_froid_GMH_field.getText().trim()+"','";
       ajouter_requete+=Skiascopie_dilatation_DMV_field.getText().trim()+"','"+Skiascopie_dilatation_DMH_field.getText().trim()+"','";
       ajouter_requete+=Skiascopie_dilatation_DMV_field.getText().trim()+"','"+Skiascopie_dilatation_DMH_field.getText().trim()+"','";
       ajouter_requete+=Diagnostic_D_field.getText().trim()+"','"+Diagnostic_G_field.getText().trim()+"')";
      
      
    /*************************************************************le première requete******************************************************************/
       
        String ajouter_requete2="INSERT INTO `aquite`(`Nom`, `Prenom`, `AVB_D`, `AVB_G`, `AC_D_S`, `AC_D_C`, `AC_D_Ax`, `AC_D_Av`, `AC_G_S`, `AC_G_C`, `AC_G_Ax`, `AC_G_Av`, `Biomicro_D`, `Biomicro_G`, `Fond_oeil_D`, `Fond_oeil_G`, `Javal_D_Ax`, `Javal_D_C`, `Javal_G_Ax`, `Javal_G_C`) VALUES ('"+nom_field.getText().trim()+"','"+prenom_field.getText().trim()+"','";
      
   
       
       ajouter_requete2+=aquite_visuelle_brut_D_field.getText().trim()+"','"+aquite_visuelle_brut_G_field.getText().trim()+"','";
       ajouter_requete2+=Ancienne_Correction_VDs_field.getText().trim()+"','"+Ancienne_Correction_VDc_field.getText().trim()+"','"+Ancienne_Correction_VDax_field.getText().trim()+"','"+Ancienne_Correction_VDav_field.getText().trim()+"','";
       ajouter_requete2+=Ancienne_Correction_VGs_field.getText().trim()+"','"+Ancienne_Correction_VGc_field.getText().trim()+"','"+Ancienne_Correction_VGax_field.getText().trim()+"','"+Ancienne_Correction_VGav_field.getText().trim()+"','";
       ajouter_requete2+=Biomicro_D_field.getText().trim()+"','"+Biomicro_G_field.getText().trim()+"','";
       ajouter_requete2+=Fond_oeil_D_field.getText().trim()+"','"+Fond_oeil_G_field.getText().trim()+"','";      
       ajouter_requete2+=Javal_VDa_field.getText().trim()+"','"+Javal_VDc_field.getText().trim()+"','"+Javal_VGa_field.getText().trim()+"','"+Javal_VGc_field.getText().trim()+"')";
       
       
       Statement st1;
          try {
              
                 if(getconnaction()!=null ) {
                        
                    st1 = getconnaction().createStatement();
                    st1.executeUpdate(ajouter_requete);
                    st1.executeUpdate(ajouter_requete2);
                    
                             Alert dialogE = new Alert(Alert.AlertType.INFORMATION);
                             dialogE.setTitle("Ajout Terminé ");
                             dialogE.setHeaderText("Malade Ajouté");
                             dialogE.setContentText("l'ajout du malade a été effectuée avec succes");
                             dialogE.showAndWait();
                    
                    
                   vider_champs();
                  }
                 else{
                             Alert dialogE = new Alert(Alert.AlertType.ERROR);
                             dialogE.setTitle("Ajout éronné ");
                             dialogE.setHeaderText("Malade Non Ajouté");
                             dialogE.setContentText("l'ajout du malade n'a pas été effectuée, veuillez vérifier la connexion avec la base de données");
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
    
    
    /**************************************************************************************************************************/
      
 private void vider_champs() {

            
            
         /************************************************ Initialiser la premierer requete****************************************************************/   
          
            
            nom_field.setText("");
               prenom_field.setText("");
               age_field.setText("");
               telephone_field.setText("");
               montant_verse_field.setText("");
               montant_reste_field.setText("");
               medecin_field.setText("");
               adresse_field.setText("");
               predominance_field.setText("");
               //VLDa_field.setText(set.getString(11));
               antecedent_field.setText("");
               diagnostic_field.setText("");
               Skiascopie_froid_DMV_field.setText("");
               Skiascopie_froid_DMH_field.setText("");
               Skiascopie_froid_GMV_field.setText("");
               Skiascopie_froid_GMH_field.setText("");
               Skiascopie_dilatation_DMV_field.setText("");
               Skiascopie_dilatation_DMH_field.setText("");
               Skiascopie_dilatation_GMV_field.setText("");
               
               Skiascopie_dilatation_GMH_field.setText("");
               Diagnostic_D_field.setText("");
               Diagnostic_G_field.setText("");
              
               
            /************************************************ Initialiser la deuxième requete****************************************************************/ 
              
               
              
               aquite_visuelle_brut_D_field.setText("");
               aquite_visuelle_brut_G_field.setText("");
               Ancienne_Correction_VDs_field.setText("");
               Ancienne_Correction_VDc_field.setText("");
               Ancienne_Correction_VDax_field.setText("");
               Ancienne_Correction_VDav_field.setText("");
               Ancienne_Correction_VGs_field.setText("");
               Ancienne_Correction_VGc_field.setText("");
               Ancienne_Correction_VGax_field.setText("");
               Ancienne_Correction_VGav_field.setText("");
               Biomicro_D_field.setText("");
               Biomicro_G_field.setText("");
               Fond_oeil_D_field.setText("");
               Fond_oeil_G_field.setText("");
               Javal_VDa_field.setText("");
               Javal_VDc_field.setText("");
               Javal_VGa_field.setText("");
               Javal_VGc_field.setText("");
         
     
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optometrie_version_1;

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
public class Fenetre_Modifier_Progressive extends Stage{
    
    
    
     private AnchorPane grand_conteneur = new AnchorPane();
    private Scene scene3 = new Scene(grand_conteneur,932, 546);
    private Button modifier_progression=new Button("");
    private Button retour_progression=new Button("");
    private VBox conteneur_bouton=new VBox(14);
    private GridPane teinte_verre=new GridPane();
    private GridPane correction_disrete=new GridPane();
    private GridPane information_generale=new GridPane();
    private HBox vision_loin_droite=new HBox(7);
    private HBox vision_pres_droite=new HBox(7);
    private HBox vision_loin_gauche=new HBox(7);
    private HBox vision_pres_gauche=new HBox(7);
      
    private TextField nom_field=new TextField();
    private TextField prenom_field=new TextField();
    private TextField age_field=new TextField();
    private TextArea adresse_field=new TextArea();   
    private TextField telephone_field=new TextField();   
    private TextField montant_verse_field=new TextField();
    private TextField montant_restant_field=new TextField();
    private DatePicker date_field=new DatePicker();
    
    private TextField type_field=new TextField();
    private TextField fournisseur_field=new TextField();
    private TextField addition_field=new TextField();
    private TextField transition_field=new TextField();
    
    private TextField VLDs_field=new TextField();
    private TextField VLDc_field=new TextField();
    private TextField VLDa_field=new TextField();
    
    private TextField VLGs_field=new TextField();
    private TextField VLGc_field=new TextField();
    private TextField VLGa_field=new TextField();
    
    private TextField VPDs_field=new TextField();
    private TextField VPDc_field=new TextField();
    private TextField VPDa_field=new TextField();
    
    private TextField VPGs_field=new TextField();
    private TextField VPGc_field=new TextField();
    private TextField VPGa_field=new TextField();
    
   

    
    private Label nom_label=new Label("");
    private Label pronom_label=new Label("");
    private Label age_label=new Label("");
    private Label adresse_label=new Label("");
    private Label medecin_label=new Label("");
    private Label date_label=new Label("");
    private Label montant_label=new Label("");
    private Label vision_loin_label=new Label("");
    private Label vision_pres_label=new Label("");
    private Label oeil_droit_label1=new Label("");
    private Label oeil_droit_label2=new Label("");
     
    private Label oeil_gauche_label1=new Label("");
    private Label oeil_gauche_label2=new Label("");
    private Label type_verre_label=new Label("");
    private Label teinte_label=new Label("");
    
    String Anciene_nom="";
    String Anciene_prenom="";
      public Fenetre_Modifier_Progressive(ResultSet set)
    {
       
     initialiser_fenetre();
     evenement_gestion();
     initialiser_field(set);
     
    this.setResizable(false); 
    this.setTitle("Modification Progressive");
    this.setScene(scene3);
    this.show();
     
    }
      
      
    /*************************************************************************************************************************/  
    
    
    
     public void initialiser_fenetre()
   {
    grand_conteneur.setId("grand_conteneur_css");
    scene3.getStylesheets().addAll(this.getClass().getResource("css/ajouter_progressive.css").toExternalForm()); 
    
    grand_conteneur.getChildren().addAll(information_generale,correction_disrete,teinte_verre,conteneur_bouton);
    
    
    
    /****************************************************Infos generale TAB*************************************************************************/  
     
     VLDs_field.setId("VLDs_css");VLDc_field.setId("VLDc_css");VLDa_field.setId("VLDa_css");
     VLGs_field.setId("VLGs_css");VLGc_field.setId("VLGc_css");VLGa_field.setId("VLGa_css"); 
     VPDs_field.setId("VPDs_css");VPDc_field.setId("VPDc_css");VPDa_field.setId("VPDa_css");
     VPGs_field.setId("VPGs_css");VPGc_field.setId("VPGc_css");VPGa_field.setId("VPGa_css");
     modifier_progression.setId("ajouter_lunette_css");
     retour_progression.setId("annuler_lunette_css");     
     
     
     
     
     
     conteneur_bouton.getChildren().addAll(modifier_progression,retour_progression);
       
     //grand_conteneur.getChildren().addAll(conteneur_bouton,correction_disrete,information_generale,teinte_verre);
     vision_loin_droite.getChildren().addAll(oeil_droit_label1,VLDs_field,VLDc_field,VLDa_field);
     vision_loin_gauche.getChildren().addAll(oeil_gauche_label1,VLGs_field,VLGc_field,VLGa_field);
     vision_pres_droite.getChildren().addAll(oeil_droit_label2,VPDs_field,VPDc_field,VPDa_field);
     vision_pres_gauche.getChildren().addAll(oeil_gauche_label2,VPGs_field,VPGc_field,VPGa_field); 
     correction_disrete.add(vision_loin_label, 0, 0);
     correction_disrete.add(vision_pres_label, 1, 0);
     correction_disrete.add(vision_loin_droite, 0,1 );
     correction_disrete.add(vision_loin_gauche, 0,2);
     correction_disrete.add(vision_pres_droite, 1,1);
     correction_disrete.add(vision_pres_gauche, 1,2);
     correction_disrete.setVgap(5);
     correction_disrete.setHgap(35);
     
     
     information_generale.add(nom_field,1,0,2,1);     
     information_generale.add(prenom_field,4,0,2,1);     
     information_generale.add(age_field,1,1,2,1);    
     information_generale.add(telephone_field,4,1,2,1);
      information_generale.add(montant_verse_field,1,2,2,1);
     information_generale.add(montant_restant_field,1,3,2,1);
     information_generale.add(date_field,1,4,2,1);
     information_generale.add(adresse_field,4,2,2,3);        
     information_generale.add(fournisseur_field,1,5,2,1);
     information_generale.add(type_field,4,5,2,1);
     information_generale.add(transition_field,1,6,2,1);     
     information_generale.add(addition_field,4,6,2,1);
     information_generale.setVgap(5);
     information_generale.setHgap(75);
     
     adresse_field.setId("adresse_field_css");
     
     
     
     
     AnchorPane.setTopAnchor(information_generale, 125.00);
     AnchorPane.setRightAnchor(information_generale, 90.00);
     AnchorPane.setTopAnchor(correction_disrete, 385.00);
     AnchorPane.setRightAnchor(correction_disrete, 197.00);
     
     AnchorPane.setTopAnchor(conteneur_bouton, 404.00);
     AnchorPane.setRightAnchor(conteneur_bouton, 63.00);
     
     modifier_progression.setStyle("-fx-min-width:102;-fx-max-width:102;-fx-min-height:28;-fx-max-height:28;-fx-background-color:transparent;");
     retour_progression.setStyle("-fx-min-width:102;-fx-max-width:102;-fx-min-height:28;-fx-max-height:28;-fx-background-color:transparent;");
     
     
     
     prenom_field.setMaxWidth(140.00);prenom_field.setMinWidth(140.00);
     nom_field.setMaxWidth(140.00);nom_field.setMinWidth(140.00);    
     age_field.setMaxWidth(140.00);age_field.setMinWidth(140.00);
    type_field.setMaxWidth(140.00);type_field.setMinWidth(140.00);
     addition_field.setMaxWidth(140.00);addition_field.setMinWidth(140.00);
     fournisseur_field.setMaxWidth(140.00);fournisseur_field.setMinWidth(140.00);
     transition_field.setMaxWidth(140.00);transition_field.setMinWidth(140.00);
     
     adresse_field.setMaxWidth(140.00);adresse_field.setMinWidth(140.00);
     montant_verse_field.setMaxWidth(140.00);montant_verse_field.setMinWidth(140.00);
     montant_restant_field.setMaxWidth(140.00);montant_restant_field.setMinWidth(140.00);
     date_field.setMaxWidth(140.00);date_field.setMinWidth(140.00);
     telephone_field.setMaxWidth(140.00);telephone_field.setMinWidth(140.00);     

     
     /****************************************************progressive TAB*************************************************************************/  
     
      
   }
    
   public void evenement_gestion(){
   
       retour_progression.setOnAction((event) -> {
            
             this.close();
        });
     
       modifier_progression.setOnAction((ActionEvent event) -> {
                  
            modifier_progression_fonction();
            this.close();
            
       
       });
       
       modifier_progression.setOnMouseEntered((event) -> {           
         
         scene3.setCursor(Cursor.HAND);
         
        }); 
    retour_progression.setOnMouseEntered((event) -> {           
         
         scene3.setCursor(Cursor.HAND);
         
        }); 
     
    modifier_progression.setOnMouseExited((event)-> {
         
         scene3.setCursor(Cursor.DEFAULT);
     
     });
     
     
    retour_progression.setOnMouseExited((event)-> {
         
         scene3.setCursor(Cursor.DEFAULT);
     
     });
   modifier_progression.setOnMouseExited((event)-> {
         
         scene3.setCursor(Cursor.DEFAULT);
     
     });
   
   
   }
   
   /**************************************************************************************************************************************/ 
     private void initialiser_field(ResultSet set) {
        
        
       
        try {
               nom_field.setText(set.getString(2));
               Anciene_nom=set.getString(2);
               prenom_field.setText(set.getString(3));
               Anciene_prenom=set.getString(3);
               age_field.setText(set.getString(4));
               telephone_field.setText(set.getString(5));
               montant_verse_field.setText(set.getString(6));
               montant_restant_field.setText(set.getString(7));
               date_field.setValue(LOCAL_DATE(set.getString(8)));
              type_field.setText(set.getString(9));
               fournisseur_field.setText(set.getString(10));
               addition_field.setText(set.getString(11));
               transition_field.setText(set.getString(12));
               adresse_field.setText(set.getString(13));
               VLDs_field.setText(set.getString(14));
               VLDc_field.setText(set.getString(15));
               VLDa_field.setText(set.getString(16));
               VLGs_field.setText(set.getString(17));
               VLGc_field.setText(set.getString(18));
               VLGa_field.setText(set.getString(19));
               VPDs_field.setText(set.getString(20));
               VPDc_field.setText(set.getString(21));
               VPDa_field.setText(set.getString(22));
               VPGs_field.setText(set.getString(23));
               VPGc_field.setText(set.getString(24));
               VPGa_field.setText(set.getString(25));
               
               
        } catch (Exception e) {
        }
        
        
        
        
        
    }
    /********************************************************************************************************************************/
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
     
   
     /********************************************************************************************************************************/
      public void modifier_progression_fonction(){
       
   
   
    String modifier_requete="UPDATE `progressive` SET `Nom`='"+nom_field.getText().trim()+"',`Prenom`='"+prenom_field.getText().trim()+"',`Age`='"+age_field.getText().trim()+"',`Telephone`='"+telephone_field.getText().trim()+"',`Montant_verse`=";
       if (montant_verse_field.getText().trim().isEmpty()) modifier_requete+=000+",`Montant_restant`="; 
       else   modifier_requete+= Integer.parseInt(montant_verse_field.getText().trim())+",`Montant_restant`=";  
      
        if (montant_restant_field.getText().trim().isEmpty()) modifier_requete+=000+",`Date_Commande`='"; 
       else   modifier_requete+= Integer.parseInt(montant_restant_field.getText().trim())+",`Date_Commande`='"; 
           
              
       if (date_field.getValue()==null) modifier_requete+="1444-12-01',`Type`='";
       else modifier_requete+=date_field.getValue().toString().trim()+"',`Type`='";
       
        modifier_requete+=type_field.getText().trim()+"',`Fournisseur`='"+fournisseur_field.getText().trim()+"',`Addition`='"+addition_field.getText().trim()+"',`Transition`='"+transition_field.getText().trim()+"',`Adresse`='"+adresse_field.getText().trim()+"',`VLDs`='";
 
       modifier_requete+=VLDs_field.getText().trim()+"',`VLDc`='"+VLDc_field.getText().trim()+"',`VLDa`='"+VLDa_field.getText().trim()+"',`VLGs`='";
       modifier_requete+=VLGs_field.getText().trim()+"',`VLGc`='"+VLGc_field.getText().trim()+"',`VLGa`='"+VLGa_field.getText().trim()+"',`VPDs`='";
       modifier_requete+=VPDs_field.getText().trim()+"',`VPDc`='"+VPDc_field.getText().trim()+"',`VPDa`='"+VPDa_field.getText().trim()+"',`VPGs`='";
       modifier_requete+=VPGs_field.getText().trim()+"',`VPGc`='"+VPGc_field.getText().trim()+"',`VPGa`='"+VPGa_field.getText().trim()+"' where `Nom`='"+Anciene_nom+"'AND `Prenom`='"+Anciene_prenom+"'";
    
    
     
        Statement st1;
          try {
              
                 if(getconnaction()!=null ) {
                        
                    st1 = getconnaction().createStatement();
                    st1.executeUpdate(modifier_requete);
                    
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
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-DD");
    LocalDate localDate = LocalDate.parse(dateString, formatter);
    return localDate;
  }  
       
    
    
    
    
}

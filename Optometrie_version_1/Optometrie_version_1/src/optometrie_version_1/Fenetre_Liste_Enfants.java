/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optometrie_version_1;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import com.mysql.jdbc.Connection;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.awt.event.MouseEvent;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Clock;
import java.util.Set;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
/**
 *
 * @author Milano
 */
public class Fenetre_Liste_Enfants extends Stage{
    
     private AnchorPane grand_conteneur = new AnchorPane();
     private Scene scene3 = new Scene(grand_conteneur,944, 626);
     private HBox centeneur_bouton=new HBox(21);
     private Button bouton_1=new Button();
     private Button bouton_2=new Button();
     private Button bouton_3=new Button();
     private Button bouton_4=new Button();
     private Button bouton_5=new Button();
      Button ajouter_enfant =new Button("");
      Button modifier_enfant =new Button("");
      Button supprimer_enfant =new Button("");
      Button enregistrer_enfant =new Button("");        
      VBox conteneur_bouton=new VBox(14);
     
     private int selected_row_table_enfant=-1;
    private String selected_row_table_enfant_nom="";
    private String selected_row_table_enfant_prenom="";
    private  Label labe=new Label("mon texte");
    private Text text=new Text();
    private TableView table_enfant=new TableView();
    
    
    private TextField recherche_nom_field=new TextField();
    private  DatePicker recherche_date_field=new DatePicker();
    private  HBox recherche_box=new HBox(70);
    private  Button rechercher_buttom=new Button("");
    
    
    public Fenetre_Liste_Enfants(){
        
     
    initialise_fenetre();
  
     
    evenement_fenetre();
    String requete2="SELECT `Id`, `Nom`, `Prenom`, `Age`, `Numero_Telephone`, `Medecin`, `Adresse`, `Predominance`, `Date_consultation`, `Antecedent`, `Diagnostic`, `SF_D_MV`, `SF_D_MH`, `SF_G_MV`, `SF_G_MH`, `SD_D_MV`, `SD_D_MH`, `SD_G_MV`, `SD_G_MH`, `Diagnostic_D`, `Diagnostic_G`  FROM `enfant` ";
    Chargement_Donnee(requete2);
    
     
    this.setResizable(false); 
    this.setTitle("Liste Pédiatries");  
    
    this.setScene(scene3);
    this.show();
    
    
    }
      /**************************************************************************************************************************************/   
      public void evenement_fenetre()
        {
 
         bouton_1.setOnAction((event) -> {           
             Fenetre_Liste_Lunette fen=new Fenetre_Liste_Lunette();
             this.close();
        });
      bouton_2.setOnAction((event) -> {           
             Fenetre_Liste_lentille fen=new Fenetre_Liste_lentille();
             this.close();
        });
     
    bouton_4.setOnAction((event) -> {           
             Fenetre_Liste_Progressive fen=new Fenetre_Liste_Progressive();
             this.close();
        });
       bouton_5.setOnAction((event) -> {           
             Fenetre_Principal fen=new Fenetre_Principal();
             this.close();
        });
     bouton_1.setOnMouseEntered((event) -> {           
         
         scene3.setCursor(Cursor.HAND);
         
        });
      bouton_2.setOnMouseEntered((event) -> {           
         
         scene3.setCursor(Cursor.HAND);
         
        }); 
     bouton_3.setOnMouseEntered((event) -> {           
         
         scene3.setCursor(Cursor.HAND);
         
        }); 
     bouton_4.setOnMouseEntered((event) -> {           
         
         scene3.setCursor(Cursor.HAND);
         
        }); 
     bouton_5.setOnMouseEntered((event) -> {           
         
         scene3.setCursor(Cursor.HAND);
         
        });
     bouton_1.setOnMouseExited((event)-> {
         
         scene3.setCursor(Cursor.DEFAULT);
     
     });
     
     
     bouton_2.setOnMouseExited((event)-> {
         
         scene3.setCursor(Cursor.DEFAULT);
     
     });
     
     bouton_3.setOnMouseExited((event)-> {
         
         scene3.setCursor(Cursor.DEFAULT);
     
     });
     
     bouton_4.setOnMouseExited((event)-> {
         
         scene3.setCursor(Cursor.DEFAULT);
     
     });
     bouton_5.setOnMouseExited((event)-> {
         
         scene3.setCursor(Cursor.DEFAULT);
     
     });
     
   
    ajouter_enfant.setOnMouseEntered((event) -> {           
         
         scene3.setCursor(Cursor.HAND);
         
        });
    supprimer_enfant.setOnMouseEntered((event) -> {           
         
         scene3.setCursor(Cursor.HAND);
         
        }); 
    modifier_enfant.setOnMouseEntered((event) -> {           
         
         scene3.setCursor(Cursor.HAND);
         
        }); 
    enregistrer_enfant.setOnMouseEntered((event) -> {           
         
         scene3.setCursor(Cursor.HAND);
         
        }); 
    
    rechercher_buttom.setOnMouseEntered((event) -> {           
         
         scene3.setCursor(Cursor.HAND);
         
        });
    
    ajouter_enfant.setOnMouseExited((event)-> {
         
         scene3.setCursor(Cursor.DEFAULT);
     
     });
     
     
     supprimer_enfant.setOnMouseExited((event)-> {
         
         scene3.setCursor(Cursor.DEFAULT);
     
     });
     
     modifier_enfant.setOnMouseExited((event)-> {
         
         scene3.setCursor(Cursor.DEFAULT);
     
     });
     
     enregistrer_enfant.setOnMouseExited((event)-> {
         
         scene3.setCursor(Cursor.DEFAULT);
     
     });
     
     rechercher_buttom.setOnMouseExited((event)-> {
         
         scene3.setCursor(Cursor.DEFAULT);
     
     });
    /************************************************* evenement de traitement***************************************************************/
    rechercher_buttom.setOnAction((event) -> {
            
        String requete= "SELECT `Id`, `Nom`, `Prenom`, `Age`, `Numero_Telephone`, `Medecin`, `Adresse`, `Predominance`, `Date_consultation`, `Antecedent`, `Diagnostic`, `SF_D_MV`, `SF_D_MH`, `SF_G_MV`, `SF_G_MH`, `SD_D_MV`, `SD_D_MH`, `SD_G_MV`, `SD_G_MH`, `Diagnostic_D`, `Diagnostic_G` FROM `enfant`" ;
        if (recherche_nom_field.getText().isEmpty()){     
               if(recherche_date_field.getValue()!=null) requete+=" WHERE Date_consultation='"+recherche_date_field.getValue().toString()+"'";     
        }else{
           requete+= " WHERE Nom='"+recherche_nom_field.getText()+"'";
        if(recherche_date_field.getValue()!=null) requete+=" AND Date_consultation='"+recherche_date_field.getValue().toString()+"'"; 
        
        }
        System.out.println("requete");
             Chargement_Donnee(requete);
        });
     
     
     
    ajouter_enfant.setOnAction((event) -> {
            
             Fenetre_Ajouter_Enfant fen=new Fenetre_Ajouter_Enfant();
        });
 
       
    supprimer_enfant.setOnAction((event) -> {
             
                try {
                          if(getconnaction()!=null ) {
                         supprimerligne(selected_row_table_enfant_nom,selected_row_table_enfant_prenom);

                          }else
                          {
                             Alert dialogE = new Alert(AlertType.ERROR);
                             dialogE.setTitle("Supression Eronnée ");
                             dialogE.setHeaderText("Malade Non Supprimée");
                             dialogE.setContentText("la suppression du malade n'a pas été effectuée, veuillez vérifier la connexion avec la base de données");
                             dialogE.showAndWait();
                          }

                     } catch (Exception e) {

                     }

                              });
 
    enregistrer_enfant.setOnAction((event) -> {
    String requete2="SELECT `Id`, `Nom`, `Prenom`, `Age`, `Numero_Telephone`, `Medecin`, `Adresse`, `Predominance`, `Date_consultation`, `Antecedent`, `Diagnostic`, `SF_D_MV`, `SF_D_MH`, `SF_G_MV`, `SF_G_MH`, `SD_D_MV`, `SD_D_MH`, `SD_G_MV`, `SD_G_MH`, `Diagnostic_D`, `Diagnostic_G`  FROM `enfant` ";
            Chargement_Donnee(requete2);
        });  
         
    modifier_enfant.setOnAction((event)->{
        
            
            
        if(!selected_row_table_enfant_nom.isEmpty() || !selected_row_table_enfant_prenom.isEmpty())
        { 
            
            
            String requete_selection= "SELECT * FROM `enfant` WHERE Nom='"+selected_row_table_enfant_nom+"' AND Prenom='"+selected_row_table_enfant_prenom+"'";
            String requete_selection2= "SELECT * FROM `aquite` WHERE Nom='"+selected_row_table_enfant_nom+"' AND Prenom='"+selected_row_table_enfant_prenom+"'";
           
            try {
                        Connection connection1=getconnaction();
                        Statement st=connection1.createStatement();           
                        ResultSet sr=st.executeQuery(requete_selection);
                        Statement st2=connection1.createStatement();           
                        ResultSet sr2=st2.executeQuery(requete_selection2);
       
            if(sr.next()&&sr2.next())
            {       
            
                Fenetre_Modifier_Enfant fenetre=new Fenetre_Modifier_Enfant(sr,sr2);
            
            }
            
            }catch(Exception e)
            {}
        
        }
        
        });
         
   table_enfant.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
                @Override
                public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                    //Check whether item is selected and set value of selected item to Label
                    if(table_enfant.getSelectionModel().getSelectedItem() != null) 
                    {    
                       TableViewSelectionModel selectionModel = table_enfant.getSelectionModel();
                       ObservableList selectedCells = selectionModel.getSelectedCells();
                       TablePosition tablePosition = (TablePosition) selectedCells.get(0); 
                       String[] liste_value=newValue.toString().split(",");
                       selected_row_table_enfant=tablePosition.getRow()+1;
                       selected_row_table_enfant_nom=liste_value[1].trim();
                       selected_row_table_enfant_prenom=liste_value[2].trim();
                     //  Object val = tablePosition.getTableColumn().getCellData(newValue);                         
                     }
                     }
                 });
 
 
 
 }
      
 /**************************************************************************************************************************************/  
      public void initialise_fenetre(){
      
          recherche_nom_field.setId("info_field_css");
      recherche_date_field.setId("info_field_css");
      recherche_box.getChildren().addAll(recherche_nom_field,recherche_date_field);
      grand_conteneur.getChildren().addAll(recherche_box,rechercher_buttom);
      AnchorPane.setTopAnchor(recherche_box, 183.00);
      AnchorPane.setLeftAnchor(recherche_box, 360.00);
      AnchorPane.setTopAnchor(rechercher_buttom, 180.00);
      AnchorPane.setLeftAnchor(rechercher_buttom, 776.00);
      rechercher_buttom.setStyle("-fx-min-width:115;-fx-max-width:115;-fx-min-height:32;-fx-max-height:32;-fx-background-color:transparent;");
        
          
          
          
     bouton_1.setMaxWidth(80.00);
     bouton_1.setMinWidth(80.00);
     bouton_1.setMaxHeight(50.00);
     bouton_1.setMinHeight(50.00);
     bouton_1.setStyle("-fx-background-color:transparent");
     bouton_2.setMaxWidth(85.00);
     bouton_2.setMinWidth(85.00);
     bouton_2.setMaxHeight(50.00);
     bouton_2.setMinHeight(50.00);
     bouton_2.setStyle("-fx-background-color:transparent");
     bouton_3.setMaxWidth(82.00);
     bouton_3.setMinWidth(82.00);
     bouton_3.setMaxHeight(50.00);
     bouton_3.setMinHeight(50.00);
     bouton_3.setStyle("-fx-background-color:transparent");
     bouton_4.setMaxWidth(74.00);
     bouton_4.setMinWidth(74.00);
     bouton_4.setMaxHeight(50.00);
     bouton_4.setMinHeight(50.00);
     bouton_4.setStyle("-fx-background-color:transparent");
        bouton_5.setMaxWidth(45.00);
     bouton_5.setMinWidth(45.00);
     bouton_5.setMaxHeight(45.00);
     bouton_5.setMinHeight(45.00);
      bouton_5.setStyle("-fx-background-color:transparent");
     grand_conteneur.getChildren().add(bouton_5);
     AnchorPane.setTopAnchor(bouton_5, 30.00);
     AnchorPane.setLeftAnchor(bouton_5, 48.00);
     centeneur_bouton.getChildren().addAll(bouton_1,bouton_2,bouton_3,bouton_4);
     grand_conteneur.setId("Background_liste_Enfants_css");
     scene3.getStylesheets().addAll(this.getClass().getResource("css/ajouter_enfant.css").toExternalForm());
     grand_conteneur.getChildren().add(centeneur_bouton);
     AnchorPane.setTopAnchor(centeneur_bouton, 25.00);
     AnchorPane.setLeftAnchor(centeneur_bouton, 150.00);
     
     
      
     conteneur_bouton.getChildren().addAll(ajouter_enfant,modifier_enfant,supprimer_enfant,enregistrer_enfant);
        AnchorPane root = new AnchorPane();
        grand_conteneur.getChildren().addAll(table_enfant,conteneur_bouton);
         AnchorPane.setLeftAnchor(conteneur_bouton, 79.0);
        AnchorPane.setTopAnchor(conteneur_bouton, 183.0);
        AnchorPane.setRightAnchor(table_enfant, 70.0);
        AnchorPane.setTopAnchor(table_enfant, 284.0);
        table_enfant.setId("table_enfant_css");      
       ajouter_enfant.setId("ajouter_lunette_css2");  
        modifier_enfant.setId("modifier_lunette_css2");
        supprimer_enfant.setId("supprimer_lunette_css2");
        enregistrer_enfant.setId("enregistrer_lunette_css2");
      
      }
      
      
   /**************************************************************************************************************************************/   
          public void Chargement_Donnee(String requete2){
          
           ObservableList<ObservableList>  data ;
            data = FXCollections.observableArrayList();
          
            table_enfant= new TableView();
            grand_conteneur.getChildren().addAll(table_enfant);
            AnchorPane.setRightAnchor(table_enfant, 70.0);
            AnchorPane.setTopAnchor(table_enfant, 284.0);
            table_enfant.setId("table_enfant_css");
             table_enfant.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
                @Override
                public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                    //Check whether item is selected and set value of selected item to Label
                    if(table_enfant.getSelectionModel().getSelectedItem() != null) 
                    {    
                       TableViewSelectionModel selectionModel = table_enfant.getSelectionModel();
                       ObservableList selectedCells = selectionModel.getSelectedCells();
                       TablePosition tablePosition = (TablePosition) selectedCells.get(0); 
                       String[] liste_value=newValue.toString().split(",");
                       selected_row_table_enfant=tablePosition.getRow()+1;
                       selected_row_table_enfant_nom=liste_value[1].trim();
                       selected_row_table_enfant_prenom=liste_value[2].trim();
                     //  Object val = tablePosition.getTableColumn().getCellData(newValue);                         
                     }
                     }
                 });
 
 
            
            
          try{
          
            
            Statement st=getconnaction().createStatement();
            ResultSet rs = st.executeQuery(requete2);

            /**********************************
             * TABLE COLUMN ADDED DYNAMICALLY *
             **********************************/
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                final int j = i;                
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });

                table_enfant.getColumns().addAll(col); 
               
            }

            /********************************
             * Data added to ObservableList *
             ********************************/
            while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rs.getString(i));
                }             
                 data.add(row);
            }           
           table_enfant.setItems(data);       
          }catch(Exception e){
              e.printStackTrace();
              System.out.println("Error on Building Data");             
          }
      }
     
     /**************************************************************************************************************************************/     
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
     
            
              /******************************************************************************************************************************/  
      public void supprimerligne(String selected_item_nom,String selected_item_prenom)
   {
       
            selected_item_nom=selected_item_nom.trim();
            selected_item_prenom=selected_item_prenom.trim();
            String requete_suppression= "DELETE FROM `enfant` WHERE Nom='"+selected_item_nom+"' AND Prenom='"+selected_item_prenom+"'";
            System.out.println(requete_suppression);
            try {
                
            Statement st1=getconnaction().createStatement();
            st1.executeUpdate(requete_suppression);
            String requete2="SELECT  `Id`,`Nom`, `Prenom`, `Age`, `Numero_Telephone`, `Medecin`, `Adresse`, `Predominance`, `Date_consultation`, `Antecedent`, `Diagnostic`, `SF_D_MV`, `SF_D_MH`, `SF_G_MV`, `SF_G_MH`, `SD_D_MV`, `SD_D_MH`, `SD_G_MV`, `SD_G_MH`, `Diagnostic_D`, `Diagnostic_G`  FROM `enfant` ";
            Chargement_Donnee(requete2);
            
       } catch (Exception e) {
           e.printStackTrace();
       }
           
   }
          
      
}
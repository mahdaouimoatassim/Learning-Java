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

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
//import javafx.scene.control.Alert;
//import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
//import javafx.scene.control.DatePicker;
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
public class Fenetre_Principal  extends Stage {
    
     private AnchorPane grand_conteneur = new AnchorPane();
     private Scene scene3 = new Scene(grand_conteneur,944, 626);
     private HBox centeneur_bouton=new HBox(21);
     private Button bouton_1=new Button();
     private Button bouton_2=new Button();
     private Button bouton_3=new Button();
     private Button bouton_4=new Button();
     private Button bouton_5=new Button();
  
   
   
    
    
    public Fenetre_Principal(){
        
    this.setResizable(false); 
    this.setTitle("Optométrie");
    initialise_fenetre();
    evenement_fenetre();
    
    }
    
  /******************************************************************************************************************************/   
    public void initialise_fenetre(){
    
     
        
      
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
     grand_conteneur.setId("Background_fenetre_principal_css");
     scene3.getStylesheets().addAll(this.getClass().getResource("css/Chargement_Principal.css").toExternalForm()); 
     grand_conteneur.getChildren().add(centeneur_bouton);
     AnchorPane.setTopAnchor(centeneur_bouton, 23.00);
     AnchorPane.setLeftAnchor(centeneur_bouton, 150.00);
     
     
     
     this.setScene(scene3);
      this.show();
        
        
        
    
    }
      
    
      /******************************************************************************************************************************/   
    
    
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
      bouton_3.setOnAction((event) -> {           
             Fenetre_Liste_Enfants fen=new Fenetre_Liste_Enfants();
             this.close();
        });
     
    bouton_4.setOnAction((event) -> {           
             Fenetre_Liste_Progressive fen=new Fenetre_Liste_Progressive();
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
     
     /************************************************* evenement de traitement***************************************************************/

 }
    
    
    
}

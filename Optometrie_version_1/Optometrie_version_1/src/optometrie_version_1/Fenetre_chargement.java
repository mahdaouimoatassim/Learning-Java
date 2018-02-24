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
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
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
public class Fenetre_chargement extends Stage{
    
     private AnchorPane grand_conteneur = new AnchorPane();
     private Scene scene3 = new Scene(grand_conteneur,948, 483);
     private HBox centeneur_bouton=new HBox(21);
     private Button bouton_1=new Button();
     private Button bouton_2=new Button();
     private Button bouton_3=new Button();
     private Button bouton_4=new Button();
    
    public Fenetre_chargement(){
    
  initialise_fenetre();
    
  
    try{
   // Thread.sleep(15000);
    if(getconnaction()!=null){
    //Fenetre_Principal gh=new Fenetre_Principal();
    
  }
    }catch (Exception e)
    {  e.printStackTrace(); }
 
   
  
    }
    
      public Connection getconnaction() throws Exception{
    
        try {
            String url="jdbc:mysql://localhost:3306/optometrie";
            String user="root";
            String password="";
            Class.forName("com.mysql.jdbc.Driver");            
            Connection connection=(Connection) DriverManager.getConnection(url,user,password);            
            return connection;
        } catch (Exception e) {            
            e.printStackTrace();
        }
        return null;
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
     centeneur_bouton.getChildren().addAll(bouton_1,bouton_2,bouton_3,bouton_4);
     grand_conteneur.setId("Background_fenetre_chargement_css");
     scene3.getStylesheets().addAll(this.getClass().getResource("css/Chargement_Principal.css").toExternalForm()); 
     grand_conteneur.getChildren().add(centeneur_bouton);
     AnchorPane.setTopAnchor(centeneur_bouton, 23.00);
     AnchorPane.setLeftAnchor(centeneur_bouton, 150.00);
     
     this.setResizable(false);
     this.setTitle("Chagrement...");
     this.setScene(scene3);
     this.show();
        
        
        
    
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optometrie_version_1;

import com.mysql.jdbc.Connection;
import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.time.LocalDate;
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
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

/**
 *
 * @author Milano
 */
public class Optometrie_version_1 extends Application {
  
 
   
    @Override
    public void start(Stage primaryStage) {
          
        try{
            
                
          Fenetre_Principal kj=new Fenetre_Principal();
         //Credit jh=new Credit();
        }catch(Exception e)
        { e.printStackTrace();}
  
        
    }

    
    public static void main(String[] args) {

        launch(args);
    }
    
}
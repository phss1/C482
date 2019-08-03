/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c482_javafxml_proj;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Model.*;
import Controller.*;
import javafx.scene.Node;

/**
 *
 * @author Pete.Heiss
 */
public class C482_JavaFXML_Proj extends Application {
    
    @Override
    public void start(Stage stage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("/View/MainMenu.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        //add in house test data
        InHouse a1 = new InHouse(1,"Part A1",2.99,10,5,108,false,100);
        InHouse a2 = new InHouse(2,"Part A2",3.99,11,6,109,false,101);
        
        //System.out.println(Inventory.getAllParts());
        
        Inventory.addPart(a1);
        Inventory.addPart(a2);
        
        //add outsourced part test data
        Part o1 = new Outsourced(3,"Part O1",2.99,10,5,108,true,"Company1");
        Part o2 = new Outsourced(4,"Part O2",3.99,11,6,109,true,"Company2");
        Inventory.addPart(o1);
        Inventory.addPart(o2);
        
        launch(args);
    }
}

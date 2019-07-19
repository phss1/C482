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
        InHouse a1 = new InHouse(1,"Part A1",2.99,10,5,108,100);
        InHouse a2 = new InHouse(2,"Part A2",3.99,11,6,109,101);
        InHouse a3 = new InHouse(3,"Part A3",1.99,12,7,107,102);
        InHouse a4 = new InHouse(4,"Part A4",4.99,16,8,101,109);
        InHouse a5 = new InHouse(5,"Part A5",5.99,17,9,102,105);
        
        //System.out.println(Inventory.getAllParts());
        
        Inventory.addPart(a1);
        Inventory.addPart(a2);
        Inventory.addPart(a3);
        Inventory.addPart(a4);
        Inventory.addPart(a5);
        
        launch(args);
        
        /*
        //add outsourced part test data
        Part o1 = new Outsourced(1,"Part O1",2.99,10,5,108,"Company1");
        Part o2 = new Outsourced(2,"Part O2",3.99,11,6,109,"Company2");
        Part o3 = new Outsourced(3,"Part O3",1.99,12,7,107,"Company3");
        Part o4 = new Outsourced(4,"Part O4",4.99,16,8,101,"Company4");
        Part o5 = new Outsourced(5,"Part O5",5.99,17,9,102,"Company5");
        Inventory.addPart(o1);
        Inventory.addPart(o2);
        Inventory.addPart(o3);
        Inventory.addPart(o4);
        Inventory.addPart(o5);
        //add test product data
        */
        
    }
    
    /**
     * @param args the command line arguments
     
    public static void main(String[] args) {
        launch(args);
    }*/
    
}

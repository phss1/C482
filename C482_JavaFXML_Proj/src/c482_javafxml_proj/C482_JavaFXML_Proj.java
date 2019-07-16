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
    public void start(Stage stage) throws Exception {
        Inventory inv = new Inventory();
        addTestData(inv);
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddPart.fxml"));
        Controller.MainMenuController controller = new Controller.MainMenuController(inv);
        
        loader.setController(controller);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.getScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    void addTestData(Inventory inv)
    {
        //add in house test data
        Part a1 = new InHouse(1,"Part A1",2.99,10,5,108,100);
        Part a2 = new InHouse(2,"Part A2",3.99,11,6,109,101);
        Part a3 = new InHouse(3,"Part A3",1.99,12,7,107,102);
        Part a4 = new InHouse(4,"Part A4",4.99,16,8,101,109);
        Part a5 = new InHouse(5,"Part A5",5.99,17,9,102,105);
        inv.addPart(a1);
        inv.addPart(a2);
        inv.addPart(a3);
        inv.addPart(a4);
        inv.addPart(a5);
        //add outsourced part test data
        Part o1 = new Outsourced(1,"Part A1",2.99,10,5,108,"Company1");
        Part o2 = new Outsourced(2,"Part A2",3.99,11,6,109,"Company2");
        Part o3 = new Outsourced(3,"Part A3",1.99,12,7,107,"Company3");
        Part o4 = new Outsourced(4,"Part A4",4.99,16,8,101,"Company4");
        Part o5 = new Outsourced(5,"Part A5",5.99,17,9,102,"Company5");
        inv.addPart(o1);
        inv.addPart(o2);
        inv.addPart(o3);
        inv.addPart(o4);
        inv.addPart(o5);
        //add test product data
        
    }
    
    /**
     * @param args the command line arguments
     
    public static void main(String[] args) {
        launch(args);
    }*/
    
}

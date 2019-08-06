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
import java.io.IOException;
import javafx.scene.control.Button;

/**
 *
 * @author Pete.Heiss
 */
public class C482 extends Application {
    
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
        int newPartId1 = Inventory.getPartIdCnt();
        InHouse a1 = new InHouse(newPartId1,"Part A1",2.99,10,5,108,false,100);
        int newPartId2 = Inventory.getPartIdCnt();
        InHouse a2 = new InHouse(newPartId2,"Part A2",3.99,11,6,109,false,101);
        
        //System.out.println(Inventory.getAllParts());
        
        Inventory.addPart(a1);
        Inventory.addPart(a2);
        
        //add outsourced part test data
        int newPartId3 = Inventory.getPartIdCnt();
        Part o1 = new Outsourced(newPartId3,"Part O1",2.99,10,5,108,true,"Company1");
        int newPartId4 = Inventory.getPartIdCnt();
        Part o2 = new Outsourced(newPartId4,"Part O2",3.99,11,6,109,true,"Company2");
        Inventory.addPart(o1);
        Inventory.addPart(o2);
        
        int newprodId1 = Inventory.getProdIdCnt();
        Product p1 = new Product(newprodId1, "P1", 1.00, 1, 1, 4);
        int newprodId2 = Inventory.getProdIdCnt();
        Product p2 = new Product(newprodId2, "P1", 2.00, 2, 2, 5);
        int newprodId3 = Inventory.getProdIdCnt();
        Product p3 = new Product(newprodId3, "P1", 3.00, 3, 3, 6);
        int newprodId4 = Inventory.getProdIdCnt();
        Product p4 = new Product(newprodId4, "P1", 4.00, 4, 4, 7);
        Inventory.addProduct(p1);
        Inventory.addProduct(p2);
        Inventory.addProduct(p3);
        Inventory.addProduct(p4);
        
        launch(args);
    }
}

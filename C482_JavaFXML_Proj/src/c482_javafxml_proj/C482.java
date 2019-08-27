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
import javafx.collections.ObservableList;
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
        InHouse a1 = new InHouse(newPartId1,"InHouse1",2.99,10,5,108,false,11);
        int newPartId2 = Inventory.getPartIdCnt();
        InHouse a2 = new InHouse(newPartId2,"InHouse2",3.99,11,6,109,false,22);
        
        //System.out.println(Inventory.getAllParts());
        
        Inventory.addPart(a1);
        Inventory.addPart(a2);
        
        //add outsourced part test data
        int newPartId3 = Inventory.getPartIdCnt();
        Outsourced o1 = new Outsourced(newPartId3,"Oustourced1",4.99,12,6,110,true,"CompanyTest1");
        int newPartId4 = Inventory.getPartIdCnt();
        Outsourced o2 = new Outsourced(newPartId4,"Outsourced2",5.99,13,7,111,true,"CompanyTest2");
        Inventory.addPart(o1);
        Inventory.addPart(o2);
        
        int newprodId1 = Inventory.getProdIdCnt();
        Product p1 = new Product(newprodId1, "P1", 1.00, 1, 1, 4);
        p1.addAssociatedPart(a2);
        int newprodId2 = Inventory.getProdIdCnt();
        Product p2 = new Product(newprodId2, "P2", 2.00, 2, 2, 5);
        p2.addAssociatedPart(a2);
        int newprodId3 = Inventory.getProdIdCnt();
        Product p3 = new Product(newprodId3, "P3", 3.00, 3, 3, 6);
        p3.addAssociatedPart(a2);
        int newprodId4 = Inventory.getProdIdCnt();
        Product p4 = new Product(newprodId4, "P4", 4.00, 4, 4, 7);
        p4.addAssociatedPart(a2);
        Inventory.addProduct(p1);
        Inventory.addProduct(p2);
        Inventory.addProduct(p3);
        Inventory.addProduct(p4);
        
        launch(args);
    }
}

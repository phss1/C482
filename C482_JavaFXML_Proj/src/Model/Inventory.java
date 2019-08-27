/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Model.*;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Region;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author 39ds03d
 */
public class Inventory
{
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static ObservableList<Part> filteredParts = FXCollections.observableArrayList();
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();
    private static ObservableList<Product> filteredProducts = FXCollections.observableArrayList();
    private static int partIdCnt = 0;
    private static int prodIdCnt = 0;
    
    public static int getProdIdCnt()
    {
        prodIdCnt++;
        return prodIdCnt;
    }
    
    public static int getPartIdCnt() {
        partIdCnt++;
        return partIdCnt;
    }

    public static ObservableList<Part> getFilteredParts()
    {
        return filteredParts;
    }

    public static void setFilteredParts(ObservableList<Part> filteredParts)
    {
        Inventory.filteredParts = filteredParts;
    }

    public static ObservableList<Product> getFilteredProducts()
    {
        return filteredProducts;
    }

    public static void setFilteredProducts(ObservableList<Product> filteredProducts)
    {
        Inventory.filteredProducts = filteredProducts;
    }

    //getters
    public static ObservableList<Part> getAllParts()
    {
        return allParts;
    }
    
    public static ObservableList<Part> getAllFilteredParts()
    {
        return filteredParts;
    }
    
    public static ObservableList<Product> getAllFilteredProducts()
    {
        return filteredProducts;
    }

    public static ObservableList<Product> getAllProducts()
    {
        return allProducts;
    }
    
    //methods
    public static void addPart(Part part)
    {
        allParts.add(part);
    }
    
    public static void addProduct(Product product)
    {
        allProducts.add(product);
    }
    
    //utility methods    
    public static void displayInputError(String errorMessage)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, errorMessage, ButtonType.OK);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.show();
    }
            
    //misc methods 
    public static boolean isInvInputCorrect(int partInvMin, int partInvMax, int enteredInvLvl)
    {
        boolean result = (partInvMin < partInvMax) && 
                (partInvMin > 0 && 
                (partInvMax > 0) &&
                (enteredInvLvl <= partInvMax) &&
                (enteredInvLvl >= partInvMin));
        return result;
    }
}
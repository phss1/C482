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

    public static ObservableList<Part> getFilteredParts() {
        return filteredParts;
    }

    public static void setFilteredParts(ObservableList<Part> filteredParts) {
        Inventory.filteredParts = filteredParts;
    }

    public static ObservableList<Product> getFilteredProducts() {
        return filteredProducts;
    }

    public static void setFilteredProducts(ObservableList<Product> filteredProducts) {
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
    public static boolean checkUserInput(String id, String name, String price, String inv, String min, String max)
    {
        Boolean conversionFailed = false;
        Exception error;
        int partId;
        String partName;
        int partInv;
        Double partPrice;
        int partMin;
        int partMiax; 
        
        try
        {
            partId = Integer.parseInt(id);
            partName = name;
            partInv = Integer.parseInt(inv);
            partPrice = Double.parseDouble(price);
            partMin = Integer.parseInt(min);
            partMiax = Integer.parseInt(max);   
        }
        catch(Exception e)
        {
            conversionFailed = true;
            String errorReason = getInputErrorType(e.toString());
            displayInputError(errorReason);            
        }
        
        return conversionFailed;
    }
    
    public static void displayInputError(String errorMessage)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, errorMessage, ButtonType.OK);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.show();
    }
    
    public static String getInputErrorType(String error)
    {
        String errorString = null;
        if(error.contains("NumberFormatException"))
        {
            errorString = "You've entered a non-numeric value in a field expecting a number/integer type. Please correct it and try again.";
        }
        
        //need null checker
        
        return errorString;
    }
            
    //misc methods
    public static int confirmOperation(String confirmationType)
    {
        String fullMessage = "Are you sure you want to " + confirmationType + "?";
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.initModality(Modality.NONE);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Confirm " + confirmationType);
        alert.setContentText(fullMessage);
        Optional<ButtonType> result = alert.showAndWait();
        
        int test = -1;
        if(result.get() == ButtonType.OK)
        {
            test = 0;
        }
        else if(result.get() == ButtonType.CANCEL)
        {
            test = 1;
        }
        return test;
    }
    
    public static boolean isInvInputCorrect(int partInvMin, int partInvMax)
    {
        boolean result = (partInvMax < partInvMin) ||
                (partInvMin > partInvMax);
        
        if(result = true)
        {
            displayInputError("The inventory minimum is greater than the maximum. Please fix before that part can be saved.");
        }
        System.out.println(partInvMin);
        System.out.println(partInvMax);
        
        return result;
    }
    
    public static boolean nullFieldValueExists(String id, String name, String price, String inv, String min, String max)
    {
        boolean result = (id.isEmpty()) || 
                (name.isEmpty()) || 
                (price.isEmpty()) || 
                (inv.isEmpty()) || 
                (min.isEmpty()) || 
                (max.isEmpty());
        
        if(result == true)
        {
            displayInputError("You've left a field empty. Please enter a value and try again.");
        }

        return result;
    }
}
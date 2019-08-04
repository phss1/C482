/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Model.*;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Region;

/**
 *
 * @author 39ds03d
 */
public class Inventory
{
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static ObservableList<Part> filteredParts = FXCollections.observableArrayList();
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();

    //getters
    public static ObservableList<Part> getAllParts()
    {
        return allParts;
    }
    
    public static ObservableList<Part> getAllFilteredParts()
    {
        return filteredParts;
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
    
    public static void deletePart(Part part)
    {
        int index = -1;
        for(Part currentPart : Inventory.getAllParts())
        {
            index++;
            if(currentPart.getId() == part.getId())
            {
                Inventory.getAllParts().remove(currentPart);
            }
        }
    }
    
    public static void modifyPart(Part part)
    {
        int index = -1;
        for(Part currentPart : Inventory.getAllParts())
        {
            index++;
            if(currentPart.getId() == part.getId())
            {
                Inventory.getAllParts().set(index, part);
            }
        }
    }
    

    
    public static boolean checkPartUserInput(String id, String name, String price, String inv, String min, String max)
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
            String errorReason = getPartInputErrorType(e.toString());
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
    
    public static String getPartInputErrorType(String error)
    {
        String errorString = null;
        if(error.contains("NumberFormatException"))
        {
            errorString = "You've entered a non-numeric value in a field expecting a number/integer type. Please correct it and try again.";
        }
        
        //need null checker
        
        
        
        return errorString;
    }
            
    //product methods
    public static void deleteProduct(Product product)
    {
        
    }
}
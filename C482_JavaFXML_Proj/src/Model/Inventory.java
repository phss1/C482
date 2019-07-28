/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Model.*;

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
    
    public static void deleteProduct(Product product)
    {
        
    }
}
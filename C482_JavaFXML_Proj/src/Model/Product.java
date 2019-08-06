/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author 39ds03d
 */
public class Product
{
    private static ObservableList<Part> associatedParts = FXCollections.observableArrayList();
    private int id;
    private String name;
    private Double price;
    private int stock;
    private int min;
    private int max;

    public Product(int id, String name, Double price, int stock, int min, int max)
    {
        this.associatedParts = associatedParts;
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Double getPrice()
    {
        return price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }

    public int getStock()
    {
        return stock;
    }

    public void setStock(int stock)
    {
        this.stock = stock;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min)
    {
        this.min = min;
    }

    public int getMax()
    {
        return max;
    }

    public void setMax(int max)
    {
        this.max = max;
    }
    
    public static ObservableList<Part> getAssociatedParts()
    {
        return associatedParts;
    }

    public void setAssociatedParts(ObservableList<Part> associatedParts)
    {
        this.associatedParts = associatedParts;
    }

    public static void addAssociatedPart(Part part)
    {
        associatedParts.add(part);
    }
    
    public static void deleteAssociatedPart(Part part)
    {
        int index = -1;
        for(Part currentPart : Product.getAssociatedParts())
        {
            index++;
            if(currentPart.getId() == part.getId())
            {
                System.out.println(currentPart.getId());
                System.out.println(part.getId());
                Product.getAssociatedParts().remove(currentPart);
            }
        }
    }
          
    public static void deleteProduct(Product product)
    {
        int index = -1;
        for(Product currentProduct : Inventory.getAllProducts())
        {
            index++;
            if(currentProduct.getId() == product.getId())
            {
                Inventory.getAllProducts().remove(currentProduct);
            }
        }
    }

    public static Product productSearch(int id)
    {
        int index = -1;
        for(Product currentProduct : Inventory.getAllProducts())
        {
            index++;
            if(currentProduct.getId() == id)
            {
                return currentProduct;
            }
        }
        return null;
    }
    
    public static ObservableList<Product> filterProducts(int id)
    {
        if(!(Inventory.getAllFilteredProducts().isEmpty()))
            Inventory.getAllFilteredProducts().clear();
        
        for(Product currentProduct : Inventory.getAllProducts())
        {
            if(currentProduct.getId() == id)
            {
                Inventory.getAllFilteredProducts().add(currentProduct);
            }
        }
        return Inventory.getAllFilteredProducts();
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Region;

/**
 *
 * @author 39ds03d
 */
public abstract class Part
{
    private int id;
    private String name;
    private Double price;
    private int stock;
    private int min;
    private int max;
    private boolean outsourced;

    public Part(int id, String name, Double price, int stock, int min, int max, boolean outsourced)
    {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
        this.outsourced = outsourced;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock)
    {
        this.stock = stock;
    }

    public int getMin()
    {
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
    
    public boolean getOutsourced()
    {
        return outsourced;
    }

    public void setOutsourced(boolean outsourced)
    {
        this.outsourced = outsourced;
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
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author 39ds03d
 */
public class Outsourced extends Part
{
    private String companyName;
    
    public Outsourced(int id, String name, Double price, int stock, int min, int max, boolean outsourced, String companyName)
    {
        super(id, name, price, stock, min, max, outsourced);
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }
}

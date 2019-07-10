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
public class InHouse extends Part
{
    private String machineId;
    
    public InHouse(int id, String name, Double price, int stock, int min, int max, String machineId)
    {
        super(id, name, price, stock, min, max);
        this.machineId = machineId;
    }

    public String getMachineId()
    {
        return machineId;
    }

    public void setMachineId(String machineId)
    {
        this.machineId = machineId;
    }
}
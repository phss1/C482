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
    private int machineId;
    
    public InHouse(int id, String name, Double price, int stock, int min, int max, boolean outsourced, int machineId)
    {
        super(id, name, price, stock, min, max, outsourced);
        this.machineId = machineId;
    }

    public int getMachineId()
    {
        return machineId;
    }

    public void setMachineId(int machineId)
    {
        this.machineId = machineId;
    }
}
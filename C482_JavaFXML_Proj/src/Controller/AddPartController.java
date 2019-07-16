/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Inventory;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import Model.*;
import java.awt.event.MouseEvent;

/**
 *
 * @author Pete.Heiss
 */
public class AddPartController implements Initializable
{
    Stage stage;
    Parent scene;
    
    @FXML
    private TextField companyNameTxtFld;

    @FXML
    private Label companyNameLbl;
    
    @FXML
    private TextField machineIdTxtFld;
    
    @FXML
    private Label machineIdLbl;
    
    @FXML
    private ToggleGroup status;

    @FXML
    private TextField addPartId;

    @FXML
    private TextField addPartName;

    @FXML
    private TextField addPartInv;

    @FXML
    private TextField addPartMax;

    @FXML
    private TextField addPartPriceCost;

    @FXML
    private TextField addPartMin;

    @FXML
    private TextField addPartMachineID;
    
    @FXML
    private RadioButton inHouseRdBtn;

    @FXML
    private RadioButton outsourcedRdBtn;

    
    @FXML
    void cancel(MouseEvent event) throws IOException
    {
        addPartId.clear();
        addPartName.clear();
        addPartInv.clear();
        addPartPriceCost.clear();
        addPartMax.clear();
        addPartMin.clear();
        
        if(outsourcedRdBtn.isSelected())
        {
            companyNameTxtFld.clear();
        }
        else
        {
            machineIdTxtFld.clear();
        }
        
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/MainMenu.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void inHouse(MouseEvent event)
    {
        machineIdLbl.setVisible(true);
        machineIdTxtFld.setVisible(true);
        machineIdTxtFld.setEditable(true);
        companyNameLbl.setVisible(false);
        companyNameTxtFld.setVisible(false);
        companyNameTxtFld.setEditable(false);
    }

    @FXML
    void outSourced(MouseEvent event)
    {
        machineIdLbl.setVisible(false);
        machineIdTxtFld.setVisible(false);
        machineIdTxtFld.setEditable(false);
        companyNameLbl.setVisible(true);
        companyNameTxtFld.setVisible(true);
        companyNameTxtFld.setEditable(true);
    }

    @FXML
    void savePart(MouseEvent event)
    {
        //  Integer.parseInt(addPartMin), 
        Part newPart = null; // Integer.parseInt(addPartId.getText()), String addPartName, Double.parseDouble(addPartPriceCost), Integer.parseInt(addPartInv), Integer.parseInt(addPartMin), Integer.parseInt(addPartMax);
        newPart.setId(Integer.parseInt(addPartId.getText()));
        newPart.setName(addPartName.getText());
        newPart.setPrice(Double.parseDouble(addPartPriceCost.getText()));
        newPart.setStock(Integer.parseInt(addPartInv.getText()));
        newPart.setMin(Integer.parseInt(addPartMin.getText()));
        newPart.setMax(Integer.parseInt(addPartMax.getText()));
        
        Inventory.addPart(newPart);
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    
    
}

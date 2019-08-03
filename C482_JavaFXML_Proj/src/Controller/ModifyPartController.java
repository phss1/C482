/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.*;
import Model.Part;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

/**
 *
 * @author Pete.Heiss
 */
public class ModifyPartController implements Initializable
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
    private Button CloseButton;

    @FXML
    private Button SaveButton;

    @FXML
    private ToggleGroup status;

    @FXML
    private TextField modifyPartId;

    @FXML
    private TextField modifyPartName;

    @FXML
    private TextField modifyPartInv;

    @FXML
    private TextField modifyPartMax;

    @FXML
    private TextField modifyPartPriceCost;

    @FXML
    private TextField modifyPartMin;

    @FXML
    private TextField modifyPartMachineId;
    
    @FXML
    private RadioButton inHouseRdBtn;

    @FXML
    private RadioButton outsourcedRdBtn;

    @FXML
    void inHouseRdBtn(ActionEvent event)
    {
        machineIdLbl.setVisible(true);
        machineIdTxtFld.setVisible(true);
        companyNameLbl.setVisible(false);
        companyNameTxtFld.setVisible(false);
    }

    @FXML
    void outsourcedRdBtn(ActionEvent event)
    {
        machineIdLbl.setVisible(false);
        machineIdTxtFld.setVisible(false);
        companyNameLbl.setVisible(true);
        companyNameTxtFld.setVisible(true);
    }
    
    @FXML
    public void saveBtn(ActionEvent event) throws IOException
    {
        Boolean inputConvResult = Inventory.checkPartUserInput(modifyPartId.getText(),modifyPartName.getText(),modifyPartPriceCost.getText(),modifyPartInv.getText(),modifyPartMin.getText(),modifyPartMax.getText());
        
        if(inputConvResult == false)
        {
            int partId = Integer.parseInt(modifyPartId.getText());
            String partName = modifyPartName.getText();
            int partInv = Integer.parseInt(modifyPartInv.getText());
            Double partPrice = Double.parseDouble(modifyPartPriceCost.getText());
            int partMax = Integer.parseInt(modifyPartMax.getText());
            int partMin = Integer.parseInt(modifyPartMin.getText());  
        
            if(outsourcedRdBtn.isSelected())
            {
                String companyName = companyNameTxtFld.getText();
                Part outsourced = new Outsourced(partId, partName, partPrice, partInv, partMin, partMax, true, companyName);
                Inventory.modifyPart(outsourced);
            }
            else if(inHouseRdBtn.isSelected())
            {
                int machineId = Integer.parseInt(machineIdTxtFld.getText());
                Part inHouse = new InHouse(partId, partName, partPrice, partInv, partMin, partMax, false, machineId);
                Inventory.modifyPart(inHouse);
            }
            
            stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/View/MainMenu.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();
        }
    }
    
    @FXML
    public void cancelBtn(ActionEvent event) throws IOException
    {
        modifyPartId.clear();
        modifyPartName.clear();
        modifyPartInv.clear();
        modifyPartPriceCost.clear();
        modifyPartMax.clear();
        modifyPartMin.clear();
        
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        Part filteredPartToModify = Inventory.getAllFilteredParts().get(0);
        modifyPartId.setText(Integer.toString(filteredPartToModify.getId()));
        modifyPartName.setText(filteredPartToModify.getName());
        modifyPartInv.setText(Integer.toString(filteredPartToModify.getStock()));
        modifyPartPriceCost.setText(Double.toString(filteredPartToModify.getPrice()));
        modifyPartMax.setText(Integer.toString(filteredPartToModify.getMax()));
        modifyPartMin.setText(Integer.toString(filteredPartToModify.getMin()));
        
        if(filteredPartToModify.getOutsourced() == true)
        {
            machineIdLbl.setVisible(false);
            machineIdTxtFld.setVisible(false);
            companyNameLbl.setVisible(true);
            companyNameTxtFld.setVisible(true);
            
            outsourcedRdBtn.setSelected(true);
            inHouseRdBtn.setDisable(true);
        }
        else
        {
            machineIdLbl.setVisible(false);
            machineIdTxtFld.setVisible(false);
            companyNameLbl.setVisible(true);
            companyNameTxtFld.setVisible(true);
            
            inHouseRdBtn.setSelected(true);
            outsourcedRdBtn.setDisable(true);
        }
    }
}
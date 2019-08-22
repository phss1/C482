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
import java.util.Optional;
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
import javafx.stage.Modality;
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
        Boolean invInputCorrect = Inventory.isInvInputCorrect(Integer.parseInt(modifyPartMin.getText()), 
                Integer.parseInt(modifyPartMax.getText()),
                Integer.parseInt(modifyPartInv.getText()));
        
        try
        {
            int partId = Integer.parseInt(modifyPartId.getText());
            String partName = modifyPartName.getText();
            int partInv = Integer.parseInt(modifyPartInv.getText());
            Double partPrice = Double.parseDouble(modifyPartPriceCost.getText());
            int partMax = Integer.parseInt(modifyPartMax.getText());
            int partMin = Integer.parseInt(modifyPartMin.getText());
            String companyName = companyNameTxtFld.getText();

            if(outsourcedRdBtn.isSelected() && 
                    !companyName.isEmpty() && 
                    invInputCorrect == true)
            {
                Part outsourced = new Outsourced(partId, partName, partPrice, 
                        partInv, partMin, partMax, true, companyName);
                Part.modifyPart(outsourced);
                
                stage = (Stage)((Button)event.getSource()).getScene().getWindow();
                scene = FXMLLoader.load(getClass().getResource("/View/MainMenu.fxml"));
                stage.setScene(new Scene(scene));
                stage.show();
            }
            else if(inHouseRdBtn.isSelected() && 
                    invInputCorrect == true)
            {
                int machineId = Integer.parseInt(machineIdTxtFld.getText());
                Part inHouse = new InHouse(partId, partName, partPrice, partInv, 
                        partMin, partMax, false, machineId);
                Part.modifyPart(inHouse);
                
                stage = (Stage)((Button)event.getSource()).getScene().getWindow();
                scene = FXMLLoader.load(getClass().getResource("/View/MainMenu.fxml"));
                stage.setScene(new Scene(scene));
                stage.show();
            }
            else if(companyName.isEmpty() && outsourcedRdBtn.isSelected())
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.initModality(Modality.NONE);
                alert.setTitle("Warning");
                alert.setHeaderText("Input Error");
                alert.setContentText("Please make sure a value for Company Name field is entered .");
                Optional<ButtonType> result = alert.showAndWait();
            }
            else if(invInputCorrect == false)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.initModality(Modality.NONE);
                alert.setTitle("Warning");
                alert.setHeaderText("Input Error");
                alert.setContentText("Please make sure the min inventory level is not greater than the max or "
                        + "the Inv entry is not between the inventory min/max values.");
                Optional<ButtonType> result = alert.showAndWait();
            }
        }
        catch(Exception e)
        {
            if(e.toString().contains("input string:"))
            {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.initModality(Modality.NONE);
                alert.setTitle("Warning");
                alert.setHeaderText("Input Error");
                alert.setContentText("You either entered a non-integer, incorrect Price in format 1.00, "
                        + "or null value. Please correct field input.");
                Optional<ButtonType> result = alert.showAndWait();
            }
        }
    }
    
    @FXML
    public void cancelBtn(ActionEvent event) throws IOException
    {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.initModality(Modality.NONE);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Confirm Cancel");
        alert.setContentText("Do you want to cancel?");
        Optional<ButtonType> result = alert.showAndWait();

        
        if(result.get() == ButtonType.OK)
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
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        Boolean filteredPartToModify = Inventory.getAllFilteredParts().get(0).getOutsourced();
        
        if(filteredPartToModify == true)
        {
            Outsourced outSourcedPartToModify = (Model.Outsourced)Inventory.getAllFilteredParts().get(0);
            modifyPartId.setText(Integer.toString(outSourcedPartToModify.getId()));
            modifyPartName.setText(outSourcedPartToModify.getName());
            modifyPartInv.setText(Integer.toString(outSourcedPartToModify.getStock()));
            modifyPartPriceCost.setText(Double.toString(outSourcedPartToModify.getPrice()));
            modifyPartMax.setText(Integer.toString(outSourcedPartToModify.getMax()));
            modifyPartMin.setText(Integer.toString(outSourcedPartToModify.getMin()));
            companyNameTxtFld.setText(outSourcedPartToModify.getCompanyName());
            
            machineIdLbl.setVisible(false);
            machineIdTxtFld.setVisible(false);
            companyNameLbl.setVisible(true);
            companyNameTxtFld.setVisible(true);
            
            outsourcedRdBtn.setSelected(true);
        }
        else
        {
            InHouse inHousePartToModify = (Model.InHouse)Inventory.getAllFilteredParts().get(0);
            modifyPartId.setText(Integer.toString(inHousePartToModify.getId()));
            modifyPartName.setText(inHousePartToModify.getName());
            modifyPartInv.setText(Integer.toString(inHousePartToModify.getStock()));
            modifyPartPriceCost.setText(Double.toString(inHousePartToModify.getPrice()));
            modifyPartMax.setText(Integer.toString(inHousePartToModify.getMax()));
            modifyPartMin.setText(Integer.toString(inHousePartToModify.getMin()));
            machineIdTxtFld.setText(Integer.toString(inHousePartToModify.getMachineId()));
            
            machineIdLbl.setVisible(true);
            machineIdTxtFld.setVisible(true);
            companyNameLbl.setVisible(false);
            companyNameTxtFld.setVisible(false);
            
            inHouseRdBtn.setSelected(true);
        }
    }
}
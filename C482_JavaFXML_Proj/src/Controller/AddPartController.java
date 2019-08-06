/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
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
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;

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
    void cancel(ActionEvent event) throws IOException
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initModality(Modality.NONE);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Confirm Cancel");
        alert.setContentText("Do you want to cancel?");
        Optional<ButtonType> result = alert.showAndWait();

        if(result.get() == ButtonType.OK)
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
    }

    @FXML
    void inHouse(ActionEvent event) throws IOException
    {
        machineIdLbl.setVisible(true);
        machineIdTxtFld.setVisible(true);
        companyNameLbl.setVisible(false);
        companyNameTxtFld.setVisible(false);
    }

    @FXML
    void outSourced(ActionEvent event) throws IOException
    {
        machineIdLbl.setVisible(false);
        machineIdTxtFld.setVisible(false);
        companyNameLbl.setVisible(true);
        companyNameTxtFld.setVisible(true);
    }

    @FXML
    void savePart(ActionEvent event) throws IOException
    {
        Boolean invInputCorrect = Inventory.isInvInputCorrect(Integer.parseInt(addPartMin.getText()), Integer.parseInt(addPartMax.getText()));
                
        try
        {
            int id = Integer.parseInt(addPartId.getText());
            String name = addPartName.getText();
            Double price = Double.parseDouble(addPartPriceCost.getText());
            int stock = Integer.parseInt(addPartInv.getText());
            int min = Integer.parseInt(addPartMin.getText());
            int max = Integer.parseInt(addPartMax.getText());
            String companyName = companyNameTxtFld.getText();

            if(outsourcedRdBtn.isSelected() && 
                    !companyName.isEmpty() && 
                    invInputCorrect == true)
            {
                Part outsourced = new Outsourced(id, name, price, stock, min, max, true, companyName);
                Inventory.addPart(outsourced);
                
                stage = (Stage)((Button)event.getSource()).getScene().getWindow();
                scene = FXMLLoader.load(getClass().getResource("/View/MainMenu.fxml"));
                stage.setScene(new Scene(scene));
                stage.show();
            }
            else if(inHouseRdBtn.isSelected() && 
                    invInputCorrect == true)
            {
                int machineId = Integer.parseInt(machineIdTxtFld.getText());
                Part inHouse = new InHouse(id, name, price, stock, min, max, false, machineId);
                Inventory.addPart(inHouse);
                
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
                alert.setContentText("Please make sure the min inventory level is not greater than the max.");
                Optional<ButtonType> result = alert.showAndWait();
            }
        }
        catch(Exception e)
        {
            //java.lang.NumberFormatException: For input string: ""
            if(e.toString().contains("input string:"))
            {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.initModality(Modality.NONE);
                alert.setTitle("Warning");
                alert.setHeaderText("Input Error");
                alert.setContentText("You either entered a non-integer, incorrect Price in format 1.00, or null value. Please correct field input.");
                Optional<ButtonType> result = alert.showAndWait();
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        machineIdLbl.setVisible(true);
        machineIdTxtFld.setVisible(true);
        companyNameLbl.setVisible(false);
        companyNameTxtFld.setVisible(false);
        
        //need if statement to check for part type if outsourced or inhouse
        
    }
}

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
        int id = Integer.parseInt(addPartId.getText());
        String name = addPartName.getText();
        Double price = Double.parseDouble(addPartPriceCost.getText());
        int stock = Integer.parseInt(addPartInv.getText());
        int min = Integer.parseInt(addPartMin.getText());
        int max = Integer.parseInt(addPartMax.getText());
        
        if(outsourcedRdBtn.isSelected())
        {
            String companyName = companyNameTxtFld.getText();
            Part outsourced = new Outsourced(id, name, price, stock, min, max, companyName);
            Inventory.addPart(outsourced);
        }
        else if(inHouseRdBtn.isSelected())
        {
            int machineId = Integer.parseInt(machineIdTxtFld.getText());
            Part inHouse = new InHouse(id, name, price, stock, min, max, machineId);
            Inventory.addPart(inHouse);
        }
        
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/MainMenu.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        machineIdLbl.setVisible(true);
        machineIdTxtFld.setVisible(true);
        companyNameLbl.setVisible(false);
        companyNameTxtFld.setVisible(false);
    }    
    
}

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
    void onActionInHouseRdBtn(ActionEvent event)
    {
        machineIdLbl.setVisible(true);
        machineIdTxtFld.setVisible(true);
        machineIdTxtFld.setEditable(true);
        companyNameLbl.setVisible(false);
        companyNameTxtFld.setVisible(false);
        companyNameTxtFld.setEditable(false);
    }

    @FXML
    void onActionOutsourcedRdBtn(ActionEvent event)
    {
        machineIdLbl.setVisible(false);
        machineIdTxtFld.setVisible(false);
        machineIdTxtFld.setEditable(false);
        companyNameLbl.setVisible(true);
        companyNameTxtFld.setVisible(true);
        companyNameTxtFld.setEditable(true);
    }
    
    @FXML
    void onActionSaveBtn(ActionEvent event)
    {
        
    }
    
    @FXML
    void onActionCancelBtn(ActionEvent event) throws IOException
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
        // TODO
    }
}

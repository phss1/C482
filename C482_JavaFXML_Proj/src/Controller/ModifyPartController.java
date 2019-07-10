/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author Pete.Heiss
 */
public class ModifyPartController implements Initializable
{
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
    void onActionInHouseRdBtn(ActionEvent event)
    {

    }

    @FXML
    void onActionOutsourcedRdBtn(ActionEvent event)
    {

    }
    
    @FXML
    void onActionSaveBtn(ActionEvent event)
    {

    }
    
    @FXML
    void onActionCancelBtn(ActionEvent event)
    {

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }
}

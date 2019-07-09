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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author Pete.Heiss
 */
public class AddPartController implements Initializable
{
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
    void onActionAddPartInHouseRdBtn(ActionEvent event) throws IOException
    {

    }

    @FXML
    void onActionAddPartRdBtn(ActionEvent event) throws IOException
    {

    }
    
    @FXML
    void onActionAddPartCancelBtn(ActionEvent event) throws IOException
    {
        
    }
    
    @FXML
    void onActionAddPartSaveBtn(ActionEvent event) throws IOException
    {

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

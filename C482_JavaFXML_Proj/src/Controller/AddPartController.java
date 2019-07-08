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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 *
 * @author Pete.Heiss
 */
public class AddPartController implements Initializable {
    
    @FXML
    private Button addProductCancelBtn;

    @FXML
    private Button addProductSaveBtn;

    @FXML
    private RadioButton addPartInHouseRdBtn;

    @FXML
    private RadioButton addPartOutsourced;

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
    void onActionAddPartInHouseRdBtn(ActionEvent event) {

    }

    @FXML
    void onActionAddPartRdBtn(ActionEvent event) {

    }
    
    //@FXML
    //private void handleButtonAction(ActionEvent event) {
    //    System.out.println("You clicked me!");
    //    label.setText("Hello World!");
    //}
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

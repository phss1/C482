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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author Pete.Heiss
 */
public class ModifyProductController implements Initializable {
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private Button AddProdCancelBtn;

    @FXML
    private Button AddProdSaveBtn;

    @FXML
    private Button AddProdDeleteBtn;

    @FXML
    private Button AddProdSearchBtn;

    @FXML
    private TextField ModifyProdSeatchLbl;

    @FXML
    private TableView<?> ModifyProdTable2;

    @FXML
    private TableColumn<?, ?> ModifyProdAddPartIdCol2;

    @FXML
    private TableColumn<?, ?> ModifyProdAddPartNameCol2;

    @FXML
    private TableColumn<?, ?> ModifyProdAddPartInvLvlCol2;

    @FXML
    private TableColumn<?, ?> ModifyProdAddPartCostCol2;

    @FXML
    private TableView<?> ModifyProdTable1;

    @FXML
    private TableColumn<?, ?> ModifyProdAddPartIdCol;

    @FXML
    private TableColumn<?, ?> ModifyProdAddPartNameCol;

    @FXML
    private TableColumn<?, ?> ModifyProdAddInvLvlCol;

    @FXML
    private TableColumn<?, ?> ModifyProdAddPartCostCol;

    @FXML
    private TextField addPartIdLbl;

    @FXML
    private TextField addPartNameLbl;

    @FXML
    private TextField addPartInvLbl;

    @FXML
    private TextField addPartMaxLbl;

    @FXML
    private TextField addPartPriceCostLbl;

    @FXML
    private TextField addPartMinLbl;

    @FXML
    void ModifyProdPartSearchButton(ActionEvent event) {

    }

    @FXML
    void onActionModifyProdAddBtn(ActionEvent event) {
        
    }

    @FXML
    void onActionModifyProdCancelBtn(ActionEvent event) {

    }

    @FXML
    void onActionModifyProdDeleteBtn(ActionEvent event) {

    }

    @FXML
    void onActionModifyProdSaveBtn(ActionEvent event) {

    }
}
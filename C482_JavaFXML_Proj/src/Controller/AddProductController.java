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
public class AddProductController implements Initializable {
    @FXML
    private Button AddProdCancelBtn;

    @FXML
    private Button AddProdSaveBtn;

    @FXML
    private Button AddProdDeleteBtn;

    @FXML
    private Button AddProdSearchBtn;

    @FXML
    private TextField AddProdSeatchFld;

    @FXML
    private TableView<?> addPartsTable2;

    @FXML
    private TableColumn<?, ?> AddProdAddPartIdCol2;

    @FXML
    private TableColumn<?, ?> AddProdAddPartNameCol2;

    @FXML
    private TableColumn<?, ?> AddProdAddPartInvLvlCol2;

    @FXML
    private TableColumn<?, ?> AddProdAddPartCostCol2;

    @FXML
    private TableView<?> addPartsTable1;

    @FXML
    private TableColumn<?, ?> AddProdAddPartIdCol1;

    @FXML
    private TableColumn<?, ?> AddProdAddPartNameCol1;

    @FXML
    private TableColumn<?, ?> AddProdAddInvLvlCol1;

    @FXML
    private TableColumn<?, ?> AddProdAddPartCostCol1;

    @FXML
    private Button addProdAddPartTbl1;

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
    void PartSearchButton(ActionEvent event) {

    }

    @FXML
    void onActionAddProdAddBtn(ActionEvent event) {

    }

    @FXML
    void onActionAddProdCancelBtn(ActionEvent event) {

    }

    @FXML
    void onActionAddProdDeleteBtn(ActionEvent event) {

    }

    @FXML
    void onActionAddProdSaveBtn(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

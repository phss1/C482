/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
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
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Pete.Heiss
 */
public class ModifyProductController implements Initializable
{
    @FXML
    private TextField prodPartSearchTxtFld;

    @FXML
    private TableView<Part> productPartsTbl;

    @FXML
    private TableColumn<Part, Integer> prodId;

    @FXML
    private TableColumn<Part, String> prodName;

    @FXML
    private TableColumn<Part, Integer> prodInvLvl;

    @FXML
    private TableColumn<Part, Double> prodPriceCost;

    @FXML
    private TableView<Part> productAssociatedPartsTbl;

    @FXML
    private TableColumn<Part, Integer> partId;

    @FXML
    private TableColumn<Part, String> partName;

    @FXML
    private TableColumn<Part, Integer> partInvLvl;

    @FXML
    private TableColumn<Part, Double> partPriceCost;

    @FXML
    private TextField prodIdTxtFld;

    @FXML
    private TextField prodNameTxtFld;

    @FXML
    private TextField prodInvTxtFld;

    @FXML
    private TextField prodMaxTxtFld;

    @FXML
    private TextField prodPriceTxtFld;

    @FXML
    private TextField prodMinTxtFld;

    @FXML
    void onActionAddPartBtn(ActionEvent event)
    {
        
    }

    @FXML
    void onActionCancelBtn(ActionEvent event)
    {
        
    }

    @FXML
    void onActionDeleteProdBtn(ActionEvent event)
    {
        
    }

    @FXML
    void onActionSaveProdBtn(ActionEvent event)
    {
        
    }

    @FXML
    void onActionSearchPartBtn(ActionEvent event)
    {
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        Product filteredProductToModify = Inventory.getAllFilteredProducts().get(0);
        prodIdTxtFld.setText(Integer.toString(filteredProductToModify.getId()));
        prodNameTxtFld.setText(filteredProductToModify.getName());
        prodInvTxtFld.setText(Integer.toString(filteredProductToModify.getStock()));
        prodPriceTxtFld.setText(Double.toString(filteredProductToModify.getPrice()));
        prodMinTxtFld.setText(Integer.toString(filteredProductToModify.getMin()));
        prodMaxTxtFld.setText(Integer.toString(filteredProductToModify.getMax()));
        
        productPartsTbl.setItems(Inventory.getAllParts());
        partId.setCellValueFactory(new PropertyValueFactory<>("id"));
        partName.setCellValueFactory(new PropertyValueFactory<>("name"));
        partInvLvl.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partPriceCost.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        //line for associated part tbale population
    }
}
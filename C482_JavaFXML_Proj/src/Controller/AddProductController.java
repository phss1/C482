/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Inventory;
import Model.Part;
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
public class AddProductController implements Initializable
{
    @FXML
    private Label label;

    @FXML
    private Label label1;

    @FXML
    private TextField prodPartSearchTxtFld;

    @FXML
    private TableView<Part> productPartsTbl;

    @FXML
    private TableColumn<Part, Integer> prodPartId;

    @FXML
    private TableColumn<Part, String> prodPartName;

    @FXML
    private TableColumn<Part, Integer> productInvLvl;

    @FXML
    private TableColumn<Part, Double> prodPriceCost;

    @FXML
    private TableView<Part> productAssociatedPartsTbl;

    @FXML
    private TableColumn<Part, Integer> partId;

    @FXML
    private TableColumn<Part, String> partName;

    @FXML
    private TableColumn<Part, Integer> partInv;

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
    void onActionDeleteBtn(ActionEvent event)
    {

    }

    @FXML
    void onActionSaveProductBtn(ActionEvent event)
    {

    }

    @FXML
    void onActionSearchPartBtn(ActionEvent event)
    {

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        productPartsTbl.setItems(Inventory.getAllParts());
        partId.setCellValueFactory(new PropertyValueFactory<>("id"));
        partName.setCellValueFactory(new PropertyValueFactory<>("name"));
        partInv.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partPriceCost.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        //line for associated products table 
    }
}

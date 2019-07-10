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
public class AddProductController implements Initializable
{
    @FXML
    private Label label;

    @FXML
    private Label label1;

    @FXML
    private TextField prodPartSearchTxtFld;

    @FXML
    private TableView<?> productsTable;

    @FXML
    private TableColumn<?, ?> prodPartId;

    @FXML
    private TableColumn<?, ?> prodPartName;

    @FXML
    private TableColumn<?, ?> productInvLvl;

    @FXML
    private TableColumn<?, ?> prodPriceCost;

    @FXML
    private TableView<?> partsTable;

    @FXML
    private TableColumn<?, ?> partId;

    @FXML
    private TableColumn<?, ?> partName;

    @FXML
    private TableColumn<?, ?> partInv;

    @FXML
    private TableColumn<?, ?> partPriceCost;

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
        // TODO
    }    
    
}

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
public class ModifyProductController implements Initializable
{
    @FXML
    private TextField prodPartSearchTxtFld;

    @FXML
    private TableView<?> productTbl;

    @FXML
    private TableColumn<?, ?> prodId;

    @FXML
    private TableColumn<?, ?> prodName;

    @FXML
    private TableColumn<?, ?> prodInvLvl;

    @FXML
    private TableColumn<?, ?> prodPriceCost;

    @FXML
    private TableView<?> productPartsTbl;

    @FXML
    private TableColumn<?, ?> partId;

    @FXML
    private TableColumn<?, ?> partName;

    @FXML
    private TableColumn<?, ?> partInvLvl;

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
        // TODO
    }
}
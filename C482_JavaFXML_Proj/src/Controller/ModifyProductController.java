/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Pete.Heiss
 */
public class ModifyProductController implements Initializable
{
    Stage stage;
    Parent scene;
    
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
    void onActionCancelBtn(ActionEvent event) throws IOException
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initModality(Modality.NONE);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Confirm Cancel");
        alert.setContentText("Do you want to cancel?");
        Optional<ButtonType> result = alert.showAndWait();

        if(result.get() == ButtonType.OK)
        {
            stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/View/MainMenu.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();
        }
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
        int searchId = Integer.parseInt(prodPartSearchTxtFld.getText());
        Part searchedPart = Part.partSearch(searchId);
        
        productPartsTbl.getSelectionModel().select(searchedPart);
        partId.setCellValueFactory(new PropertyValueFactory<>("id"));
        partName.setCellValueFactory(new PropertyValueFactory<>("name"));
        partInvLvl.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partPriceCost.setCellValueFactory(new PropertyValueFactory<>("price"));

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
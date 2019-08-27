/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.AddProductController.minProductValue;
import static Controller.AddProductController.wasPartAlreadyAdded;
import Model.*;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    ObservableList<Part> partsList = FXCollections.observableArrayList();
    
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
        Part selectedTableViewPart = productPartsTbl.getSelectionModel().getSelectedItem();
        
        
        if(!selectedTableViewPart.getName().equals(null))
        {
            partsList.add(productPartsTbl.getSelectionModel().getSelectedItem());
            productAssociatedPartsTbl.setItems(partsList);
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initModality(Modality.NONE);
            alert.setTitle("Warning");
            alert.setHeaderText("No Part Selected");
            alert.setContentText("Please make sure a part is selected to add.");
            Optional<ButtonType> result = alert.showAndWait();
        }
    }
    
    public void sendInfo(Product product)
    {
        Inventory.getFilteredProducts().clear();
        Product chosenProduct = product;
        ObservableList<Part> productAssocParts = chosenProduct.getAssociatedParts();
        Inventory.getFilteredProducts().add(chosenProduct);
        partsList = chosenProduct.getAssociatedParts();
        
        prodIdTxtFld.setText(String.valueOf(chosenProduct.getId()));
        prodNameTxtFld.setText(String.valueOf(chosenProduct.getName()));
        prodInvTxtFld.setText(String.valueOf(chosenProduct.getStock()));
        prodPriceTxtFld.setText(String.valueOf(chosenProduct.getPrice()));
        prodMinTxtFld.setText(String.valueOf(chosenProduct.getMin()));
        prodMaxTxtFld.setText(String.valueOf(chosenProduct.getMax()));
        
        productAssociatedPartsTbl.setItems(productAssocParts);
        prodId.setCellValueFactory(new PropertyValueFactory<>("id"));
        prodName.setCellValueFactory(new PropertyValueFactory<>("name"));
        prodInvLvl.setCellValueFactory(new PropertyValueFactory<>("stock"));
        prodPriceCost.setCellValueFactory(new PropertyValueFactory<>("price"));
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
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initModality(Modality.NONE);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Confirm Part Deletion");
        alert.setContentText("Do you want to delete this part from the product?");
        Optional<ButtonType> result = alert.showAndWait();

        if(result.get() == ButtonType.OK)
        {   
            Part selectedTableViewPart = productAssociatedPartsTbl.getSelectionModel().getSelectedItem();
            System.out.println(selectedTableViewPart.getId());
            Product productToModify = Inventory.getAllFilteredProducts().get(0);
            productToModify.deleteAssociatedPart(selectedTableViewPart, productToModify);
        }
    }

    @FXML
    void onActionSaveProdBtn(ActionEvent event)
    {
        Product modProductToSave = Inventory.getAllFilteredProducts().get(0);
        
        Boolean invInputCorrect = Inventory.isInvInputCorrect(Integer.parseInt(prodMinTxtFld.getText()), 
                Integer.parseInt(prodMaxTxtFld.getText()),
                Integer.parseInt(prodInvTxtFld.getText()));
        
        Double minProductPrice = minProductValue(modProductToSave);
        Double enteredProdTotal = Double.parseDouble(prodPriceTxtFld.getText());
        Boolean isTotalCorrect = (enteredProdTotal >= minProductPrice);
        
        ObservableList<Part> currentProdAssociatedParts = productAssociatedPartsTbl.getItems();
        int associatedPartsCount = currentProdAssociatedParts.size();
        Boolean productHasParts = (associatedPartsCount >= 1);
        
        try
        {
            if(invInputCorrect == true && 
                    isTotalCorrect == true && 
                    productHasParts == true)
            {
                ObservableList<Part> associatedParts = productAssociatedPartsTbl.getItems();
                int prodId = Integer.parseInt(prodIdTxtFld.getText());
                String productName = prodNameTxtFld.getText();
                int prodInv = Integer.parseInt(prodInvTxtFld.getText());
                Double prodPrice = Double.parseDouble(prodPriceTxtFld.getText());
                int prodMin = Integer.parseInt(prodMinTxtFld.getText());
                int prodMax = Integer.parseInt(prodMaxTxtFld.getText());
                
                Product product = new Product(prodId,productName,prodPrice,prodInv,prodMin,prodMax);
                product.setAssociatedParts(partsList);
                modProductToSave.modifyProduct(product);
                
                stage = (Stage)((Button)event.getSource()).getScene().getWindow();
                scene = FXMLLoader.load(getClass().getResource("/View/MainMenu.fxml"));
                stage.setScene(new Scene(scene));
                stage.show();
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initModality(Modality.NONE);
                alert.setTitle("Input Error");
                alert.setHeaderText("Input Error");
                alert.setContentText("You either entered a price that is lower than the sum of the added parts to the product,"
                        + " the min inventory level is higher than the min inventory level, "
                        + "or the inventory level is not between the min/max item levels..");
                Optional<ButtonType> result = alert.showAndWait();
            }
        }
        catch(Exception c)
        {
            if(c.toString().contains("input string:"))
            {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.initModality(Modality.NONE);
                alert.setTitle("Warning");
                alert.setHeaderText("Input Error");
                alert.setContentText("You either entered a non-integer, incorrect Price in format 1.00, or null value. "
                        + "Please correct field input.");
                Optional<ButtonType> result = alert.showAndWait();
            }
        }
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
        productPartsTbl.setItems(Inventory.getAllParts());
        partId.setCellValueFactory(new PropertyValueFactory<>("id"));
        partName.setCellValueFactory(new PropertyValueFactory<>("name"));
        partInvLvl.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partPriceCost.setCellValueFactory(new PropertyValueFactory<>("price"));
    }
}
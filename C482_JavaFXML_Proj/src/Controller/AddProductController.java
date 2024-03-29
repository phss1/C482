/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Inventory;
import Model.Part;
import Model.Product;
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
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;

/**
 *
 * @author Pete.Heiss
 */
public class AddProductController implements Initializable
{
    Stage stage;
    Parent scene;
    ObservableList<Part> partsList = FXCollections.observableArrayList();
    
    @FXML
    private Label label;

    @FXML
    private Label label1;

    @FXML
    private TextField prodPartSearchTxtFld;

    @FXML
    private TableView<Part> productPartsTbl;

    @FXML
    private TableColumn<Part, Integer> partId;

    @FXML
    private TableColumn<Part, String> partName;

    @FXML
    private TableColumn<Part, Integer> partInv;

    @FXML
    private TableColumn<Part, Double> partPriceCost;

    @FXML
    private TableView<Part> productAssociatedPartsTbl;

    @FXML
    private TableColumn<Part, Integer> prodPartId;

    @FXML
    private TableColumn<Part, String> prodPartName;

    @FXML
    private TableColumn<Part, Integer> productInvLvl;

    @FXML
    private TableColumn<Part, Double> prodPriceCost;

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
    public void onActionAddPartBtn(ActionEvent event)
    {
        Part selectedTableViewPart = productPartsTbl.getSelectionModel().getSelectedItem();

        if(!(selectedTableViewPart.getName().equals(null)))
        {
            partsList.add(selectedTableViewPart);
            productAssociatedPartsTbl.setItems(partsList);
            prodPartId.setCellValueFactory(new PropertyValueFactory<>("id"));
            prodPartName.setCellValueFactory(new PropertyValueFactory<>("name"));
            productInvLvl.setCellValueFactory(new PropertyValueFactory<>("stock"));
            prodPriceCost.setCellValueFactory(new PropertyValueFactory<>("price"));
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initModality(Modality.NONE);
            alert.setTitle("Warning");
            alert.setHeaderText("Duplicate Part Added");
            alert.setContentText("You cannot add the same part twice to a product.");
            Optional<ButtonType> result = alert.showAndWait();
        }
    }
    
    @FXML
    public void onActionCancelBtn(ActionEvent event) throws IOException
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
    public void onActionDeleteBtn(ActionEvent event)
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
            deleteAssociatedPart(partsList, selectedTableViewPart.getId());
        }
    }
    
    public void deleteAssociatedPart(ObservableList<Part> partList, int partId)
    {
        int index = -1;
        for(Part currentPart : partList)
        {
            index++;
            if(currentPart.getId() == partId)
            {
                partList.remove(index);
            }
        }
    }

    @FXML
    public void onActionSaveProductBtn(ActionEvent event)
    {
        Product productToSave = new Product(Integer.parseInt(prodIdTxtFld.getText()), prodNameTxtFld.getText(),Double.parseDouble(prodPriceTxtFld.getText()), Integer.parseInt(prodInvTxtFld.getText()), Integer.parseInt(prodMinTxtFld.getText()), Integer.parseInt(prodMaxTxtFld.getText()));
        
        Boolean invInputCorrect = Inventory.isInvInputCorrect(Integer.parseInt(prodMinTxtFld.getText()), 
                Integer.parseInt(prodMaxTxtFld.getText()),
                Integer.parseInt(prodInvTxtFld.getText()));
        
        Double minProductPrice = minProductValue(productToSave);
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
                int prodId = Integer.parseInt(prodIdTxtFld.getText());
                String productName = prodNameTxtFld.getText();
                int prodInv = Integer.parseInt(prodInvTxtFld.getText());
                Double prodPrice = Double.parseDouble(prodPriceTxtFld.getText());
                int prodMin = Integer.parseInt(prodMinTxtFld.getText());
                int prodMax = Integer.parseInt(prodMaxTxtFld.getText());
                
                ObservableList<Part> associatedParts = productAssociatedPartsTbl.getItems();
                Product product = new Product(prodId,productName,prodPrice,prodInv,prodMin,prodMax);
                product.setAssociatedParts(partsList);
                Inventory.addProduct(product);
                
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
    
    public static Double minProductValue(Product product)
    {
        int index = -1;
        Double totalPrice = 0.00;
        for(Part currentPart : product.getAssociatedParts())
        {
            index++;
            totalPrice += currentPart.getPrice();
        }
        return totalPrice;
    }

    @FXML
    public void onActionSearchPartBtn(ActionEvent event)
    {
        int searchId = Integer.parseInt(prodPartSearchTxtFld.getText());
        Part searchedPart = Part.partSearch(searchId);
        
        productPartsTbl.getSelectionModel().select(searchedPart);
        partId.setCellValueFactory(new PropertyValueFactory<>("id"));
        partName.setCellValueFactory(new PropertyValueFactory<>("name"));
        partInv.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partPriceCost.setCellValueFactory(new PropertyValueFactory<>("price"));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        productPartsTbl.setItems(Inventory.getAllParts());
        partId.setCellValueFactory(new PropertyValueFactory<>("id"));
        partName.setCellValueFactory(new PropertyValueFactory<>("name"));
        partInv.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partPriceCost.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        int newPartId = Inventory.getPartIdCnt();
        prodIdTxtFld.setText(Integer.toString(newPartId));
        prodInvTxtFld.setText("0");
    }
}

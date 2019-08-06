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
    public void onActionAddPartBtn(ActionEvent event)
    {
        try
        {
            Part selectedTableViewPart = productPartsTbl.getSelectionModel().getSelectedItem();
            int currentPartId = selectedTableViewPart.getId();
            boolean partAlreadyAdded = wasPartAlreadyAdded(currentPartId);
            
            if(!selectedTableViewPart.getName().equals(null) && partAlreadyAdded == false)
            {   
                Product.addAssociatedPart(selectedTableViewPart);
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
        catch(Exception e)
        {
            if(e.toString().contains("java.lang.NullPointerException"))
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.initModality(Modality.NONE);
                alert.setTitle("Warning");
                alert.setHeaderText("Selection Error");
                alert.setContentText("Please select a part from the list before clicking the add part button.");
                Optional<ButtonType> result = alert.showAndWait();
            }
        }
    }
    
    public static boolean wasPartAlreadyAdded(int id)
    {
        int index = -1;
        for(Part currentPart : Product.getAssociatedParts())
        {
            index++;
            if(currentPart.getId() == id)
            {
                return true;
            }
        }
        return false;
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
            System.out.println(selectedTableViewPart.getId());
            Product.deleteAssociatedPart(selectedTableViewPart);
        }
    }

    @FXML
    public void onActionSaveProductBtn(ActionEvent event)
    {
        Boolean invInputCorrect = Inventory.isInvInputCorrect(Integer.parseInt(prodMinTxtFld.getText()), 
                Integer.parseInt(prodMaxTxtFld.getText()));
        
        Double minProductPrice = minProductValue();
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
                int prodMax = Integer.parseInt(prodMinTxtFld.getText());
                
                Product product = new Product(prodId,productName,prodPrice,prodInv,prodMin,prodMax);
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
                alert.setContentText("You either entered a price that is lower than the sum of the added parts to the product or "
                        + "the min inventory level is higher than the min inventory level.");
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
    
    public static Double minProductValue()
    {
        int index = -1;
        Double totalPrice = 0.00;
        for(Part currentPart : Product.getAssociatedParts())
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
        
        productAssociatedPartsTbl.setItems(Product.getAssociatedParts());
        prodPartId.setCellValueFactory(new PropertyValueFactory<>("id"));
        prodPartName.setCellValueFactory(new PropertyValueFactory<>("name"));
        productInvLvl.setCellValueFactory(new PropertyValueFactory<>("stock"));
        prodPriceCost.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        int newPartId = Inventory.getPartIdCnt();
        prodIdTxtFld.setText(Integer.toString(newPartId));
        prodInvTxtFld.setText("0");
    }
}

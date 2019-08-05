/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 39ds03d
 */
public class MainMenuController implements Initializable
{
    @FXML
    private Label label;

    @FXML
    private AnchorPane PartAnchorPane;

    @FXML
    private Button searchPartsBtn;

    @FXML
    private TextField PartSearchTxtLbl;

    @FXML
    private TableView<Part> PartsTable;

    @FXML
    private TableColumn<Part, Integer> PartIdCol;

    @FXML
    private TableColumn<Part, String> PartNameCol;

    @FXML
    private TableColumn<Part, Integer> PartInvLvlCol;

    @FXML
    private TableColumn<Part, Double> PartCostCol;

    @FXML
    private Button addPartBtn;

    @FXML
    private Button PartModifyBtn;

    @FXML
    private Button PartDeleteBtn;

    @FXML
    private AnchorPane ProductAnchorPane;

    @FXML
    private Button ProductSearchBtn;

    @FXML
    private TextField ProductSearchTxtLbl;

    @FXML
    private TableView<Product> ProductsTable;

    @FXML
    private TableColumn<Product, Integer> ProductIdCol;

    @FXML
    private TableColumn<Product, String> ProductNameCol;

    @FXML
    private TableColumn<Product, Integer> ProductInvLvlCol;

    @FXML
    private TableColumn<Product, Double> ProductCostCol;

    @FXML
    private Button addProductBtn;

    @FXML
    private Button modifyProductBtn;

    @FXML
    private Button deleteProductBtn;

    @FXML
    private Button ExitBtn;
    
    Stage stage;
    Parent scene;
    
    //misc methods
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        PartsTable.setItems(Inventory.getAllParts());
        PartIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        PartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        PartInvLvlCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        PartCostCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        ProductsTable.setItems(Inventory.getAllProducts());
        ProductIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        ProductNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        ProductInvLvlCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        ProductCostCol.setCellValueFactory(new PropertyValueFactory<>("price"));
    }
    
    public void exitProgram(ActionEvent event)
    {
        System.exit(0);
    }
    
    //Part methods
    public Part partSearch(int id)
    {
        int index = -1;
        for(Part currentPart : Inventory.getAllParts())
        {
            index++;
            if(currentPart.getId() == id)
            {
                return currentPart;
            }
        }
        return null;
    }
    
    public void modifySelectedPart(int id, Part part)
    {
        int index = -1;
        for(Part currentPart : Inventory.getAllParts())
        {
            index++;
            if(currentPart.getId() == id)
            {
                Inventory.getAllParts().set(index, currentPart);
            }
        }
    }
        
    public ObservableList<Part> filterParts(int id)
    {
        if(!(Inventory.getAllFilteredParts().isEmpty()))
            Inventory.getAllFilteredParts().clear();
        
        for(Part currentPart : Inventory.getAllParts())
        {
            if(currentPart.getId() == id)
            {
                Inventory.getAllFilteredParts().add(currentPart);
            }
        }
        return Inventory.getAllFilteredParts();
    }
    
    @FXML
    public void addPart(ActionEvent event) throws IOException
    {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/AddPart.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    public void deletePart(ActionEvent event)
    {
        Part selectedPart = PartsTable.getSelectionModel().getSelectedItem();
        Part.deletePart(selectedPart);
    }

    public void modifyPart(ActionEvent event) throws IOException
    {
        Part selectedTableViewPart = PartsTable.getSelectionModel().getSelectedItem();
        int selectedPartId = selectedTableViewPart.getId();
        
        filterParts(selectedPartId);
                
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/ModifyPart.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    public void searchParts(ActionEvent event) throws IOException
    {
        int searchId = Integer.parseInt(PartSearchTxtLbl.getText());
        Part searchedPart = partSearch(searchId);
        
        PartsTable.getSelectionModel().select(searchedPart);
        PartIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        PartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        PartInvLvlCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        PartCostCol.setCellValueFactory(new PropertyValueFactory<>("price"));
    }
    
    //product methods
    public void addProduct(ActionEvent event) throws IOException
    {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/AddProduct.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }
    
    public void modifyProduct(ActionEvent event) throws IOException
    {
        Product selectedTableViewProduct = ProductsTable.getSelectionModel().getSelectedItem();
        int selectedProductId = selectedTableViewProduct.getId();
        
        Product.filterProducts(selectedProductId);
        
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/ModifyProduct.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }
    
    public void deleteProduct(ActionEvent event)
    {
        Product selectedProduct = ProductsTable.getSelectionModel().getSelectedItem();
        Product.deleteProduct(selectedProduct);
    }
    
    public void searchProducts(ActionEvent event)
    {
        int searchId = Integer.parseInt(ProductSearchTxtLbl.getText());
        Product searchedProduct = Product.productSearch(searchId);
        
        ProductsTable.getSelectionModel().select(searchedProduct);
        PartIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        PartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        PartInvLvlCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        PartCostCol.setCellValueFactory(new PropertyValueFactory<>("price"));
    }
    
    /*  
    public void changeControllerScreen(String screenName) throws IOException
    {        
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/" + screenName + ".fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }
    */
}

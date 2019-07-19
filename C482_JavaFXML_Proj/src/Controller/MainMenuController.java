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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        PartsTable.setItems(Inventory.getAllParts());
        PartIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        PartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        PartInvLvlCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        PartCostCol.setCellValueFactory(new PropertyValueFactory<>("price"));
    }
    
    @FXML
    void addPart(ActionEvent event) throws IOException
    {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/AddPart.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    void addProduct(MouseEvent event)
    {
        
    }

    void deletePart(MouseEvent event)
    {
        
    }

    void deleteProduct(MouseEvent event)
    {
        
    }

    void exitProgram(MouseEvent event)
    {
        
    }

    void modifyPart(MouseEvent event)
    {
        
    }

    void modifyProduct(MouseEvent event)
    {
        
    }

    void searchParts(MouseEvent event)
    {
        
    }

    void searchProducts(MouseEvent event)
    {
        
    }
    
    
}

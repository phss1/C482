/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;

/**
 * FXML Controller class
 *
 * @author 39ds03d
 */
public class MainMenuController implements Initializable {

    @FXML
    private Button PartSearchBtn;

    @FXML
    private TextField PartSearchTxtLbl;

    @FXML
    private TableView<?> PartsTable;

    @FXML
    private TableColumn<?, ?> PartIdCol;

    @FXML
    private TableColumn<?, ?> PartNameCol;

    @FXML
    private TableColumn<?, ?> PartInvLvlCol;

    @FXML
    private TableColumn<?, ?> PartCostCol;

    @FXML
    private Button PartAddBtn;

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
    private TableView<?> ProductsTable;

    @FXML
    private TableColumn<?, ?> ProductIdCol;

    @FXML
    private TableColumn<?, ?> ProductNameCol;

    @FXML
    private TableColumn<?, ?> ProductInvLvlCol;

    @FXML
    private TableColumn<?, ?> ProductCostCol;

    @FXML
    private Button ProductAddBtn;

    @FXML
    private Button ProductModifyBtn;

    @FXML
    private Button ProductDeleteBtn;

    @FXML
    private Button ExitBtn;

    @FXML
    void ExitProgramButton(ActionEvent event) {

    }

    @FXML
    void PartAddButton(ActionEvent event) {

    }

    @FXML
    void PartDeleteButton(ActionEvent event) {

    }

    @FXML
    void PartModifyButton(ActionEvent event) throws IOException {
        
        Stage stage; 
        Parent root;       
        stage=(Stage) ExitBtn.getScene().getWindow();
        //load up OTHER FXML document
        FXMLLoader loader=new FXMLLoader(getClass().getResource("ModifyPart.fxml"));
        root =loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void PartSearchButton(ActionEvent event) {

    }

    @FXML
    void ProductAddButton(ActionEvent event) throws IOException {
        
        Stage stage; 
        Parent root;       
        stage=(Stage) ExitBtn.getScene().getWindow();
        //load up OTHER FXML document
        FXMLLoader loader=new FXMLLoader(getClass().getResource("AddProduct.fxml"));
        root =loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    void ProductDeleteButton(ActionEvent event) {

    }

    @FXML
    void ProductModifyButton(ActionEvent event) throws IOException {
        
        Stage stage; 
        Parent root;       
        stage=(Stage) ProductModifyBtn.getScene().getWindow();
        //load up OTHER FXML document
        FXMLLoader loader=new FXMLLoader(getClass().getResource("ModifyProduct.fxml"));
        root =loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void ProductSearchButton(ActionEvent event) {

    }


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}

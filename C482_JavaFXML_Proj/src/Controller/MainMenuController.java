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
public class MainMenuController implements Initializable
{
    
    Stage stage;
    Parent scene;
    
    @FXML
    void onActionPartAddButton(ActionEvent event) throws IOException
    {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/AddPart.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }
    
    @FXML
    void onActionExitProgramButton(ActionEvent event)
    {

    }

    @FXML
    void onActionPartDeleteButton(ActionEvent event)
    {

    }

    @FXML
    void onActionPartModifyButton(ActionEvent event) throws IOException
    {
        
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
    void onActionPartSearchButton(ActionEvent event)
    {

    }

    @FXML
    void onActionProductAddButton(ActionEvent event) throws IOException
    {
        
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
    void onActionProductDeleteButton(ActionEvent event)
    {

    }
    
    @FXML
    void onActionProductModifyButton(ActionEvent event) throws IOException
    {
        
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
    void ProductSearchButton(ActionEvent event)
    {

    }
            
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}

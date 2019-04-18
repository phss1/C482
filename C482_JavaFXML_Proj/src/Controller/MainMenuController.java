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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Pete.Heiss
 */
public class MainMenuController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private AnchorPane PartAnchorPane;
    @FXML
    private Button PartSearchButton;
    @FXML
    private TextField PartSearchTextLabel;
    @FXML
    private TableView<?> PartsTable;
    @FXML
    private TableColumn<?, ?> PartIDTableColumn;
    @FXML
    private TableColumn<?, ?> PartNameTableColumn;
    @FXML
    private TableColumn<?, ?> PartInvLvlTableColumn;
    @FXML
    private TableColumn<?, ?> PartCostTableColumn;
    @FXML
    private Button PartAddButton;
    @FXML
    private Button PartModifyButton;
    @FXML
    private Button PartDeleteButton;
    @FXML
    private AnchorPane ProductAnchorPane;
    @FXML
    private Button ProductSearchButton;
    @FXML
    private TextField ProductSearchTxtLbl;
    @FXML
    private TableView<?> ProductsTable;
    @FXML
    private TableColumn<?, ?> ProductIDTableColumn;
    @FXML
    private TableColumn<?, ?> ProductNameTableColumn;
    @FXML
    private TableColumn<?, ?> ProductInvLvlTableColumn;
    @FXML
    private TableColumn<?, ?> ProductCostTableColumn;
    @FXML
    private Button ProductAddButton;
    @FXML
    private Button ProductModifyButton;
    @FXML
    private Button ProductDeleteButton;
    @FXML
    private Button ExitProgramButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void PartSearchButton(ActionEvent event)
    {  
        
    }

    @FXML
    private void PartAddButton(ActionEvent event) throws IOException
    {
        Stage stage; 
        Parent root;       
        stage=(Stage) Exit.getScene().getWindow();
        //load up OTHER FXML document
        FXMLLoader loader=new FXMLLoader(getClass().getResource("AddPart.fxml"));
        root =loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void PartModifyButton(ActionEvent event) {
    }

    @FXML
    private void PartDeleteButton(ActionEvent event) {
    }

    @FXML
    private void ProductSearchButton(ActionEvent event) {
    }

    @FXML
    private void ProductAddButton(ActionEvent event) {
    }

    @FXML
    private void ProductModifyButton(ActionEvent event) {
    }

    @FXML
    private void ProductDeleteButton(ActionEvent event) {
    }

    @FXML
    private void ExitProgramButton(ActionEvent event) {
    }
    
}

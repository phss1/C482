package Controller;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import Controller.AddPartController;

public class MainMenuController
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
    private Button addProductBtn;

    @FXML
    private Button modifyProductBtn;

    @FXML
    private Button deleteProductBtn;

    @FXML
    private Button ExitBtn;

    @FXML
    void addPart(MouseEvent event)
    {
        try
        {
            String inv = "";
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/AddPart.fxml"));
            AddPartController controller = new AddPartController(inv);
            
            loader.setLoader(controller));
            
        }
        catch (IOException c)
        {
            
        }
    }

    @FXML
    void addProduct(MouseEvent event)
    {
        
    }

    @FXML
    void deletePart(MouseEvent event)
    {
        
    }

    @FXML
    void deleteProduct(MouseEvent event)
    {
        
    }

    @FXML
    void exitProgram(MouseEvent event)
    {
        
    }

    @FXML
    void modifyPart(MouseEvent event)
    {
        
    }

    @FXML
    void modifyProduct(MouseEvent event)
    {
        
    }

    @FXML
    void searchParts(MouseEvent event)
    {
        
    }

    @FXML
    void searchProducts(MouseEvent event)
    {
        
    }

    /**
     * Initializes the controller class.
     */
    //@Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    
}

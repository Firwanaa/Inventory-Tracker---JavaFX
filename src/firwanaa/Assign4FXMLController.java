/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firwanaa;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author QQ
 */
public class Assign4FXMLController implements Initializable {

    /**
     * Assigning UI components to variables
     */
    @FXML
    private TextField txtf1, txtf2, txtf3, txtf4, txtf5;
    @FXML
    private Label lbl1, lbl2, lbl3, lbl4, lbl5;
    @FXML
    private TextField[] txtFields;
    @FXML
    private Label lblBelow;
    @FXML
    private ListView<Inventory> listView;
    @FXML
    private Button BtnAdd, BtnSave, BtnOrders, BtnExit;

    /**
     * Instantiating InvetoryList Object
     */
    InventoryList invList = new InventoryList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /**
         * * Setting text for Labels using Enum Class.
         */

        lbl1.setText(Fields.ITEM_ID.getCaption());
        lbl2.setText(Fields.ITEM_NAME.getCaption());
        lbl3.setText(Fields.QOH.getCaption());
        lbl4.setText(Fields.ROP.getCaption());
        lbl5.setText(Fields.PRICE.getCaption());

        /**
         * Array of TextFields
         */
        txtFields = new TextField[]{txtf1, txtf2, txtf3, txtf4, txtf5};

        /**
         * Add Button method that unlock the text fields and Locks save and
         * orders buttons
         */
        BtnAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                for (TextField txtField : txtFields) {
                    txtField.setEditable(true);
                    txtField.setText("");
                }
                BtnAdd.setDisable(true);
                BtnSave.setDisable(false);
                BtnOrders.setDisable(true);
            }
        });
        /**
         * Save Button method to get text and set it to inventory object fields,
         * Add the object to the InventoryList, Enabling Add and Orders Buttons,
         * And Validating user Input and send an alert with error message.
         */
        BtnSave.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                try {
                    Inventory inv1 = new Inventory();
                    inv1.setId(txtf1.getText());
                    inv1.setName(txtf2.getText());
                    inv1.setQoh(Integer.parseInt(txtf3.getText()));
                    inv1.setRop(Integer.parseInt(txtf4.getText()));
                    inv1.setSellPrice(Double.parseDouble(txtf5.getText()));
                    invList.add(inv1);
                } catch (Exception e1) {
                    String err1 = e1.getMessage();
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Error Message");
                    alert.setHeaderText("Please note: ");
                    alert.setContentText(err1);
                    alert.showAndWait();
                }
                BtnOrders.setDisable(false);
                BtnAdd.setDisable(false);
            }
        });

        /**
         * Orders method that use For-Loop to display items that need to be
         * re-ordered, Change the bottom label text when needed, and Enables
         * Save button and disables Orders button.
         *
         */
        BtnOrders.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {

                for (int i = 0; i < invList.length(); i++) {
                    if (invList.get(i).getRop() >= invList.get(i).getQoh()) {
                        listView.getItems().add(invList.get(i));
                    }

                }

                if (invList.length() == 0) {
                    lblBelow.setText("No items to list. Add Some!");
                }
                for (int i = 0; i < invList.length(); i++) {
                    if (invList.get(i).getRop() < invList.get(i).getQoh()) {
                        lblBelow.setText("No items to re-order.");
                    } else {
                        lblBelow.setText("");

                    }
                }
                BtnSave.setDisable(false);
                BtnOrders.setDisable(true);
            }
        });
        
        /**
         * Exit button method that shows conformation message before exiting the program.
         */
        BtnExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Exit");
                alert.setHeaderText("Do you want to Exit? ");
                alert.setContentText("Click Yes to Exit or No To Go Back");
                ButtonType okButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
                ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.NO);
                alert.getButtonTypes().setAll(okButton, noButton);
                alert.showAndWait().ifPresent(type -> {
                    if (type == okButton) {
                        System.exit(0);
                    } else if (type == noButton) {
                    } else {
                    }
                });
            }
        });

        /**
         * ObsevableList that Fire Event when click on ListView Items, and change the text on bottom label to Re-order point value.
         */
        ObservableList<Inventory> obsInvList = FXCollections.observableArrayList();
        listView.setItems(obsInvList);
        listView.getSelectionModel().selectedItemProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable o) {
              
                int i = listView.getSelectionModel().getSelectedIndex();
                lblBelow.setText("Re-Order Point: " + invList.get(i).getRop());
            }
        });
    }

}

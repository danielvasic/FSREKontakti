/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontakti.controller;

import java.awt.event.MouseEvent;
import kontakti.model.KontaktModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Daniel
 */
public class KontaktiController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    TableView kontaktiTbl;
    @FXML
    TableColumn imeTblCol;
    @FXML
    TableColumn prezimeTblCol;
    @FXML
    TableColumn emailTblCol;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<KontaktModel> data = KontaktModel.listaKontakata();
        imeTblCol.setCellValueFactory(new PropertyValueFactory<KontaktModel, String>("Ime"));
        prezimeTblCol.setCellValueFactory(new PropertyValueFactory<KontaktModel, String>("Prezime"));
        emailTblCol.setCellValueFactory(new PropertyValueFactory<KontaktModel, String>("Email"));
        kontaktiTbl.setItems(data);

    }

}

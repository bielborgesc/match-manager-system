package view.controller;

import java.net.URL;
import java.util.ResourceBundle;

import domain.entities.championship.CategoryEnum;
import domain.entities.championship.Championship;
import domain.entities.championship.TypeEnum;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.DataFormat;

public class ChampionshipManagementController implements Initializable {
    @FXML
    private TableView<Championship> tableViewChampionships;
    @FXML
    private TableColumn<Championship, Integer> tColumnID;
    @FXML
    private TableColumn<Championship, String> tColumnName;
    @FXML
    private TableColumn<Championship, DataFormat> tColumnData;
    @FXML
    private TableColumn<Championship, TypeEnum> tColumnSport;
    @FXML
    private TableColumn<Championship, CategoryEnum> tColumnType;

    @FXML
    private Button btVoltar;
    @FXML
    private Button btDeletar;
    @FXML
    private Button btDetalhar;
    @FXML
    private Button btEditar;
    @FXML
    private Button btNovo;

    @FXML
    private void onbtVoltar() {
        
    }

    @FXML
    private void onbtDeletar() {
        
    }

    @FXML
    private void onbtDetalhar() {
        
    }

    @FXML
    private void onbtEditar() {
        
    }

    @FXML
    private void onbtNovo() {
        
    }





    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeNodes();
    }    

    private void initializeNodes(){
        tColumnID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tColumnData.setCellValueFactory(new PropertyValueFactory<>("date"));
        tColumnSport.setCellValueFactory(new PropertyValueFactory<>("typeEnun"));
        tColumnType.setCellValueFactory(new PropertyValueFactory<>("categoryEnun"));
    }
}

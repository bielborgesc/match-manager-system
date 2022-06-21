package view.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.DataFormat;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import domain.entities.championship.CategoryEnum;
import domain.entities.championship.Championship;
import domain.entities.championship.TypeEnum;

import static application.main.Main.*;

public class ChampionshipUserUIController implements Initializable {

    @FXML
    private TableView<Championship> tableViewChampionships;
    @FXML
    private TableColumn<Championship, Integer> tColumnID;
    @FXML
    private TableColumn<Championship, String> tColumnName;
    @FXML
    private TableColumn<Championship, Date> tColumnData;
    @FXML
    private TableColumn<Championship, TypeEnum> tColumnSport;
    @FXML
    private TableColumn<Championship, CategoryEnum> tColumnType;

    SimpleDateFormat dateFormat;

    private ObservableList<Championship> championshipsList;



    public void detailChampionship(ActionEvent actionEvent) {
    }

    public void createChampionship(ActionEvent actionEvent) {
    }

    public void backToPreviousScene(ActionEvent event) throws IOException{
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void updateTableView(){
        List<Championship> list = findChampionshipUseCase.findAll();
        championshipsList = FXCollections.observableArrayList(list);
        tableViewChampionships.setItems(championshipsList);
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeNodes();
        updateTableView();
    }     

    private void initializeNodes(){
        tColumnID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tColumnData.setCellValueFactory(new PropertyValueFactory<>("date"));
        tColumnSport.setCellValueFactory(new PropertyValueFactory<>("typeEnum"));
        tColumnType.setCellValueFactory(new PropertyValueFactory<>("categoryEnum"));
        tColumnData.setCellFactory(column -> {
            TableCell<Championship, Date> cell = new TableCell<Championship, Date>() {
                private SimpleDateFormat format = new SimpleDateFormat("dd / MM / yyyy");
    
                @Override
                protected void updateItem(Date item, boolean empty) {
                    super.updateItem(item, empty);
                    if(empty) {
                        setText(null);
                    }
                    else {
                        this.setText(format.format(item));
    
                    }
                }
            };
    
            return cell;
        });
    }

        
    


}

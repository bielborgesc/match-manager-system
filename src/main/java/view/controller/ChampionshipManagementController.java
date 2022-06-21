package view.controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import domain.entities.championship.CategoryEnum;
import domain.entities.championship.Championship;
import domain.entities.championship.TypeEnum;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.Node;

import static application.main.Main.*;

public class ChampionshipManagementController implements Initializable {

    private ObservableList<Championship> championshipsList;

    @FXML
    private TableView<Championship> tableViewChampionships;
    @FXML
    private TableColumn<Championship, Integer> tColumnID;
    @FXML
    private TableColumn<Championship, String> tColumnName;

    SimpleDateFormat dateFormat;
    @FXML
    private TableColumn<Championship, Date> tColumnData;
    @FXML
    private TableColumn<Championship, TypeEnum> tColumnSport;
    @FXML
    private TableColumn<Championship, CategoryEnum> tColumnType;
    @FXML
    private TableColumn<Championship, Championship> tColumnEdit;

    @FXML
    private TableColumn<Championship, Championship> tColumnDelete;

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
    private void onbtVoltar(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }


    @FXML
    private void onbtNovo(ActionEvent event) {

    }

    public void updateTableView() {
        List<Championship> list = findChampionshipUseCase.findAll();
        championshipsList = FXCollections.observableArrayList(list);
        tableViewChampionships.setItems(championshipsList);
    }

    private void initEditButtons() {
        tColumnEdit.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        tColumnEdit.setCellFactory(param -> new TableCell<Championship, Championship>() {
            private final Button button = new Button(" Editar ");

            @Override
            protected void updateItem(Championship obj, boolean empty) {
                super.updateItem(obj, empty);
                if (obj == null) {
                    setGraphic(null);
                    return;
                }
                setGraphic(button);
                button.setOnAction(
                        event -> System.out.println("Table edit"));
            }
        });
        tColumnDelete.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        tColumnDelete.setCellFactory(param -> new TableCell<Championship, Championship>() {
            private final Button button = new Button(" Deletar ");

            @Override
            protected void updateItem(Championship obj, boolean empty) {
                super.updateItem(obj, empty);
                if (obj == null) {
                    setGraphic(null);
                    return;
                }
                setGraphic(button);
                button.setOnAction(
                        event -> System.out.println("Table Delete"));
            }
        });
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeNodes();
        initEditButtons();
        updateTableView();
    }

    private void initializeNodes() {
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
                    if (empty) {
                        setText(null);
                    } else {
                        this.setText(format.format(item));

                    }
                }
            };

            return cell;
        });
    }
}

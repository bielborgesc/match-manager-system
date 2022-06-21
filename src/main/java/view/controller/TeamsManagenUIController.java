package view.controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;


import domain.entities.championship.TypeEnum;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.Node;

import domain.entities.team.Team;

import static application.main.Main.*;

public class TeamsManagenUIController implements Initializable {

    private ObservableList<Team> teamList;


    @FXML
    private TableView<Team> tableViewTeam;
    @FXML
    private TableColumn<Team, Integer> tColumnID;
    @FXML
    private TableColumn<Team, String> tColumnName;
    @FXML
    private TableColumn<Team, Team> tColumnEdit;

    @FXML
    private TableColumn<Team, Team> tColumnDelete;




    public void updateTableView(){
        List<Team> list = findTeamUseCase.findAll();
        teamList = FXCollections.observableArrayList(list);
        tableViewTeam.setItems(teamList);;
        initEditDeleteButtons();
    }


    private void initEditDeleteButtons() {
        tColumnEdit.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        tColumnEdit.setCellFactory(param -> new TableCell<Team, Team>() {
            private final Button button = new Button(" Editar ");

            @Override
            protected void updateItem(Team obj, boolean empty) {
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
        tColumnDelete.setCellFactory(param -> new TableCell<Team, Team>() {
            private final Button button = new Button(" Deletar ");

            @Override
            protected void updateItem(Team obj, boolean empty) {
                super.updateItem(obj, empty);
                if (obj == null) {
                    setGraphic(null);
                    return;
                }
                setGraphic(button);
                button.setOnAction(
                        event -> removeEntity(obj));
            }
        });
        
    }

    private void removeEntity(Team obj) {
		Optional<ButtonType> result = Alerts.showConfirmation("Confirmação", "Você quer mesmo deletar?");

		if (result.get() == ButtonType.OK) {

				removeTeamUseCase.remove(obj);
				updateTableView();
			
		}
	}

    @FXML
    public void backToPreviousScene(ActionEvent event) {
        Stage thisstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        thisstage.close();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeNodes();
        updateTableView();
    }

    private void initializeNodes(){
        tColumnID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        tColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
    }
 
}

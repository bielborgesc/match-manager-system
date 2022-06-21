package view.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.control.cell.PropertyValueFactory;

import domain.entities.team.Team;

import static application.main.Main.*;

public class TeamsUserUIController implements Initializable {

    private ObservableList<Team> teamList;

    @FXML
    private TableView<Team> tableViewTeam;
    @FXML
    private TableColumn<Team, Integer> tColumnID;
    @FXML
    private TableColumn<Team, String> tColumnName;

    public void updateTableView() {
        List<Team> list = findTeamUseCase.findAll();
        teamList = FXCollections.observableArrayList(list);
        tableViewTeam.setItems(teamList);
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

    private void initializeNodes() {
        tColumnID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        tColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
    }

}

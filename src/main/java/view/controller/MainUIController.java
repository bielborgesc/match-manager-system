package view.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainUIController {

    @FXML
    private Button btAdmin;

    @FXML
    private Button btTeams;

    @FXML
    private Button btChampionship;

    @FXML
    private void onBtAdminAction(ActionEvent event) throws IOException {
        Stage thisstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        loadView("/view/AdminAuthentication.fxml", "Login Administrador", thisstage);

    }

    @FXML
    private void onbtChampionship(ActionEvent event) throws IOException {
        Stage thisstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        loadView("/view/ChampionshipUserUI.fxml", "Campeonatos", thisstage);

    }

    @FXML
    private void onbtTeams(ActionEvent event) throws IOException {
        Stage thisstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        loadView("/view/TeamsUserUI.fxml", "Times", thisstage);

    }

    public void loadView(String absoluteName, String windowName, Stage fatherStage) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
        Parent parent = loader.load();
        Stage newStage = new Stage();
        Scene newsScene = new Scene(parent);
        newStage.setScene(newsScene);
        newStage.setTitle(windowName);
        newStage.setResizable(false);
        newStage.initOwner(fatherStage);
        newStage.initModality(Modality.WINDOW_MODAL);
        newStage.show();
    }

}

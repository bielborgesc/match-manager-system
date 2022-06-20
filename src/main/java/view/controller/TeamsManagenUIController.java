package view.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class TeamsManagenUIController {
    public void deleteTeams(ActionEvent actionEvent) {
    }

    public void editTeams(ActionEvent actionEvent) {
    }

    public void detailTeams(ActionEvent actionEvent) {
    }

    public void createTeams(ActionEvent actionEvent) {
    }

    public void backToPreviousScene(ActionEvent event) throws IOException {
        Stage thisstage = (Stage) ((Node) event.getSource()).getScene().getWindow().getOnCloseRequest();
        loadView("/view/MainUI.fxml", thisstage);

    }

    public void loadView(String absoluteName, Stage thisstage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
        Parent parent = loader.load();
        Stage newStage = new Stage();
        Scene newsScene = new Scene(parent);
        newStage.setScene(newsScene);
        newStage.setResizable(false);
        newStage.initModality(Modality.WINDOW_MODAL);
        newStage.show();
    }
}

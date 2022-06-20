package view;

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
    private Button btUserChamp;

    @FXML
    private Button btUserTimes;

    @FXML
    private void onBtAdminAction(ActionEvent event) throws IOException {
        Stage thisstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        loadView("/view/AdminAuthentication.fxml", "Login Administrador", thisstage);
    }

    @FXML
    private void onBtChampionshipActionUser(ActionEvent event) throws IOException {
        Stage thisstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        loadView("/view/ChampionshipUserUI.fxml", "Campeonatos", thisstage);
    }

    @FXML
    private void onBtTimesActionUser(ActionEvent event) throws IOException {
        Stage thisstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        loadView("/view/TeamsUserUI.fxml", "Times", thisstage);
    }

    @FXML
    private void onBtChampionshipAction(ActionEvent event) throws IOException {
        Stage thisstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        loadView("/view/ChampionshipManagementUI.fxml", "Campeonatos", thisstage);

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

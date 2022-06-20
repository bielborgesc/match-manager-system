package view;

import java.io.IOException;

import application.main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Node;

/**
 * AdminManagementController
 */
public class AdminManagementController {

    @FXML
    private Button btTeams;
    @FXML
    private Button btChampionship;

    @FXML
    private void onbtChampionship(ActionEvent event) throws IOException{
        Main main = new Main();
        Stage nStage = main.changeScene("/view/ChampionshipManagementUI.fxml");
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        nStage.initOwner(thisStage); 
        nStage.initModality(Modality.WINDOW_MODAL); 
        nStage.setResizable(false);        
        nStage.show();
    }
    @FXML
    private void onbtTeams(ActionEvent event) throws IOException{
        Main main = new Main();
        Stage nStage = main.changeScene("/view/TeamManagementUI.fxml");
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        nStage.initOwner(thisStage); 
        nStage.initModality(Modality.WINDOW_MODAL); 
        nStage.setResizable(false);        
        nStage.show();
    }
}
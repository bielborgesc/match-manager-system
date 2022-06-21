package view.controller;

import java.io.IOException;

import application.main.Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Node;


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
        Stage nStage = main.changeScene("/view/TeamsManagementUI.fxml");
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        nStage.initOwner(thisStage); 
        nStage.initModality(Modality.WINDOW_MODAL); 
        nStage.setResizable(false);        
        nStage.show();
    }
}
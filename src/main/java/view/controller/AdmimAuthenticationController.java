package view.controller;

import java.io.IOException;

import application.main.Main;
import domain.entities.admin.Admin;
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

import static application.main.Main.*;

public class AdmimAuthenticationController {

    @FXML
    private Button btEntrar;
    @FXML
    private Button btVoltar;
    @FXML
    private PasswordField password;
    @FXML
    private TextField userName;

    @FXML

    private void onbtEntrar(ActionEvent event) throws IOException {
        if (checkUserPassword()) {

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    private void onbtVoltar(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    private boolean checkUserPassword() throws IOException {
        Main main = new Main();
        Admin thisAdmin;
        try {
            thisAdmin = findAdminUseCase.findOne(userName.getText()).orElseThrow();
            String passInserted = password.getText().toString();
            String passSelected = thisAdmin.getPassword().toString();
            if (passInserted.equals(passSelected)) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Sucesso");
                alert.setContentText("Login bem sucedido");
                Stage nStage = main.changeScene("/view/AdminManagementUI.fxml");
                nStage.initOwner(main.getPrimaryScene().getWindow());
                nStage.setResizable(false);
                nStage.initModality(Modality.WINDOW_MODAL);
                nStage.show();
                alert.show();
                return true;
            } else {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Usuário ou senha incorretos");
                alert.setContentText("Verifique sua senha ou seu usuário");
                alert.show();
                return false;
            }
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Usuário ou senha incorretos");
            alert.setContentText("Verifique sua senha ou seu usuário");
            alert.show();
            return false;
        }
    }
}

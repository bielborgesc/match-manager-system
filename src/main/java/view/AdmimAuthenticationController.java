package view;

import java.io.IOException;

import application.main.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

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
    private void onbtEntrar() throws IOException {
       checkUserPassword();

    }

    private void checkUserPassword() throws IOException {
        Main main = new Main();
        if (userName.getText().toString().equals("Jose") && password.getText().toString().equals("123")) {
            main.changeScene("/view/ChampionshipManagentUI.fxml");
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Usuário ou senha incorretos");
            alert.setContentText("Verifique sua senha ou seu usuário");
            alert.show();
        }
    }

}

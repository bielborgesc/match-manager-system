package view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainUIController {

    @FXML
    private Button btAdmin;

    @FXML
    private void onBtAdminAction() throws IOException{
        loadView("/view/AdminAuthentication.fxml", "Login Administrador");
   
    }
    private void loadView(String absoluteName, String windowName) throws IOException{
     
        FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
        Parent parent = loader.load();
        Stage newStage = new Stage();
        Scene newsScene = new Scene(parent);
        newStage.setScene(newsScene);
        newStage.setTitle(windowName);
        newStage.show();
    }

}



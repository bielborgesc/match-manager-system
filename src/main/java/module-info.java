module  application.main{

    requires javafx.controls;
    requires javafx.fxml;

    opens application.main to javafx.fxml;
 
    opens view to javafx.fxml;
    exports view to javafx.fxml;
    exports application.main to javafx.graphics;
    exports view.controller to javafx.fxml;
    opens view.controller to javafx.fxml;


}

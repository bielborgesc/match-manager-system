module  application.view{

    requires javafx.controls;
    requires javafx.fxml;

    opens application.main to javafx.fxml;

    exports application.main;
}

module  application.view{

    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.xerial.sqlitejdbc;

    opens application.main to javafx.fxml;

    exports application.main;
}

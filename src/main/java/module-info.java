module  application.main{

    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.xerial.sqlitejdbc;

    opens application.main to javafx.fxml;
 

    exports application.main to javafx.graphics;
    exports view.controller to javafx.fxml;
    opens view.controller to javafx.fxml;
    opens domain.entities.championship to javafx.base;
    opens domain.entities.team to javafx.base;

}

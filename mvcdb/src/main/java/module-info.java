module com.mvcdb {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.mvcdb to javafx.graphics;
    opens com.mvcdb.controller to javafx.fxml;
    opens com.mvcdb.model to javafx.fxml;
}

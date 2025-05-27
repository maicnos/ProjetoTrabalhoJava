module org.example.projetotrabalhojava {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;


    opens app.controller to javafx.graphics, java.fx.controls, javafx.fxml;
    opens app.model;
    exports app;
}
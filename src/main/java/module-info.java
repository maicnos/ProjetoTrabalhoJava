module org.example.projetotrabalhojava {
    requires javafx.controls;
    requires javafx.fxml;


    opens br.com.app.tarefas to javafx.fxml;
    exports br.com.app.tarefas;
    exports br.com.app.tarefas.controller;
    opens br.com.app.tarefas.controller to javafx.fxml;
}
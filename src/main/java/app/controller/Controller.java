package app.controller;

import app.dao.DAO;
import app.model.Tarefa;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;


public class Controller {

    @FXML
    private Button butn_ad;

    @FXML
    private Button butn_del;

    @FXML
    private Button butn_ed;

    @FXML
    private TextArea idDescricao;

    @FXML
    private Label idLabelError;

    @FXML
    private DatePicker idPrazo;

    @FXML
    private ComboBox<String> idPrioridade;

    @FXML
    private TextField idTitulo;

    @FXML
    private CheckBox id_IsConcluido;

    @FXML
    private TableView<Tarefa> tabelaTarefas;

    private ObservableList<Tarefa> tarefasData;

    @FXML
    void butn_ad_adicionar(ActionEvent event) {
        try {
            Tarefa nova_tarefa = DAO.getTarefa().create(new Tarefa(this.idTitulo.getText(),
                    this.idDescricao.getText(), this.idPrazo.getValue(),
                    this.idPrioridade.getValue(),
                    this.id_IsConcluido.isSelected()));



            this.tarefasData.add(nova_tarefa);
            //this.tarefasData.addAll(DAO.getTarefa().read());

        } catch (Exception e) {
            this.idLabelError.setText("Um erro aconteceu!");
            System.out.println(e);
        }

        this.idTitulo.clear();
        this.idDescricao.clear();
        this.idPrazo.setValue(null);
        this.idPrioridade.setValue("Prioridade");
        this.id_IsConcluido.setSelected(false);
    }

    @FXML
    void butn_del_deletar(ActionEvent event) {

    }

    @FXML
    void butn_ed_editar(ActionEvent event) {

    }

    @FXML
    public void initialize() {
        idPrioridade.getItems().addAll(
                "Alta",
                "Normal",
                "Baixa"
        );

        this.tarefasData = FXCollections.observableArrayList();
        //this.tarefasData.addAll(DAO.getTarefa().read());

        TableColumn columnTitulo = new TableColumn<>("Tarefa");
        TableColumn columnPrazo = new TableColumn<>("Prazo");
        TableColumn columnPrioridade = new TableColumn<>("Prioridade");
        TableColumn columnDescricao = new TableColumn<>("Descrição");
        TableColumn columnStatus = new TableColumn("Status");

        columnTitulo.setCellValueFactory(new PropertyValueFactory<Tarefa,String>("titulo"));
        columnPrazo.setCellValueFactory(new PropertyValueFactory<Tarefa,LocalDate>("prazo"));
        columnPrioridade.setCellValueFactory(new PropertyValueFactory<Tarefa,String>("prioridade"));
        columnDescricao.setCellValueFactory(new PropertyValueFactory<Tarefa,String>("descricao"));
        columnStatus.setCellValueFactory(new PropertyValueFactory<Tarefa,String>("status"));

        this.tabelaTarefas.getColumns().addAll(columnTitulo,columnPrazo,columnPrioridade,columnDescricao,columnStatus);
        this.tabelaTarefas.setItems(tarefasData);



    }
}
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



    private ObservableList<Tarefa> tarefasData; // Lista observável para exibir as tarefas na tabela

    private Tarefa tarefaSelecionada; // Armazena a tarefa atualmente selecionada na tabela

    @FXML
    void butn_ad_adicionar(ActionEvent event) { // Método chamado ao clicar no botão "Adicionar"
        try {

            Tarefa nova_tarefa = DAO.getTarefa().create(new Tarefa(this.idTitulo.getText(),
                    this.idDescricao.getText(), this.idPrazo.getValue(),
                    this.idPrioridade.getValue(),
                    this.id_IsConcluido.isSelected()));



            this.tarefasData.add(nova_tarefa);  // Adiciona na tabela
            //this.tarefasData.addAll(DAO.getTarefa().read());

        } catch (Exception e) {
            this.idLabelError.setText("Um erro aconteceu!"); // Exibe erro na label caso algo falhe
            System.out.println(e);
        }

        // Limpa os campos da interface após o cadastro
        this.idTitulo.clear();
        this.idDescricao.clear();
        this.idPrazo.setValue(null);
        this.idPrioridade.setValue("Prioridade");
        this.id_IsConcluido.setSelected(false);
    }

    @FXML
    void butn_del_deletar(ActionEvent event) { // Método chamado ao clicar no botão "Deletar"
        try {

            idLabelError.setText("A tarefa "
                    + tarefaSelecionada.getTitulo()
                    + " foi removida."); // Exibe mensagem de remoção

            DAO.getTarefa().delete(tarefaSelecionada.getId()); // Remove a tarefa do DAO

            tarefasData.remove(tarefaSelecionada); // Remove a tarefa da tabela visível

            //DAO.getTarefa().read();

        } catch (Exception e) {
            System.out.println(e);
            idLabelError.setText("Aconteceu algum erro.");
        }

    }

    @FXML
    void butn_ed_editar(ActionEvent event) { // Método chamado ao clicar no botão "Editar"
        try {
            if (tarefaSelecionada != null) {
                // Atualiza os campos da tarefa com o que está na tela
                tarefaSelecionada.setTitulo(idTitulo.getText());
                tarefaSelecionada.setDescricao(idDescricao.getText());
                tarefaSelecionada.setPrazo(idPrazo.getValue());
                tarefaSelecionada.setPrioridade(idPrioridade.getValue());
                tarefaSelecionada.setConcluido(id_IsConcluido.isSelected());

                // Chama o DAO para aplicar a atualização
                DAO.getTarefa().update(tarefaSelecionada);

                //tabelaTarefas.refresh();
                idLabelError.setText("Tarefa atualizada com sucesso.");
            } else {
                idLabelError.setText("Nenhuma tarefa selecionada.");
            }
        } catch (Exception e) {
            idLabelError.setText("Erro ao atualizar tarefa.");
            System.out.println(e);
        }

    }


    void selecionar() { // Atualiza os campos da interface com os dados da tarefa selecionada
        if (tarefaSelecionada != null) {
            idTitulo.setText(tarefaSelecionada.getTitulo());
            idPrazo.setValue(tarefaSelecionada.getPrazo());
            idPrioridade.setValue(tarefaSelecionada.getPrioridade());
            idDescricao.setText(tarefaSelecionada.getDescricao());
            id_IsConcluido.setSelected(tarefaSelecionada.getConcluido());
        }


    }



    @FXML
    public void initialize() {

        //this.tarefasData.addAll(DAO.getTarefa().read());

        idPrioridade.getItems().addAll( // Preenche o ComboBox com os níveis de prioridade
                "Alta",
                "Normal",
                "Baixa"
        );

        this.tarefasData = FXCollections.observableArrayList(); // Inicializa a lista observável de tarefas
        //this.tarefasData.addAll(DAO.getTarefa().read());

        // Cria as colunas da tabela
        TableColumn columnTitulo = new TableColumn<>("Tarefa");
        TableColumn columnPrazo = new TableColumn<>("Prazo");
        TableColumn columnPrioridade = new TableColumn<>("Prioridade");
        TableColumn columnDescricao = new TableColumn<>("Descrição");
        TableColumn columnStatus = new TableColumn("Status");

        // Usando os atributos da model, define quais dados serão exibidos
        columnTitulo.setCellValueFactory(new PropertyValueFactory<Tarefa,String>("titulo"));
        columnPrazo.setCellValueFactory(new PropertyValueFactory<Tarefa,LocalDate>("prazo"));
        columnPrioridade.setCellValueFactory(new PropertyValueFactory<Tarefa,String>("prioridade"));
        columnDescricao.setCellValueFactory(new PropertyValueFactory<Tarefa,String>("descricao"));
        columnStatus.setCellValueFactory(new PropertyValueFactory<Tarefa,String>("status"));

        // Adiciona as colunas na tabela
        this.tabelaTarefas.getColumns().addAll(columnTitulo,columnPrazo,columnPrioridade,columnDescricao,columnStatus);
        this.tabelaTarefas.setItems(tarefasData); // Liga a lista de tarefas à tabela para que atualizações apareçam automaticamente

        // Define ação ao selecionar uma tarefa na tabela
        tabelaTarefas.getSelectionModel().selectedItemProperty().addListener((obs,
                                                                              oldSel,
                                                                              newSel) -> {tarefaSelecionada = newSel; selecionar();});

        //selecionar()

    }
}
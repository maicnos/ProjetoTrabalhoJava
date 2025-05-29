package app.model;

import java.time.LocalDate;

public class Tarefa {
    private int id; // identificador da tarefa
    private String titulo; // Título da tarefa
    private String descricao; // Descrição da tarefa
    private LocalDate prazo; // Prazo da tarefa
    private String prioridade; // Prioridade da tarefa
    private Boolean isConcluido; // Indica se a tarefa foi concluída
    private String status; // Status em forma de texto da tarefa

    public Tarefa(String titulo, String descricao, LocalDate prazo, String prioridade, Boolean isConcluido) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.prazo = prazo;
        this.prioridade = prioridade;
        this.isConcluido = isConcluido;
    } // Construtor para inicializar uma nova tarefa (sem ID)

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDate prazo) {
        this.prazo = prazo;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public Boolean getConcluido() {
        return isConcluido;
    }

    public String getStatus() {
        if (this.isConcluido) {
            return "Concluído";
        }
        return "Não concluído";
    } // Retorna o status textual da tarefa com base no campo isConcluido

    public void setConcluido(Boolean concluido) {
        isConcluido = concluido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

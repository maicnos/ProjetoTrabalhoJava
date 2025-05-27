package app.model;

import java.time.LocalDate;

public class Tarefa {
    private String titulo;
    private String descricao;
    private LocalDate prazo;
    private String prioridade;
    private Boolean isConcluido;

    public Tarefa(String titulo, String descricao, LocalDate prazo, String prioridade, Boolean isConcluido) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.prazo = prazo;
        this.prioridade = prioridade;
        this.isConcluido = isConcluido;
    }

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

    public String status() {
        if (this.isConcluido) {
            return "Concluído";
        }
        return "Não concluído";
    }

    public void setConcluido(Boolean concluido) {
        isConcluido = concluido;
    }
}

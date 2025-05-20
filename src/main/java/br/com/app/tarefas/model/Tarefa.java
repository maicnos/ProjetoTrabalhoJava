package br.com.app.tarefas.model;

public class Tarefa {
    private String titulo;
    private String descricao;
    private int prazo;
    private String prioridade;
    private Double isConcluido;

    public Tarefa(String titulo, String descricao, int prazo, String prioridade, Double isConcluido) {
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

    public int getPrazo() {
        return prazo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public Double getIsConcluido() {
        return isConcluido;
    }

    public void setIsConcluido(Double isConcluido) {
        this.isConcluido = isConcluido;
    }
}

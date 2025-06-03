package app.dao.tarefa;

import app.model.Tarefa;

import java.util.ArrayList;
import java.util.List;

// Implementação da interface TarefaDAO que armazena as tarefas em uma lista
// Essa implementação simula um "banco de dados" simples apenas na memória, útil para teste ou aplicações pequenas sem persistência real

public class TarefaDAOImpl implements TarefaDAO{

    private List<Tarefa> tarefas; // Lista que armazena as tarefas
    private int nextID; // Próximo ID a ser atribuído automaticamente a uma nova tarefa

    public TarefaDAOImpl() {
        this.tarefas = new ArrayList<>();
        this.nextID = 0;

    }

    @Override
    public Tarefa create(Tarefa tarefa) {
        tarefa.setId(this.nextID);
        nextID ++;

        this.tarefas.add(tarefa);
        return tarefa;

    } // Cria uma nova tarefa, atribui um ID único e adiciona à lista.

    @Override
    public List<Tarefa> read() {
        return new ArrayList<>(this.tarefas);

    } // Retorna uma cópia da lista de tarefas.

    @Override
    public void update(Tarefa tarefa) {
        for (int i = 0; i < this.tarefas.size(); i++) {
            Tarefa t = this.tarefas.get(i);
            if (t.getId() == tarefa.getId()) {
                this.tarefas.set(i, tarefa); // Substitui a tarefa original
                System.out.println("aqui");
            }
        }

    } // Atualiza uma tarefa existente na lista com base no ID.

    @Override
    public void delete(int id) {
        this.tarefas.removeIf(tarefa -> tarefa.getId() == id); // Remove usando lambda

    } // Remove uma tarefa da lista com base no ID.
}

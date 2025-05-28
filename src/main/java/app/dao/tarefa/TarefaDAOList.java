package app.dao.tarefa;

import app.model.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class TarefaDAOList implements TarefaDAO{

    private List<Tarefa> tarefas;
    private int nextID;

    public TarefaDAOList() {
        this.tarefas = new ArrayList<>();
        this.nextID = 0;
    }

    @Override
    public Tarefa create(Tarefa tarefa) {
        tarefa.setId(this.nextID);
        nextID ++;

        this.tarefas.add(tarefa);
        return tarefa;
    }

    @Override
    public List<Tarefa> read() {
        List<Tarefa> listaTarefas = new ArrayList<>();
        for (Object i : this.tarefas) {
            listaTarefas.add((Tarefa) i);
        }
        return listaTarefas;
    }

    @Override
    public void update(Tarefa tarefa) {
        for (int i = 0; i < this.tarefas.size(); i++) {
            if (this.tarefas.get(i).getId() == tarefa.getId()) {
                this.tarefas.set(i, tarefa);
            }
        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < this.tarefas.size(); i++) {
            if (this.tarefas.get(i).getId() == id) {
                this.tarefas.remove(id);
            }
        }
    }
}

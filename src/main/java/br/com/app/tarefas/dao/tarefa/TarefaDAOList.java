package br.com.app.tarefas.dao.tarefa;

import br.com.app.tarefas.model.Tarefa;

import java.util.List;

public class TarefaDAOList implements TarefaDAO{
    @Override
    public Tarefa create(Tarefa obj) {
        return null;
    }

    @Override
    public List<Tarefa> read() {
        return List.of();
    }

    @Override
    public Tarefa update(Tarefa obj) {
        return null;
    }

    @Override
    public void delete(Tarefa obj) {

    }
}

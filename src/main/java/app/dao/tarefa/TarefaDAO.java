package app.dao.tarefa;

import app.dao.CRUD;
import app.model.Tarefa;

public interface TarefaDAO extends CRUD<Tarefa> {

    void delete(int id);
}

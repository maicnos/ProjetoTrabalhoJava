package app.dao;

import app.dao.tarefa.TarefaDAOList;

public class DAO {
    private static TarefaDAOList tarefas;

    public static TarefaDAOList getTarefas() {
        if (tarefas == null) {
            tarefas = new TarefaDAOList();
        }
        return tarefas;
    }
}

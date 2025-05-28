package app.dao;

import app.dao.tarefa.TarefaDAOList;

public class DAO {
    private static TarefaDAOList tarefa;

    public static TarefaDAOList getTarefa() {
        if (tarefa == null) {
            tarefa = new TarefaDAOList();
        }
        return tarefa;
    }
}

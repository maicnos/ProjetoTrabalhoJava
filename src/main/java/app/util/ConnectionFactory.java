package app.util;

import app.dao.tarefa.TarefaDAOList;

public class ConnectionFactory {
    private static TarefaDAOList tarefas;

    public static TarefaDAOList getTarefas() {
        if (tarefas == null) {
            tarefas = new TarefaDAOList();
        }
        return tarefas;
    }
}

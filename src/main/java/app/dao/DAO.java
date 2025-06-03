package app.dao;

import app.dao.tarefa.TarefaDAOImpl;

// Classe DAO (Data Access Object) central que fornece acesso ao DAO de tarefas
// Implementa o padrão Singleton para garantir que apenas uma instância de TarefaDAOImpl seja utilizada

public class DAO {
    private static TarefaDAOImpl tarefa; // Singleton de TarefaDAOImpl

    public static TarefaDAOImpl getTarefa() {
        if (tarefa == null) {
            tarefa = new TarefaDAOImpl();
        }
        return tarefa;
    } // Retorna a instância de TarefaDAOList. Se ainda não foi criada, uma nova instância será inicializada.
}

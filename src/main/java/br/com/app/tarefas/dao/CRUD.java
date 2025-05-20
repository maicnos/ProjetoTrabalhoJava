package br.com.app.tarefas.dao;

import java.util.List;

public interface CRUD <J>{

    public J create(J obj);

    public List<J> read();

    public J update(J obj);

    public void delete(J obj);

}

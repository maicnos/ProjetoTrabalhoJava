package app.dao;

import java.util.List;

// Interface genérica para operações CRUD (Create, Read, Update, Delete).
// <J> é o tipo de objeto que será manipulado pelo DAO

public interface CRUD <J>{

    public J create(J obj);

    public List<J> read();

    public void update(J obj);

    public void delete(int id);

}

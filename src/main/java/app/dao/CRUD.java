package app.dao;

import java.util.List;

public interface CRUD <J>{

    public J create(J obj);

    public List<J> read();

    public void update(J obj);

    public void delete(int id);

}

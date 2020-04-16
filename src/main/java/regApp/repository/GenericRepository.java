package regApp.repository;

import java.util.List;

public interface GenericRepository<E, ID> {
    E save(E entity);
    List<E> findAll();
    E findById(int id);
    void remove(int id);
}

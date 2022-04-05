package ua.goit.dl;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {

    Optional<T> findById(Integer id);

    void save(T entity);
    void saveWithId(T entity);
    int update(T entity);
    void delete(T entity);
    List<T> selectAll();
}

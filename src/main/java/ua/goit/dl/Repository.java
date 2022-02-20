package ua.goit.dl;

public interface Repository<T> {

    T findById(Integer id);

    void save(T entity);
    void saveWithId(T entity);
    int update(T entity);
    void delete(Integer id);



}

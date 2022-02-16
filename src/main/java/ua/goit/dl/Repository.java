package ua.goit.dl;

public interface Repository<T> {

    T findById(Integer id);

    void save(T entity);
    void update(T entity);
    void delete(T entity);

}

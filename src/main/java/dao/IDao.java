package dao;

import java.util.List;

public interface IDao<T> {
    T findById(Integer id);
    List<T> findAll();
    void save(T o);
    void update(T o);
    void delete(Integer id);

}
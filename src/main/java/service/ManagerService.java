package service;

import java.util.List;

public interface ManagerService <T> {
    List<T> showAll();
    void add (T t);
    T findById(int id);
    void update(int id, T t);
    void delete(int id);
}

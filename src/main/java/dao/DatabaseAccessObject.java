package dao;

import java.sql.SQLException;
import java.util.List;

public interface DatabaseAccessObject<T> {
    List<T> showAll() throws SQLException, ClassNotFoundException;
    void insert(T t) throws SQLException, ClassNotFoundException;
    T select(String name) throws SQLException, ClassNotFoundException;
    boolean delete(int id) throws SQLException;
    boolean update(T t) throws SQLException;
}

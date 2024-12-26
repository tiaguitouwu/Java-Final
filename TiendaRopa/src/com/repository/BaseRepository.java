package com.repository;

import com.entity.Ropa;
import java.sql.SQLException;
import java.util.List;

public interface BaseRepository<T> {
    void save(T obj) throws SQLException;

    T findById(int id) throws SQLException;

    List<T> findAll() throws SQLException;

    void update(T obj) throws SQLException;

    void delete(int id) throws SQLException;
}

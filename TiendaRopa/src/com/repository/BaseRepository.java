package com.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface BaseRepository<T> {
    void save(T obj) throws SQLException;

    Optional<T> findById(int id) throws SQLException;

    List<T> findAll() throws SQLException;

    void update(T obj) throws SQLException;

    void delete(int id) throws SQLException;
}

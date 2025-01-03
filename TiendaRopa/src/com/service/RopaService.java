package com.service;

import com.entity.Ropa;
import com.repository.Ropa.RopaRepository;
import com.repository.Ropa.IRopaRepository;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class RopaService {
    private final IRopaRepository repository;

    public RopaService(RopaRepository ropaRepository) {
        this.repository = new RopaRepository();
    }
    
    public void add(Ropa ropa) throws SQLException {
        repository.save(ropa);
    }

    public Optional<Ropa> findById(int id) throws SQLException {
        return repository.findById(id);
    }

    public List<Ropa> findAll()  throws SQLException {
        return repository.findAll();
    }

    public void delete(int id)  throws SQLException {
        repository.delete(id);
    }
    
    public void update(Ropa tienda) throws SQLException {
        repository.update(tienda);
    }
}

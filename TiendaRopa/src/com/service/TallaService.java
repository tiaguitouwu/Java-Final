package com.service;

import com.entity.Talla;
import com.repository.Talla.ITallaRepository;
import com.repository.Talla.TallaRepository;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TallaService {
    private final ITallaRepository repository;

    public TallaService(TallaRepository tallaRepository) {
        this.repository = new TallaRepository();
    }
    
    public void add(Talla talla) throws SQLException {
        repository.save(talla);
    }

    public Optional<Talla> findById(int id) throws SQLException {
        return repository.findById(id);
    }

    public List<Talla> findAll()  throws SQLException {
        return repository.findAll();
    }

    public void delete(int id)  throws SQLException {
        repository.delete(id);
    }
}

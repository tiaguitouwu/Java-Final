package com.service;

import com.entity.Timbrado;
import com.repository.Timbrado.ITimbradoRepository;
import com.repository.Timbrado.TimbradoRepository;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TimbradoService {
    private final ITimbradoRepository repository;

    public TimbradoService(TimbradoRepository timbradoRepository) {
        this.repository = new TimbradoRepository();
    }
    
    public void add(Timbrado timbrado) throws SQLException {
        repository.save(timbrado);
    }

    public Optional<Timbrado> findById(int id) throws SQLException {
        return repository.findById(id);
    }

    public List<Timbrado> findAll()  throws SQLException {
        return repository.findAll();
    }

    public void delete(int id)  throws SQLException {
        repository.delete(id);
    }
}

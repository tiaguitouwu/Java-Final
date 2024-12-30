package com.service;

import com.entity.Tienda;
import com.repository.Tienda.ITiendaRepository;
import com.repository.Tienda.TiendaRepository;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TiendaService {
    private final ITiendaRepository repository;

    public TiendaService(TiendaRepository tiendaRepository) {
        this.repository = new TiendaRepository();
    }
    
    public void add(Tienda tienda) throws SQLException {
        repository.save(tienda);
    }

    public Optional<Tienda> findById(int id) throws SQLException {
        return repository.findById(id);
    }

    public List<Tienda> findAll()  throws SQLException {
        return repository.findAll();
    }

    public void delete(int id)  throws SQLException {
        repository.delete(id);
    }
}

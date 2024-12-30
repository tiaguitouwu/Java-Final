package com.service;

import com.entity.TipoComprobante;
import com.repository.TipoComprobante.ITipoComprobanteRepository;
import com.repository.TipoComprobante.TipoComprobanteRepository;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TipoComprobanteService {
    private final ITipoComprobanteRepository repository;

    public TipoComprobanteService(TipoComprobanteRepository tipoComprobanteRepository) {
        this.repository = new TipoComprobanteRepository();
    }
    
    public void add(TipoComprobante tipoComprobante) throws SQLException {
        repository.save(tipoComprobante);
    }

    public Optional<TipoComprobante> findById(int id) throws SQLException {
        return repository.findById(id);
    }

    public List<TipoComprobante> findAll()  throws SQLException {
        return repository.findAll();
    }

    public void delete(int id)  throws SQLException {
        repository.delete(id);
    }
}

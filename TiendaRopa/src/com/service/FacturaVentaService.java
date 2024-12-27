package com.service;

import com.entity.FacturaVenta;
import com.repository.FacturaVenta.FacturaVentaRepository;
import com.repository.FacturaVenta.IFacturaVentaRepository;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class FacturaVentaService {
    private final IFacturaVentaRepository repository;

    public FacturaVentaService() {
        this.repository = new FacturaVentaRepository();
    }
    
    public void add(FacturaVenta facturaVenta) throws SQLException {
        repository.save(facturaVenta);
    }

    public Optional<FacturaVenta> findById(int id) throws SQLException {
        return repository.findById(id);
    }

    public List<FacturaVenta> findAll()  throws SQLException {
        return repository.findAll();
    }

    public void delete(int id)  throws SQLException {
        repository.delete(id);
    }
}

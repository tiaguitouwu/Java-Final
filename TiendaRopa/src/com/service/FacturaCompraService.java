package com.service;

import com.entity.FacturaCompra;
import com.repository.FacturaCompra.FacturaCompraRepository;
import com.repository.FacturaCompra.IFacturaCompraRepository;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class FacturaCompraService {
    private final IFacturaCompraRepository repository;

    public FacturaCompraService() {
        this.repository = new FacturaCompraRepository();
    }
    
    public void add(FacturaCompra facturaCompra) throws SQLException {
        repository.save(facturaCompra);
    }

    public Optional<FacturaCompra> findById(int id) throws SQLException {
        return repository.findById(id);
    }

    public List<FacturaCompra> findAll()  throws SQLException {
        return repository.findAll();
    }

    public void delete(int id)  throws SQLException {
        repository.delete(id);
    }
}

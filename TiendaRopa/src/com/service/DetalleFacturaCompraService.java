package com.service;

import com.entity.DetalleFacturaCompra;
import com.repository.DetalleFacturaCompra.DetalleFacturaCompraRepository;
import com.repository.DetalleFacturaCompra.IDetalleFacturaCompraRepository;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class DetalleFacturaCompraService {
    private final IDetalleFacturaCompraRepository repository;

    public DetalleFacturaCompraService() {
        this.repository = new DetalleFacturaCompraRepository();
    }
    
    public void add(DetalleFacturaCompra detalleFacturaCompra) throws SQLException {
        repository.save(detalleFacturaCompra);
    }

    public Optional<DetalleFacturaCompra> findById(int id) throws SQLException {
        return repository.findById(id);
    }

    public List<DetalleFacturaCompra> findAll()  throws SQLException {
        return repository.findAll();
    }

    public void delete(int id)  throws SQLException {
        repository.delete(id);
    }
}

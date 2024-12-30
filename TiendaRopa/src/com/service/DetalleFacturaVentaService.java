package com.service;

import com.entity.DetalleFacturaVenta;
import com.repository.DetalleFacturaVenta.DetalleFacturaVentaRepository;
import com.repository.DetalleFacturaVenta.IDetalleFacturaVentaRepository;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class DetalleFacturaVentaService {
    private final IDetalleFacturaVentaRepository repository;

    public DetalleFacturaVentaService(DetalleFacturaVentaRepository detalleFacturaVentaRepository) {
        this.repository = new DetalleFacturaVentaRepository();
    }
    
    public void add(DetalleFacturaVenta detalleFacturaVenta) throws SQLException {
        repository.save(detalleFacturaVenta);
    }

    public Optional<DetalleFacturaVenta> findById(int id) throws SQLException {
        return repository.findById(id);
    }

    public List<DetalleFacturaVenta> findAll()  throws SQLException {
        return repository.findAll();
    }

    public void delete(int id)  throws SQLException {
        repository.delete(id);
    }
}

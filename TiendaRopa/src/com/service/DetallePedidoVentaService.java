package com.service;

import com.entity.DetallePedidoVenta;
import com.repository.DetallePedidoVenta.DetallePedidoVentaRepository;
import com.repository.DetallePedidoVenta.IDetallePedidoVentaRepository;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class DetallePedidoVentaService {
    private final IDetallePedidoVentaRepository repository;

    public DetallePedidoVentaService(DetallePedidoVentaRepository detallePedidoVentaRepository) {
        this.repository = new DetallePedidoVentaRepository();
    }
    
    public void add(DetallePedidoVenta detallePedidoVenta) throws SQLException {
        repository.save(detallePedidoVenta);
    }

    public Optional<DetallePedidoVenta> findById(int id) throws SQLException {
        return repository.findById(id);
    }

    public List<DetallePedidoVenta> findAll()  throws SQLException {
        return repository.findAll();
    }

    public void delete(int id)  throws SQLException {
        repository.delete(id);
    }
}

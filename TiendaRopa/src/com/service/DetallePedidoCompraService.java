package com.service;

import com.entity.DetallePedidoCompra;
import com.repository.DetallePedidoCompra.DetallePedidoCompraRepository;
import com.repository.DetallePedidoCompra.IDetallePedidoCompraRepository;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class DetallePedidoCompraService {
    private final IDetallePedidoCompraRepository repository;

    public DetallePedidoCompraService(DetallePedidoCompraRepository detallePedidoCompraRepository) {
        this.repository = new DetallePedidoCompraRepository();
    }
    
    public void add(DetallePedidoCompra detallePedidoCompra) throws SQLException {
        repository.save(detallePedidoCompra);
    }

    public Optional<DetallePedidoCompra> findById(int id) throws SQLException {
        return repository.findById(id);
    }

    public List<DetallePedidoCompra> findAll()  throws SQLException {
        return repository.findAll();
    }

    public void delete(int id)  throws SQLException {
        repository.delete(id);
    }
}

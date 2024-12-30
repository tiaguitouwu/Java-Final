package com.service;

import com.entity.PedidoCompra;
import com.repository.PedidoCompra.PedidoCompraRepository;
import com.repository.PedidoCompra.IPedidoCompraRepository;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class PedidoCompraService {
    private final IPedidoCompraRepository repository;

    public PedidoCompraService(PedidoCompraRepository pedidoCompraRepository) {
        this.repository = new PedidoCompraRepository();
    }
    
    public void add(PedidoCompra pedidoCompra) throws SQLException {
        repository.save(pedidoCompra);
    }

    public Optional<PedidoCompra> findById(int id) throws SQLException {
        return repository.findById(id);
    }

    public List<PedidoCompra> findAll()  throws SQLException {
        return repository.findAll();
    }

    public void delete(int id)  throws SQLException {
        repository.delete(id);
    }
}

package com.service;

import com.entity.PedidoVenta;
import com.repository.PedidoVenta.IPedidoVentaRepository;
import com.repository.PedidoVenta.PedidoVentaRepository;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class PedidoVentaService {
    private final IPedidoVentaRepository repository;

    public PedidoVentaService() {
        this.repository = new PedidoVentaRepository();
    }
    
    public void add(PedidoVenta pedidoVenta) throws SQLException {
        repository.save(pedidoVenta);
    }

    public Optional<PedidoVenta> findById(int id) throws SQLException {
        return repository.findById(id);
    }

    public List<PedidoVenta> findAll()  throws SQLException {
        return repository.findAll();
    }

    public void delete(int id)  throws SQLException {
        repository.delete(id);
    }
}

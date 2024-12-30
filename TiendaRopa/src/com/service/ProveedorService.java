package com.service;

import com.entity.Proveedor;
import com.repository.Proveedor.IProveedorRepository;
import com.repository.Proveedor.ProveedorRepository;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProveedorService {
    private final IProveedorRepository repository;

    public ProveedorService(ProveedorRepository proveedorRepository) {
        this.repository = new ProveedorRepository();
    }
    
    public void add(Proveedor proveedor) throws SQLException {
        repository.save(proveedor);
    }

    public Optional<Proveedor> findById(int id) throws SQLException {
        return repository.findById(id);
    }

    public List<Proveedor> findAll()  throws SQLException {
        return repository.findAll();
    }

    public void delete(int id)  throws SQLException {
        repository.delete(id);
    }
}

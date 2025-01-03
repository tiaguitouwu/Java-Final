package com.service;

import com.entity.Cliente;
import com.repository.Cliente.ClienteRepository;
import com.repository.Cliente.IClienteRepository;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ClienteService {
    private final IClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = new ClienteRepository();
    }
    
    public void add(Cliente cliente) throws SQLException {
        repository.save(cliente);
    }

    public Optional<Cliente> findById(int id) throws SQLException {
        return repository.findById(id);
    }

    public List<Cliente> findAll()  throws SQLException {
        return repository.findAll();
    }

    public void delete(int id)  throws SQLException {
        repository.delete(id);
    }
    
    public void update(Cliente cliente) throws SQLException {
        repository.update(cliente);
    }
}

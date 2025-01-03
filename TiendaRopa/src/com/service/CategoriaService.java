package com.service;

import com.entity.Categoria;
import com.repository.Categoria.CategoriaRepository;
import com.repository.Categoria.ICategoriaRepository;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CategoriaService {
    private final ICategoriaRepository repository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.repository = new CategoriaRepository();
    }
    
    public void add(Categoria categoria) throws SQLException {
        repository.save(categoria);
    }

    public Optional<Categoria> findById(int id) throws SQLException {
        return repository.findById(id);
    }

    public List<Categoria> findAll()  throws SQLException {
        return repository.findAll();
    }

    public void delete(int id)  throws SQLException {
        repository.delete(id);
    }
    
    public void update(Categoria categoria) throws SQLException {
        repository.update(categoria);
    }
}

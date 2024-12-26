package com.repository.Categoria;

import com.entity.Categoria;
import com.repository.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CategoriaRepository implements ICategoriaRepository{
    private final Connection connection;
    
    public CategoriaRepository() {
        this.connection = ConnectionManager.getConnection();    
    }
    
    @Override
    public void save(Categoria Categoria) throws SQLException {
        String sql = "INSERT INTO Categoria (descripcion, idtalla, idcategoria, usuario, fechaultmodificacion) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, Categoria.getDescripcion());
            stmt.setInt(2, Categoria.getIdTalla());
            stmt.setInt(3, Categoria.getIdCategoria());
            stmt.setString(4, Categoria.getUsuario());
            stmt.setObject(5, Categoria.getFechaUltModificacion());
            stmt.executeUpdate();
        }
    }

    @Override
    public Categoria findById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Categoria> findAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Categoria categoria) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

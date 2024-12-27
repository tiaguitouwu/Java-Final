package com.repository.Categoria;

import com.entity.Categoria;
import com.repository.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoriaRepository implements ICategoriaRepository{
    private final Connection connection;
    
    public CategoriaRepository() {
        this.connection = ConnectionManager.getConnection();    
    }
    
    @Override
    public void save(Categoria Categoria) throws SQLException {
        String sql = "INSERT INTO Categoria (descripcioncategoria, usuario, fechaultmodificacion) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, Categoria.getDescripcionCategoria());
            stmt.setString(2, Categoria.getUsuario());
            stmt.setObject(3, Categoria.getFechaUltModificacion());
            stmt.executeUpdate();
        }
    }

    @Override
    public Optional<Categoria> findById(int id) throws SQLException {
        String sql = "SELECT * FROM Categoria WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Categoria categoria = new Categoria();
                    categoria.setId(rs.getInt("id"));
                    categoria.setDescripcionCategoria(rs.getString("descripcioncategoria"));
                    categoria.setUsuario(rs.getString("usuario"));
                    categoria.setFechaUltModificacion(rs.getTimestamp("fechaultmodificacion").toLocalDateTime());
                    return Optional.of(categoria);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Categoria> findAll() throws SQLException {
        List<Categoria> categoriaList = new ArrayList<>();
        String sql = "SELECT * FROM Categoria";
        try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("id"));
                categoria.setDescripcionCategoria(rs.getString("descripcioncategoria"));
                categoria.setUsuario(rs.getString("usuario"));
                categoria.setFechaUltModificacion(rs.getTimestamp("fechaultmodificacion").toLocalDateTime());
                categoriaList.add(categoria);
            }
        }
        return categoriaList;
    }

    @Override
    public void update(Categoria categoria) throws SQLException {
        String sql = "UPDATE categoria SET descripcioncategoria = ?, usuario = ?, fechaultmodificacion = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, categoria.getDescripcionCategoria());
            stmt.setString(2, categoria.getUsuario());
            stmt.setObject(3, categoria.getFechaUltModificacion());
            stmt.setInt(4, categoria.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Categoria WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

}

package com.repository.Ropa;

import com.entity.Ropa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.List;
import com.repository.ConnectionManager;
import java.util.Optional;

public class RopaRepository implements IRopaRepository {
    private final Connection connection;

    public RopaRepository() {
        this.connection = ConnectionManager.getConnection();
    }

    @Override
    public void save(Ropa ropa) throws SQLException {
        String sql = "INSERT INTO Ropa (descripcion, idtalla, idcategoria, usuario, fechaultmodificacion) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, ropa.getDescripcion());
            stmt.setInt(2, ropa.getIdTalla());
            stmt.setInt(3, ropa.getIdCategoria());
            stmt.setString(4, ropa.getUsuario());
            stmt.setObject(5, ropa.getFechaUltModificacion());
            stmt.executeUpdate();
        }
    }

    @Override
    public Optional<Ropa> findById(int id) throws SQLException {
        String sql = "SELECT * FROM Ropa WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Ropa ropa = new Ropa();
                    ropa.setId(rs.getInt("id"));
                    ropa.setDescripcion(rs.getString("descripcion"));
                    ropa.setIdTalla(rs.getInt("idtalla"));
                    ropa.setIdCategoria(rs.getInt("idcategoria"));
                    ropa.setUsuario(rs.getString("usuario"));
                    ropa.setFechaUltModificacion(rs.getTimestamp("fechaultmodificacion").toLocalDateTime());
                    return Optional.of(ropa);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Ropa> findAll() throws SQLException {
        List<Ropa> ropaList = new ArrayList<>();
        String sql = "SELECT * FROM Ropa";
        try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Ropa ropa = new Ropa();
                ropa.setId(rs.getInt("id"));
                ropa.setDescripcion(rs.getString("descripcion"));
                ropa.setIdTalla(rs.getInt("idtalla"));
                ropa.setIdCategoria(rs.getInt("idcategoria"));
                ropa.setUsuario(rs.getString("usuario"));
                ropa.setFechaUltModificacion(rs.getTimestamp("fechaultmodificacion").toLocalDateTime());
                ropaList.add(ropa);
            }
        }
        return ropaList;
    }

    @Override
    public void update(Ropa ropa) throws SQLException {
        String sql = "UPDATE Ropa SET descripcion = ?, idtalla = ?, idcategoria = ?, usuario = ?, fechaultmodificacion = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, ropa.getDescripcion());
            stmt.setInt(2, ropa.getIdTalla());
            stmt.setInt(3, ropa.getIdCategoria());
            stmt.setString(4, ropa.getUsuario());
            stmt.setObject(5, ropa.getFechaUltModificacion());
            stmt.setInt(6, ropa.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Ropa WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

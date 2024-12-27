package com.repository.Talla;

import com.entity.Talla;
import com.repository.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TallaRepository implements ITallaRepository {

    private final Connection connection;
    
    public TallaRepository(){
        this.connection = ConnectionManager.getConnection();   
    }
    
    @Override
    public void save(Talla obj) throws SQLException {
        String sql = "INSERT INTO Talla (descripciontalla, usuario, fechaultmodificacion) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, obj.getDescripcionTalla());
            stmt.setString(2, obj.getUsuario());
            stmt.setObject(3, obj.getFechaUltModificacion());
            stmt.executeUpdate();
        }
    }

    @Override
    public Optional<Talla> findById(int id) throws SQLException {
        String sql = "SELECT * FROM Talla WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Talla obj = new Talla();
                    obj.setId(rs.getInt("id"));
                    obj.setDescripcionTalla(rs.getString("descripciontalla"));
                    obj.setUsuario(rs.getString("usuario"));
                    obj.setFechaUltModificacion(rs.getTimestamp("fechaultmodificacion").toLocalDateTime());
                    return Optional.of(obj);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Talla> findAll() throws SQLException {
        List<Talla> objList = new ArrayList<>();
        String sql = "SELECT * FROM Talla";
        try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Talla obj = new Talla();
                obj.setId(rs.getInt("id"));
                obj.setDescripcionTalla(rs.getString("descripciontalla"));
                obj.setUsuario(rs.getString("usuario"));
                obj.setFechaUltModificacion(rs.getTimestamp("fechaultmodificacion").toLocalDateTime());
                objList.add(obj);
            }
        }
        return objList;
    }

    @Override
    public void update(Talla obj) throws SQLException {
        String sql = "UPDATE Talla SET descripciontalla = ?, usuario = ?, fechaultmodificacion = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, obj.getDescripcionTalla());
            stmt.setString(2, obj.getUsuario());
            stmt.setObject(3, obj.getFechaUltModificacion());
            stmt.setInt(4, obj.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Talla WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

}

package com.repository.Proveedor;

import com.entity.Proveedor;
import com.repository.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProveedorRepository implements IProveedorRepository {

    private final Connection connection;
    
    public ProveedorRepository(){
        this.connection = ConnectionManager.getConnection();   
    }
    
    @Override
    public void save(Proveedor obj) throws SQLException {
        String sql = "INSERT INTO Proveedor (razonsocial, nombre, apellido, ruc, usuario, fechaultmodificacion) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, obj.getRazonSocial());
            stmt.setString(2, obj.getNombre());
            stmt.setString(3, obj.getApellido());
            stmt.setString(4, obj.getRuc());
            stmt.setString(5, obj.getUsuario());
            stmt.setObject(6, obj.getFechaUltModificacion());
            stmt.executeUpdate();
        }
    }

    @Override
    public Optional<Proveedor> findById(int id) throws SQLException {
        String sql = "SELECT * FROM Proveedor WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Proveedor obj = new Proveedor();
                    obj.setId(rs.getInt("id"));
                    obj.setRazonSocial(rs.getString("razonsocial"));
                    obj.setNombre(rs.getString("nombre"));
                    obj.setApellido(rs.getString("apellido"));
                    obj.setRuc(rs.getString("ruc"));
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
    public List<Proveedor> findAll() throws SQLException {
        List<Proveedor> objList = new ArrayList<>();
        String sql = "SELECT * FROM Proveedor";
        try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Proveedor obj = new Proveedor();
                obj.setId(rs.getInt("id"));
                obj.setRazonSocial(rs.getString("razonsocial"));
                obj.setNombre(rs.getString("nombre"));
                obj.setApellido(rs.getString("apellido"));
                obj.setRuc(rs.getString("ruc"));
                obj.setUsuario(rs.getString("usuario"));
                obj.setFechaUltModificacion(rs.getTimestamp("fechaultmodificacion").toLocalDateTime());
                objList.add(obj);
            }
        }
        return objList;
    }

    @Override
    public void update(Proveedor obj) throws SQLException {
        String sql = "UPDATE Proveedor SET razonsocial = ?, nombre = ?, apellido = ?, ruc = ?, usuario = ?, fechaultmodificacion = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, obj.getRazonSocial());
            stmt.setString(2, obj.getNombre());
            stmt.setString(3, obj.getApellido());
            stmt.setString(4, obj.getRuc());
            stmt.setString(5, obj.getUsuario());
            stmt.setObject(6, obj.getFechaUltModificacion());
            stmt.setInt(7, obj.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Proveedor WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

}

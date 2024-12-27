package com.repository.Tienda;

import com.entity.Tienda;
import com.repository.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TiendaRepository implements ITiendaRepository{

    private final Connection connection;
    
    public TiendaRepository(){
        this.connection = ConnectionManager.getConnection();   
    }
    
    @Override
    public void save(Tienda obj) throws SQLException {
        String sql = "INSERT INTO Tienda (descripciontienda, direccion, telefono, correo, usuario, fechaultmodificacion) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, obj.getDescripcionTienda());
            stmt.setString(2, obj.getDireccion());
            stmt.setString(3, obj.getTelefono());
            stmt.setString(4,obj.getCorreo());
            stmt.setString(5,obj.getUsuario());
            stmt.setObject(6, obj.getFechaUltModificacion());
            stmt.executeUpdate();
        }
    }

    @Override
    public Optional<Tienda> findById(int id) throws SQLException {
        String sql = "SELECT * FROM Tienda WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Tienda obj = new Tienda();
                    obj.setId(rs.getInt("id"));
                    obj.setDescripcionTienda(rs.getString("descripciontienda"));
                    obj.setDireccion(rs.getString("direccion"));
                    obj.setTelefono(rs.getString("telefono"));
                    obj.setCorreo(rs.getString("correo"));
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
    public List<Tienda> findAll() throws SQLException {
        List<Tienda> objList = new ArrayList<>();
        String sql = "SELECT * FROM Tienda";
        try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Tienda obj = new Tienda();
                obj.setId(rs.getInt("id"));
                obj.setDescripcionTienda(rs.getString("descripciontienda"));
                obj.setDireccion(rs.getString("direccion"));
                obj.setTelefono(rs.getString("telefono"));
                obj.setCorreo(rs.getString("correo"));
                obj.setUsuario(rs.getString("usuario"));
                obj.setFechaUltModificacion(rs.getTimestamp("fechaultmodificacion").toLocalDateTime());
                objList.add(obj);
            }
        }
        return objList;
    }

    @Override
    public void update(Tienda obj) throws SQLException {
        String sql = "UPDATE Tienda SET descripciontienda = ?, direccion=?, telefono=?, correo=?, usuario = ?, fechaultmodificacion = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, obj.getDescripcionTienda());
            stmt.setString(2, obj.getDireccion());
            stmt.setString(3, obj.getTelefono());
            stmt.setString(4, obj.getCorreo());
            stmt.setString(5, obj.getUsuario());
            stmt.setObject(6, obj.getFechaUltModificacion());
            stmt.setInt(7, obj.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Tienda WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

}

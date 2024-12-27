package com.repository.DetalleFacturaVenta;

import com.entity.DetalleFacturaVenta;
import com.repository.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DetalleFacturaVentaRepository implements IDetalleFacturaVentaRepository{

    private final Connection connection;
    
    public DetalleFacturaVentaRepository(){
        this.connection = ConnectionManager.getConnection();   
    }
    @Override
    public void save(DetalleFacturaVenta obj) throws SQLException {
        String sql = "INSERT INTO DetalleFacturaVenta (idfacturaventa, idropa, precio, cantidad, usuario, fechaultmodificacion) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, obj.getIdFacturaVenta());
            stmt.setInt(2, obj.getIdRopa());
            stmt.setFloat(3, obj.getPrecio());
            stmt.setInt(4, obj.getCantidad());
            stmt.setString(5, obj.getUsuario());
            stmt.setObject(6, obj.getFechaUltModificacion());
            stmt.executeUpdate();
        }
    }

    @Override
    public Optional<DetalleFacturaVenta> findById(int id) throws SQLException {
        String sql = "SELECT * FROM DetalleFacturaVenta WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    DetalleFacturaVenta obj = new DetalleFacturaVenta();
                    obj.setId(rs.getInt("id"));
                    obj.setIdFacturaVenta(rs.getInt("idfacturaventa"));
                    obj.setIdRopa(rs.getInt("idropa"));
                    obj.setPrecio(rs.getFloat("precio"));
                    obj.setCantidad(rs.getInt("cantidad"));
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
    public List<DetalleFacturaVenta> findAll() throws SQLException {
        List<DetalleFacturaVenta> objList = new ArrayList<>();
        String sql = "SELECT * FROM DetalleFacturaVenta";
        try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                DetalleFacturaVenta obj = new DetalleFacturaVenta();
                obj.setId(rs.getInt("id"));
                obj.setIdFacturaVenta(rs.getInt("idfacturaventa"));
                obj.setIdRopa(rs.getInt("idropa"));
                obj.setPrecio(rs.getFloat("precio"));
                obj.setCantidad(rs.getInt("cantidad"));
                obj.setUsuario(rs.getString("usuario"));
                obj.setFechaUltModificacion(rs.getTimestamp("fechaultmodificacion").toLocalDateTime());
                objList.add(obj);
            }
        }
        return objList;
    }

    @Override
    public void update(DetalleFacturaVenta obj) throws SQLException {
        String sql = "UPDATE DetalleFacturaVenta SET idfacturaventa = ?, idropa = ?, precio = ?, cantidad = ?, usuario = ?, fechaultmodificacion = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, obj.getIdFacturaVenta());
            stmt.setInt(2, obj.getIdRopa());
            stmt.setFloat(3, obj.getPrecio());
            stmt.setInt(4, obj.getCantidad());
            stmt.setString(5, obj.getUsuario());
            stmt.setObject(6, obj.getFechaUltModificacion());
            stmt.setInt(7, obj.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM DetalleFacturaVenta WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

}

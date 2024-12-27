package com.repository.DetalleFacturaCompra;

import com.entity.DetalleFacturaCompra;
import com.repository.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DetalleFacturaCompraRepository implements IDetalleFacturaCompraRepository{
    
    private final Connection connection;
    
    public DetalleFacturaCompraRepository(){
        this.connection = ConnectionManager.getConnection();   
    }
    @Override
    public void save(DetalleFacturaCompra obj) throws SQLException {
        String sql = "INSERT INTO DetalleFacturaCompra (idfacturacompra, idropa, precio, cantidad, usuario, fechaultmodificacion) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, obj.getIdFacturaCompra());
            stmt.setInt(2, obj.getIdRopa());
            stmt.setFloat(3, obj.getPrecio());
            stmt.setInt(4, obj.getCantidad());
            stmt.setString(5, obj.getUsuario());
            stmt.setObject(6, obj.getFechaUltModificacion());
            stmt.executeUpdate();
        }
    }

    @Override
    public Optional<DetalleFacturaCompra> findById(int id) throws SQLException {
        String sql = "SELECT * FROM detallefacturacompra WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    DetalleFacturaCompra obj = new DetalleFacturaCompra();
                    obj.setId(rs.getInt("id"));
                    obj.setIdFacturaCompra(rs.getInt("idfacturacompra"));
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
    public List<DetalleFacturaCompra> findAll() throws SQLException {
        List<DetalleFacturaCompra> objList = new ArrayList<>();
        String sql = "SELECT * FROM detallefacturacompra";
        try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                DetalleFacturaCompra obj = new DetalleFacturaCompra();
                obj.setId(rs.getInt("id"));
                obj.setIdFacturaCompra(rs.getInt("idfacturacompra"));
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
    public void update(DetalleFacturaCompra obj) throws SQLException {
        String sql = "UPDATE detallefacturacompra SET idfacturacompra = ?, idropa = ?, precio = ?, cantidad = ?, usuario = ?, fechaultmodificacion = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, obj.getIdFacturaCompra());
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
        String sql = "DELETE FROM DetalleFacturaCompra WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

}

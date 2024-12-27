package com.repository.DetallePedidoVenta;

import com.entity.DetallePedidoVenta;
import com.repository.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DetallePedidoVentaRepository implements IDetallePedidoVentaRepository{

    private final Connection connection;
    
    public DetallePedidoVentaRepository(){
        this.connection = ConnectionManager.getConnection();   
    }
    @Override
    public void save(DetallePedidoVenta obj) throws SQLException {
        String sql = "INSERT INTO DetallePedidoVenta (idpedidoventa, idropa, precio, cantidad, usuario, fechaultmodificacion) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, obj.getIdPedidoVenta());
            stmt.setInt(2, obj.getIdRopa());
            stmt.setFloat(3, obj.getPrecio());
            stmt.setInt(4, obj.getCantidad());
            stmt.setString(5, obj.getUsuario());
            stmt.setObject(6, obj.getFechaUltModificacion());
            stmt.executeUpdate();
        }
    }

    @Override
    public Optional<DetallePedidoVenta> findById(int id) throws SQLException {
        String sql = "SELECT * FROM DetallePedidoCompra WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    DetallePedidoVenta obj = new DetallePedidoVenta();
                    obj.setId(rs.getInt("id"));
                    obj.setIdPedidoVenta(rs.getInt("idpedidoventa"));
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
    public List<DetallePedidoVenta> findAll() throws SQLException {
        List<DetallePedidoVenta> objList = new ArrayList<>();
        String sql = "SELECT * FROM DetallePedidoVenta";
        try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                DetallePedidoVenta obj = new DetallePedidoVenta();
                obj.setId(rs.getInt("id"));
                obj.setIdPedidoVenta(rs.getInt("idpedidoventa"));
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
    public void update(DetallePedidoVenta obj) throws SQLException {
        String sql = "UPDATE DetallePedidoVenta SET idpedidoventa = ?, idropa = ?, precio = ?, cantidad = ?, usuario = ?, fechaultmodificacion = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, obj.getIdPedidoVenta());
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
        String sql = "DELETE FROM DetallePedidoVenta WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

}

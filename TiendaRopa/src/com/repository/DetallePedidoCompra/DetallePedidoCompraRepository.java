package com.repository.DetallePedidoCompra;

import com.entity.DetallePedidoCompra;
import com.repository.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DetallePedidoCompraRepository implements IDetallePedidoCompraRepository{

    private final Connection connection;
    
    public DetallePedidoCompraRepository(){
        this.connection = ConnectionManager.getConnection();   
    }
    @Override
    public void save(DetallePedidoCompra obj) throws SQLException {
        String sql = "INSERT INTO DetallePedidoCompra (idpedidocompra, idropa, precio, cantidad, usuario, fechaultmodificacion) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, obj.getIdPedidoCompra());
            stmt.setInt(2, obj.getIdRopa());
            stmt.setFloat(3, obj.getPrecio());
            stmt.setInt(4, obj.getCantidad());
            stmt.setString(5, obj.getUsuario());
            stmt.setObject(6, obj.getFechaUltModificacion());
            stmt.executeUpdate();
        }
    }

    @Override
    public Optional<DetallePedidoCompra> findById(int id) throws SQLException {
        String sql = "SELECT * FROM DetallePedidoCompra WHERE idpedidocompra = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    DetallePedidoCompra obj = new DetallePedidoCompra();
                    obj.setId(rs.getInt("id"));
                    obj.setIdPedidoCompra(rs.getInt("idpedidocompra"));
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
    public List<DetallePedidoCompra> findAll() throws SQLException {
        List<DetallePedidoCompra> objList = new ArrayList<>();
        String sql = "SELECT * FROM DetallePedidoCompra";
        try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                DetallePedidoCompra obj = new DetallePedidoCompra();
                obj.setId(rs.getInt("id"));
                obj.setIdPedidoCompra(rs.getInt("idpedidocompra"));
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
    public void update(DetallePedidoCompra obj) throws SQLException {
        String sql = "UPDATE DetallePedidoCompra SET idpedidocompra = ?, idropa = ?, precio = ?, cantidad = ?, usuario = ?, fechaultmodificacion = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, obj.getIdPedidoCompra());
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
        String sql = "DELETE FROM DetallePedidoCompra WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

}

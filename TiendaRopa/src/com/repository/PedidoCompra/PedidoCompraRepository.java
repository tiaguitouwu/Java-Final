package com.repository.PedidoCompra;

import com.entity.PedidoCompra;
import com.repository.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PedidoCompraRepository implements IPedidoCompraRepository{

    private final Connection connection;
    
    public PedidoCompraRepository(){
        this.connection = ConnectionManager.getConnection();   
    }
    
    @Override
    public void save(PedidoCompra obj) throws SQLException {
        String sql = "INSERT INTO PedidoCompra ( idproveedor, idtienda, fechapedido, estado, usuario, fechaultmodificacion) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            //stmt.setString(1, obj.getNroPedido());
            stmt.setObject(1, obj.getIdProveedor());
            stmt.setInt(2, obj.getIdTienda());
            stmt.setObject(3, obj.getFechaPedido());
            stmt.setInt(4, obj.getEstado());
            stmt.setString(5, obj.getUsuario());
            stmt.setObject(6, obj.getFechaUltModificacion());
            stmt.executeUpdate();
        }
    }

    @Override
    public Optional<PedidoCompra> findById(int id) throws SQLException {
        String sql = "SELECT * FROM PedidoCompra WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    PedidoCompra obj = new PedidoCompra();
                    obj.setId(rs.getInt("id"));
                    obj.setNroPedido(rs.getString("nropedido"));
                    obj.setIdProveedor(rs.getInt("idproveedor"));
                    obj.setIdTienda(rs.getInt("idtienda"));
                    obj.setFechaPedido(rs.getTimestamp("fechapedido").toLocalDateTime());
                    obj.setEstado(rs.getInt("estado"));
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
    public List<PedidoCompra> findAll() throws SQLException {
        List<PedidoCompra> objList = new ArrayList<>();
        String sql = "SELECT * FROM PedidoCompra";
        try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                PedidoCompra obj = new PedidoCompra();
                obj.setId(rs.getInt("id"));
                obj.setNroPedido(rs.getString("nropedido"));
                obj.setIdProveedor(rs.getInt("idproveedor"));
                obj.setIdTienda(rs.getInt("idtienda"));
                obj.setFechaPedido(rs.getTimestamp("fechapedido").toLocalDateTime());
                obj.setEstado(rs.getInt("estado"));
                obj.setUsuario(rs.getString("usuario"));
                obj.setFechaUltModificacion(rs.getTimestamp("fechaultmodificacion").toLocalDateTime());
                objList.add(obj);
            }
        }
        return objList;
    }

    @Override
    public void update(PedidoCompra obj) throws SQLException {
        String sql = "UPDATE PedidoCompra SET idproveedor = ?, idtienda = ?, fechapedido = ?, estado = ?, usuario = ?, fechaultmodificacion = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, obj.getIdProveedor());
            stmt.setInt(2, obj.getIdTienda());
            stmt.setInt(3, obj.getEstado());
            stmt.setObject(4, obj.getFechaPedido());
            stmt.setString(5, obj.getUsuario());
            stmt.setObject(6, obj.getFechaUltModificacion());
            stmt.setInt(7, obj.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM PedidoCompra WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

}

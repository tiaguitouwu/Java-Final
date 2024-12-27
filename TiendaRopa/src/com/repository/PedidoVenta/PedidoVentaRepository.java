package com.repository.PedidoVenta;

import com.entity.PedidoVenta;
import com.repository.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PedidoVentaRepository implements IPedidoVentaRepository {

    private final Connection connection;
    
    public PedidoVentaRepository(){
        this.connection = ConnectionManager.getConnection();   
    }
    
    @Override
    public void save(PedidoVenta obj) throws SQLException {
        String sql = "INSERT INTO PedidoVenta (nropedido, idcliente, idtienda, fechapedido, estado, usuario, fechaultmodificacion) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, obj.getNroPedido());
            stmt.setInt(2, obj.getIdCliente());
            stmt.setInt(3, obj.getIdTienda());
            stmt.setObject(4, obj.getFechaPedido());
            stmt.setInt(5, obj.getEstado());
            stmt.setString(6, obj.getUsuario());
            stmt.setObject(7, obj.getFechaUltModificacion());
            stmt.executeUpdate();
        }
    }

    @Override
    public Optional<PedidoVenta> findById(int id) throws SQLException {
        String sql = "SELECT * FROM PedidoVenta WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    PedidoVenta obj = new PedidoVenta();
                    obj.setId(rs.getInt("id"));
                    obj.setNroPedido(rs.getString("nropedido"));
                    obj.setIdCliente(rs.getInt("idcliente"));
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
    public List<PedidoVenta> findAll() throws SQLException {
        List<PedidoVenta> objList = new ArrayList<>();
        String sql = "SELECT * FROM PedidoVenta";
        try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                PedidoVenta obj = new PedidoVenta();
                obj.setId(rs.getInt("id"));
                obj.setNroPedido(rs.getString("nropedido"));
                obj.setIdCliente(rs.getInt("idcliente"));
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
    public void update(PedidoVenta obj) throws SQLException {
        String sql = "UPDATE PedidoVenta SET nropedido = ?, idcliente = ?, idtienda = ?, fechapedido = ?, estado = ?, usuario = ?, fechaultmodificacion = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, obj.getNroPedido());
            stmt.setInt(2, obj.getIdCliente());
            stmt.setInt(3, obj.getIdTienda());
            stmt.setInt(4, obj.getEstado());
            stmt.setObject(5, obj.getFechaPedido());
            stmt.setString(6, obj.getUsuario());
            stmt.setObject(7, obj.getFechaUltModificacion());
            stmt.setInt(8, obj.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM PedidoVenta WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

}

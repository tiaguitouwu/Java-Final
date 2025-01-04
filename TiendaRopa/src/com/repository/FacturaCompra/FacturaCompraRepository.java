package com.repository.FacturaCompra;

import com.entity.FacturaCompra;
import com.repository.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaCompraRepository implements IFacturaCompraRepository {

    private final Connection connection;
    
    public FacturaCompraRepository(){
        this.connection = ConnectionManager.getConnection();   
    }
    @Override
    public void save(FacturaCompra obj) throws SQLException {
        String sql = "INSERT INTO FacturaCompra (idpedidocompra, nrofactura, fechafactura, estado, usuario, fechaultmodificacion) VALUES (?,?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, obj.getIdPedidoCompra());
            stmt.setInt(2, obj.getIdPedidoCompra());
            stmt.setObject(3, obj.getFechaFactura());
            stmt.setInt(4, obj.getEstado());
            stmt.setString(5, obj.getUsuario());
            stmt.setObject(6, obj.getFechaUltModificacion());
            stmt.executeUpdate();
        }
    }

    @Override
    public Optional<FacturaCompra> findById(int id) throws SQLException {
        String sql = "SELECT * FROM FacturaCompra WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    FacturaCompra obj = new FacturaCompra();
                    obj.setId(rs.getInt("id"));
                    obj.setIdPedidoCompra(rs.getInt("idpedidocompra"));
                    obj.setFechaFactura(rs.getTimestamp("fechafactura").toLocalDateTime());
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
    public List<FacturaCompra> findAll() throws SQLException {
        List<FacturaCompra> objList = new ArrayList<>();
        String sql = "SELECT * FROM FacturaCompra";
        try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                FacturaCompra obj = new FacturaCompra();
                obj.setId(rs.getInt("id"));
                obj.setIdPedidoCompra(rs.getInt("idpedidocompra"));
                obj.setFechaFactura(rs.getTimestamp("fechafactura").toLocalDateTime());
                obj.setEstado(rs.getInt("estado"));
                obj.setUsuario(rs.getString("usuario"));
                obj.setFechaUltModificacion(rs.getTimestamp("fechaultmodificacion").toLocalDateTime());
                objList.add(obj);
            }
        }
        return objList;
    }

    @Override
    public void update(FacturaCompra obj) throws SQLException {
        String sql = "UPDATE FacturaCompra SET idpedidocompra = ?, fechafactura = ?, estado = ?, usuario = ?, fechaultmodificacion = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, obj.getIdPedidoCompra());
            stmt.setObject(2, obj.getFechaFactura());
            stmt.setInt(3, obj.getEstado());
            stmt.setString(4, obj.getUsuario());
            stmt.setObject(5, obj.getFechaUltModificacion());
            stmt.setInt(6, obj.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM FacturaCompra WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

}

package com.repository.FacturaVenta;

import com.entity.FacturaVenta;
import com.repository.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaVentaRepository implements IFacturaVentaRepository{

    private final Connection connection;
    
    public FacturaVentaRepository(){
        this.connection = ConnectionManager.getConnection();   
    }
    
    @Override
    public void save(FacturaVenta obj) throws SQLException {
        String sql = "INSERT INTO FacturaVenta (idpedidoventa, fechafactura, idtimbrado, estado, usuario, fechaultmodificacion) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, obj.getIdPedidoVenta());
            stmt.setObject(2, obj.getFechaFactura());
            stmt.setInt(3, obj.getIdTimbrado());
            stmt.setInt(4, obj.getEstado());
            stmt.setString(5, obj.getUsuario());
            stmt.setObject(6, obj.getFechaUltModificacion());
            stmt.executeUpdate();
        }
    }

    @Override
    public Optional<FacturaVenta> findById(int id) throws SQLException {
        String sql = "SELECT * FROM FacturaVenta WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    FacturaVenta obj = new FacturaVenta();
                    obj.setId(rs.getInt("id"));
                    obj.setIdPedidoVenta(rs.getInt("idpedidoventa"));
                    obj.setFechaFactura(rs.getTimestamp("fechafactura").toLocalDateTime());
                    obj.setIdTimbrado(rs.getInt("idtimbrado"));
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
    public List<FacturaVenta> findAll() throws SQLException {
        List<FacturaVenta> objList = new ArrayList<>();
        String sql = "SELECT * FROM FacturaVenta";
        try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                FacturaVenta obj = new FacturaVenta();
                obj.setId(rs.getInt("id"));
                obj.setIdPedidoVenta(rs.getInt("idpedidoventa"));
                obj.setFechaFactura(rs.getTimestamp("fechafactura").toLocalDateTime());
                obj.setIdTimbrado(rs.getInt("idtimbrado"));
                obj.setEstado(rs.getInt("estado"));
                obj.setUsuario(rs.getString("usuario"));
                obj.setFechaUltModificacion(rs.getTimestamp("fechaultmodificacion").toLocalDateTime());
                objList.add(obj);
            }
        }
        return objList;
    }

    @Override
    public void update(FacturaVenta obj) throws SQLException {
        String sql = "UPDATE FacturaVenta SET idpedidoventa = ?, fechafactura = ?, idtimbrado = ?, estado = ?, usuario = ?, fechaultmodificacion = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, obj.getIdPedidoVenta());
            stmt.setObject(2, obj.getFechaFactura());
            stmt.setInt(3, obj.getIdTimbrado());
            stmt.setInt(4, obj.getEstado());
            stmt.setString(5, obj.getUsuario());
            stmt.setObject(6, obj.getFechaUltModificacion());
            stmt.setInt(7, obj.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM FacturaVenta WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

}

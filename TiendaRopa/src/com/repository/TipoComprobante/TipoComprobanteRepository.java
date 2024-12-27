package com.repository.TipoComprobante;

import com.entity.TipoComprobante;
import com.repository.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TipoComprobanteRepository implements ITipoComprobanteRepository{

    private final Connection connection;
    
    public TipoComprobanteRepository(){
        this.connection = ConnectionManager.getConnection();   
    }
    
    @Override
    public void save(TipoComprobante obj) throws SQLException {
        String sql = "INSERT INTO TipoComprobante (descripciontipocomprobante, esventa, escompra, usuario, fechaultmodificacion) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, obj.getDescripcionTipoComprobante());
            stmt.setBoolean(2, obj.isEsVenta());
            stmt.setBoolean(3, obj.isEsCompra());
            stmt.setString(4,obj.getUsuario());
            stmt.setObject(5, obj.getFechaUltModificacion());
            stmt.executeUpdate();
        }
    }

    @Override
    public Optional<TipoComprobante> findById(int id) throws SQLException {
        String sql = "SELECT * FROM TipoComprobante WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    TipoComprobante obj = new TipoComprobante();
                    obj.setId(rs.getInt("id"));
                    obj.setDescripcionTipoComprobante(rs.getString("descripciontipocomprobante"));
                    obj.setEsVenta(rs.getBoolean("esventa"));
                    obj.setEsCompra(rs.getBoolean("escompra"));
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
    public List<TipoComprobante> findAll() throws SQLException {
        List<TipoComprobante> objList = new ArrayList<>();
        String sql = "SELECT * FROM TipoComprobante";
        try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                TipoComprobante obj = new TipoComprobante();
                obj.setId(rs.getInt("id"));
                obj.setDescripcionTipoComprobante(rs.getString("descripciontipocomprobante"));
                obj.setEsVenta(rs.getBoolean("esventa"));
                obj.setEsCompra(rs.getBoolean("escompra"));
                obj.setUsuario(rs.getString("usuario"));
                obj.setFechaUltModificacion(rs.getTimestamp("fechaultmodificacion").toLocalDateTime());
                objList.add(obj);
            }
        }
        return objList;
    }

    @Override
    public void update(TipoComprobante obj) throws SQLException {
        String sql = "UPDATE TipoComprobante SET descripciontipocomprobante = ?, esventa=?, escompra=?, usuario = ?, fechaultmodificacion = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, obj.getDescripcionTipoComprobante());
            stmt.setBoolean(2, obj.isEsVenta());
            stmt.setBoolean(3, obj.isEsCompra());
            stmt.setString(4, obj.getUsuario());
            stmt.setObject(5, obj.getFechaUltModificacion());
            stmt.setInt(6, obj.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM TipoComprobante WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

}

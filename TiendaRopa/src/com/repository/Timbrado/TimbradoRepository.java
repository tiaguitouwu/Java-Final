package com.repository.Timbrado;

import com.entity.Timbrado;
import com.repository.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TimbradoRepository implements ITimbradoRepository{

    private final Connection connection;
    
    public TimbradoRepository(){
        this.connection = ConnectionManager.getConnection();   
    }
    
    @Override
    public void save(Timbrado obj) throws SQLException {
        String sql = "INSERT INTO Timbrado (idtipocomprobante, iniciovigencia, finvigencia, usuario, fechaultmodificacion) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, obj.getIdTipoComprobante());
            stmt.setObject(2, obj.getInicioVigencia());
            stmt.setObject(3, obj.getFinVigencia());
            stmt.setString(4,obj.getUsuario());
            stmt.setObject(5, obj.getFechaUltModificacion());
            stmt.executeUpdate();
        }
    }

    @Override
    public Optional<Timbrado> findById(int id) throws SQLException {
        String sql = "SELECT * FROM Timbrado WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Timbrado obj = new Timbrado();
                    obj.setId(rs.getInt("id"));
                    obj.setIdTipoComprobante(rs.getInt("idtipocomprobante"));
                    obj.setInicioVigencia(rs.getTimestamp("iniciovigencia").toLocalDateTime());
                    obj.setFinVigencia(rs.getTimestamp("finvigencia").toLocalDateTime());
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
    public List<Timbrado> findAll() throws SQLException {
        List<Timbrado> objList = new ArrayList<>();
        String sql = "SELECT * FROM Timbrado";
        try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Timbrado obj = new Timbrado();
                obj.setId(rs.getInt("id"));
                obj.setIdTipoComprobante(rs.getInt("idtipocomprobante"));
                obj.setInicioVigencia(rs.getTimestamp("iniciovigencia").toLocalDateTime());
                obj.setFinVigencia(rs.getTimestamp("finvigencia").toLocalDateTime());
                obj.setUsuario(rs.getString("usuario"));
                obj.setFechaUltModificacion(rs.getTimestamp("fechaultmodificacion").toLocalDateTime());
                objList.add(obj);
            }
        }
        return objList;
    }

    @Override
    public void update(Timbrado obj) throws SQLException {
        String sql = "UPDATE Timbrado SET idtipocomprobante = ?, iniciovigencia=?, finvigencia=?, usuario = ?, fechaultmodificacion = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, obj.getIdTipoComprobante());
            stmt.setObject(2, obj.getInicioVigencia());
            stmt.setObject(3, obj.getFinVigencia());
            stmt.setString(4, obj.getUsuario());
            stmt.setObject(5, obj.getFechaUltModificacion());
            stmt.setInt(6, obj.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Timbrado WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

}

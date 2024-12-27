package com.repository.Stock;

import com.entity.Stock;
import com.repository.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StockRepository implements IStockRepository{

    private final Connection connection;
    
    public StockRepository(){
        this.connection = ConnectionManager.getConnection();   
    }
    
    @Override
    public void save(Stock obj) throws SQLException {
        String sql = "INSERT INTO Stock (idtienda, idropa, cantidadexistencia, fechaultmodificacion) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, obj.getIdTienda());
            stmt.setInt(2, obj.getIdRopa());
            stmt.setInt(3, obj.getCantidadExistencia());
            stmt.setObject(4, obj.getFechaUltModificacion());
            stmt.executeUpdate();
        }
    }

    @Override
    public Optional<Stock> findById(int id) throws SQLException {
        String sql = "SELECT * FROM Stock WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Stock obj = new Stock();
                    obj.setId(rs.getInt("id"));
                    obj.setIdTienda(rs.getInt("idtienda"));
                    obj.setIdRopa(rs.getInt("idropa"));
                    obj.setCantidadExistencia(rs.getInt("cantidadexistencia"));
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
    public List<Stock> findAll() throws SQLException {
        List<Stock> objList = new ArrayList<>();
        String sql = "SELECT * FROM Stock";
        try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Stock obj = new Stock();
                obj.setId(rs.getInt("id"));
                obj.setIdTienda(rs.getInt("idtienda"));
                obj.setIdRopa(rs.getInt("idropa"));
                obj.setCantidadExistencia(rs.getInt("cantidadexistencia"));
                obj.setFechaUltModificacion(rs.getTimestamp("fechaultmodificacion").toLocalDateTime());
                objList.add(obj);
            }
        }
        return objList;
    }

    @Override
    public void update(Stock obj) throws SQLException {
        String sql = "UPDATE Stock SET idtienda = ?, idropa = ?, cantidadexistencia = ?, fechaultmodificacion = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, obj.getIdTienda());
            stmt.setInt(2, obj.getIdRopa());
            stmt.setInt(3, obj.getCantidadExistencia());
            stmt.setObject(4, obj.getFechaUltModificacion());
            stmt.setInt(5, obj.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Stock WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

}

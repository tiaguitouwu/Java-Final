package com.repository.Cliente;


import com.entity.Cliente;
import com.repository.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteRepository implements IClienteRepository {

    private final Connection connection;
    
    public ClienteRepository(){
        this.connection = ConnectionManager.getConnection();   
    }
    
    @Override
    public void save(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO Cliente (razonsocial, nombre, apellido, ruc, usuario, fechaultmodificacion) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cliente.getRazonSocial());
            stmt.setString(2, cliente.getNombre());
            stmt.setString(3, cliente.getApellido());
            stmt.setString(4, cliente.getRuc());
            stmt.setString(5, cliente.getUsuario());
            stmt.setObject(6, cliente.getFechaUltModificacion());
            stmt.executeUpdate();
        }
    }

    @Override
    public Optional<Cliente> findById(int id) throws SQLException {
        String sql = "SELECT * FROM Cliente WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setId(rs.getInt("id"));
                    cliente.setRazonSocial(rs.getString("razonsocial"));
                    cliente.setRazonSocial(rs.getString("nombre"));
                    cliente.setRazonSocial(rs.getString("apellido"));
                    cliente.setRazonSocial(rs.getString("ruc"));
                    cliente.setUsuario(rs.getString("usuario"));
                    cliente.setFechaUltModificacion(rs.getTimestamp("fechaultmodificacion").toLocalDateTime());
                    return Optional.of(cliente);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Cliente> findAll() throws SQLException {
        List<Cliente> clientList = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";
        try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setRazonSocial(rs.getString("razonsocial"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setRuc(rs.getString("ruc"));
                cliente.setUsuario(rs.getString("usuario"));
                cliente.setFechaUltModificacion(rs.getTimestamp("fechaultmodificacion").toLocalDateTime());
                clientList.add(cliente);
            }
        }
        return clientList;
    }

    @Override
    public void update(Cliente cliente) throws SQLException {
        String sql = "UPDATE Cliente SET razonsocial = ?, nombre = ?, apellido = ?, ruc = ?, usuario = ?, fechaultmodificacion = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cliente.getRazonSocial());
            stmt.setString(2, cliente.getNombre());
            stmt.setString(3, cliente.getApellido());
            stmt.setString(4, cliente.getRuc());
            stmt.setString(5, cliente.getUsuario());
            stmt.setObject(6, cliente.getFechaUltModificacion());
            stmt.setInt(7, cliente.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Cliente WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

}

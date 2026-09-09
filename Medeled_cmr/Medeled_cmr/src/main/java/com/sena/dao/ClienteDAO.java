package com.sena.dao;

import com.sena.conexion.Conexion;
import com.sena.modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public void insertar(Cliente cliente) {
        String sql = "INSERT INTO cliente (nombre, producto, fecha_compra, estado, observaciones) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getProducto());
            ps.setString(3, cliente.getFechaCompra());
            ps.setString(4, cliente.getEstado());
            ps.setString(5, cliente.getObservaciones());
            ps.executeUpdate();
            System.out.println("Cliente insertado correctamente");
        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }

    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Cliente c = new Cliente(
                    rs.getInt("idcliente"),
                    rs.getString("nombre"),
                    rs.getString("producto"),
                    rs.getString("fecha_compra"),
                    rs.getString("estado"),
                    rs.getString("observaciones")
                );
                lista.add(c);
                System.out.println(c.getIdCliente() + " - " + c.getNombre() + " - " + c.getEstado());
            }
        } catch (SQLException e) {
            System.out.println("Error al listar: " + e.getMessage());
        }
        return lista;
    }

    public void actualizar(Cliente cliente) {
        String sql = "UPDATE cliente SET nombre=?, producto=?, fecha_compra=?, estado=?, observaciones=? WHERE idcliente=?";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getProducto());
            ps.setString(3, cliente.getFechaCompra());
            ps.setString(4, cliente.getEstado());
            ps.setString(5, cliente.getObservaciones());
            ps.setInt(6, cliente.getIdCliente());
            ps.executeUpdate();
            System.out.println("Cliente actualizado correctamente");
        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM cliente WHERE idcliente=?";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Cliente eliminado correctamente");
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }
}
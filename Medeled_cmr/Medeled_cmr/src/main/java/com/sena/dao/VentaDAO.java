package com.sena.dao;

import com.sena.conexion.Conexion;
import com.sena.modelo.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VentaDAO {

    public void insertar(Venta venta) {
        String sql = "INSERT INTO venta (idcliente, producto, cantidad, precio_unitario, fecha_venta, estado) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, venta.getIdCliente());
            ps.setString(2, venta.getProducto());
            ps.setInt(3, venta.getCantidad());
            ps.setBigDecimal(4, venta.getPrecioUnitario());
            ps.setString(5, venta.getFechaVenta());
            ps.setString(6, venta.getEstado());
            ps.executeUpdate();
            System.out.println("Venta insertada correctamente");
        } catch (SQLException e) {
            System.out.println("Error al insertar venta: " + e.getMessage());
        }
    }

    public List<Venta> listar() {
        List<Venta> lista = new ArrayList<>();
        String sql = "SELECT * FROM venta";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Venta v = new Venta(
                    rs.getInt("idventa"),
                    rs.getInt("idcliente"),
                    rs.getString("producto"),
                    rs.getInt("cantidad"),
                    rs.getBigDecimal("precio_unitario"),
                    rs.getString("fecha_venta"),
                    rs.getString("estado")
                );
                lista.add(v);
                System.out.println(v.getIdVenta() + " - cliente " + v.getIdCliente() + " - " + v.getProducto() + " x" + v.getCantidad() + " - " + v.getEstado());
            }
        } catch (SQLException e) {
            System.out.println("Error al listar ventas: " + e.getMessage());
        }
        return lista;
    }

    public void actualizar(Venta venta) {
        String sql = "UPDATE venta SET idcliente=?, producto=?, cantidad=?, precio_unitario=?, fecha_venta=?, estado=? WHERE idventa=?";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, venta.getIdCliente());
            ps.setString(2, venta.getProducto());
            ps.setInt(3, venta.getCantidad());
            ps.setBigDecimal(4, venta.getPrecioUnitario());
            ps.setString(5, venta.getFechaVenta());
            ps.setString(6, venta.getEstado());
            ps.setInt(7, venta.getIdVenta());
            ps.executeUpdate();
            System.out.println("Venta actualizada correctamente");
        } catch (SQLException e) {
            System.out.println("Error al actualizar venta: " + e.getMessage());
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM venta WHERE idventa=?";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Venta eliminada correctamente");
        } catch (SQLException e) {
            System.out.println("Error al eliminar venta: " + e.getMessage());
        }
    }
}

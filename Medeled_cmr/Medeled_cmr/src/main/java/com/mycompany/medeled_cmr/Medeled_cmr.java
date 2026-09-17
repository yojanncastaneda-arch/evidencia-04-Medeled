/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.medeled_cmr;
import com.sena.dao.ClienteDAO;
import com.sena.dao.VentaDAO;
import com.sena.modelo.Cliente;
import com.sena.modelo.Venta;
import java.math.BigDecimal;
/**
 *
 * @author USER
 */
public class Medeled_cmr {


    public static void main(String[] args) {
        ClienteDAO clienteDao = new ClienteDAO();

        Cliente c1 = new Cliente(0, "Carlos Pérez", "Lavadora", "2026-09-01", "pendiente", "Reclamo por ruido");
        clienteDao.insertar(c1);
        clienteDao.listar();

        Cliente c2 = new Cliente(2, "Carlos Pérez", "Lavadora", "2026-09-01", "resuelto", "Se cambió la pieza");
        clienteDao.actualizar(c2);
        clienteDao.listar();

        VentaDAO ventaDao = new VentaDAO();

        Venta v1 = new Venta(0, 2, "Panel solar 450W", 4, new BigDecimal("850000.00"), "2026-09-16", "pendiente");
        ventaDao.insertar(v1);
        ventaDao.listar();
    }
}


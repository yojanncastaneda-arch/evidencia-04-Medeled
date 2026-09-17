package com.sena.web;

import com.sena.dao.VentaDAO;
import com.sena.modelo.Venta;
import java.math.BigDecimal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VentaController {

    private final VentaDAO ventaDAO = new VentaDAO();

    @GetMapping("/ventas")
    public String listar(Model model) {
        model.addAttribute("ventas", ventaDAO.listar());
        return "ventas";
    }

    @PostMapping("/ventas")
    public String crear(@RequestParam int idCliente,
                         @RequestParam String producto,
                         @RequestParam int cantidad,
                         @RequestParam BigDecimal precioUnitario,
                         @RequestParam String fechaVenta,
                         @RequestParam String estado) {
        ventaDAO.insertar(new Venta(0, idCliente, producto, cantidad, precioUnitario, fechaVenta, estado));
        return "redirect:/ventas";
    }
}

package com.sena.web;

import com.sena.dao.ClienteDAO;
import com.sena.modelo.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClienteController {

    private final ClienteDAO clienteDAO = new ClienteDAO();

    @GetMapping("/clientes")
    public String listar(Model model) {
        model.addAttribute("clientes", clienteDAO.listar());
        return "clientes";
    }

    @PostMapping("/clientes")
    public String crear(@RequestParam String nombre,
                         @RequestParam String producto,
                         @RequestParam String fechaCompra,
                         @RequestParam String estado,
                         @RequestParam String observaciones) {
        clienteDAO.insertar(new Cliente(0, nombre, producto, fechaCompra, estado, observaciones));
        return "redirect:/clientes";
    }
}

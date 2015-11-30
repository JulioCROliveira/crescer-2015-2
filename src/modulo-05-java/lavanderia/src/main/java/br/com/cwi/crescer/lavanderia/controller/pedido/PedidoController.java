package br.com.cwi.crescer.lavanderia.controller.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cwi.crescer.lavanderia.services.PedidoService;

@Controller
@RequestMapping("/pedidos")
public abstract class PedidoController {

    protected PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }
}

package br.com.cwi.crescer.lavanderia.controller.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.lavanderia.dto.pedido.PedidoDTO;
import br.com.cwi.crescer.lavanderia.services.PedidoService;

@Controller
@RequestMapping("/pedidos")
public class PedidoBuscarController extends PedidoController {

    @Autowired
    public PedidoBuscarController(PedidoService pedidoService) {
        super(pedidoService);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {
        return new ModelAndView("pedido/lista", "pedidos", pedidoService.listarTodosPedidos());
    }

    @ResponseBody
    @RequestMapping(path = "/rest/{id}")
    public PedidoDTO buscarCliente(@PathVariable("id") Long id) {
        return pedidoService.buscarPedidoPorId(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ModelAndView viewExibe(@PathVariable("id") Long id) {
        return new ModelAndView("pedido/exibe", "pedido", pedidoService.buscarPedidoPorId(id));
    }
}

package br.com.cwi.crescer.lavanderia.controller.pedido;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.lavanderia.dto.pedido.PedidoDTO;
import br.com.cwi.crescer.lavanderia.services.ClienteService;
import br.com.cwi.crescer.lavanderia.services.PedidoService;

@Controller
@RequestMapping("/pedidos")
public class PedidoAdicionarController extends PedidoController {

    private ClienteService clienteService;

    @Autowired
    public PedidoAdicionarController(PedidoService pedidoService, ClienteService clienteService) {
        super(pedidoService);
        this.clienteService = clienteService;
    }

    @RequestMapping(path = "/clientes", method = RequestMethod.GET)
    public ModelAndView listar(HttpServletRequest request) {
        String nome = request.getParameter("nome");
        if (nome != null) {
            return new ModelAndView("pedido/listaClientes", "clientes", clienteService.filtraAtivosPorNome(nome));
        }
        return new ModelAndView("pedido/listaClientes", "clientes", clienteService.listarClientesAtivos());
    }

    @RequestMapping(path = "/novo/{id}", method = RequestMethod.GET)
    public ModelAndView viewExibe(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("pedido/novo");
        mv.addObject("cliente", clienteService.buscarClientePorId(id));
        mv.addObject("pedido", new PedidoDTO());
        return mv;
    }
}

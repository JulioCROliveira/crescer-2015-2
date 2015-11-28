package br.com.cwi.crescer.lavanderia.controller.cliente;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.lavanderia.dto.cliente.ClienteDTO;
import br.com.cwi.crescer.lavanderia.services.CidadeService;
import br.com.cwi.crescer.lavanderia.services.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteBuscarController extends ClienteController {

    @Autowired
    public ClienteBuscarController(ClienteService clienteService, CidadeService cidadeService) {
        super(clienteService, cidadeService);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar(HttpServletRequest request) {
        String nome = request.getParameter("nome");
        if (nome != null) {
            return new ModelAndView("cliente/lista", "clientes", clienteService.filtraPorNome(nome));
        }
        return new ModelAndView("cliente/lista", "clientes", clienteService.listarClientesTodos());
    }

    @ResponseBody
    @RequestMapping(path = "/rest/{id}")
    public ClienteDTO buscarCliente(@PathVariable("id") Long id) {
        return clienteService.buscarClientePorId(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ModelAndView viewExibe(@PathVariable("id") Long id) {
        return new ModelAndView("cliente/exibe", "cliente", clienteService.buscarClientePorId(id));
    }
}

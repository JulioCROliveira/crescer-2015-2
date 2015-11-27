package br.com.cwi.crescer.lavanderia.controller.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.lavanderia.dto.ClienteDTO;
import br.com.cwi.crescer.lavanderia.services.CidadeService;
import br.com.cwi.crescer.lavanderia.services.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteRemoverController extends ClienteController {

    @Autowired
    public ClienteRemoverController(ClienteService clienteService, CidadeService cidadeService) {
        super(clienteService, cidadeService);
    }

    @RequestMapping(path = "/deletar/{id}", method = RequestMethod.GET)
    public ModelAndView viewDeleta(@PathVariable("id") Long id) {
        return new ModelAndView("cliente/deleta", "cliente", clienteService.buscarClientePorId(id));
    }

    @RequestMapping(path = "/deletar", method = RequestMethod.POST)
    public ModelAndView deletar(ClienteDTO dto, RedirectAttributes redirectAttributes) {
        clienteService.inativar(dto);
        redirectAttributes.addFlashAttribute("mensagem", "Cliente inativado com sucesso!");
        return new ModelAndView("redirect:/clientes");
    }

}

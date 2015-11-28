package br.com.cwi.crescer.lavanderia.controller.cliente;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.lavanderia.dto.cliente.ClienteDTO;
import br.com.cwi.crescer.lavanderia.services.CidadeService;
import br.com.cwi.crescer.lavanderia.services.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteAdicionarController extends ClienteController {

    @Autowired
    public ClienteAdicionarController(ClienteService clienteService, CidadeService cidadeService) {
        super(clienteService, cidadeService);
    }

    @RequestMapping(path = "/novo", method = RequestMethod.GET)
    public ModelAndView viewNovo() {
        return new ModelAndView("cliente/novo", "cliente", new ClienteDTO());
    }

    @RequestMapping(path = "/novo", method = RequestMethod.POST)
    public ModelAndView adicinar(@Valid @ModelAttribute("cliente") ClienteDTO dto,
            BindingResult result, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("mensagem", "Cliente criado com sucesso!");

        if (result.hasErrors()) {
            return new ModelAndView("cliente/novo");
        }

        clienteService.adicionar(dto);
        return new ModelAndView("redirect:/clientes");
    }

}

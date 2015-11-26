package br.com.cwi.crescer.lavanderia.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.lavanderia.domain.Cidade;
import br.com.cwi.crescer.lavanderia.dto.ClienteDTO;
import br.com.cwi.crescer.lavanderia.services.CidadeService;
import br.com.cwi.crescer.lavanderia.services.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteService clienteService;
    private CidadeService cidadeService;

    @Autowired
    public ClienteController(ClienteService clienteService, CidadeService cidadeService) {
        this.clienteService = clienteService;
        this.cidadeService = cidadeService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {
        return new ModelAndView("cliente/lista", "clientes", clienteService.listarClientesAtivos());
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

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/editar/{id}", method = RequestMethod.GET)
    public ModelAndView viewEdita(@PathVariable("id") Long id) {
        return new ModelAndView("cliente/edita", "cliente", clienteService.buscarClientePorId(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/editar", method = RequestMethod.POST)
    public ModelAndView editar(@Valid @ModelAttribute("cliente") ClienteDTO dto,
            BindingResult result, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("mensagem", "Cliente editado com sucesso!");

        if (result.hasErrors()) {
            return new ModelAndView("cliente/edita", "cliente", dto);
        }

        clienteService.atualizar(dto);
        return new ModelAndView("redirect:/clientes");
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

    @ModelAttribute("cidades")
    public List<Cidade> comboCidades() {
        return cidadeService.listar();
    }
}

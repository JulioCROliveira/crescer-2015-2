package br.com.cwi.crescer.lavanderia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.lavanderia.dto.UsuarioDTO;
import br.com.cwi.crescer.lavanderia.services.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {
        return new ModelAndView("usuarios/lista", "usuarios", usuarioService.listarUsuarios());
    }

    @ResponseBody
    @RequestMapping(path = "/rest/{username}")
    public UsuarioDTO buscarUsuario(@PathVariable("username") String username) {
        return usuarioService.buscarUsuarioPorUsername(username);
    }

    @RequestMapping(path = "/{username}", method = RequestMethod.GET)
    public ModelAndView viewExibe(@PathVariable("username") String username) {
        return new ModelAndView("usuarios/exibe", "usuarios", usuarioService.buscarUsuarioPorUsername(username));
    }

    // @PreAuthorize("hasRole('ADMIN')")
    // @RequestMapping(path = "/editar/{id}", method = RequestMethod.GET)
    // public ModelAndView viewEdita(@PathVariable("id") Long id) {
    // return new ModelAndView("cliente/edita", "cliente", clienteService.buscarClientePorId(id));
    // }
    //
    // @PreAuthorize("hasRole('ADMIN')")
    // @RequestMapping(path = "/editar", method = RequestMethod.POST)
    // public ModelAndView editar(@Valid @ModelAttribute("cliente") ClienteDTO dto,
    // BindingResult result, RedirectAttributes redirectAttributes) {
    // redirectAttributes.addFlashAttribute("mensagem", "Cliente editado com sucesso!");
    //
    // if (result.hasErrors()) {
    // return new ModelAndView("cliente/edita", "cliente", dto);
    // }
    //
    // clienteService.atualizar(dto);
    // return new ModelAndView("redirect:/clientes");
    // }
    //
    // @RequestMapping(path = "/novo", method = RequestMethod.GET)
    // public ModelAndView viewNovo() {
    // return new ModelAndView("cliente/novo", "cliente", new ClienteDTO());
    // }
    //
    // @RequestMapping(path = "/novo", method = RequestMethod.POST)
    // public ModelAndView adicinar(@Valid @ModelAttribute("cliente") ClienteDTO dto,
    // BindingResult result, RedirectAttributes redirectAttributes) {
    // redirectAttributes.addFlashAttribute("mensagem", "Cliente criado com sucesso!");
    //
    // if (result.hasErrors()) {
    // return new ModelAndView("cliente/novo");
    // }
    //
    // clienteService.adicionar(dto);
    // return new ModelAndView("redirect:/clientes");
    // }
    //
    // @RequestMapping(path = "/deletar/{id}", method = RequestMethod.GET)
    // public ModelAndView viewDeleta(@PathVariable("id") Long id) {
    // return new ModelAndView("cliente/deleta", "cliente", clienteService.buscarClientePorId(id));
    // }
    //
    // @RequestMapping(path = "/deletar", method = RequestMethod.POST)
    // public ModelAndView deletar(ClienteDTO dto, RedirectAttributes redirectAttributes) {
    // clienteService.inativar(dto);
    // redirectAttributes.addFlashAttribute("mensagem", "Cliente inativado com sucesso!");
    // return new ModelAndView("redirect:/clientes");
    // }
    //
    // @ModelAttribute("cidades")
    // public List<Cidade> comboCidades() {
    // return cidadeService.listar();
    // }
}

package br.com.cwi.crescer.lavanderia.controller.produto;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.lavanderia.dto.produto.ProdutoEdicaoDTO;
import br.com.cwi.crescer.lavanderia.services.MaterialService;
import br.com.cwi.crescer.lavanderia.services.ProdutoService;
import br.com.cwi.crescer.lavanderia.services.ServicoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoEditarController extends ProdutoController {

    @Autowired
    public ProdutoEditarController(ProdutoService produtoService,
            ServicoService servicoService, MaterialService materialService) {
        super(produtoService, servicoService, materialService);

    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/editar", method = RequestMethod.POST)
    public ModelAndView editar(@Valid @ModelAttribute("produto") ProdutoEdicaoDTO dto,
            BindingResult result, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("mensagem", "Produto editado com sucesso!");

        if (result.hasErrors()) {
            return new ModelAndView("produto/edita", "produto", dto);
        }

        produtoService.atualizar(dto);
        return new ModelAndView("redirect:/produtos");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/editar/{id}", method = RequestMethod.GET)
    public ModelAndView viewEdita(@PathVariable("id") Long id) {
        return new ModelAndView("produto/edita", "produto", produtoService.buscarProdutoPorId(id));
    }
}

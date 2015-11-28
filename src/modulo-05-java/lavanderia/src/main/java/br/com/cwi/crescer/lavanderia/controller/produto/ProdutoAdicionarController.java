package br.com.cwi.crescer.lavanderia.controller.produto;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.lavanderia.dto.produto.ProdutoInclusaoDTO;
import br.com.cwi.crescer.lavanderia.services.MaterialService;
import br.com.cwi.crescer.lavanderia.services.ProdutoService;
import br.com.cwi.crescer.lavanderia.services.ServicoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoAdicionarController extends ProdutoController {

    @Autowired
    public ProdutoAdicionarController(ProdutoService produtoService,
            ServicoService servicoService, MaterialService materialService) {
        super(produtoService, servicoService, materialService);

    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/novo", method = RequestMethod.GET)
    public ModelAndView viewNovo(HttpServletRequest request, @ModelAttribute("produto") ProdutoInclusaoDTO dto) {
        Long idServico = 1L;
        ModelAndView mv = new ModelAndView("produto/novo");
        if (request.getParameter("idServico") != null) {
            idServico = Long.parseLong(request.getParameter("idServico"));
        } else {
            mv.addObject("produto", new ProdutoInclusaoDTO());
        }
        mv.addObject("materiais", materialService.listar(idServico));
        return mv;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/novo", method = RequestMethod.POST)
    public ModelAndView adicinar(@Valid @ModelAttribute("produto") ProdutoInclusaoDTO dto,
            BindingResult result, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("mensagem", "Produto inserido com sucesso!");

        if (result.hasErrors()) {
            return new ModelAndView("produto/novo");
        }

        produtoService.adicionar(dto);
        return new ModelAndView("redirect:/produtos");
    }
}

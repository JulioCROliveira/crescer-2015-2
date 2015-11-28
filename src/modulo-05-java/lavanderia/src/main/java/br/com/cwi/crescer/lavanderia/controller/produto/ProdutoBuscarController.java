package br.com.cwi.crescer.lavanderia.controller.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.lavanderia.services.MaterialService;
import br.com.cwi.crescer.lavanderia.services.ProdutoService;
import br.com.cwi.crescer.lavanderia.services.ServicoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoBuscarController extends ProdutoController {

    @Autowired
    public ProdutoBuscarController(ProdutoService produtoService,
            ServicoService servicoService, MaterialService materialService) {
        super(produtoService, servicoService, materialService);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {
        return new ModelAndView("produto/lista", "produtos", produtoService.listarTodosProdutos());
    }
}

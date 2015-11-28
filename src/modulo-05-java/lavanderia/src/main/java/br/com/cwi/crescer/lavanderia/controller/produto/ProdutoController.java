package br.com.cwi.crescer.lavanderia.controller.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cwi.crescer.lavanderia.domain.Servico;
import br.com.cwi.crescer.lavanderia.services.MaterialService;
import br.com.cwi.crescer.lavanderia.services.ProdutoService;
import br.com.cwi.crescer.lavanderia.services.ServicoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    protected ProdutoService produtoService;
    protected ServicoService servicoService;
    protected MaterialService materialService;

    @Autowired
    public ProdutoController(ProdutoService produtoService,
            ServicoService servicoService, MaterialService materialService) {
        this.produtoService = produtoService;
        this.servicoService = servicoService;
        this.materialService = materialService;
    }

    @ModelAttribute("servicos")
    protected List<Servico> comboServicos() {
        return servicoService.listar();
    }
}

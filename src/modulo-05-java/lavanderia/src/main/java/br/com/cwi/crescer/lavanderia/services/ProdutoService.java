package br.com.cwi.crescer.lavanderia.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.dao.MaterialDAO;
import br.com.cwi.crescer.lavanderia.dao.ProdutoDAO;
import br.com.cwi.crescer.lavanderia.dao.ServicoDAO;
import br.com.cwi.crescer.lavanderia.domain.Produto;
import br.com.cwi.crescer.lavanderia.dto.produto.ProdutoEdicaoDTO;
import br.com.cwi.crescer.lavanderia.dto.produto.ProdutoInclusaoDTO;
import br.com.cwi.crescer.lavanderia.dto.produto.ProdutoListagemDTO;
import br.com.cwi.crescer.lavanderia.mapper.produto.ProdutoEdicaoMapper;
import br.com.cwi.crescer.lavanderia.mapper.produto.ProdutoInclusaoMapper;
import br.com.cwi.crescer.lavanderia.mapper.produto.ProdutoListagemMapper;

@Service
public class ProdutoService {

    private ProdutoDAO produtoDAO;
    private MaterialDAO materialDAO;
    private ServicoDAO servicoDAO;

    @Autowired
    public ProdutoService(ProdutoDAO produtoDAO, MaterialDAO materialDAO, ServicoDAO servicoDAO) {
        this.produtoDAO = produtoDAO;
        this.materialDAO = materialDAO;
        this.servicoDAO = servicoDAO;
    }

    public List<ProdutoListagemDTO> listarTodosProdutos() {
        List<Produto> produtos = produtoDAO.listAll();

        List<ProdutoListagemDTO> dtos = new ArrayList<ProdutoListagemDTO>();

        for (Produto produto : produtos) {
            dtos.add(ProdutoListagemMapper.toDTO(produto));
        }

        return dtos;
    }

    public void adicionar(ProdutoInclusaoDTO dto) {
        Produto entity = ProdutoInclusaoMapper.getNewEntity(dto);
        entity.setMaterial(materialDAO.findById(dto.getIdMaterial()));
        entity.setServico(servicoDAO.findById(dto.getIdServico()));
        entity.setSituacao(Produto.SituacaoProduto.ATIVO);
        produtoDAO.save(entity);
    }

    public void atualizar(ProdutoEdicaoDTO dto) {
        Produto entity = produtoDAO.findById(dto.getIdProduto());
        ProdutoEdicaoMapper.merge(dto, entity);

        produtoDAO.save(entity);
    }

    public Object buscarProdutoPorId(Long id) {
        return ProdutoEdicaoMapper.toDTO(produtoDAO.findById(id));
    }

}

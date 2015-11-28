package br.com.cwi.crescer.lavanderia.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.dao.ProdutoDAO;
import br.com.cwi.crescer.lavanderia.domain.Produto;
import br.com.cwi.crescer.lavanderia.dto.produto.ProdutoListagemDTO;
import br.com.cwi.crescer.lavanderia.mapper.ProdutoListagemMapper;

@Service
public class ProdutoService {

    private ProdutoDAO produtoDAO;

    @Autowired
    public ProdutoService(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    public List<ProdutoListagemDTO> listarTodosProdutos() {
        List<Produto> produtos = produtoDAO.listAll();

        List<ProdutoListagemDTO> dtos = new ArrayList<ProdutoListagemDTO>();

        for (Produto produto : produtos) {
            dtos.add(ProdutoListagemMapper.toDTO(produto));
        }

        return dtos;
    }

}

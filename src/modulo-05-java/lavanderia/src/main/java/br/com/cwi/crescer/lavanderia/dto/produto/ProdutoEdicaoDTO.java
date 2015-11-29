package br.com.cwi.crescer.lavanderia.dto.produto;

import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import br.com.cwi.crescer.lavanderia.domain.Produto;

public class ProdutoEdicaoDTO {

    @NotNull
    private Long idProduto;

    @NotNull
    @Min(value = 0)
    private BigDecimal valor;

    @NotNull
    @Min(value = 0)
    @Max(value = 999)
    private int prazo;

    @NotNull
    private Produto.SituacaoProduto situacao;

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public int getPrazo() {
        return prazo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

    public Produto.SituacaoProduto getSituacao() {
        return situacao;
    }

    public void setSituacao(Produto.SituacaoProduto situacao) {
        this.situacao = situacao;
    }

}

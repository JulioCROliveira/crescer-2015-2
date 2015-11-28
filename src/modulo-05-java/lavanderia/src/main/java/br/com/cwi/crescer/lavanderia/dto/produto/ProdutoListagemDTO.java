package br.com.cwi.crescer.lavanderia.dto.produto;

import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.NumberFormat;

import br.com.cwi.crescer.lavanderia.domain.Produto;

public class ProdutoListagemDTO {

    @NotNull
    private Long idProduto;

    @NotBlank
    private String servico;

    @NotBlank
    private String material;

    @NotNull
    @Min(value = 0)
    @NumberFormat(pattern = "R$ #,00")
    private BigDecimal valor;

    @NotNull
    @Min(value = 0)
    @Max(value = 999)
    private int prazo;

    @NotNull
    private Produto.SituacaoProduto situacao;

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getPrazo() {
        return prazo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Produto.SituacaoProduto getSituacao() {
        return situacao;
    }

    public void setSituacao(Produto.SituacaoProduto situacao) {
        this.situacao = situacao;
    }
}

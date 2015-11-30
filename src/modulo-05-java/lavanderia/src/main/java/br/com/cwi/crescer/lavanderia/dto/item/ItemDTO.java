package br.com.cwi.crescer.lavanderia.dto.item;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import br.com.cwi.crescer.lavanderia.domain.Item;

public class ItemDTO {

    @NotNull
    private Long idItem;

    @NotNull
    private Long idPedido;

    @NotNull
    private Long idProduto;
    private String servico;
    private String material;

    @NotNull
    private BigDecimal peso;

    @NotBlank
    private String valorUnitario;

    @NotNull
    private BigDecimal valorTotal;

    @NotNull
    private Item.SituacaoItem situacao;

    public Long getIdItem() {
        return idItem;
    }

    public void setIdItem(Long idItem) {
        this.idItem = idItem;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public String getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(String valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Item.SituacaoItem getSituacao() {
        return situacao;
    }

    public void setSituacao(Item.SituacaoItem situacao) {
        this.situacao = situacao;
    }

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

}

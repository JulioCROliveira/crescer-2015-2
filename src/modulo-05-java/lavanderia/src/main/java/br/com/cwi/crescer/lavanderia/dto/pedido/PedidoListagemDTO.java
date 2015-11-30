package br.com.cwi.crescer.lavanderia.dto.pedido;

import java.util.Date;

import br.com.cwi.crescer.lavanderia.domain.Pedido;

public class PedidoListagemDTO {

    private Long idPedido;

    private Long idCliente;
    private String cpf;
    private String nomeCliente;

    private Date dataInclusao;

    private String valorTotal;

    private Pedido.SituacaoPedido situacao;

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(String valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Pedido.SituacaoPedido getSituacao() {
        return situacao;
    }

    public void setSituacao(Pedido.SituacaoPedido situacao) {
        this.situacao = situacao;
    }

}

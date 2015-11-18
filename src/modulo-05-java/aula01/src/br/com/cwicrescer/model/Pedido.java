package br.com.cwicrescer.model;


public class Pedido {

    private long idPedido;
    private long idCliente;
    private String dsPedido;

    public long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(long idPedido) {
        this.idPedido = idPedido;
    }

    public String getDsPedido() {
        return dsPedido;
    }

    public void setDsPedido(String dsPedido) {
        this.dsPedido = dsPedido;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }


}

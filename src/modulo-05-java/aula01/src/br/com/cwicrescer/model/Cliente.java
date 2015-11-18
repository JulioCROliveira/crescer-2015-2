package br.com.cwicrescer.model;


public class Cliente {

    private long idCliente;
    private String nmCliente, nrCpf;

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNmCliente() {
        return nmCliente;
    }

    public void setNmCliente(String nmCliente) {
        this.nmCliente = nmCliente;
    }

    public String getNrCpf() {
        return nrCpf;
    }

    public void setNrCpf(String nrCpf) {
        this.nrCpf = nrCpf;
    }

    @Override
    public String toString() {
        return String.format("Id: %s, Nome: %d, CPF: %s", this.idCliente, this.nmCliente, this.nrCpf);
    }
}

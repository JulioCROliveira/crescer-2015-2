package br.com.cwi.crescer.lavanderia.dto.cliente;

import br.com.cwi.crescer.lavanderia.domain.Cliente;

public class ClienteResumoDTO {

    private String nome;
    private String cpf;
    private String situacao;
    private Long id;

    public ClienteResumoDTO() {
    }

    public ClienteResumoDTO(Long id, String nome, String cpf, String situacao) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.situacao = situacao;
    }

    public ClienteResumoDTO(Cliente entity) {
        id = entity.getIdCliente();
        nome = entity.getNome();
        cpf = entity.getCpf();
        situacao = entity.getSituacao().toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

}

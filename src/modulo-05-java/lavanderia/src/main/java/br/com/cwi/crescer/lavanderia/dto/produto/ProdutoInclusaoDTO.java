package br.com.cwi.crescer.lavanderia.dto.produto;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ProdutoInclusaoDTO {

    @NotNull
    private Long idServico;

    @NotNull
    private Long idMaterial;

    @NotNull
    @Min(value = 0)
    @Digits(integer = 12, fraction = 2)
    private BigDecimal valor;
    // problema com virgula no lugar de ponto

    @NotNull
    @Min(value = 0)
    @Max(value = 999)
    private int prazo;

    public Long getIdServico() {
        return idServico;
    }

    public void setIdServico(Long idServico) {
        this.idServico = idServico;
    }

    public Long getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Long idMaterial) {
        this.idMaterial = idMaterial;
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
}

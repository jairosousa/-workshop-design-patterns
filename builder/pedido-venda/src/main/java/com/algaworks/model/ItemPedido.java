package com.algaworks.model;

import java.math.BigDecimal;

/**
 * @Autor Jairo Nascimento
 * @Created 26/12/2021 - 15:23
 */
public class ItemPedido {

    private String nome;
    private BigDecimal valorUnitario;
    private Integer quantidade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}

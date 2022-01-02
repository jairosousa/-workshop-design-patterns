package com.jnsdev.venda.venda;

import java.math.BigDecimal;

/**
 * @Autor Jairo Nascimento
 * @Created 02/01/2022 - 18:26
 */
public class Produto {

    private String nome;
    private Integer quantidade;
    private BigDecimal valorUnitario;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getValorTotal(double imposto) {
        BigDecimal valorTotal = valorUnitario.add(new BigDecimal(imposto));

        valorTotal = valorTotal.multiply(new BigDecimal(quantidade));

        return valorTotal.doubleValue();
    }
}

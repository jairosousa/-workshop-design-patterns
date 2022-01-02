package com.algaworks.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Autor Jairo Nascimento
 * @Created 26/12/2021 - 15:22
 */
public class PedidoVenda {

    private String numero;

    private Cliente cliente;

    private List<ItemPedido> itensPedidos;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItensPedidos() {
        return itensPedidos;
    }

    public void setItensPedidos(List<ItemPedido> itensPedidos) {
        this.itensPedidos = itensPedidos;
    }

    public BigDecimal getValorTotal() {
        BigDecimal valorTotal = BigDecimal.ZERO;
        for (ItemPedido item : itensPedidos) {
            valorTotal =
                    valorTotal.add(item.getValorUnitario().multiply(new BigDecimal(item.getQuantidade())));
        }
        /**
         * Se o cliente é vip desconto 4%
         */
        if (cliente.isVip()) {
            valorTotal = valorTotal.multiply(new BigDecimal("0.96"));
        }
        return valorTotal;
    }


}

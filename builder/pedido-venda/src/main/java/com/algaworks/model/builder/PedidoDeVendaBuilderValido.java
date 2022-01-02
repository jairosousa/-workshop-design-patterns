package com.algaworks.model.builder;

import com.algaworks.model.Cliente;
import com.algaworks.model.ItemPedido;
import com.algaworks.model.PedidoVenda;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * @Autor Jairo Nascimento
 * @Created 02/01/2022 - 11:21
 */
public class PedidoDeVendaBuilderValido {

    private PedidoVenda instancia;

    public PedidoDeVendaBuilderValido(PedidoVenda instancia) {
        this.instancia = instancia;
    }

    public PedidoVenda construir() {
        return this.instancia;
    }
}

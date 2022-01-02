package com.algaworks.model;

import com.algaworks.model.builder.PedidoDeVendaBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


/**
 * @Autor Jairo Nascimento
 * @Created 26/12/2021 - 15:33
 */
public class PedidoVendaTest {

    @Test
    public void deveCalcularValorTotalPedidoParaClienteVip() {
        PedidoVenda pedidoVenda = new PedidoVenda();

        Cliente cliente = new Cliente();
        cliente.setNome("João");
        cliente.setVip(true);
        pedidoVenda.setCliente(cliente);

        ItemPedido item1 = new ItemPedido();
        item1.setNome("Calculador");
        item1.setValorUnitario(new BigDecimal("200"));
        item1.setQuantidade(2);

        ItemPedido item2 = new ItemPedido();
        item2.setNome("Mochila");
        item2.setValorUnitario(new BigDecimal("200"));
        item2.setQuantidade(1);

        List<ItemPedido> itemPedidos = Arrays.asList(item1,item2);
        pedidoVenda.setItensPedidos(itemPedidos);

        BigDecimal valorTotal = pedidoVenda.getValorTotal();

        Assert.assertEquals(new BigDecimal("576").doubleValue(), valorTotal.doubleValue(), 0.0001);

    }

    @Test
    public void deveCalcularValorTotalPedidoParaClienteVipComBuilder() {
        PedidoVenda pedidoVenda = new PedidoDeVendaBuilder()
                .comClienteVip("João Silva")
                .comItem("Calculadora", 2, "200")
                .comItem("Mochila", 1, "200")
                .comNumero("02366")
                .construir();

        BigDecimal valorTotal = pedidoVenda.getValorTotal();

        Assert.assertEquals(new BigDecimal("576").doubleValue(), valorTotal.doubleValue(), 0.0001);
    }

}
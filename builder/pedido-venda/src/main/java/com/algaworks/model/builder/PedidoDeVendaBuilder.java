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
public class PedidoDeVendaBuilder {

    private PedidoVenda instancia;

    public PedidoDeVendaBuilder() {
        this.instancia = new PedidoVenda();
    }

    public PedidoDeVendaBuilder comClienteVip(String nome){
        definirCliente(nome,true);
        return this;
    }

    public PedidoDeVendaBuilder comClienteNormal(String nome){
        definirCliente(nome,false);
        return this;
    }

    /**
     * ) numero é obrigatório
     * @param numero
     * @return PedidoDeVendaBuilderValido
     */
    public PedidoDeVendaBuilderValido comNumero(String numero){
        this.instancia.setNumero(numero);
        return new PedidoDeVendaBuilderValido(instancia);
    }


    public PedidoDeVendaBuilder comItem(String nome, Integer quantidade, String valor) {
        ItemPedido item = new ItemPedido();
        item.setNome(nome);
        item.setValorUnitario(new BigDecimal(valor));
        item.setQuantidade(quantidade);

        if (this.instancia.getItensPedidos() == null) {
            this.instancia.setItensPedidos(new ArrayList<ItemPedido>());
        }
        this.instancia.getItensPedidos().add(item);

        return this;
    }

    private void definirCliente(String nome, boolean vip) {
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setVip(vip);
        this.instancia.setCliente(cliente);
    }

}

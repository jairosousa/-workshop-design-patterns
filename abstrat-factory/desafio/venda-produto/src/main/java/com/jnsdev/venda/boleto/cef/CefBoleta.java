package com.jnsdev.venda.boleto.cef;

import com.jnsdev.venda.boleto.Boleta;
import com.jnsdev.venda.venda.Produto;

/**
 * @Autor Jairo Nascimento
 * @Created 02/01/2022 - 17:18
 */
public class CefBoleta implements Boleta {

    @Override
    public void emitir(Produto produto, double imposto) {
        System.out.println("Emitindo Boleto pela Caixa Economica");
        System.out.println("Emissão de Boleto da Banco Itaú");
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
        System.out.println("Imposto: R$" + imposto);
        System.out.println("Valor Total: R$" + produto.getValorTotal(imposto) + "\n\n");
    }

}

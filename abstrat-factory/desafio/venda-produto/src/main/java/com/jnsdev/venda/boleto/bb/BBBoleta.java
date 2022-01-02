package com.jnsdev.venda.boleto.bb;

import com.jnsdev.venda.boleto.Boleta;
import com.jnsdev.venda.venda.Produto;

/**
 * @Autor Jairo Nascimento
 * @Created 02/01/2022 - 17:17
 */
public class BBBoleta implements Boleta {

    @Override
    public void emitir(Produto produto, double imposto) {
        System.out.println("emitindo um boleto pelo BB");
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
        System.out.println("ValorUnitario: R$" + produto.getValorUnitario());
        System.out.println("Imposto Unirario: R$" + imposto);
        System.out.println("Valor Total: R$" + produto.getValorTotal(imposto));
        System.out.println("Imposto Total: R$" + (imposto * produto.getQuantidade()) + "\n\n");    }
}

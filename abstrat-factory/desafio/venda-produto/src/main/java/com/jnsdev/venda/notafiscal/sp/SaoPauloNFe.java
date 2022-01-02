package com.jnsdev.venda.notafiscal.sp;

import com.jnsdev.venda.notafiscal.NFe;
import com.jnsdev.venda.venda.Produto;

import java.math.BigDecimal;

/**
 * @Autor Jairo Nascimento
 * @Created 02/01/2022 - 17:19
 */
public class SaoPauloNFe implements NFe {

    private BigDecimal aliquota = new BigDecimal("0.30");

    @Override
    public double calculaImposto(Produto produto) {
        BigDecimal imposto = aliquota.multiply(produto.getValorUnitario());

        return imposto.doubleValue();
    }

    @Override
    public void gerar(Produto produto, double imposto) {
        System.out.println("Emissão da Nota Fiscal para o estado de São Paulo");
        System.out.println("--------------------------------------------------");
        System.out.println("Aliquota: " + (aliquota.doubleValue() * 100) + "%");
        System.out.println("Descrição do produto: " + produto.getNome());
        System.out.println("Quantidade: " + produto.getQuantidade());
        System.out.println("Valor Unitário: " + produto.getValorUnitario());
        System.out.println("Imposto: R$" + imposto);
        System.out.println("Valor Total: R$" + produto.getValorTotal(imposto)+"\n");

    }
}

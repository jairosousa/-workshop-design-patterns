package com.jnsdev.venda.notafiscal;

import com.jnsdev.venda.venda.Produto;

/**
 * @Autor Jairo Nascimento
 * @Created 02/01/2022 - 17:10
 */
public interface NFe {

    double calculaImposto(Produto produto);

    void gerar(Produto produto, double imposto);
}

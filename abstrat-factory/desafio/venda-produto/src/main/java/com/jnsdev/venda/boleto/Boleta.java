package com.jnsdev.venda.boleto;

import com.jnsdev.venda.venda.Produto;

/**
 * @Autor Jairo Nascimento
 * @Created 02/01/2022 - 17:10
 */
public interface Boleta {

    void emitir(Produto produto, double imposto);
}

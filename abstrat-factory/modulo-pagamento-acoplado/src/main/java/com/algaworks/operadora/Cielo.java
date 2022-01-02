package com.algaworks.operadora;

import java.math.BigDecimal;

/**
 * @Autor Jairo Nascimento
 * @Created 02/01/2022 - 15:13
 */
public class Cielo {

    private Long codigConfirmacao = -1L;

    public void capturar(String cartao, BigDecimal valor) throws CapturaNaoAutorizadaException{
        if (cartao.startsWith("5555")) {
            throw new CapturaNaoAutorizadaException("Número de cartão inválido!");
        }
        this.codigConfirmacao = (long) Math.random() * 1000;
    }

    public Long confirmar() {
        System.out.println("Fazendo o débito na conta do cliente via Cielo");
        return this.codigConfirmacao;
    }
}

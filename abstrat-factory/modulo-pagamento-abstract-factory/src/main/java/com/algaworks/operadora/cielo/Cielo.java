package com.algaworks.operadora.cielo;

import com.algaworks.operadora.CapturaNaoAutorizadaException;
import com.algaworks.operadora.Operadora;

import java.math.BigDecimal;

/**
 * @Autor Jairo Nascimento
 * @Created 02/01/2022 - 15:13
 */
public class Cielo implements Operadora {

    private Long codigConfirmacao = -1L;

    @Override
    public void capturar(String cartao, BigDecimal valor) throws CapturaNaoAutorizadaException{
        if (cartao.startsWith("5555")) {
            throw new CapturaNaoAutorizadaException("Número de cartão inválido!");
        }
        this.codigConfirmacao = (long) Math.random() * 1000;
    }

    @Override
    public Long confirmar() {
        System.out.println("Fazendo o débito na conta do cliente via Cielo");
        return this.codigConfirmacao;
    }
}

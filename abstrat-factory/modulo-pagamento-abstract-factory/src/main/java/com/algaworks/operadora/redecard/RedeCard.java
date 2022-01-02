package com.algaworks.operadora.redecard;

import com.algaworks.operadora.CapturaNaoAutorizadaException;
import com.algaworks.operadora.Operadora;

import java.math.BigDecimal;

/**
 * @Autor Jairo Nascimento
 * @Created 02/01/2022 - 16:09
 */
public class RedeCard implements Operadora {

    private Long codigConfirmacao = -1L;

    @Override
    public void capturar(String cartao, BigDecimal valor) throws CapturaNaoAutorizadaException{
        if (cartao.startsWith("2222") && valorMaiorQueLimite(valor)) {
            throw new CapturaNaoAutorizadaException("Valor maior que o limite para o cartão informado.");
        }
        this.codigConfirmacao = (long) Math.random() * 300;
    }

    @Override
    public Long confirmar() {
        System.out.println("Fazendo o débito na conta do cliente via Redecard");
        return this.codigConfirmacao;
    }

    private boolean valorMaiorQueLimite(BigDecimal valor) {
        BigDecimal limite = new BigDecimal("1000");
        return limite.compareTo(valor) < 0;
    }
}

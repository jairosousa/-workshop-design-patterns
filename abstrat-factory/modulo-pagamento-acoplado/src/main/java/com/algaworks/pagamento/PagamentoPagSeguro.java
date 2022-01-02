package com.algaworks.pagamento;

import com.algaworks.gestorderisco.AlertaDeRiscoException;
import com.algaworks.gestorderisco.FControl;
import com.algaworks.operadora.CapturaNaoAutorizadaException;
import com.algaworks.operadora.Cielo;

import java.math.BigDecimal;

/**
 * @Autor Jairo Nascimento
 * @Created 02/01/2022 - 15:05
 */
public class PagamentoPagSeguro {

    private Cielo operadora;
    private FControl gestorDeRisco;

    public PagamentoPagSeguro(Cielo operadora, FControl gestorDeRisco) {
        this.operadora = operadora;
        this.gestorDeRisco = gestorDeRisco;
    }

    public Long autorizar(String cartao, BigDecimal valor) throws CapturaNaoAutorizadaException, AlertaDeRiscoException {
        this.operadora.capturar(cartao, valor);
        this.gestorDeRisco.avaliarRisco(cartao,valor);
        return this.operadora.confirmar();
    }
}

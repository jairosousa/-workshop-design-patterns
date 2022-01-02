package com.algaworks.pagamento;

import com.algaworks.gestorderisco.AlertaDeRiscoException;
import com.algaworks.gestorderisco.GestorDeRisco;
import com.algaworks.gestorderisco.fcontrol.FControl;
import com.algaworks.operadora.CapturaNaoAutorizadaException;
import com.algaworks.operadora.Operadora;

import java.math.BigDecimal;

/**
 * @Autor Jairo Nascimento
 * @Created 02/01/2022 - 15:05
 */
public class Pagamento {

    private Operadora operadora;
    private GestorDeRisco gestorDeRisco;

    public Pagamento(ModuloPagamentoFactory moduloPagamentoFactory) {
        this.operadora = moduloPagamentoFactory.criarOperadora();
        this.gestorDeRisco = moduloPagamentoFactory.criarGestorDeRisco();
    }

    public Long autorizar(String cartao, BigDecimal valor) throws CapturaNaoAutorizadaException, AlertaDeRiscoException {
        this.operadora.capturar(cartao, valor);
        this.gestorDeRisco.avaliarRisco(cartao,valor);
        return this.operadora.confirmar();
    }
}

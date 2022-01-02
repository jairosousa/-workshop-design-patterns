package com.algaworks.pagamento;

import com.algaworks.gestorderisco.AlertaDeRiscoException;
import com.algaworks.gestorderisco.GestorDeRisco;
import com.algaworks.gestorderisco.fcontrol.FControl;
import com.algaworks.operadora.CapturaNaoAutorizadaException;
import com.algaworks.operadora.Operadora;
import com.algaworks.operadora.cielo.Cielo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @Autor Jairo Nascimento
 * @Created 02/01/2022 - 15:11
 */
public class PagamentoViaPagSeguro {

    private Pagamento pagamento;

    @Before
    public void setUp() {
        Operadora operadora = new Cielo();
        GestorDeRisco gestorDeRisco = new FControl();
        pagamento = new Pagamento(operadora, gestorDeRisco);
    }

    @Test
    public void deveAutorizarVanda() throws CapturaNaoAutorizadaException, AlertaDeRiscoException {
        Long codigoAutorizacao = pagamento.autorizar("2222.2222", new BigDecimal("200"));
        Assert.assertNotNull(codigoAutorizacao);
    }

    @Test(expected = CapturaNaoAutorizadaException.class)
    public void deveNegarCaptura_cartaoInavalido() throws CapturaNaoAutorizadaException, AlertaDeRiscoException {
        pagamento.autorizar("5555.2222", new BigDecimal("2000"));
    }

    @Test(expected = AlertaDeRiscoException.class)
    public void deveAlertaDeRisco() throws CapturaNaoAutorizadaException, AlertaDeRiscoException {
        pagamento.autorizar("7777.2222", new BigDecimal("5500"));
    }

}
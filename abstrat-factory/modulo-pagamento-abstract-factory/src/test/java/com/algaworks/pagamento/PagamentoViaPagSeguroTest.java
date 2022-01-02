package com.algaworks.pagamento;

import com.algaworks.gestorderisco.AlertaDeRiscoException;
import com.algaworks.operadora.CapturaNaoAutorizadaException;
import com.algaworks.pagamento.pagseguro.PagSeguroModuloPagamentoFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @Autor Jairo Nascimento
 * @Created 02/01/2022 - 15:11
 */
public class PagamentoViaPagSeguroTest {

    private Pagamento pagamento;

    @Before
    public void setUp() {
        ModuloPagamentoFactory moduloPagamentoFactory = new PagSeguroModuloPagamentoFactory();
        pagamento = new Pagamento(moduloPagamentoFactory);
    }

    @Test
    public void deveAutorizarVenda() throws CapturaNaoAutorizadaException, AlertaDeRiscoException {
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
package com.algaworks.pagamento;

import com.algaworks.gestorderisco.AlertaDeRiscoException;
import com.algaworks.gestorderisco.GestorDeRisco;
import com.algaworks.gestorderisco.clearsale.ClearSale;
import com.algaworks.gestorderisco.fcontrol.FControl;
import com.algaworks.operadora.CapturaNaoAutorizadaException;
import com.algaworks.operadora.Operadora;
import com.algaworks.operadora.cielo.Cielo;
import com.algaworks.operadora.redecard.RedeCard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @Autor Jairo Nascimento
 * @Created 02/01/2022 - 15:11
 */
public class PagamentoViaPayPalTest {

    private Pagamento pagamento;

    @Before
    public void setUp() {
        Operadora operadora = new RedeCard();
        GestorDeRisco gestorDeRisco = new ClearSale();
        pagamento = new Pagamento(operadora, gestorDeRisco);
    }

    @Test
    public void deveAutorizarVanda() throws CapturaNaoAutorizadaException, AlertaDeRiscoException {
        Long codigoAutorizacao = pagamento.autorizar("2222.2222", new BigDecimal("200"));
        Assert.assertNotNull(codigoAutorizacao);
    }

    @Test(expected = CapturaNaoAutorizadaException.class)
    public void deveNegarCaptura_valorAcimaDoLimiteParaCartao() throws CapturaNaoAutorizadaException, AlertaDeRiscoException {
        pagamento.autorizar("2222.2222", new BigDecimal("2000"));
    }

    @Test
    public void deveAutorizarVanda_valorAltoComCartaoValido() throws CapturaNaoAutorizadaException, AlertaDeRiscoException {
        Long codigoAutorizacao = pagamento.autorizar("3333.2222", new BigDecimal("2000"));
        Assert.assertNotNull(codigoAutorizacao);
    }

    @Test(expected = AlertaDeRiscoException.class)
    public void deveGerarAlertaDeRisco() throws CapturaNaoAutorizadaException, AlertaDeRiscoException {
        pagamento.autorizar("1111.2222", new BigDecimal("5500"));
    }

}
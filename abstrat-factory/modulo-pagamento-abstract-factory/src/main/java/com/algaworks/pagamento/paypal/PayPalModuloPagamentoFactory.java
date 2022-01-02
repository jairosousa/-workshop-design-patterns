package com.algaworks.pagamento.paypal;

import com.algaworks.gestorderisco.GestorDeRisco;
import com.algaworks.gestorderisco.clearsale.ClearSale;
import com.algaworks.gestorderisco.fcontrol.FControl;
import com.algaworks.operadora.Operadora;
import com.algaworks.operadora.cielo.Cielo;
import com.algaworks.operadora.redecard.RedeCard;
import com.algaworks.pagamento.ModuloPagamentoFactory;

/**
 * @Autor Jairo Nascimento
 * @Created 02/01/2022 - 16:30
 */
public class PayPalModuloPagamentoFactory implements ModuloPagamentoFactory {

    @Override
    public Operadora criarOperadora() {
        return new RedeCard();
    }

    @Override
    public GestorDeRisco criarGestorDeRisco() {
        return new ClearSale();
    }
}

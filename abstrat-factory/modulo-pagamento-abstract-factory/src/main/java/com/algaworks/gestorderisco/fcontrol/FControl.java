package com.algaworks.gestorderisco.fcontrol;

import com.algaworks.gestorderisco.AlertaDeRiscoException;
import com.algaworks.gestorderisco.GestorDeRisco;

import java.math.BigDecimal;

/**
 * @Autor Jairo Nascimento
 * @Created 02/01/2022 - 15:15
 */
public class FControl implements GestorDeRisco {

    @Override
    public void avaliarRisco(String cartao, BigDecimal valor) throws AlertaDeRiscoException{
        if (cartao.startsWith("7777")) {
            throw new AlertaDeRiscoException("Cartão suspeito");
        }
    }
}

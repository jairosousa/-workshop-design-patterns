package com.algaworks.gestorderisco;

import java.math.BigDecimal;

/**
 * @Autor Jairo Nascimento
 * @Created 02/01/2022 - 15:57
 */
public interface GestorDeRisco {

    void avaliarRisco(String cartao, BigDecimal valor) throws AlertaDeRiscoException;
}

package com.algaworks.operadora;

import java.math.BigDecimal;

/**
 * @Autor Jairo Nascimento
 * @Created 02/01/2022 - 15:52
 */
public interface Operadora {

    void capturar(String cartao, BigDecimal valor) throws CapturaNaoAutorizadaException;

    Long confirmar();
}

package com.algaworks.pagamento;

import com.algaworks.gestorderisco.GestorDeRisco;
import com.algaworks.operadora.Operadora;

/**
 * @Autor Jairo Nascimento
 * @Created 02/01/2022 - 16:28
 */
public interface ModuloPagamentoFactory {

    Operadora criarOperadora();
    GestorDeRisco criarGestorDeRisco();

}

package com.jnsdev.venda.venda;

import com.jnsdev.venda.boleto.Boleta;
import com.jnsdev.venda.notafiscal.NFe;

import java.lang.reflect.InvocationTargetException;

/**
 * @Autor Jairo Nascimento
 * @Created 02/01/2022 - 17:34
 */
public interface ModuloVendaFactory {

    NFe criarNFe() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;

    Boleta criarBoleta() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
}

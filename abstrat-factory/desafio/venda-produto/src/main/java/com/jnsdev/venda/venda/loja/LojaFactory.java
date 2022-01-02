package com.jnsdev.venda.venda.loja;

import com.jnsdev.venda.boleto.Boleta;
import com.jnsdev.venda.notafiscal.NFe;
import com.jnsdev.venda.venda.ModuloVendaFactory;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

/**
 * @Autor Jairo Nascimento
 * @Created 02/01/2022 - 17:38
 */
public class LojaFactory implements ModuloVendaFactory {

    Properties prop;

    private String siglaEstado;
    private String siglaBanco;

    public LojaFactory(String siglaEstado, String siglaBanco) throws IOException {
        this.siglaBanco = siglaBanco;
        this.siglaEstado = siglaEstado;
        this.prop = new Properties();
        prop.load(this.getClass().getResourceAsStream("/config.properties"));
    }

    @Override
    @SuppressWarnings({"unchecked", "deprecated"})
    public NFe criarNFe() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String classeNFe = this.prop.getProperty(siglaEstado);
        return (NFe) Class.forName(classeNFe).getConstructor().newInstance();
    }

    @Override
    @SuppressWarnings({"unchecked", "deprecated"})
    public Boleta criarBoleta() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String classeNFe = this.prop.getProperty(siglaBanco);
        return (Boleta) Class.forName(classeNFe).getConstructor().newInstance();
    }
}

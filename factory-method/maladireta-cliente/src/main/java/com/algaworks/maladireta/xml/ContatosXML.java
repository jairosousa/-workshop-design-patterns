package com.algaworks.maladireta.xml;

import com.algaworks.contato.Contato;
import com.algaworks.contato.Contatos;
import com.thoughtworks.xstream.XStream;

import java.net.URL;
import java.util.List;

/**
 * @Autor Jairo Nascimento
 * @Created 26/12/2021 - 13:38
 */
public class ContatosXML implements Contatos {

    private String nomeArquivo;

    public ContatosXML(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    @Override
    public List<Contato> todos() {
        XStream xStream = new XStream();
        xStream.alias("contatos", List.class);
        xStream.alias("contato", Contato.class);

        URL arquivo = this.getClass().getResource("/" + nomeArquivo);
        return (List<Contato>) xStream.fromXML(arquivo);
    }
}

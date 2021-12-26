package com.algaworks.maladireta.csv;

import com.algaworks.contato.Contatos;
import com.algaworks.maladireta.MalaDireta;

/**
 * @Autor Jairo Nascimento
 * @Created 26/12/2021 - 13:17
 */
public class MalaDiretaCSV extends MalaDireta {

    private String nomeArquivo;

    public MalaDiretaCSV(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    @Override
    protected Contatos criarContatos() {
        return new ContatosCSV(nomeArquivo);
    }
}

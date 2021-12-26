package com.algaworks.maladireta;

import com.algaworks.contato.Contato;
import com.algaworks.contato.Contatos;

import java.util.List;

/**
 * @Autor Jairo Nascimento
 * @Created 26/12/2021 - 12:09
 */
public abstract class MalaDireta {

    protected abstract Contatos criarContatos();

    public boolean enviaEmail(String mensagem) {
        List<Contato> contatos = criarContatos().todos();

        System.out.println("Conectando no servidor SMTP...");
        System.out.println("Mensagem enviada: " + mensagem);
        System.out.println();

        for (Contato contato : contatos) {
            System.out.println("From: <contato@algaworks.com>");
            System.out.printf("To:[%s] <%s>\n", contato.getNome(), contato.getEmail());
            System.out.println(mensagem);
            System.out.println();
        }
        return true;
    }
}

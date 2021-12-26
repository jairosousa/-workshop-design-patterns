package com.algaworks;

import com.algaworks.maladireta.MalaDireta;
import com.algaworks.maladireta.xml.MalaDiretaXML;

import javax.swing.*;

/**
 * @Autor Jairo Nascimento
 * @Created 26/12/2021 - 13:47
 */
public class NovoClienteCadastrado {

    public static void main(String[] args) {
        MalaDireta malaDiretaXML = new MalaDiretaXML("contatos.xml");

        String mensagem = JOptionPane.showInputDialog(null, "Informe a mensagem de novo cliente");

        boolean status = malaDiretaXML.enviaEmail(mensagem);

        int situacao = JOptionPane.showConfirmDialog(null, "Emails enviados: " + status);

        System.out.println(situacao);
    }
}

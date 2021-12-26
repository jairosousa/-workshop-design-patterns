package com.algaworks;

import com.algaworks.maladireta.MalaDireta;

import javax.swing.*;

/**
 * @Autor Jairo Nascimento
 * @Created 26/12/2021 - 10:55
 */
public class Principal {
    public static void main(String[] args) {
        MalaDireta malaDireta = new MalaDireta();
        String mensagem = JOptionPane.showInputDialog(null, "Informe a mensagem para e-mail");
        boolean status = malaDireta.enviaEmail("contatos.xml", mensagem);

        System.out.println(status);
    }
}

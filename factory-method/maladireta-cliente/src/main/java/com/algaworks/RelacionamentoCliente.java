package com.algaworks;

import com.algaworks.maladireta.MalaDireta;
import com.algaworks.maladireta.csv.MalaDiretaCSV;
import com.algaworks.maladireta.xml.MalaDiretaXML;

import javax.swing.*;

/**
 * @Autor Jairo Nascimento
 * @Created 26/12/2021 - 13:22
 */
public class RelacionamentoCliente {

    public static void main(String[] args) {
        MalaDireta malaDiretaCSV = new MalaDiretaCSV("contatos.csv");
        String mensagem = JOptionPane.showInputDialog(null, "Informe a mensagem para e-mail");
        boolean status = malaDiretaCSV.enviaEmail(mensagem);

        JOptionPane.showConfirmDialog(null, "Emails enviados: " + status);

    }
}

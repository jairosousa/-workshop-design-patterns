package com.algaworks.contato;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;
import com.thoughtworks.xstream.XStream;

/**
 * @Autor Jairo Nascimento
 * @Created 26/12/2021 - 10:55
 */
public class Contatos {
    public List<Contato> recuperaContatosCSV(String nomeArquivo) {
        List<Contato> contatos = new ArrayList<>();

        CSVReader csvReader = null;

        try {
            URI uri = this.getClass().getResource("/" + nomeArquivo).toURI();
            File arquivoCSV = new File(uri);
            FileReader fileReader = new FileReader(arquivoCSV);
            csvReader = new CSVReader(fileReader);
            String[] nextLine;

            while ((nextLine = csvReader.readNext()) != null) {
                contatos.add(new Contato(nextLine[0].trim(), nextLine[1].trim()));
            }

        }catch (Exception e){
            throw new RuntimeException("Erro lendo arquivo csv", e);
        }finally {
            try {
                csvReader.close();
            }catch (IOException e){}
        }

        return contatos;
    }

    @SuppressWarnings("unchecked")
    public List<Contato> recuperaContatosXML(String nomeArquivo) {
        XStream xStream = new XStream();
        xStream.alias("contatos", List.class);
        xStream.alias("contato", Contato.class);

        URL arquivo = this.getClass().getResource("/" + nomeArquivo);
        return (List<Contato>) xStream.fromXML(arquivo);
    }
}

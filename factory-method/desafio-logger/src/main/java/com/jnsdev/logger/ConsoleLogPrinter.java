package com.jnsdev.logger;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Autor Jairo Nascimento
 * @Created 26/12/2021 - 14:25
 */
public class ConsoleLogPrinter implements LogPrinter {

    @Override
    public void printMensagem(TipoLogs logs, String mensagem) {
        System.out.printf("%s: %s: %s\n", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss")), logs, mensagem);
    }
}

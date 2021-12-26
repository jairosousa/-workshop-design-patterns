package com.jnsdev.logger;

/**
 * @Autor Jairo Nascimento
 * @Created 26/12/2021 - 14:27
 */
public class ConsoleLogCreator extends Logger {

    @Override
    protected LogPrinter createLogger() {
        return new ConsoleLogPrinter();
    }
}

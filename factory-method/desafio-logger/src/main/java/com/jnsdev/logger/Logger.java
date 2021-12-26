package com.jnsdev.logger;

/**
 * @Autor Jairo Nascimento
 * @Created 26/12/2021 - 14:16
 */
public abstract class Logger {

    protected abstract LogPrinter createLogger();

    public void info(String mensagem) {
        createLogger().printMensagem(TipoLogs.INFO, mensagem);
    }

    public void error(String mensagem) {
        createLogger().printMensagem(TipoLogs.ERROR, mensagem);
    }

    public void warning(String mensagem) {
        createLogger().printMensagem(TipoLogs.WARNING, mensagem);
    }
}

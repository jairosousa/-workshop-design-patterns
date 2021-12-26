package com.jnsdev;

import com.jnsdev.logger.ConsoleLogCreator;
import com.jnsdev.logger.Logger;

/**
 * @Autor Jairo Nascimento
 * @Created 26/12/2021 - 14:54
 */
public class Principal {

    public static void main(String[] args) {
        Logger logger = new ConsoleLogCreator();

        logger.info("Menssagem INFO");
        logger.error("Menssagem ERROR");
        logger.warning("Menssagem WARNING");

    }
}

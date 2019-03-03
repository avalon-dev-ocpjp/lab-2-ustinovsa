package ru.avalon.java.ocpjp.labs;

import ru.avalon.java.ocpjp.labs.console.ConsoleUI;

import java.io.IOException;
import ru.avalon.java.ocpjp.labs.actions.Action;
import ru.avalon.java.ocpjp.labs.actions.FileCopyAction;
import ru.avalon.java.ocpjp.labs.actions.FileDeleteAction;
import ru.avalon.java.ocpjp.labs.actions.FileInfoAction;
import ru.avalon.java.ocpjp.labs.actions.FileMoveAction;

/**
 * Лабораторная работа №2
 * <p>
 * Курс: "DEV-OCPJP. Подготовка к сдаче
 * сертификационных экзаменов серии Oracle Certified
 * Professional Java Programmer"
 * <p>
 * Тема: "Потоки исполнения (Threads) и многозадачность" 
 *
 * @author Daniel Alpatov <danial.alpatov@gmail.com>
 */
public class Main extends ConsoleUI<Commands> {
    /**
     * Точка входа в приложение.
     * 
     * @param args 
     */
    public static void main(String[] args) {
        new Main().run();
    }
    /**
     * Конструктор класса.
     * <p>
     * Инициализирует экземпляр базового типа с использоавнием
     * перечисления {@link Commands}.
     */
    Main() {
        super(Commands.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCommand(Commands command) throws IOException {
        switch (command) {
            case copy:
                /*
                 * TODO №6 Обработайте команду copy
                 */
                Action copyFile = new FileCopyAction();
                copyFile.run();
                break;
                
            case move:
                /*
                 * TODO №7 Обработайте команду move
                 */
                Action moveFile = new FileMoveAction();
                moveFile.run();
                break;
                
            case info:
                Action infoFile = new FileInfoAction();
                infoFile.run();
                break;
                
            case delete:
                Action deleteFile = new FileDeleteAction();
                deleteFile.run();
                break;
                
            case exit:
                close();
                break;
                /*
                 * TODO №9 Обработайте необработанные команды
                 */
        }
    }
    
}
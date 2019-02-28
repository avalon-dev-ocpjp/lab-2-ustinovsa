package ru.avalon.java.ocpjp.labs;

import ru.avalon.java.ocpjp.labs.console.ConsoleUI;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.avalon.java.ocpjp.labs.actions.FileCopyAction;
import ru.avalon.java.ocpjp.labs.actions.FileDeleteAction;
import ru.avalon.java.ocpjp.labs.actions.FileMoveAction;

/**
 * Лабораторная работа №2
 * <p>
 * Курс: "DEV-OCPJP. Подготовка к сдаче сертификационных экзаменов серии Oracle
 * Certified Professional Java Programmer"
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
     * Инициализирует экземпляр базового типа с использоавнием перечисления
     * {@link Commands}.
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
                FileCopyAction copy = new FileCopyAction();
                copy.start();

                break;
            case move:
                /*
                 * TODO №7 Обработайте команду move
                 */
                FileMoveAction move = new FileMoveAction();
                move.start();
                break;
            case exit:
                close();
                break;
            case delete:
                FileDeleteAction delete = new FileDeleteAction();
                delete.start();
                break;
            case help:
                System.out.println("Commands and parameters:");
                System.out.println("------------------------");
                System.out.println("copy");
                System.out.println("path file for copy");
                System.out.println("path target file");
                System.out.println("------------------------");
                System.out.println("move");
                System.out.println("path file for move");
                System.out.println("new path for file");
                System.out.println("------------------------");
                System.out.println("delete");
                System.out.println("path file for delete");
                System.out.println("------------------------");
                System.out.println("exit");
                System.out.println("This command whithout prameters closing application.");
                System.out.println("------------------------");
                System.out.println("help");
                System.out.println("Help with the application .");
                break;
            /*
                 * TODO №9 Обработайте необработанные команды
             */
        }
    }

}

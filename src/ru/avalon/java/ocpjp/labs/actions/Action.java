package ru.avalon.java.ocpjp.labs.actions;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Абстрактное представление о действии, как функциональном элементе приложения.
 * <p>
 * Действие является потоковым объектом, что позволяет исполнять несколько
 * действий параллельно и не блокировать основной поток исполнения.
 */
public interface Action extends Runnable, AutoCloseable {

    /**
     * Запускает потоковый объект на исполнение в отдельном потоке исполнения.
     * @param action
     */
    default void start() {
        /*
         * TODO №1 Реализуйте метод start интерфейса Action.
         */

        Thread thread = new Thread(this);
        thread.start();

    }

}

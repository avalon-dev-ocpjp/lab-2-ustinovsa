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
     */
    default void start(String action) {
        /*
         * TODO №1 Реализуйте метод start интерфейса Action.
         */
        switch (action) {

            case "copy":
                try (FileCopyAction fcopy = new FileCopyAction()){
                    fcopy.run();
                } catch (Exception ex) {
            Logger.getLogger(Action.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                break;
            case "move":
               try(FileMoveAction fmove = new FileMoveAction()){
                fmove.run();
               } catch (Exception ex) {
            Logger.getLogger(Action.class.getName()).log(Level.SEVERE, null, ex);
        }
                break;
            case "create":
                try(FileCreateAction fcreate = new FileCreateAction()){
                fcreate.run();
                } catch (Exception ex) {
            Logger.getLogger(Action.class.getName()).log(Level.SEVERE, null, ex);
        }
                break;
            case "delete":
                try(FileDeleteAction fdelete = new FileDeleteAction()){
                fdelete.run();
                } catch (Exception ex) {
            Logger.getLogger(Action.class.getName()).log(Level.SEVERE, null, ex);
        }
                break;

        }
    }

}

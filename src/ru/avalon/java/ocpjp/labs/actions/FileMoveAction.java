package ru.avalon.java.ocpjp.labs.actions;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Действие, которое перемещает файлы в пределах дискового
 * пространства.
 */
public class FileMoveAction implements Action {
    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        /*
         * TODO №4 Реализуйте метод run класса FileMoveAction
         */
        File distination = FileUtils.getFile ("C:\\Users\\UIS\\Downloads\\Source\\");
        File source = FileUtils.getFile("c:\\Users\\UIS\\Desktop\\Avalon\\lab-1\\lab-1\\src\\ru\\avalon\\java\\ocpjp\\labs\\resources\\first-names.txt");
        try {
            FileUtils.moveFileToDirectory(source, distination, false);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //throw new UnsupportedOperationException("Not implemented yet!");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void close() throws Exception {
        /*
         * TODO №5 Реализуйте метод close класса FileMoveAction
         */
        throw new UnsupportedOperationException("Not implemented yet!");
    }

}

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
    File source = FileUtils.getFile("C:\\Users\\UIS\\Desktop\\1\\src\\ru\\avalon\\java\\ocpjp\\labs\\resources\\last-names.txt");
    File distination = FileUtils.getFile ("C:\\Users\\UIS\\Desktop\\1\\src\\ru\\avalon\\java\\ocpjp\\labs\\newresourcers\\");

    @Override
    public void run() {
        try {
            FileUtils.moveFileToDirectory(source, distination, false);
        } catch (IOException e) {
            System.out.println("File not found!!!!");;
        }
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void close() throws Exception {

        distination = null;
        source = null;
        throw new UnsupportedOperationException("Not implemented yet!");
    }

}

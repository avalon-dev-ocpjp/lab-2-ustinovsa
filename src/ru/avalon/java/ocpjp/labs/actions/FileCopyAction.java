package ru.avalon.java.ocpjp.labs.actions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

/**
 * Действие, которое копирует файлы в пределах дискового
 * пространства.
 */
public class FileCopyAction implements Action {
    /**
     * {@inheritDoc}
     */
    private File source;
    private File dest;
    
    public FileCopyAction()  {
        try {
        System.out.println("Input the source file's path to copy: ");
        Scanner sc = new Scanner(System.in);
        source = new File(sc.next());
        if (source.exists()) {
            System.out.println("Input the destination file's path to copy: ");
            dest = new File(sc.next());
            if (!dest.exists()) {
                this.dest.createNewFile();
                System.out.println("Destination file was created, copied and located on the path " + dest);
            } else {
                System.out.println("File was copied and located on the path " + dest);
            }
        } else {
        System.out.println("Source file does not exist");
        } 
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    @Override
    public void run() {
        try {
            /*
            * TODO №2 Реализуйте метод run класса FileCopyAction
            */
            synchronized (source) {
            Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException | NullPointerException ex) {
            System.err.println(ex.getMessage()); 
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void close() throws Exception {
        /*
         * TODO №3 Реализуйте метод close класса FileCopyAction
         */
        //nothing to close
    }
}

package ru.avalon.java.ocpjp.labs.actions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

/**
 * Действие, которое перемещает файлы в пределах дискового
 * пространства.
 */
public class FileMoveAction implements Action {
    /**
     * {@inheritDoc}
     */
    private File source;
    private File dest;
    
    public FileMoveAction() {
        try {
        System.out.println("Input the source file's path to move: ");
        Scanner sc = new Scanner(System.in);
        source = new File(sc.next());
        if (source.exists()) {
            System.out.println("Input the destination file's path to move: ");
            dest = new File(sc.next() + "/" + source.getName());
            if (!dest.exists()) {
                this.dest.createNewFile();
                System.out.println("File copied and located on the path " + dest);
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
            * TODO №4 Реализуйте метод run класса FileMoveAction
            */
            synchronized (source) {
            Files.move(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
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
         * TODO №5 Реализуйте метод close класса FileMoveAction
         */
        //nothing to close
    }

}
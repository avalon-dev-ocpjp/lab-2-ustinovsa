package ru.avalon.java.ocpjp.labs.actions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Действие, которое копирует файлы в пределах дискового пространства.
 */
public class FileCopyAction implements Action {

    private Path file;
    private Path newdir;
    private BufferedReader br;
    private boolean copy_fl;

    public FileCopyAction() throws IOException {
        System.out.println("Input name file for copy:");
        br = new BufferedReader(new InputStreamReader(System.in));
        file = Paths.get(br.readLine());
        if (file.toFile().exists()) {
            System.out.println("Input name target file:");
            newdir = Paths.get(br.readLine());
            if (newdir.toString().length() == 0) {
                newdir = Paths.get(System.getProperty("user.dir") + file.toFile().getName());
            }

            copy_fl = true;
        } else {
            copy_fl = false;
            System.out.println("File not exists!");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        /*
         * TODO №2 Реализуйте метод run класса FileCopyAction
         */
        if (copy_fl) {
            Path res;
            try {
                synchronized (file) {
                    res = Files.copy(file, newdir, StandardCopyOption.REPLACE_EXISTING);

                }
                System.out.println("File copying was successful! File copy to: " + res.toString());
            } catch (IOException ex) {
                System.out.println("File copy error: " + ex.getMessage());
            }
        } else {
            System.out.println("Command Copy cannot be executed. File " + this.file.toFile().toString() + " not exists!");
        }
        try {
            this.close();
        } catch (Exception ex) {
            System.out.println("Object close error: " + ex.getMessage());
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
//        br.close();
        br = null;
        file = null;
        newdir = null;
    }
}

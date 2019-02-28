package ru.avalon.java.ocpjp.labs.actions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Действие, которое перемещает файлы в пределах дискового
 * пространства.
 */
public class FileMoveAction implements Action {
    private Path file;
    private Path newdir;
    private BufferedReader br;
    private boolean move_fl;
    public FileMoveAction() throws IOException{
        System.out.println("Input name file for move:");
        br = new BufferedReader(new InputStreamReader(System.in));
        file = Paths.get(br.readLine());
        if (file.toFile().exists()) {
            System.out.println("Input name target file:");
            newdir = Paths.get(br.readLine());
            if (newdir.toString().length() == 0) {
                newdir = Paths.get(System.getProperty("user.dir") + file.toFile().getName());
            }

            move_fl = true;
        } else {
            move_fl = false;
            System.out.println("File not exists!");
        }
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        /*
         * TODO №4 Реализуйте метод run класса FileMoveAction
         */
        if (move_fl) {
            Path res;
            try {
                synchronized (file) {
                    res = Files.move(file, newdir, StandardCopyOption.REPLACE_EXISTING);

                }
                System.out.println("File move was successful! File move to: " + res.toString());
            } catch (IOException ex) {
                System.out.println("File move error: " + ex.getMessage());
            }
        } else {
            System.out.println("Command Move cannot be executed. File " + this.file.toFile().toString() + " not exists!");
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
         * TODO №5 Реализуйте метод close класса FileMoveAction
         */
       br = null;
        file = null;
        newdir = null;
    }

}

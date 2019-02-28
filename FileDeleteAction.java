/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.ocpjp.labs.actions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author MultatulyIM
 */
public class FileDeleteAction implements Action{
private Path file;
    
    private BufferedReader br;
    private boolean delete_fl;
    public FileDeleteAction() throws IOException {
        System.out.println("Input name file for delete:");
        br = new BufferedReader(new InputStreamReader(System.in));
        file = Paths.get(br.readLine());
        if (file.toFile().exists()) {
            delete_fl = true;
        } else {
            delete_fl = false;
            System.out.println("File not exists!");
        }
    }

    @Override
    public void run() {
        if (delete_fl) {
            
            try {
                synchronized (file) {
                    Files.delete(file);

                }
                System.out.println("File delete was successful!");
            } catch (IOException ex) {
                System.out.println("File delete error: " + ex.getMessage());
            }
        } else {
            System.out.println("Command Delete cannot be executed. File " + this.file.toFile().toString() + " not exists!");
        }
        try {
            this.close();
        } catch (Exception ex) {
            System.out.println("Object close error: " + ex.getMessage());
        }
    }

    @Override
    public void close() throws Exception {
        br = null;
        file = null;
    }
    
}

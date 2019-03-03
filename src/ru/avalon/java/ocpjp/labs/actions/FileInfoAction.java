/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.ocpjp.labs.actions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

/**
 *
 * @author Constantine
 */
public class FileInfoAction implements Action {
    
    private File file;
    
    public FileInfoAction() {
        try {
        System.out.println("Input the source file's path to get info: ");
        Scanner sc = new Scanner(System.in);
        file = new File(sc.next());
        if (!file.exists()) {
            System.out.println("Source file does not exist");
        } 
        } catch (NullPointerException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void run() {
        try {
            synchronized (file) {
            System.out.println("FILE'S INFO:");
            System.out.println("File's owner: " + Files.getOwner(file.toPath()).toString());
            System.out.println("Last time modified: " + Files.getLastModifiedTime(file.toPath()));
            System.out.println("File store: " + Files.getFileStore(file.toPath()));
            }
        } catch (IOException | NullPointerException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void close() throws Exception {
        //nothing to close
    }
    
}

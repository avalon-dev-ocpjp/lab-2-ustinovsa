package ru.avalon.java.ocpjp.labs.actions;

import java.io.File;

public class FileDelete implements Action {

    File file = new File("C:\\Users\\UIS\\Desktop\\1\\src\\ru\\avalon\\java\\ocpjp\\labs\\newresourcers\\newnames.txt");

    @Override
    public void run() {
        if(file.delete()) {
            System.out.println("File was deleted");
        } else {
            System.out.println("File not found");
        }
    }

    @Override
    public void close() throws Exception {
        file = null;
    }
}

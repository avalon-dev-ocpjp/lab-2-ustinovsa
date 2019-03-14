package ru.avalon.java.ocpjp.labs.actions;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Действие, которое копирует файлы в пределах дискового
 * пространства.
 */
public class FileCopyAction implements Action {
    /**
     * {@inheritDoc}
     */
    ArrayList<String> newnames = new ArrayList<>();
    File file = new File("C:\\Users\\UIS\\Desktop\\1\\src\\ru\\avalon\\java\\ocpjp\\labs\\resources\\first-names.txt");

    @Override
    public void run() {

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                newnames.add(scanner.nextLine()); // записал в все строки из файла в ArrayList
                Writer writer = null;
                writer = new FileWriter("C:\\Users\\UIS\\Desktop\\1\\src\\ru\\avalon\\java\\ocpjp\\labs\\newresourcers\\newnames.txt");
                for (String line : newnames) { // перезаписал в другой файл всё из ArrayList
                    writer.write(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void close() throws Exception {

        newnames = null;

        throw new UnsupportedOperationException("Not implemented yet!");
    }
}

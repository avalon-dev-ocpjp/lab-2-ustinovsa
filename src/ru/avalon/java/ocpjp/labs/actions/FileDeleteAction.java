/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.ocpjp.labs.actions;

import java.io.File;

/**
 *
 * @author JAVA
 */
public class FileDeleteAction implements Action{

     String file = "Exam808_SampleQuestion.pdf";
    String path = "D:\\Users\\Bozhenkov\\lab2\\";
    public void delete(){
        File f = new File(path, file);
        boolean deleted = f.delete();
    }
    
    @Override
    public void run() {
        delete();
        
      
    }

    @Override
    public void close() throws Exception {
        
    }
    
}

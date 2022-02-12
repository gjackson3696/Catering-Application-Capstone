package com.techelevator.view;

import java.io.File;
import java.io.FileWriter;

public class LogWriter {

    private FileWriter logWriter;

    public LogWriter() {
        File file = new File("Log.txt");
        try {
            file.createNewFile();
            logWriter = new FileWriter(file, true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void addActionToLog(String lineToLog){
        try{
            logWriter.write(lineToLog);
        } catch (Exception ex){
            ex.printStackTrace();
        }

    }



}

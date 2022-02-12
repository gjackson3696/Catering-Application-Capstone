package com.techelevator.view;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogWriter {
    private File logFile;
    private PrintWriter logWriter;

    public LogWriter() {
        logFile = new File("Log.txt");
        try {
            logFile.createNewFile();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void addActionToLog(String lineToLog){
        try(PrintWriter logWriter = new PrintWriter(new FileOutputStream(logFile,true))){
            logWriter.println();
            logWriter.print(calculateTime()+" "+lineToLog);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private String calculateTime() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        String time = currentDateTime.format(DateTimeFormatter.ofPattern("MM/dd/uuuu hh:mm:ss a"));
        return time;
    }

}

package org.example.Assignment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFile implements  Runnable{
    //String Path = "/Users/bhargavabr/coding/JavaBasics/Files/output.txt";
    String Path;
    List<Integer> list;

    public WriteFile(String path, List<Integer> list) {
        Path = path;
        this.list = list;
    }

    public WriteFile(String path) {
        Path = path;
    }

    public WriteFile() {
    }

    @Override
    public void run() {
        System.out.println("Write Thread is : " + Thread.currentThread().getName());
        try{
            File outputFile = new File(Path);
            if(outputFile.createNewFile()) {
                System.out.println("File created!");
            }
        } catch (IOException e) {
            System.out.println("Error while creating output file");
            throw new RuntimeException(e);
        }
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter(Path);
            for (Integer line : list) {

                fileWriter.write(""+line+ System.lineSeparator());

            }
            fileWriter.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

package org.example.Assignment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFile {
    //String Path = "/Users/bhargavabr/coding/JavaBasics/Files/output.txt";

    public void createFile(String Path){
        try{
            File outputFile = new File(Path);
            if(outputFile.createNewFile()) {
                System.out.println("File created!");
            }
        } catch (IOException e) {
            System.out.println("Error while creating output file");
            throw new RuntimeException(e);
        }
    }
    public void writetoFile(List<Integer> result, String Path) throws IOException {
        FileWriter fileWriter = new FileWriter(Path);
        for (Integer line : result) {
            try {
                fileWriter.write(""+line+ System.lineSeparator());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        fileWriter.close();
    }
}

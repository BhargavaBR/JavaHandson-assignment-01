package org.example.Assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {

    List<Integer> list ;



    public List<Integer> readFiles(String path) throws FileNotFoundException{
        list = new ArrayList<Integer>();
        try {
            File file = new File(path);
            Scanner myReader = new Scanner(file);
            while(myReader.hasNext()) {
                String line = myReader.nextLine();
                list.add(Integer.parseInt(line));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
            ex.printStackTrace();
        }
        return list;
    }
}




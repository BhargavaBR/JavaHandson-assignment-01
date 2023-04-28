package org.example.Assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class ReadFile  implements Callable<List<Integer>> {

    List<Integer> list ;
    String Path;

    public ReadFile(String path) {
        Path = path;
    }



    @Override
    public List<Integer> call() throws Exception {
        list = new ArrayList<Integer>();
        System.out.println("Reading on Thread : "+ Thread.currentThread().getName());
        try {
            File file = new File(Path);
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




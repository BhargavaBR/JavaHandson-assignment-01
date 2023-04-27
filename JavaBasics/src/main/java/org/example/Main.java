package org.example;

import okhttp3.Response;
import org.example.Assignment.ReadFile;
import org.example.Assignment.WriteFile;
import org.example.http.Client;
import org.example.sorting.Merge;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Hello world!");
        //Client client = new Client();
        ReadFile readFile = new ReadFile();
        WriteFile writeFile = new WriteFile();
        Merge m = new Merge();
        String basePath = "/Users/bhargavabr/coding/JavaBasics/Files";

        List<Integer> list;
        List<Integer> res = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of files to merge : ");
        int n = scan.nextInt();
        while(n-- >0) {
            try {
                list = new ArrayList<>();
                System.out.println("Enter file to merge");
                String filePath = scan.next();
                list = readFile.readFiles(basePath + "/" + filePath+".txt");
                System.out.println("file size : " + list.size());
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            res= m.merge(res, list);
            System.out.println("File sizez after merge : " + res.size());
        }
        System.out.println("Enter output file to store results");
        String outputPath = scan.next();
        outputPath = basePath + "/" +outputPath+ ".txt";
        writeFile.createFile(outputPath);
        writeFile.writetoFile(res, outputPath);

    }
}
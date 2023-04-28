package org.example;

import org.example.Assignment.ReadFile;
import org.example.Assignment.WriteFile;
import org.example.sorting.Merge;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {

        System.out.println("Hi, I can merge any number of Files to one File");

        String basePath = "/Users/bhargavabr/coding/JavaBasics/Files";

        List<Integer> list;
        List<Integer> res = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of files to merge : ");
        int n = scan.nextInt();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        while(n-- >0) {
            System.out.println("Enter file to merge");
            String filePath = scan.next();
            ReadFile readFile = new ReadFile(basePath + "/" + filePath+".txt");

            Future<List<Integer>> readList = executor.submit(readFile);
            list = readList.get();

            Merge m = new Merge(res, list);
            Future<List<Integer>> mergeFuture = executor.submit(m);
            res = mergeFuture.get();

        }

        System.out.println("Enter output file to store results");
        String outputPath = scan.next();
        outputPath = basePath + "/" +outputPath+ ".txt";

        WriteFile writeFile = new WriteFile(outputPath,res);
        executor.submit(writeFile);

        executor.shutdown();
    }
}
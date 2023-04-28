package org.example.sorting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

public class Merge implements Callable<List<Integer>> {
    List<Integer> list1 ;
    List<Integer> list2 ;

    public Merge(List<Integer> list1, List<Integer> list2) {
        this.list1 = list1;
        this.list2 = list2;
    }


    @Override
    public List<Integer> call() throws Exception {
        System.out.println("Merging files in Thread : " + Thread.currentThread().getName());
        List<Integer> result = new ArrayList<Integer>();
        Collections.sort(list1);
        Collections.sort(list2);
        int i=0,j=0;
        while(i<list1.size() && j<list2.size()){
            if(list1.get(i) <= list2.get(j)){
                result.add(list1.get(i));
                i++;
            }
            else{
                result.add(list2.get(j));
                j++;
            }
        }
        if(i<list1.size()) result.addAll(list1.subList(i,list1.size()));
        if(j<list2.size()) result.addAll(list2.subList(j,list2.size()));
        return result;
    }
}

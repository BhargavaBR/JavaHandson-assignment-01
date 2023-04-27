package org.example.sorting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Merge {
    public List<Integer> merge(List<Integer> list1, List<Integer> list2){
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

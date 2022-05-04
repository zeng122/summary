package zzm.java.leetcode.practise1000;

import zzm.java.jvm.FullGC;

import java.util.*;

public class Practise1090 {
    public static void main(String[] args) {
        int[] values = {5,4,3,2,1};
        int[] labels = {1,1,2,2,3};
        int numWanted = 3;
        int useLimit = 1;
        System.out.println(new Practise1090().largestValsFromLabels(values,labels,numWanted,useLimit));

    }

    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        for(int i = 0 ;i<labels.length;i++){

            if(hashMap.containsKey(labels[i])){
                hashMap.get(labels[i]).add(values[i]);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(values[i]);
                hashMap.put(labels[i],list);
            }
        }

        List<Integer> tempVaule = new ArrayList<>();
        for(Map.Entry<Integer,List<Integer>> entry : hashMap.entrySet()){
            if(entry.getValue().size()<= useLimit){
                tempVaule.addAll(entry.getValue());
            }else{
                Collections.sort(entry.getValue(), new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return  o2-o1;
                    }
                });

                tempVaule.addAll(entry.getValue().subList(0,useLimit));
            }
        }

        Collections.sort(tempVaule, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        int result = 0;
        if(tempVaule.size() > numWanted){
            tempVaule = tempVaule.subList(0,numWanted);
        }
        for(Integer i: tempVaule){
            result = result+i;
        }
        return result;
    }
}

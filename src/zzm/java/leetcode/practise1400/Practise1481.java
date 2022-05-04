package zzm.java.leetcode.practise1400;

import java.util.*;
import java.util.stream.Collectors;

public class Practise1481 {

    public static void main(String[] args) {
        Practise1481 practise1481 =new Practise1481();
        int [] arr = {4,3,1,1,3,3,2};
        System.out.println(practise1481.findLeastNumOfUniqueInts(arr,3));
    }

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0 ;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else{
                map.put(arr[i],1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            list.add(entry.getKey());
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1)-map.get(o2);
            }
        });

        int total = 0;
        int num = 0;
        for(Integer i :list){
            if((total+map.get(i))>k){
                break;
            }else{
                total = total+map.get(i);
                num++;
            }
        }

        return  list.size() - num;
    }
}

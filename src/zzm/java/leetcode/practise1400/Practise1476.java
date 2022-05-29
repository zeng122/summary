package zzm.java.leetcode.practise1400;

import java.util.*;

public class Practise1476 {
    public static void main(String[] args) {
        Practise1476 practise1476 = new Practise1476();
        int[] mapping = {8,9,4,0,2,1,3,5,7,6};
        int[] nums = {991,338,38};
        System.out.println(practise1476.sortJumbled(mapping,nums));
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        Integer[] newNums = new Integer[nums.length];
        Map<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0;i<nums.length;i++){
            int temp = nums[i];
            int newNum = 0;
            int time = 1;
            do {
                int tailNum = temp % 10;
                newNum = newNum + time * mapping[tailNum];
                time = time * 10;
                temp = temp / 10;
            } while (temp != 0);
            newNums[i] = newNum;
            arrayList.add(nums[i]);
            map.put(nums[i],newNum);
        }
        Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1)-map.get(o2);
            }
        });

        //排序
        for(int i = 0;i<nums.length;i++){
           nums[i] = arrayList.get(i);
        }

        return nums;
    }


}

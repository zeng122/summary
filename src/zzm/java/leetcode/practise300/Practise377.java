package zzm.java.leetcode.practise300;

import java.util.HashMap;
import java.util.HashSet;

public class Practise377 {


    HashMap<Integer,Integer> hashMap = new HashMap<>();
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(new Practise377().combinationSum4(nums,4));
    }


    public int combinationSum4(int[] nums, int target) {
        return find(nums,target);

    }

    public int find(int[] nums,int target){
        if(target<0){
            return 0;
        }
        if(target == 0){
            return  1;
        }
        if(hashMap.containsKey(target)){
            return hashMap.get(target);
        }
        int result = 0 ;
        for(int i = 0;i<nums.length;i++){
            result = result+find(nums,target- nums[i]);
        }
        hashMap.put(target,result);
        return result;
    }
}

package zzm.java.leetcode.practise0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practise40 {

    public static void main(String[] args) {
        Practise40 practise40 = new Practise40();
        int[] nums = {1,2,3};
        practise40.permute(nums);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0){
            return result;
        }
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        result.add(list);
        if(nums.length == 1){
            return result;
        }
        for(int i = 1;i<nums.length;i++){
            List<List<Integer>> newResult = new ArrayList<>();

            for(int j = 0;j<result.size();j++){
                List<Integer> temp = new ArrayList<>(result.get(j));
                for(int k = 0;k<=result.get(0).size();k++){
                    temp.add(k,nums[i]);
                    newResult.add(temp);
                    temp = new ArrayList<>(result.get(j));
                }
            }

            result = newResult;
        }

        return result;
    }
}

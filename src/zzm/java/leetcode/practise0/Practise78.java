package zzm.java.leetcode.practise0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practise78 {

    public static void main(String[] args) {
        Practise78 practise78 = new Practise78();
        int[] nums = {1,2,3};
        int[] N = {8, 1, 12, 7, 9, 7};
        practise78.subsets(nums);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int i = 0;i<nums.length;i++){
            //改变大小会有问题
            List<List<Integer>> newResult = new ArrayList<>(result);
            for(List<Integer> temp : result){
                List<Integer> newTemp = new ArrayList<>(temp);
                newTemp.add(nums[i]);
                newResult.add(newTemp);
            }
            result = newResult;
        }
        return  result;
    }
}

package zzm.java.leetcode.practise300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practise368 {

    public static void main(String[] args) {
        Practise368 practise368 = new Practise368();
        int[] nums = {1,2,4,8,9,72};
        practise368.largestDivisibleSubset(nums);
    }
    public List<Integer> largestDivisibleSubset(int[] nums) {
        //
        Arrays.sort(nums);
        int[] times = new int[nums.length];
        int[] lastNum = new int[nums.length];
        lastNum[0] = -1;
        int maxIndex = 0;
        for(int i = 0 ;i<nums.length;i++){
            int tempNum = 0;
            int lastTemp = -1;
            for(int j = i-1;j>=0;j--){
               if(nums[i] % nums[j] == 0 && times[j] > tempNum){
                   tempNum = times[j];
                   lastTemp = j;
               }
            }

            if(tempNum == -1){
                times[i] = 1;
                lastNum[i] = -1;
            }else{
                times[i] = tempNum+1;
                lastNum[i] = lastTemp;
            }

            if(times[maxIndex]<times[i]){
                maxIndex = i;
            }
        }

        List<Integer> result = new ArrayList<>();
        while (maxIndex!= -1){
            result.add(nums[maxIndex]);
            maxIndex = lastNum[maxIndex];
        }
        return result;
    }

}

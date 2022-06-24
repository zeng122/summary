package zzm.java.leetcode.practise0;

import java.util.Arrays;

public class Practise31 {
    public static void main(String[] args) {
        Practise31 practise31 = new Practise31();
        int[] nums = {5,1,1};
        practise31.nextPermutation(nums);
    }

    public void nextPermutation(int[] nums) {
        int currentRight = -1;
        for(int i = nums.length-1;i>=0;i--){
            if(nums[i]>=currentRight){
                currentRight = nums[i];
            }else{
                //找到第一个比它小的
                int j = 0;
                for(j = i+1;j<nums.length;j++){
                    if(nums[j]<=nums[i]){
                        break;
                    }
                }
                int temp = nums[i];
                nums[i] = nums[j-1];
                nums[j-1] = temp;
                Arrays.sort(nums,i+1,nums.length-1);
                return;
            }
        }
        Arrays.sort(nums);
    }
}

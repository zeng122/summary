package zzm.java.leetcode.practise200;

import java.util.LinkedHashMap;

public class Practise215 {
    public static void main(String[] args) {
        int[] nums = {2,1};
        Practise215 practise215 = new Practise215();
        System.out.println(practise215.findKthLargest(nums,1));
    }

    public int findKthLargest(int[] nums, int k) {
       return quickSort(nums,0,nums.length-1,k);
    }

    public  int quickSort(int [] nums,int start,int end,int k){
        if(start == end){
            return nums[start];
        }
        int left = start;
        int right = end;

        while (left != right){
            while (nums[right] <= nums[start] && left != right){
                right--;
            }
            while (nums[left] >= nums[start] && left != right){
                left++;
            }
            if(left != right){
                int tempValue = nums[right];
                nums[right] = nums[left];
                nums[left] = tempValue;
            }
        }
        int tempValue = nums[right];
        nums[right] = nums[start];
        nums[start] = tempValue;
        if(k == right+1){
            return nums[right];
        }else if(k < right+1){
            return quickSort(nums,start,right-1,k);
        }else{
            return quickSort(nums,right+1,end,k);
        }

    }
}

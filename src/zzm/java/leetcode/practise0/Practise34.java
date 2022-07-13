package zzm.java.leetcode.practise0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practise34 {

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        new Practise34().searchRange(nums,8);
    }


    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int[] result = new int[2];
        Arrays.fill(result,-1);
        while (left<=right){
            int mid = (left+right)/2;
            if(nums[mid] == target){
                left = mid-1;
                right = mid+1;
                while (left>=0){
                    if(nums[left] == target){
                        left--;
                    }else{
                        break;
                    }
                }

                while (right<=nums.length-1){
                    if(nums[right] == target){
                        right++;
                    }else{
                        break;
                    }
                }
                result[0] = left+1;
                result[1] = right-1;
                break;
            }else if(nums[mid] > target){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }

        return result;
    }


}

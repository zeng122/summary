package zzm.java.leetcode.practise100;

public class Practise162 {

    public static void main(String[] args) {
        int[] nums = {1,2};
        new Practise162().findPeakElement(nums);
    }
    public int findPeakElement(int[] nums) {

        int left  = 0;
        int right = nums.length-1;
        while (left<=right){
            if(left == right){
                return left;
            }
            if(left+1 == right){
                return nums[left]>nums[right]?left:right;
            }
            int mid = (left+right)/2;
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                return mid;
            }
            if(nums[left]>nums[mid]){
                right = mid-1;
            }else if(nums[right]>nums[mid]){
                left = mid+1;
            }else if(nums[left]==nums[mid]){
                right = mid-1;
            }else if(nums[right]==nums[mid]){
                left = mid+1;
            }else if(nums[mid]<nums[mid-1]){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }


}

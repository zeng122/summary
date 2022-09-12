package zzm.java.leetcode.practise100;

public class Practise153 {

    public static void main(String[] args) {
        int nums[] = {3,1,2};
        new Practise153().findMin(nums);
    }


    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left<right){
            if(nums[left] <= nums[right]){
                return nums[left];
            }
            if(left+1 == right){
                return Math.min(nums[left],nums[right]);
            }
            int mid = (left+right)/2;
            if(nums[left]<nums[mid]){
                left = mid;
            }else{
                right = mid;
            }
        }

        return nums[left];
    }
}

package zzm.java.leetcode.Practise900;

import java.util.HashMap;

/**
 * 给定一个数组nums，将其划分为两个连续子数组left和right，使得：
 *
 * left中的每个元素都小于或等于right中的每个元素。
 * left和right都是非空的。
 * left 的长度要尽可能小。
 * 在完成这样的分组后返回left的长度。
 */
public class Practise915 {

    public static void main(String[] args) {
        Practise915 practise915 = new Practise915();
        int[] nums = {6,0,8,30,37,6,75,98,39,90,63,74,52,92,64};
        System.out.println(practise915.partitionDisjoint(nums));
    }

    public int partitionDisjoint(int[] nums) {
        int[] minRights = new int[nums.length];
        int maxLeft = nums[0];
        int minRight = Integer.MAX_VALUE;
        if(nums.length == 1){
            return nums[0];
        }


        for (int i = nums.length-1  ;i>=0;i--){
            if(nums[i] < minRight){
                minRight = nums[i];
            }
            minRights[i] = minRight;
        }
        for(int i = 0; i<nums.length-1;i++){
            if(nums[i] > maxLeft){
                maxLeft = nums[i];
            }
            if(maxLeft <= minRights[i+1]){
                return i+1;
            }
        }
        return nums.length-1;
    }
}

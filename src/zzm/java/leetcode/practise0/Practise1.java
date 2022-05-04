package zzm.java.leetcode.practise0;

/**
 * nums = [2,7,11,15] , target = 9
 * 只有一种答案
 * 输出[2,7]
 */
public class Practise1 {


    public static void main(String[] args){
        Practise1 practise1 = new Practise1();
        int []nums = {1,2,3,4};
        int [] result = practise1.twoSum(nums,3);
        System.out.print("["+result[0]+","+result[1]+"]");
    }

    public int[] twoSum(int[] nums, int target) {
        int [] result = new int[2];
        for(int i = 0 ;i < nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                if(nums[i]+nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }
}

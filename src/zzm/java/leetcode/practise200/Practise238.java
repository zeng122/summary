package zzm.java.leetcode.practise200;


public class Practise238 {


    public static void main(String[]args){
        Practise238 practise238 = new Practise238();
        int[] nums = {1,2,3,4};
        practise238.productExceptSelf2(nums);
    }

    /**
     * 解题关键，分成了上三角和下三角
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        if(nums.length == 1){
            return nums;
        }
        int[] down = new int[nums.length];
        down[0] = 1;
        int[] up = new int[nums.length];
        up[nums.length-1] = 1;

        for(int i = 1 ;i<nums.length;i++){
            down[i] = down[i-1] * nums[i-1];
        }
        for(int i = nums.length-2;i>=0;i--){
            up[i] = up[i+1] * nums[i+1];
        }

        int [] result = new int[nums.length];
        for(int i = 0;i<result.length;i++){
            result[i] = down[i]*up[i];
        }
        return result;
    }

    public int[] productExceptSelf2(int[] nums) {
        if(nums.length == 1){
            return nums;
        }
        int [] result = new int[nums.length];
        result[0] = 1;
        for(int i = 1 ;i<nums.length;i++){
            result[i] = result[i-1] * nums[i-1];
        }
        int upTemp = 1;
        for(int i = nums.length-2;i>=0;i--){
            upTemp = upTemp * nums[i+1];
            result[i] = result[i] *upTemp;
        }
        return result;
    }
}

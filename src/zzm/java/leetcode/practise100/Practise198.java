package zzm.java.leetcode.practise100;

/**
 *
 */
public class Practise198 {

     int[] max;
    /**
     * 1 2 3
     * 怎么解决 找到最大的
     * 1 2 3 4
     * 怎么解决
     * 1 2 23 4 5 18
     * 1 18 34 25 2 7 贪心失败
     * 动态规划：
     * 1 18 34 25 2 7 1 18 34 25 2 7 1 18 34 25 2 7
     * 找等式
     * f(n) = max(f(n-3)+(n-1),f(n-2)+n)
     * @param args
     */
    public static void main(String [] args){
        Practise198 practise198 = new Practise198();
        int[] nums = {
                114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
        System.out.println(practise198.rob(nums));
    }

    public int rob(int[] nums) {
        max = new int[nums.length];
        for(int i =0 ;i<nums.length;i++){
            max[i] = -1;
        }
        return getMax(nums,nums.length);

    }

    public int getMax(int[] nums , int n){
        if(max[n-1]!=-1){
            return max[n-1];
        }
        if(n==2){
            max[1] = Math.max(nums[0],nums[1]);
            return max[1];
        }else if(n==1){
            max[0] = nums[0];
            return nums[0];
        }else if(n==3){
            max[2] = Math.max(nums[0]+nums[2],nums[1]);
            return max[2];
        }else{
            max[n-1] = Math.max(getMax(nums,n-3)+nums[n-2],getMax(nums,n-2)+nums[n-1]);
            return  max[n-1];
        }
    }

}

package zzm.java.leetcode.practise2000;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practise2031 {
    public static void main(String [] args){
        Practise2031 practise2031 = new Practise2031();
        int[] nums = {1,0,1,0,1,1,0,0,0,1};
        System.out.println(practise2031.subarraysWithMoreZerosThanOnes2(nums));
    }


    /**
     * 输入: nums = [0,1,1,0,1]
     * 输出: 9
     * 解释:
     * 长度为 1 的、1 的数量大于 0 的数量的子数组有: [1], [1], [1]
     * 长度为 2 的、1 的数量大于 0 的数量的子数组有: [1,1]
     * 长度为 3 的、1 的数量大于 0 的数量的子数组有: [0,1,1], [1,1,0], [1,0,1]
     * 长度为 4 的、1 的数量大于 0 的数量的子数组有: [1,1,0,1]
     * 长度为 5 的、1 的数量大于 0 的数量的子数组有: [0,1,1,0,1]
     * @param nums
     * @return
     */
    /**
     * 穷举法O(n^2)
     * @param nums
     * @return
     */
    public int subarraysWithMoreZerosThanOnes1(int[] nums) {

        int result = 0;
        for(int i = 0 ;i<nums.length;i++){
            int num0 = 0;
            int num1 = 0;
            for(int j = i;j<nums.length;j++){
                if(nums[j] == 0) num0++;
                if(nums[j] == 1) num1++;
                if(num1>num0){
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * 优化1,要求的就是：
     * f(n) 有多少个
     * f(n)的现在差距知道，
     *
     * @param nums
     * @return
     */
    public int subarraysWithMoreZerosThanOnes2(int[] nums) {

        Map<Integer,Integer> map = new HashMap<>();
        int result = 0;
        int num0 = 0;
        int num1 = 0;
        int maxCha = Integer.MIN_VALUE;
        for(int i = 0 ;i<nums.length;i++){
            if(nums[i] == 0) num0++;
            if(nums[i] == 1) num1++;
            int cha = num1-num0;
            if(cha>maxCha){
                maxCha = cha;
            }
            int number = map.get(cha) == null?0:map.get(cha);
            map.put(cha,number+1);
        }

        System.out.println(map.toString());
        num0 = 0;
        num1 = 0;
        int cha = 0;
        for(int i = 0 ;i<nums.length;i++){
            if(nums[i] == 0) num0++;
            if(nums[i] == 1) num1++;

            int needFind =  1 + cha;
            for(int j = needFind ; j<= maxCha ; j++){
                int number = map.get(j) == null?0:map.get(j);
                if(number < 0){
                    System.out.println(number);
                }
                result = result + number;
            }
            if(result>2000000000)
                System.out.println(result);
            cha = num1-num0;
            map.put(cha,map.get(cha)-1);
        }

        return result;
    }




}

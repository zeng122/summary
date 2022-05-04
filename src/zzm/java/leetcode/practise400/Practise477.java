package zzm.java.leetcode.practise400;
import java.util.Arrays;

public class Practise477 {
    int [] num1 = new int[32];
    int [] num0 = new int[32];
    public static void main(String[] args) {
        Practise477 practise477 = new Practise477();
        int[] nums = {4,14,2};
        System.out.println(practise477.totalHammingDistance(nums));
    }

    public int totalHammingDistance(int[] nums) {
        for(int i = 31;i>=0;i--){
            get(i,nums);
        }
        int result = 0;
        for(int i = 0;i<32;i++){
            result = result+num0[i]*num1[i];
        }

        return result;
    }

    public void get(int i,int[] nums){
        for(int j = 0;j<nums.length;j++){
            if(nums[j]>Math.pow(2,i)-1){
                num1[i]++;
                nums[j] = nums[j]-(int)Math.pow(2,i);
            }else{
                num0[i]++;
            }
        }
    }
}

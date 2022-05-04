package zzm.java.leetcode.practise1200;

public class Practise1248 {

    public static  void  main(String [] args){
        Practise1248 practise1248 = new Practise1248();
        int[] nums = {1,1,2,1,1};

        System.out.println(practise1248.numberOfSubarrays(nums,3));
    }

    public int numberOfSubarrays(int[] nums, int k) {

        int left = -1;
        //往左边扩展多少个
        int leftNum  = 0;
        int right = -1;
        //往右边扩展多少个
        int rightNum  = 0;

        int num = 0;
        int result = 0;
        for(int i = 0;i<nums.length;i++){
            right++;

            if(nums[i] % 2 == 1){
                if(num == 0){
                    left++;
                    leftNum++;
                }
                num++;
            }else if(num == 0){
                left++;
                leftNum++;
            }

            if(num == k){
               rightNum++;
            }else if(num == k+1){
                result = result + leftNum * rightNum;
                leftNum = 0;
                rightNum = 1;
                left++;
                while (left <= right){
                    leftNum++;
                    if(nums[left] % 2 == 1){
                        break;
                    }
                    left++;
                }
                num = num - 1;
            }
        }

        result = result + leftNum * rightNum;
        return result;
    }
}

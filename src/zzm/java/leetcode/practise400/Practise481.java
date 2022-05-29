package zzm.java.leetcode.practise400;

public class Practise481 {
    public static void main(String[] args) {
        new Practise481().magicalString(7);
    }


    public int magicalString(int n) {
        int[] nums = new int[120000];
        if(n == 1){
            return 1;
        }
        if(n == 2 || n == 3){
            return 2;
        }
        int total = 3;
        int index = 1;
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 2;
        int result = 1;
        while (total<n){
            index++;
            if(nums[index] == 1){
                if(nums[total-1] == 1){
                    nums[total] = 2;
                    total = total+1;
                    if(total>= n){
                        return result;
                    }
                }else{
                    nums[total] = 1;
                    result++;
                    total = total+1;
                    if(total >= n){
                        return result;
                    }
                }
            }else{
                if(nums[total-1] == 1){
                    nums[total] = 2;
                    nums[total+1] = 2;
                    total = total+2;
                    if(total>= n){
                        return result;
                    }
                }else{
                    nums[total] = 1;
                    nums[total+1] = 1;
                    total = total+2;
                    result = result+2;
                    if(total == n){
                        return result;
                    }else if(total > n){
                        return result-1;
                    }
                }
            }

        }
        return result;
    }
}

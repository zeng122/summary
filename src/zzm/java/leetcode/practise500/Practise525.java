package zzm.java.leetcode.practise500;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 *
 *
 */
public class Practise525 {

    public static void main(String [] args){
        Practise525 practise525 = new Practise525();
        int [] nums = {0,1};
        practise525.findMaxLength(nums);
    }

    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int x0 = 0 ;
        int x1 = 0;
        int result = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 0){
                x0++;
            }else{
                x1++;
            }
            Integer index = map.get((x0-x1));
            if(index != null){
                int length  = i-index;
                result = Math.max(length,result);
            }else{
               map.put((x0-x1),i);
            }
        }
        return result;
    }
    /**
     *
     * @param nums
     * @return
     */
    public int findMaxLength2(int[] nums) {

        int  max = 0;
        for(int i = 0;i<nums.length;i++){
            int x1 = 0 ;
            int x2 = 0;
            for(int j = i ;j<nums.length;j++){
                if(max>= (nums.length-i)){
                    break;
                }
                if(nums[j] == 1){
                    x1++;
                }else{
                    x2++;
                }
                if(x1 == x2){
                    if(max < ((j-i)+1)){
                        max = j-i+1;
                    }
                }
            }
        }

        return max;
    }
}

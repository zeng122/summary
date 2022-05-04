package zzm.java.leetcode.practise300;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）,
 * 其中有些元素出现两次而其他元素出现一次。
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [2,3]
 */
public class Practise313 {

    public static void main(String [] args){
        Practise313 practise313 = new Practise313();
        int[] integers = {4,3,2,7,8,2,3,1};
        practise313.findDuplicates(integers);
    }


    /**
     * 要学会利用条件，如何利用条件1<= a[i] <= n
     * 为什么有这个条件？
     * 这个是关键
     * 那么 a[a[i]] 必定不会越界
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> resInt = new ArrayList<>();
        for(int i = 0 ;i < nums.length ; i++){
            //绝对值
            int index = nums[i]>0?nums[i]:-nums[i];
            //对应下标值
            int index2 = nums[index-1];
            //小于0表示已有下表修改
            if(index2 < 0){
                resInt.add(index);
            }else{
                //表示没有修改，因为只会出现1到2次
                nums[index-1] = -index2;
            }
        }
        return resInt;
    }

}

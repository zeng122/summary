package zzm.java.leetcode.practise100;

/**
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，
 * 其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */
public class Practise137 {

    public static void main(String [] args){
        Practise137 practise137 = new Practise137();
        int[] nums = {0,1,0,1,0,1,99};
        practise137.singleNumber(nums);
    }
    /**
     * 输入：nums = [0,1,0,1,0,1,99]
     * 输出：99
     *
     * @param nums
     * @return
     */
    public int singleNumber1(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int total = 0;
            for (int num: nums) {
                total += ((num >> i) & 1);
            }
            if (total % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            int aNext = (~a & b & num) | (a & ~b & ~num), bNext = ~a & (b ^ num);
            a = aNext;
            b = bNext;
        }
        return b;
    }

}

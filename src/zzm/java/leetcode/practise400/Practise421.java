package zzm.java.leetcode.practise400;

import java.util.HashSet;
import java.util.Set;

/**
 * 解题关键
 *
 * a^b = c    可以得到 a^c = b
 * 找到最高位1,然后通过
 */
public class Practise421 {
    public static void main(String [] args){
        Practise421 practise421 = new Practise421();
        int[] nums = {3,10,5,25,2,8};
        System.out.println(5 | 25);
        System.out.println(practise421.findMaximumXOR(nums));
    }

    /**
     * 掩码
     * @param nums
     * @return
     * 1000000000000
     * 1100000000000
     * 1110000000000
     * 1111000000000
     *
     */
    public int findMaximumXOR(int[] nums) {
        int res = 0;
        int mask = 0;
        for (int i = 5; i >= 0; i--) {
            // 注意点1：注意保留前缀的方法，mask 是这样得来的
            // 用异或也是可以的 mask = mask ^ (1 << i);
            mask = mask | (1 << i);

            //前缀集合
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                // 注意点2：这里使用 & ，保留前缀的意思（从高位到低位）
                //按位&,只保留前缀
                set.add(num & mask);
            }

            //100000
            // 这里先假定第 n 位为 1 ，前 n-1 位 res 为之前迭代求得
            //第i位是否可以为1
            int temp = res | (1 << i);
            for (Integer prefix : set) {
                //结果前缀，a ^ b = result result ^ a = b,  前缀也是
                if (set.contains(prefix ^ temp)) {
                    res = temp;
                    break;
                }
            }
        }
        return res;
    }

}

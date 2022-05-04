package zzm.java.leetcode.practise200;

import java.util.HashSet;

public class Practise260 {
    public static void main(String[] args) {
        Practise260 practise260 = new Practise260();
        int[] nums = {1,2,1,3,2,5};
        practise260.singleNumber(nums);
    }

    public int[] singleNumber(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (hashSet.contains(num)) {
                hashSet.remove(num);
            } else {
                hashSet.add(num);
            }
        }
        return hashSet.stream().mapToInt(Integer::intValue).toArray();
    }


    public int[] singleNumber2(int[] nums) {
        int sum = 0;
        for (int i : nums) sum ^= i;
        int k = -1;
        for (int i = 31; i >= 0 && k == -1; i--) {
            if (((sum >> i) & 1) == 1) k = i;
        }
        int[] ans = new int[2];
        for (int i : nums) {
            if (((i >> k) & 1) == 1) ans[1] ^= i;
            else ans[0] ^= i;
        }
        return ans;
    }

}
package zzm.java.leetcode.practise300;

public class Practise300 {
    public static void main(String[] args) {
        int[] nums = {10,11,12,13,3,7,101,18};
        System.out.println(new Practise300().lengthOfLIS2(nums));
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int result = 1;
        for(int i = 1;i<nums.length;i++){
            int max = 0;
            for(int j = 0;j<i;j++){
                int temp = 1;
                if(nums[j]<nums[i]){
                    temp = dp[j]+1;
                }
                if(max<temp){
                    max = temp;
                }
            }
            dp[i] = max;
            result = Math.max(result,max);
        }
        return result;
    }

    public int lengthOfLIS2(int[] nums) {
        int len = 1, n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                int l = 1, r = len, pos = 0; // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }

}

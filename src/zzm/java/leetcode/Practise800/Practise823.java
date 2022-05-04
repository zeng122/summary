package zzm.java.leetcode.Practise800;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给出一个含有不重复整数元素的数组 arr ，每个整数 arr[i] 均大于 1。
 *
 * 用这些整数来构建二叉树，每个整数可以使用任意次数。其中：每个非叶结点的值应等于它的两个子结点的值的乘积。
 *
 * 满足条件的二叉树一共有多少个？答案可能很大，返回 对 109 + 7 取余 的结果。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-trees-with-factors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入: arr = [2, 4]
 * 输出: 3
 * 解释: 可以得到这些二叉树: [2], [4], [4, 2, 2]
 */
public class Practise823 {


    public static void main(String[] args) {
        Practise823 practise823 = new Practise823();
        int[] arr = {2,4,5,16};
        System.out.println(practise823.numFactoredBinaryTrees(arr));
    }
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        long [] nums = new long[arr.length];
        Arrays.fill(nums,1);
        Map<Integer,Long> numMap = new HashMap<>();

        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<i;j++){
                if(arr[i] % arr[j] == 0){
                    if(numMap.containsKey(arr[j]) && numMap.containsKey(arr[i] / arr[j])){
                        nums[i] = nums[i]+numMap.get(arr[j])*numMap.get((arr[i] / arr[j]));
                    }
                }
            }
            numMap.put(arr[i],nums[i]);
        }
        long total  = 0;
        for(long num:nums){
            total += num;
        }
        return  (int)(total%1000000007);
    }


}

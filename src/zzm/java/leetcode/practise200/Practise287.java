package zzm.java.leetcode.practise200;

/**
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 *
 * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
 *
 * 你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入：nums = [1,3,4,2,2,2]
 * 输出：2
 *
 *
 */
public class Practise287 {

    public static void main(String []args){
        Practise287 practise287 = new Practise287();
        int nums[]  = {1,3,4,2,2};
        System.out.println(practise287.findDuplicate(nums));
    }

    /**
     * 快慢链表来处理
     * 环形链表
     * 0--->1----->3---->2--->4---->2------>4
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int start = 0;
        int end = nums[start];
        while(start != end){
            start = nums[start];
            end = nums[nums[end]];
        }
        end = 0;
        start = nums[start];
        while(start!=end){
            start = nums[start];
            end = nums[end];
        }
        return start;

    }
}

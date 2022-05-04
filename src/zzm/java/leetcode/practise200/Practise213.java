package zzm.java.leetcode.practise200;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 198升华版
 */
public class Practise213 {
    int[] max;

    public static void main(String []args){
        Practise213 practise213 = new Practise213();
        int nums[]  = {1,2,3,1};
        System.out.println(practise213.rob(nums));
    }

    /**
     * 第一个节点不偷和最后一个节点不偷
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        max = new int[nums.length];
        for(int i =0 ;i<nums.length;i++){
            max[i] = -1;
        }
        int n1 = getMax(nums,nums.length-1);

        for(int i = 0;i<nums.length-1;i++){
            nums[i]= nums[i+1];
        }
        for(int i =0 ;i<nums.length;i++){
            max[i] = -1;
        }
        int n2 = getMax(nums,nums.length-1);
        return Math.max(n1,n2);
    }

    public int getMax(int[] nums , int n){
        if(max[n-1]!=-1){
            return max[n-1];
        }
        if(n==2){
            max[1] = Math.max(nums[0],nums[1]);
            return max[1];
        }else if(n==1){
            max[0] = nums[0];
            return nums[0];
        }else if(n==3){
            max[2] = Math.max(nums[0]+nums[2],nums[1]);
            return max[2];
        }else{
            max[n-1] = Math.max(getMax(nums,n-3)+nums[n-2],getMax(nums,n-2)+nums[n-1]);
            return  max[n-1];
        }
    }
}

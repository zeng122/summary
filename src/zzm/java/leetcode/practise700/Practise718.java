package zzm.java.leetcode.practise700;

/**
 * 输入：
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出：3
 * 解释：
 * 长度最长的公共子数组是 [3, 2, 1] 。
 */
public class Practise718 {
    public static void main(String [] args){
        Practise718 practise718 = new Practise718();
        int[] num1 = {1,1,0,0,1};
        int[] num2 = {1,1,0,0,0};
        System.out.println(practise718.findLength(num1,num2));
    }


    /**
     * 解法1，滑动窗口
     * @param nums1
     * @param nums2
     * @return
     */
    public int findLength(int[] nums1, int[] nums2) {
        //num1不动，num2移动
        //刚开始错位，num1左下标0，右下标n1,num2左下标-n2,右下标-1

        int maxLength = 0;
        int num1Left = 0;
        int num2Left = -nums2.length;
        int num1Right = nums1.length-1;
        int num2Right = -1;
        for(int i = 0;i< nums1.length+ nums2.length;i++){
            int maxLeft = Math.max(num1Left,num2Left);
            int minRight = Math.min(num1Right,num2Right);
            int start2 = Math.max((nums2.length - i), 0);
            int start1 = maxLeft;
            int tempLength = 0;
            for(int j = 0 ;j<=minRight-maxLeft;j++){
                if(nums1[start1] == nums2[start2]){
                    tempLength++;
                }else{
                    tempLength=0;
                }
                start2++;
                start1++;
                if(tempLength>maxLength){
                    maxLength = tempLength;
                }
            }

            num2Left++;
            num2Right++;
        }
        return maxLength;
    }
}

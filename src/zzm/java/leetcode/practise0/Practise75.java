package zzm.java.leetcode.practise0;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 */
public class Practise75 {

    public static void main(String [] args){
        Practise75 practise75 = new Practise75();
        int[] nums = {2,0,2,1,1,0};
        practise75.sortColors(nums);
        System.out.println(nums);
    }

    public void sortColors(int[] nums) {
        int temp = 0;
        int y = 0;
        for(int i = 1; i<nums.length;i++){
            temp = nums[i];
            y = i;
            while (y>0 && nums[y-1]> temp){
                nums[y] = nums[y-1];
                y--;
            }
            nums[y] = temp;
        }
    }
}

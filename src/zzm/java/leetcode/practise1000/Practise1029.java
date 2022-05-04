package zzm.java.leetcode.practise1000;

/**
 * 公司计划面试 2n 人。给你一个数组 costs ，
 * 其中 costs[i] = [aCosti, bCosti] 。
 * 第 i 人飞往 a 市的费用为 aCosti ，飞往 b 市的费用为 bCosti 。
 *
 * 返回将每个人都飞到 a 、b 中某座城市的最低费用，要求每个城市都有 n 人抵达。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-city-scheduling
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 输入：costs = [[10,20],[30,200],[400,50],[30,20]]
 * 输出：110
 * 解释：
 * 第一个人去 a 市，费用为 10。
 * 第二个人去 a 市，费用为 30。
 * 第三个人去 b 市，费用为 50。
 * 第四个人去 b 市，费用为 20。
 *
 * 最低总费用为 10 + 30 + 50 + 20 = 110，每个城市都有一半的人在面试。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-city-scheduling
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Practise1029 {


    public static void main(String [] args){
        Practise1029 practise1029 = new Practise1029();
        int[][] costs  = {{10,20},{30,200},{400,50},{30,20}};
        practise1029.twoCitySchedCost(costs);
    }
    /**
     * 如何解题：
     * 2n个人如何处理
     * 2(n-1)如果计算出最小值，2n也处理不了
     *
     *
     * 计算差距，排序
     * 找到差距大的5个取小的，找到差距小的取大的。
     * 是不是可以？
     * 数学证明：a1+a2+……an   b1+b2+……+bn
     * 假设我将一个差距大的值变换成取大的，那么前面的值f(n) + c1-c2
     * 结果必定大于原来的f(n)
     * 贪心算法
     * @param costs
     * @return
     */
    public int twoCitySchedCost(int[][] costs) {
        int[] gaps = new int[costs.length];
        //直接插入排序
        for(int i = 0 ;i < costs.length;i++){
            int temp1 = Math.abs(costs[i][0]-costs[i][1]);
            boolean isFind = false;
            for(int j = 0 ; j< i ;j++){
                int temp2 = Math.abs(costs[gaps[j]][0]-costs[gaps[j]][1]);
                //移动，可以用链表省去移动
                if(temp2 <= temp1){
                    int temp3 = i;
                    while (temp3 != j){
                        gaps[temp3] = gaps[temp3-1];
                        temp3--;
                    }
                    gaps[temp3] = i;
                    isFind = true;
                    break;
                }
            }

            if(!isFind){
                gaps[i] = i;
            }
        }

        int result = 0;
        int left = 0;
        int right = 0;
        for(int i = 0 ;i < costs.length;i++){
            if(costs[gaps[i]][0] > costs[gaps[i]][1]){
                if(right<costs.length/2){
                    right++;
                    result = result + costs[gaps[i]][1];
                }else{
                    left++;
                    result = result + costs[gaps[i]][0];
                }
            }else if(costs[gaps[i]][0] == costs[gaps[i]][1]){
              if(left<right) {
                  left++;
                  result = result + costs[gaps[i]][0];
              }else {
                  right++;
                  result = result + costs[gaps[i]][1];
              }
            }else if(costs[gaps[i]][0] < costs[gaps[i]][1]){
                if(left<costs.length/2){
                    left++;
                    result = result + costs[gaps[i]][0];
                }else{
                    right++;
                    result = result + costs[gaps[i]][1];
                }
            }

        }
        return result;
    }
}

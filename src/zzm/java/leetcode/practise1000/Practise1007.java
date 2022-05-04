package zzm.java.leetcode.practise1000;

/**
 * 输入：A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
 * 输出：2
 * 解释：
 * 图一表示：在我们旋转之前， A 和 B 给出的多米诺牌。
 * 如果我们旋转第二个和第四个多米诺骨牌，我们可以使上面一行中的每个值都等于 2，如图二所示。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-domino-rotations-for-equal-row
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Practise1007 {

    public static void main(String []args){
        Practise1007 practise1007 = new Practise1007();
        int[] tops = {3,5,1,2,3};
        int[] bottoms = {3,6,3,3,4};
        System.out.println(practise1007.minDominoRotations(tops,bottoms));
    }

    /**
     * 官网解答，其实更简单，要么top[0],要么bottoms[0]
     */

    /**
     * 思考：如果有答案，那么必定有一个大于1办以上的相同
     * @param tops
     * @param bottoms
     * @return
     */
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] maxTop = findMaxNumber(tops);
        int[] maxBottoms = findMaxNumber(bottoms);
        if(maxTop[0] == -1 && maxBottoms[0] == -1){
            return -1;
        }
        int needFind = -1;
        if(maxTop[0] != -1 && maxBottoms[0] != -1){
            //取上
            if(maxTop[0]<maxBottoms[0]){
                needFind = maxBottoms[1];
                int [] temp = bottoms;
                bottoms = tops;
                tops = temp;
            }else{
                needFind = maxTop[1];
            }
        }
        if(maxTop[0] == -1 && maxBottoms[0] != -1){
            //取上
            if(maxTop[0]<maxBottoms[0]){
                needFind = maxBottoms[1];
                int [] temp = bottoms;
                bottoms = tops;
                tops = temp;
            }else {
                needFind = maxTop[1];
            }
        }
        if(maxTop[0] != -1 && maxBottoms[0] == -1){
            needFind = maxTop[1];
        }

        int result = 0;
        boolean isRight = true;
        for(int i = 0;i<tops.length;i++){
            if(tops[i] != needFind && bottoms[i] != needFind){
                isRight  = false;
                break;
            }else if(tops[i] != needFind && bottoms[i] == needFind){
                result++;
            }
        }
        if(isRight){
            return result;
        }
        return -1;
    }


    int[] findMaxNumber(int[] nums){
        int result[] = new int[2];
        int length = nums.length;
        int[] numTimes = new int[7];
        for(int i = 0;i<7;i++){
            numTimes[i] = 0;
        }
        //多少次
        int maxNumber = 0;
        //最多次数的数
        int maxTimes = 0;
        for(int i = 0;i<nums.length;i++){
            numTimes[nums[i]]++;
            if(numTimes[nums[i]]>maxNumber){
                maxNumber = numTimes[nums[i]];
                maxTimes = nums[i];
            }
        }
        if(maxNumber < length/2){
            result[0] = -1;
            result[1] = -1;
        }
        result[0] = maxNumber;
        result[1] = maxTimes;
        return result;
    }


}

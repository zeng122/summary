package zzm.java.leetcode.practise400;

import java.util.Arrays;

/**
 * 输入: houses = [1,2,3], heaters = [2]
 * 输出: 1
 * 解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/heaters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Practise475 {

    public static void main(String [] args){
        Practise475 practise475 = new Practise475();
        int[] houses = {1,2,3};
        int[] heaters= {1};
        System.out.println(practise475.findRadius(houses,heaters));
    }
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int minRadius = 0;
        int i = 0;
        int j = 0;
        while (i<houses.length && j<heaters.length){
            if(houses[i] < heaters[j]){
                int temp;
                if(j == 0){
                    temp = heaters[j]-houses[i];
                }else{
                    temp = Math.min((houses[i]-heaters[j-1]),(heaters[j]- houses[i]));
                }
                if(temp>minRadius){
                    minRadius = temp;
                }
                i++;
            }else if(houses[i] == heaters[j]){
                i++;
            }else{
                if(j == heaters.length-1){
                   int temp = houses[i]-heaters[j];
                   if(temp>minRadius){
                       minRadius = temp;
                   }
                }
                j++;
            }
        }

        if(i != houses.length){
            int temp = houses[houses.length-1]-heaters[heaters.length-1];
            if(temp>minRadius){
                minRadius = temp;
            }
        }

        return minRadius;
    }
}

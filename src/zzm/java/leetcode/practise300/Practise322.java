package zzm.java.leetcode.practise300;

import java.util.Arrays;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 */
public class Practise322 {
    int result = 0;
    int[]  f ;
    public static void main(String[] args){
        Practise322 practise322 = new Practise322();
        int[] coins = {186,419,83,408};
        System.out.println(practise322.coinChange3(coins,6249));
    }

    /**
     * 动态规划：
     * 爬楼梯类似
     * n表示硬币总额
     * f(n) = min(f(n-a[0]),f(n-a[1]),~~)+1
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        int[] dp =  new int[amount+1];
        //最大次数为amount次
        Arrays.fill(dp,amount+1);
        dp[0]= 0;
        for(int i = 0;i<=amount;i++){
            for(int j = 0;j<coins.length;j++){
                if(coins[j]<i){
                    dp[i] =  Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount] == amount+1?-1:dp[amount];
    }


    public int coinChange3(int[] coins, int amount) {
        f = new int[amount+1];
        Arrays.fill(f,0);
        return fun2(coins,amount);
    }

    public int fun2(int[] coins, int amount){
        if(amount<0){
            return -1;
        }
        if(amount == 0){
            return 0;
        }

        if(f[amount]!= 0){
            return f[amount];
        }


        int temp = Integer.MAX_VALUE;
        for(int i= 0;i<coins.length;i++){
            int min = fun2(coins,amount-coins[i]);
            if(min!= -1 && min<temp){
                temp = min;
            }
        }
        f[amount] = temp == Integer.MAX_VALUE?-1:temp+1;
        return f[amount];
    }

    /**
     * 思路1：贪心+回溯
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }
        Arrays.sort(coins);
        fun(coins,amount);
        if(result == 0){
            return -1;
        }
        return result;
    }

    public int fun(int[] coins,int last){
        if(last == 0){
            return 1;
        }
        int max = findMax(coins,last);
        if(max < 0){
            return -1;
        }
        int times = last / max;
        last = last - times*max;
        result = result+times;
        if(fun(coins,last)<0){
            do{
                result = result-1;
                last = last+max;
                times--;
            }while(fun(coins,last)>0 || times>0);
        };
        return 1;
    }


    /**
     * 找到
     * @param coins
     * @param max
     * @return
     */
    int findMax(int [] coins,int max){
        if(coins[0]>max){
            return -1;
        }
        for(int i= 0;i<coins.length;i++){
            if(coins[i]>max){
                return coins[i-1];
            }
        }
        return coins[coins.length-1];
    }
}

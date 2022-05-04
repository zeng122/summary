package zzm.java.leetcode.practise500;

import java.util.Arrays;

public class Practise518 {

    int f[];

    public static void main(String [] args){

        Practise518 practise518 = new Practise518();
        int[] coins = {1, 2, 5};
        System.out.println(practise518.change(5,coins));
    }

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        //Arrays.fill(dp,0);
        for(int coin:coins){
            for(int j = coin;j<=amount;j++){
                //对应j,当一个面额为coin时，存在dp[j] = dp[j-coin],
                // 要求和
                dp[j] = dp[j]+dp[j-coin];
            }
        }


        return dp[amount];
    }

    public int coinChange3(int[] coins, int amount) {
        f = new int[amount+1];
        Arrays.fill(f,0);
        return fun2(coins,amount);
    }

    public int fun2(int[] coins, int amount){
        if(amount<0){
            return 0;
        }
        if(amount == 0){
            return 1;
        }

        if(f[amount]!= 0){
            return f[amount];
        }


        int sum =  0;
        for(int i= 0;i<coins.length;i++){
            int total = fun2(coins,amount-coins[i]);
            sum = total+sum;
        }
        f[amount] = sum;
        return f[amount];
    }
}

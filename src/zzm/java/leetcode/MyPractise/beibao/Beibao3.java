package zzm.java.leetcode.MyPractise.beibao;

/**
 * 完全背包
 *
 */
public class Beibao3 {

    //二维背包
    //dp[i][j]表示前i件商品重量为j的最大价值
    //dp[i+1][j] = max(dp[i][j],dp[i][j-w[i+1]]+v[i+1])
    //相当于多重背包，但是限制值需要自己去算
    public int findMaxValue2(int[] weights,int[] values,int maxWeight){
        int dp[][] = new int[weights.length+1][maxWeight+1];
        for(int i = 1;i<=weights.length;i++){
            for(int j = 1;j<=maxWeight;j++){
                for(int k = 1;k*weights[i]<maxWeight;k++){
                    if(weights[i-1]*k<=j){
                        dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weights[i-1]*k]+values[i-1]);
                    }
                }

            }
        }
        return dp[weights.length][maxWeight];
    }
}

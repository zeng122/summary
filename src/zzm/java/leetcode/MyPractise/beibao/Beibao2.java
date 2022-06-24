package zzm.java.leetcode.MyPractise.beibao;

/**
 * 多从背包
 */
public class Beibao2 {
    public static void main(String[] args) {

    }
    //二维背包
    //dp[i][j]表示前i件商品重量为j的最大价值
    //dp[i+1][j] = max(dp[i][j],dp[i][j-w[i+1]]+v[i+1])
    //相当于0/1背包，有重复值
    public int findMaxValue2(int[] weights,int[] nums,int[] values,int maxWeight){
        int dp[][] = new int[weights.length+1][maxWeight+1];
        for(int i = 1;i<=weights.length;i++){
            for(int j = 1;j<=maxWeight;j++){
                for(int k = 1;k<nums[i-1];k++){
                    if(weights[i-1]*k<=j){
                        dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weights[i-1]*k]+values[i-1]);
                    }
                }

            }
        }
        return dp[weights.length][maxWeight];
    }


    //一维背包
    //dp[i] 表示重量为i的最大价值
    //dp[i] = max(dp[i],dp[i-w[j]]+v[j]) 表示的是如果要第j件物品，此时的最大值
    //相当于0/1背包，有重复值
    public int findMaxValue1(int[] weights,int[] nums,int[] values,int maxWeight){
        int dp[] = new int[maxWeight+1];
        for(int i = 1;i<weights.length;i++){
            //为什么要倒过来？算dp[j]时，dp[j-weights[i-1]]是上一轮的值，不会变化
            for(int j = maxWeight;j>0;j--){
                //算dp[j]时，看能
                for(int k = 1;k<nums[i-1];k++){
                    if(weights[i-1]*k<=j){
                        dp[j] = Math.max(dp[j],dp[j-weights[i-1]*k]+values[i-1]);
                    }
                }

            }
        }
        return dp[maxWeight];
    }
}

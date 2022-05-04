package zzm.java.leetcode.Practise800;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 在社交媒体网站上有 n 个用户。给你一个整数数组 ages ，
 * 其中 ages[i] 是第 i 个用户的年龄。
 *
 * 如果下述任意一个条件为真，那么用户 x 将不会向用户 y（x != y）发送好友请求：
 *
 * ages[y] <= 0.5 * ages[x] + 7
 * ages[y] > ages[x]
 * ages[y] > 100 && ages[x] < 100
 输入：ages = [16,17,18]
 输出：2
 解释：产生的好友请求为 17 -> 16 ，18 -> 17 。
 */
public class Practise825 {

    public static void main(String [] args){
        Practise825 practise825 = new Practise825();
        int [] ages = {20,30,100,110,120};
        practise825.numFriendRequests(ages);
    }
    //穷举法 An2测试，应该超时n^2
    public int numFriendRequests(int[] ages) {
        int[] cnt = new int[121];
        for (int age : ages) {
            ++cnt[age];
        }
        int[] pre = new int[121];
        for (int i = 1; i <= 120; ++i) {
            pre[i] = pre[i - 1] + cnt[i];
        }
        int ans = 0;
        for (int i = 15; i <= 120; ++i) {
            if (cnt[i] > 0) {
                int bound = (int) (i * 0.5 + 8);
                ans += cnt[i] * (pre[i] - pre[bound - 1] - 1);
            }
        }
        return ans;
    }

    int findNearlyMaxIndex(int start,int end , int [] ages , int value){
        if(start > end){
            return -1;
        }
        int middle = (start+end)/2;
        if(middle == 0){
            if(ages[middle]>=value){
                return 0;
            }
        }else if(ages[middle-1]<value && ages[middle]>=value){
            return middle;
        }
        if(ages[middle]<value){
            return findNearlyMaxIndex(middle+1,end,ages,value);
        }else{
            return findNearlyMaxIndex(start,middle-1,ages,value);
        }
    }

}

package zzm.java.leetcode.Practise900;

import java.util.HashMap;
import java.util.Map;

/**
 * 1 3 2
 * 1 5 3  2 4
 *
 *
 *
 * 10
 * 2 4 6 8 10
 * 1 3 5 7 9
 * 1 2 3 4 5 ---> 1 3 5 7 9
 * 1 3 5
 * 2 4
 * 1 2 3 ---> 1 3 5
 * 1 3
 * 2
 * 1 2
 *
 * 所以需要一个Map
 *
 *
 */
public class Practise932 {


    public static void main(String[] args){
        Practise932 practise932 = new Practise932();
        practise932.beautifulArray(10);
    }

    // n ----> 值
    Map<Integer, int[]> memo;

    public int[] beautifulArray(int N) {
        memo = new HashMap();
        return f(N);
    }

    //1 3 5 7 9 11
    //1 2 3 4 5  6
    public int[] f(int N) {
        if (memo.containsKey(N))
            return memo.get(N);

        int[] ans = new int[N];
        if (N == 1) {
            ans[0] = 1;
        } else {
            int t = 0;
            //对于f(11)  f(6)
            //反求 奇数部分
            for (int x: f((N+1)/2))  // odds
                ans[t++] = 2*x - 1;
            for (int x: f(N/2))  // evens
                ans[t++] = 2*x;
        }
        memo.put(N, ans);
        return ans;
    }
}

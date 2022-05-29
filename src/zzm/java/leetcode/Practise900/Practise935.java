package zzm.java.leetcode.Practise900;

import java.util.HashMap;

public class Practise935 {
    HashMap<Integer,Long> map = new HashMap<>();
    final int mod =1000000007;
    public static void main(String[] args) {

        Practise935 practise935 = new Practise935();
        System.out.println(practise935.knightDialer(3131));
    }

    public int knightDialer(int n) {
        if(n == 1){
            map.put(1,1L);
            map.put(2,1L);
            map.put(3,1L);
            map.put(4,1L);
            map.put(5,1L);
            map.put(6,1L);
            map.put(7,1L);
            map.put(8,1L);
            map.put(9,1L);
            map.put(0,1L);
            return 10;
        }
        int num =  knightDialer(n-1);
        long num1 = (map.get(6)+map.get(8))%mod;
        long num2 = (map.get(7)+map.get(9))%mod;
        long num3 = (map.get(4)+map.get(8))%mod;
        long num4 = (map.get(3)+map.get(9)+map.get(0))%mod;
        long num5 = 0;
        long num6 = (map.get(1)+map.get(7)+map.get(0))%mod;
        long num7 = (map.get(2)+map.get(6))%mod;
        long num8 = (map.get(1)+map.get(3))%mod;
        long num9 = (map.get(4)+map.get(2))%mod;
        long num0 = (map.get(4)+map.get(6))%mod;
        map.put(1,num1);
        map.put(2,num2);
        map.put(3,num3);
        map.put(4,num4);
        map.put(5,num5);
        map.put(6,num6);
        map.put(7,num7);
        map.put(8,num8);
        map.put(9,num9);
        map.put(0,num0);
        return (int)((num1+num2+num3+num4+num5+num6+num7+num8+num9+num0)%(1000000007));
    }
}

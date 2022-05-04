package zzm.java.leetcode.practise1000;

import java.util.Arrays;

public class Practise1049 {
    public static void main(String []args){
        int [] stones = { 31,26,33,21,40};
        Practise1049 practise1049 = new Practise1049();
        System.out.println(practise1049.lastStoneWeightII(stones));
    }

    public int lastStoneWeightII(int[] stones) {

        Arrays.sort(stones);
        if(stones.length == 1){
            return stones[0];
        }
        int i;
        for( i = stones.length-2;i>=0;i--){
            if(stones[i] == stones[i+1]){
                stones[i] = 0;
                stones[i+1] = 0;
                i--;
            }else{
                int temp = stones[i+1]-stones[i];
                int j = i-1;  // j= -1
                stones[i+1] = 0;
                while(j >= 0 && stones[j]> temp){
                    stones[j+1] = stones[j];
                    j--;
                }
                stones[j+1] = temp;
            }
        }

        return stones[0];
    }

    public int lastStoneWeightII(int [] stones,int start){
        if(start == stones.length-1){
            return stones[stones.length-1];
        }
        int temp = lastStoneWeightII(stones,start+1);
        if(stones[start] == temp){
            return 0;
        }else{
            return Math.abs(stones[start]-temp);
        }
    }
}

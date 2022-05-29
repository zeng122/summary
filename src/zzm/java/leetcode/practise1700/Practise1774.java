package zzm.java.leetcode.practise1700;

import java.lang.reflect.Array;
import java.util.*;

public class Practise1774 {

    public static void main(String[] args) {
        Practise1774 practise1774 = new Practise1774();
        int[] baseCosts = {10};
        int[] toppingCosts = {1};
        System.out.println(practise1774.closestCost(baseCosts,toppingCosts,1));
    }


    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        HashSet<Integer> hashSet = new HashSet<>();
        //加上不需要配料，减少后面的判断
        hashSet.add(0);
        for(int i = 0;i<toppingCosts.length;i++){
            List<Integer> list = new ArrayList<>(hashSet);
            for(Integer integer : list){
                //一份
                hashSet.add(toppingCosts[i]+integer);
                //二份
                hashSet.add(toppingCosts[i]+toppingCosts[i]+integer);
            }
        }


        int result = Integer.MIN_VALUE;
        for(int i = 0;i<baseCosts.length;i++){
            for(Integer integer : hashSet){
                int cha = Math.abs(integer+baseCosts[i]-target);
                int cost = integer + baseCosts[i];
                if(cha < Math.abs(result-target) || (cha == Math.abs(result-target) && cost<result)){
                    result = cost;
                }
            }
        }
        return result;
    }
}

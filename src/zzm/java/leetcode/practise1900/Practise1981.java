package zzm.java.leetcode.practise1900;

import java.util.HashMap;
import java.util.HashSet;

public class Practise1981 {

    public static void main(String[] args) {
        Practise1981 practise1981 = new Practise1981();
        int[][] mat = {{10,3,7,7,9,6,9,8,9,5},{1,1,6,8,6,7,7,9,3,9},{3,4,4,1,3,6,3,3,9,9},{6,9,9,3,8,7,9,6,10,6}};

        System.out.println(practise1981.minimizeTheDifference(mat,5));
    }

    public int minimizeTheDifference(int[][] mat, int target) {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(0);
        //减少数量
        int temp = Integer.MAX_VALUE;
        for(int i = 0 ;i<mat.length;i++){
            HashSet<Integer> newHashSet = new HashSet<>();
            for(int j = 0;j<mat[i].length;j++){
                for(Integer integer : hashSet){
                    int value = integer+mat[i][j];
                    if(value<temp){
                        newHashSet.add(integer+mat[i][j]);
                        if(value>target){
                            temp = value;
                        }
                    }

                }
            }
            hashSet = newHashSet;
        }
        int result = Integer.MAX_VALUE;
        for(Integer integer : hashSet){
            if (Math.abs(integer - target) < result) {
                result = Math.abs(integer - target) ;
            }
        }
        return result;
    }
}

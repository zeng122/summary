package zzm.java.leetcode.practise500;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practise528 {

    public static void main(String[] args) {
        int[] w = {3,14,1,7};
        Practise528 practise528 = new Practise528(w);
        System.out.println(practise528.pickIndex());
    }
    //Map<Integer,Integer> map = new HashMap<>();
    int[] sums;
    int sum = 0;
    public Practise528(int[] w) {
        sums = new int[w.length];
        for(int i = 0;i<w.length;i++){
            sum = sum + w[i];
            sums[i] = sum;
        }
    }

    public int pickIndex() {
        int random = (int)(Math.random()*sum)+1;
        //return  find(sums,random);
        return find2(sums,0,sums.length-1,random);
    }

    public int find(int [] sums,int num){
        for(int i = 0;i<sums.length;i++){
            if(num<=sums[i]){
                return i;
            }
        }
        return sums.length-1;
    }

    //结果 前面比他小，后面比他大
    public int find2(int [] sums, int begin, int end, int num){
        if(begin == end){
            return begin;
        }
        if(begin+1 == end){
            if(sums[begin]>= num){
                return begin;
            }else{
                return end;
            }
        }
        int mid = (begin+end)/2;
        if(sums[mid] == num){
            return mid;
        }
        //4,6]
        if(sums[mid]>num){
            return find2(sums,begin,mid,num);
        }else{
            return find2(sums,mid+1,end,num);
        }
    }


}

package zzm.java.leetcode.practise1000;

import java.util.HashMap;
import java.util.Map;

public class Practise1015 {

    public static void main(String [] args){
        Practise1015 practise1015 = new Practise1015();
        System.out.println(practise1015.smallestRepunitDivByK(17));
    }
    public int smallestRepunitDivByK(int k) {
        if(k == 1){
            return 1;
        }
        Map<Integer,Boolean> hashMap = new HashMap();
        int j = 1;
        int yu = 1;
        while (true){
            int temp = yu * 10 + 1;
            yu = temp % k;
            j++;
            if(yu == 0){
                return j;
            }
            if(hashMap.containsKey(yu)){
                return -1;
            }else{
                hashMap.put(yu,true);
            }
        }
    }
}

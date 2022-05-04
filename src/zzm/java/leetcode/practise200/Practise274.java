package zzm.java.leetcode.practise200;

import java.util.Arrays;

public class Practise274 {

    //[3,0,6,1,5]

    /**
     * 1、 先排序 0 1 4 5 6
     * 2、 大于6  1, 5  2,4  3,1  4
     * 3、 times = 4
     * 4、
     * @param args
     */
    //4 ,4,0,0
    public static void main(String []args){
        int [] citations = {1,2};
        System.out.println(new Practise274().hIndex(citations));
    }


    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        if(citations[citations.length-1] == 0){
            return 0;
        }
        int result  = 1;
        boolean isFind = false;
        for(int i = 1; i<=citations.length;i++){
            if(citations[citations.length-i] == i){
                isFind = true;
                result = i;
                break;
            }else if(citations[citations.length-i]<i){
                isFind = true;
                result = i-1;
                break;
            }
        }
        if(isFind){
            return result;
        }
        return citations.length;
    }
}

package zzm.java.leetcode.practise1400;

import java.util.Arrays;

public class Practise1465 {

    public static void main(String[] args) {
        Practise1465 practise1465 = new Practise1465();
        int[] horizontalCuts = {3,1};
        int[] verticalCuts = {1};
        practise1465.maxArea(5,4,horizontalCuts,verticalCuts);
    }


    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int [] horNew = new int[horizontalCuts.length+2];
        Arrays.sort(horizontalCuts);
        for(int i = 0 ;i<horizontalCuts.length;i++){
            horNew[i+1] = horizontalCuts[i];
        }
        horNew[0] = 0;
        horNew[horizontalCuts.length+1] = h;


        int [] vNew = new int[verticalCuts.length+2];
        Arrays.sort(verticalCuts);
        for(int i = 0 ;i<verticalCuts.length;i++){
            vNew[i+1] = verticalCuts[i];
        }
        vNew[0] = 0;
        vNew[verticalCuts.length+1] = w;


        long bigH = 0;
        for(int i = 1;i<horNew.length;i++){
            if((horNew[i]-horNew[i-1]-bigH)>0){
                bigH = horNew[i]-horNew[i-1];
            }
        }


        long bigV = 0;
        for(int i = 1;i<vNew.length;i++){
            if((vNew[i]-vNew[i-1]-bigV)>0){
                bigV = vNew[i]-vNew[i-1];
            }
        }

        return  (int)((bigV*bigH)%1000000007);
    }
}

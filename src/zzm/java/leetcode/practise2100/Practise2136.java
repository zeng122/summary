package zzm.java.leetcode.practise2100;

import java.lang.reflect.Array;

public class Practise2136 {

    public static void main(String [] args){
        Practise2136 practise2136 = new Practise2136();
        int[] plantTime = {1,4,3};
        int[] growTime = {2,3,1};
        practise2136.earliestFullBloom(plantTime,growTime);

    }
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        for(int i = 0;i<growTime.length;i++){
            for(int j = i ;j<growTime.length-1;j++){
                if(growTime[j] < growTime[j]+1){
                    int temp = growTime[j];
                    growTime[j] = growTime[j+1];
                    growTime[j+1] = temp;

                    temp = plantTime[j];
                    plantTime[j] = plantTime[j+1];
                    plantTime[j+1] = temp;
                }
            }
        }

        int allDays = 0;
        int maxDays = 0;
        for(int i = 0 ;i< growTime.length;i++){
            maxDays = maxDays + plantTime[i]+growTime[i];
            if(maxDays > allDays){
                allDays = maxDays;
            }
            maxDays = plantTime[i];
        }
        return allDays+2;
    }
}

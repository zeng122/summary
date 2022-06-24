package zzm.java.leetcode.practise0;

import java.util.Arrays;
import java.util.Comparator;

public class Practise56 {

    public static void main(String[] args) {
        int[][] intervals = {
                {0,0},{1,4}
        };
        new Practise56().merge(intervals);
    }


    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0]-o2[0]);

        int [][] result = new int[intervals.length][2];
        int left = -1;
        int right = -1;
        int index = 0;
        //合并
        for(int i = 0;i<intervals.length;i++){
            if(left == -1 && right == -1){
                left = intervals[i][0];
                right = intervals[i][1];
            }else{
                if(intervals[i][0]<=right){
                    if(intervals[i][1]>right){
                        right = intervals[i][1];
                    }
                }else{
                    result[index][0] = left;
                    result[index][1] = right;
                    left = intervals[i][0];
                    right =  intervals[i][1];
                    index++;
                }
            }
        }
        result[index][0] = left;
        result[index][1] = right;
        return  Arrays.copyOfRange(result,0,index);
    }
}

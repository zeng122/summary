package zzm.java.leetcode.practise500;


import java.util.Arrays;
import java.util.List;

public class Practise539 {

    public static void main(String [] args){
        Practise539 practise539 = new Practise539();
        String [] strings = { "12:12","00:13"};
        List<String> timePoints = Arrays.asList(strings);
        System.out.println(practise539.findMinDifference(timePoints));
    }

    public int findMinDifference(List<String> timePoints) {
        int [] times = new int[timePoints.size()];
        int length = 0;
        int minTime = Integer.MAX_VALUE;
        //采用直接插入排序
        for(String timePoint:timePoints){
            int time = transferMinute(timePoint);
            int i ;
            for(i = 0;i<length;i++){
                if(time<times[i]){
                    int temp = length;
                    while (temp>i){
                        times[temp] = times[temp-1];
                        temp--;
                    }
                    times[i] = time;
                    break;
                }
            }
            if(i == length){
                times[length] = time;
            }
            length++;
        }


        for(int i = 0;i<times.length-1;i++){
            minTime = Math.min(times[i+1]-times[i],minTime);
        }
        minTime = Math.min(transferMinute("24:00")+times[0]-times[times.length-1],minTime);
        return minTime;
    }


    public int transferMinute(String time){
        return (((time.charAt(0)-'0')*10+(time.charAt(1)-'0'))*60+((time.charAt(3)-'0')*10+time.charAt(4)-'0'));
    }
}

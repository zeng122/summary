package zzm.java.leetcode.practise2100;

public class Practise2101 {

    boolean haveIn[];
    public static void main(String[] args) {
        Practise2101 practise2101 = new Practise2101();
        int[][] bombs = {{1,2,3},{2,3,1},{3,4,2},{4,5,3},{5,6,4}};
        System.out.println(practise2101.maximumDetonation(bombs));
    }

    public int maximumDetonation(int[][] bombs) {
        int result = 0;
        for(int i = 0 ;i<bombs.length;i++){
           haveIn = new boolean[bombs.length];
           haveIn[i] = true;
           int num = findMaxWithStart(bombs[i],bombs,1);
           if(num > result){
               result = num;
           }
        }
        return result;
    }

    public int findMaxWithStart(int[] bomb,int[][] bombs,int num){
        for(int i = 0 ;i<bombs.length;i++){
            if(haveIn[i] || !isInCircle(bomb,bombs[i])){
                continue;
            }
            haveIn[i] = true;
            num++;
            num = findMaxWithStart(bombs[i],bombs,num);
        }
        return num;
    }


    public boolean  isInCircle(int[] bomb1,int[] bomb2){
        if((Math.pow(Math.abs(bomb1[0]-bomb2[0]),2)+Math.pow(Math.abs(bomb1[1]-bomb2[1]),2))
            <=Math.pow(bomb1[2],2)){
            return true;
        }
        return false;
    }



}

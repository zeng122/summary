package zzm.java.leetcode.Practise800;

import java.util.Arrays;

public class Practise846 {

    public static void main(String[] args){
        Practise846 practise846 = new Practise846();
        int[] hand = {1,1,2,2,3,3};
        System.out.println(practise846.isNStraightHand(hand,2));
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        int length = hand.length;
        if(0 != length%groupSize){
            return false;
        }
        if(groupSize == 1){
            return true;
        }
        int groupNum = length/groupSize;
        Arrays.sort(hand);
        int [] hasHand = new int [length];
        int min = 1;
        int max = (hand[length-groupNum]-hand[0])/(groupSize-1);

        boolean isRight = true;
        int x = 1;
        //间距
        //for(int x = min;x<=max;x++){
            //组
            for(int i = 1;i<=groupNum;i++){
                int start = 0;
                while(hasHand[start]!=0){
                    start++;
                }
                //一个组
                for(int j = 0;j< groupSize;j++){
                    if(!canFind(hand[start]+j*x,hand,hasHand)){
                        isRight = false;
                        break;
                    }
                }
                if(!isRight)
                    break;
            }
            if(isRight){
                return true;
            }
            //isRight = true;
            //Arrays.fill(hasHand,0);
        //}
        return false;
    }

    boolean canFind(int temp,int [] hand ,int [] hasHand){
        int index = 0;
        while (index < hand.length && hand[index]<=temp){
            if(temp == hand[index] && hasHand[index]== 0){
                hasHand[index] = 1;
                return true;
            }
            index++;
        }
        return false;
    };
}

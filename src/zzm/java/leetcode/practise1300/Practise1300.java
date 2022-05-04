package zzm.java.leetcode.practise1300;

import java.util.Arrays;

public class Practise1300 {

    public static void main(String [] args){
        Practise1300 practise1300 = new Practise1300();
        int arr[] = {40091,2502,74024,53101,60555,33732,23467,40560,32693,13013};
        System.out.println(practise1300.findBestValue(arr,78666));
    }


    public int findBestValue(int[] arr, int target) {
        int average =  target/arr.length;
        Arrays.sort(arr);
        int sum = 0;
        int value = 0;


        int gap = Integer.MAX_VALUE;
        boolean isFirst = true;
        if(arr[0] >= average){
            return Math.abs(average*arr.length-target)<=Math.abs((average+1)*arr.length-target)?average:average+1;
        }
        for(int i = 0 ;i<arr.length;i++){
            if(arr[i] <= average){
                sum = sum+arr[i];
            }else{
                //2 3 6 9   20
                int temp = 0;
                if(isFirst){
                    temp =  sum - arr[i-1] + arr[i-1]*(arr.length-i+1);
                    gap = temp-target;
                    value = arr[i-1];
                    isFirst =false;
                }
                temp = sum + arr[i]*(arr.length-i);
                if(Math.abs(temp-target)<Math.abs(gap) && (temp-target)<0){
                    value = arr[i];
                    sum = sum+arr[i];
                    gap = Math.abs(temp-target);
                //在i和i-1中间
                }else{
                    average = (target-sum)/(arr.length-i);
                    return Math.abs(average*(arr.length-i)+sum-target)<=Math.abs((average+1)*(arr.length-i)+sum-target)?average:average+1;
                }
            }

        }
        if(isFirst){
            return arr[arr.length-1];
        }

        return value;
    }
}

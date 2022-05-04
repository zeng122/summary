package zzm.java.leetcode.practise1300;

public class Practise1343 {

    public static  void main(String[] args){
        Practise1343 practise1343 = new Practise1343();
        int[] arr = {2,2,2,2,5,5,5,8};
        System.out.println(practise1343.numOfSubarrays(arr,3,4));
    }

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int result = 0;
        int sum = 0;
        for(int i = 0;i<k;i++){
            sum = sum+arr[i];
        }
        if(sum>threshold*k) result++;
        for(int i = k;i<arr.length;i++){
            sum = sum+arr[i]-arr[i-k];
            if(sum>threshold*k)
                result++;
        }
        return result;
    }
}

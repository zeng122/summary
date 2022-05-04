package zzm.java.leetcode.Practise900;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Practise907 {

    public static void main(String[] args) {
        Practise907 practise907 = new Practise907();
        int []arr = {11,3,94,43,3};
        System.out.println(practise907.sumSubarrayMins(arr));
    }

    public int sumSubarrayMins(int[] arr) {
        long result = 0;
        long mo = (long) Math.pow(10,9) + 7;
        for(int i =0;i<arr.length;i++){
            result = result+fun1(i,arr);
            result = result%(mo);
        }
        return  (int)result;
    }

    public  long fun1(int length,int[] arr){
        long total = 0;
        int min = arr[length];
        total = total+min;
        for(int i = length-1;i>=0;i--){
            if(arr[i] < min){
                min = arr[i];
            }
            total = total+min;
        }
        return total;
    }


    //栈。如果遇到大的数字，入栈。如果遇到小的，前面出栈，
    // 出栈的元素求范围，他的左边界，右边界
    public int sumSubarrayMins2(int[] arr) {

        int MOD = 1000000007;
        int [] newArr = new int[arr.length+2];
        for(int i = 0;i<arr.length;i++){
            newArr[i+1] = arr[i];
        }
        newArr[0] = -1;
        newArr[arr.length+1] = Integer.MAX_VALUE;

        long result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0;i<newArr.length;i++){
            while (!stack.empty() && newArr[stack.peek()] > newArr[i]){
                    Integer temp = stack.pop();
                    Integer left = stack.peek();
                    Integer right = i;
                    result = result + (long) (temp - left) *(right-temp)*newArr[temp];
                    if(result > MOD){
                        result = result - MOD;
                    }
            }
            stack.push(i);
        }

        Integer right = stack.pop();
        while (!stack.empty() && stack.size() != 1){
            Integer temp = stack.pop();
            Integer left = stack.peek();
            result = result + (temp-left)*(right-temp)*newArr[temp];
            if(result > MOD){
                result = result - MOD;
            }
        }
        return  (int)result;
    }

}

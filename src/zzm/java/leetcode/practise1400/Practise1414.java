package zzm.java.leetcode.practise1400;

public class Practise1414 {

    public static void main(String[] args) {
        Practise1414 practise1414 = new Practise1414();
        System.out.println(practise1414.findMinFibonacciNumbers(7));
    }
    int num = 0;

    public int findMinFibonacciNumbers(int k) {
        fibonacciNumbers(k);
        return num;
    }

    public void fibonacciNumbers(int k){
        int n1 = 1,n2 =1;
        if(k == 1){
            num++;
            return;
        }
        while ((n1+n2)<k){
            int temp = n2;
            n2 = n1+n2;
            n1 = temp;
        }
        if((n1+n2) == k){
            num = num+1;
            return ;
        }else{
            num = num +1;
            fibonacciNumbers(k-n2);
        }
    }
}
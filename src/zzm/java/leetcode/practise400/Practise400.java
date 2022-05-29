package zzm.java.leetcode.practise400;

public class Practise400 {

    public static void main(String[] args) {
        Practise400 practise400 = new Practise400();
        practise400.findKthNumber(681932771,681932771);
    }
    public int findKthNumber(int n, int k) {
        long num = 1;
        int index = 1;
        while (true){
             if(index == k)
                return (int)num;
            if(num * 10 <= n){
                num = num * 10;
            }else if(num + 1<=n){
                num = num +1;
                while (num % 10 == 0){
                         num = num / 10;
                }
            }else if (num +1>n){
                num = num/10+1;
            }
            index++;
        }
    }


}

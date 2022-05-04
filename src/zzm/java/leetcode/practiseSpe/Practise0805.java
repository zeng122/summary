package zzm.java.leetcode.practiseSpe;

/**
 * 递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。
 */
public class Practise0805 {

    public static void main(String []args){
        Practise0805 practise0805 = new Practise0805();

        System.out.println(practise0805.multiply(34,56));
    }
    public int multiply(int A, int B) {

        int sum = 0;
        while(A!=1){
            if((A & 1) == 1){
                sum = sum + B;
                A = A -1;
            }else{
                B = B<<1;
                A = A>>1;
            }
        }
        return B+sum;
    }




}

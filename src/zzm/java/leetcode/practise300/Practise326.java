package zzm.java.leetcode.practise300;

public class Practise326 {

    public static void main(String[] args) {
        Practise326 practise326 = new Practise326();
        System.out.println(practise326.isPowerOfThree(27));
    }

    public boolean isPowerOfThree(int n) {
        if (n == 1){
            return true;
        }
        while (true){
            if(n % 3 == 0 ){
                if(n / 3 == 1){
                    return true;
                }else if (n/ 3> 1){
                    n = n/3;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
    }
}

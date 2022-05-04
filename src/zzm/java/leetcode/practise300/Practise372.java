package zzm.java.leetcode.practise300;

public class Practise372 {

    static final int MOD = 1337;

    public static void main(String[] args) {
        int[] b = {2,0,0};
        int result = 1;

        for(int i = 0;i<2432;i++){
           result =  (result * 3) % 1337;
        }
        System.out.println(new Practise372().superPow2(2147483647,b));
    }


    public int superPow(int a, int[] b) {
        if(a>=1337){
            a = a%1337;
        }
        if(a == 1){
            return  1;
        }
        int result = a;
        long xi = 1;
        for(int i = 0;i<b.length;i++){
            xi = xi * pow(result, b[b.length-1-i]);
            xi = xi % 1337;
            if(i != b.length-1){
                result = pow(result,10);
            }else{
                result = (int)xi;
            }

        }
        return result;
    }


    public long fun(long input, long input2, long num){
        if(num == 0){
            return 1;
        }
        if(num == 1){
            return (input * input2) % 1337;
        }
        if(num % 2 == 0){
            long temp = (input * input) % 1337;
            return fun(temp,input2,num/2);
        }else{
            return fun(input,(input2*input)%1337,num-1);
        }
    }

    public int superPow2(int a, int[] b) {
        int ans = 1;
        for (int i = b.length - 1; i >= 0; --i) {
            ans = (int) ((long) ans * fun(a,1, b[i]) % MOD);
            if(i != 0){
                a = (int)fun(a, 1, 10);
            }
        }
        return ans;
    }

    public int pow(int x, int n) {
        int res = 1;
        while (n != 0) {
            if (n % 2 != 0) {
                res = (int) ((long) res * x % MOD);
            }
            x = (int) ((long) x * x % MOD);
            n /= 2;
        }
        return res;
    }

}

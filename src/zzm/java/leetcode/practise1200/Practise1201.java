package zzm.java.leetcode.practise1200;

public class Practise1201 {

    public static void main(String [] args){
        Practise1201 practise1201 = new Practise1201();
        System.out.println(practise1201.nthUglyNumber(5,2 ,11,13));
    }

    public int nthUglyNumber(int n, int a, int b, int c) {
        long ab = minGongBeiShu(a,b);
        long ac = minGongBeiShu(a,c);
        long bc = minGongBeiShu(b,c);
        long abc = minGongBeiShu(minGongBeiShu(a,b),c);
        int min = Math.min(Math.min(a,b),c);
        long start = min;
        long end = min * n;
        long result = 0;
        while (true){
            long middle = (start+end)/2;
            long temp = middle/a+middle/b+middle/c-middle/ab-middle/bc-middle/ac+middle/abc;
            if(temp == n){
                result = middle;
                break;
            }else if(temp>n) {
               end = middle-1;
            }else{
                start = middle+1;
            }
        }

        while (true){
            result--;
            long temp = result/a+result/b+result/c-result/ab-result/bc-result/ac+result/abc;
            if(temp!=n){
                break;
            }
        }
        return (int) result+1;
    }
    /**
     * 最小公倍数，8 12
     * 2 4 3
     * @param x1
     * @param x2
     * @return
     */
    public long minGongBeiShu(long x1,long x2){
        return  x1 * x2 / gcd(x1,x2);
    }

    //m>n
    public long gcd(long m,long n) {
        if(m<n) {
            long k=m;
            m=n;
            n=k;
        }
        return m%n == 0l?n:gcd(n,m%n);
    }
}

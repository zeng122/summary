package zzm.java.leetcode.practise1000;

public class Practise1017 {
    public static void main(String[] args) {
        Practise1017 practise1017 = new Practise1017();
        practise1017.baseNeg2(-9);
    }

    public String baseNeg2(int n) {
        if (n == 0) return "0";
        String res = "";
        while (n != 0) {
            int r = n % (-2);
            r = (r + 2) % 2; // works for r < 0 or r >= 0
            res = r + res;
            n = (n - r) / -2;
        }
        return res;

    }


}

package zzm.java.leetcode.practise1300;

public class Practise1358 {
    public static void main(String[] args){
        Practise1358 practise1358 = new Practise1358();
        System.out.println(practise1358.numberOfSubstrings("abcabc"));
    }
    public int numberOfSubstrings(String s) {
        int result = 0;
        int left = 0;
        int right = 0;
        int a = 0;
        int b = 0;
        int c = 0;
        while(right<s.length()){
            while (!(a>0 && b>0 && c>0) && right<s.length()){
                char temp = s.charAt(right);
                if(temp == 'a') a++;
                else if(temp == 'b') b++;
                else c++;
                right++;
            }
            while (a>0 && b>0 && c>0){
                result = result+s.length()-right+1;
                char temp = s.charAt(left);
                if(temp == 'a') a--;
                else if(temp == 'b') b--;
                else c--;
                left++;
            }
        }
        return  result;
    }
}

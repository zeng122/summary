package zzm.java.leetcode.practise1800;

/**
 * @date 20210719
 * 给你一个字符串 num ，表示一个大整数。请你在字符串 num 的所有非空子字符串 中找出值最大的奇数 ，
 * 并以字符串形式返回。如果不存在奇数，则返回一个空字符串 "" 。
 * 输入：num = "52"
 * 输出："5"
 * 解释：非空子字符串仅有 "5"、"2" 和 "52" 。"5" 是其中唯一的奇数。
 */
public class Practise1903 {
    public static void main(String [] args){
        Practise1903 pratise1903 = new Practise1903();
        System.out.println(pratise1903.largestOddNumber1("52"));
    }

    public String largestOddNumber(String num) {
        char [] chars = num.toCharArray();
        int i  = 0 ;
        for(i = chars.length-1;i>=0;i--){
            if(chars[i] % 2 == 1){
               return String.valueOf(chars,0,i+1);
            }
        }
        return "";
    }
    public String largestOddNumber1(String num) {
        for(int i = num.length()-1;i >=0;i--){
            if(num.charAt(i) % 2 == 1){
                return num.substring(0,i+1);
            }
        }
        return "";
    }

}

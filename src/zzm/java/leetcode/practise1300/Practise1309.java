package zzm.java.leetcode.practise1300;

/**
 * 整数到字母的转换
 *
 * 字符（'a' - 'i'）分别用（'1' - '9'）表示。
 * 字符（'j' - 'z'）分别用（'10#' - '26#'）表示。
 * 如
 * s = "10#11#12"
 * 输出："jkab"
 */


public class Practise1309 {
    public static void main(String [] args){

        Practise1309 practise1309 = new Practise1309();
        System.out.println(practise1309.freqAlphabets( "10#11#12"));
    }

    /**
     * 解题思路：
     * 难点：当第一个数字遇到1，2时，如何知道采用下面的算法
     * 直接获取后面第二个的字符，看是否等于‘#’
     *
     * 如何转换：直接使用ASCII
     * @param s
     * @return
     */
    public String freqAlphabets(String s) {
        char [] str = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0 ;i<s.length();i++){
            if((str[i] == '1' | str[i] == '2') && i < s.length()-2 && str[i+2] == '#'){
                char index =(char) ((str[i]-48) * 10 + str[i+1]+48);
                stringBuilder.append(index);
                i = i + 2;
            }else{
                char index =(char) (str[i]+48);
                stringBuilder.append(index);
            }
        }
        return stringBuilder.toString();
    }


    /**
     * 为什么比上面慢？
     * char[]数组取数慢？
     * @param s
     * @return
     */
    public String freqAlphabets2(String s) {
        char [] chars = {'a','b','c','d','e','f','g',
                'h','i','j','k','l','m','n',
                'o','p','q','r','s','t', 'u','v','w','x','y','z'};
        char [] str = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0 ;i<s.length();i++){
            if((str[i] == '1' | str[i] == '2') && i < s.length()-2 && str[i+2] == '#'){
                int index = (str[i]-48) * 10 + str[i+1]-48;
                stringBuilder.append(chars[index-1]);
                i = i + 2;
            }else{
                int index = str[i]-48;
                stringBuilder.append(chars[index-1]);
            }
        }
        return stringBuilder.toString();
    }
}

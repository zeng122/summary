package zzm.java.leetcode.practise600;

/**
 * 给定两个字符串 a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。
 *
 * 注意：字符串 "abc" 重复叠加 0 次是 ""，重复叠加 1 次是 "abc"，重复叠加 2 次是 "abcabc"。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/repeated-string-match
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Practise686 {

    public static void main(String[] args){
        Practise686 practise686 = new Practise686();
        System.out.println(practise686.repeatedStringMatch("a","aa"));
    }

    public int repeatedStringMatch(String a, String b) {
        char [] chars = a.toCharArray();

        boolean judge = false;
        int i;
        for(i = 0;i<a.length();i++){
            char c = b.charAt(0);
            if(chars[i] == c){
                int j = 0;
                for(j = 0;j<a.length() && j<b.length();j++){
                    if(chars[(i+j)%a.length()] != b.charAt(j)){
                        break;
                    }
                }
                if(j == a.length() || j == b.length()){
                    judge =true;
                    break;
                }
            }
        }


        int result = 1;
        if(judge){
            for(int j = 1; j < b.length();j++){
                if(b.charAt(j) == chars[(i+j)%a.length()]){
                    if((i+j)%a.length() == 0){
                        result++;
                    }
                }else{
                    return -1;
                }
            }
        }else{
            return -1;
        }

        return result;

    }
}

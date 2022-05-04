package zzm.java.leetcode.practise1400;

/**
 * 一个 「开心字符串」定义为：
 *
 * 仅包含小写字母['a', 'b', 'c'].
 * 对所有在1到s.length - 1之间的i，满足s[i] != s[i + 1]（字符串的下标从 1 开始）。
 * 比方说，字符串"abc"，"ac"，"b" 和"abcbabcbcb"都是开心字符串，
 * 但是"aa"，"baa"和"ababbc"都不是开心字符串。
 *
 * 给你两个整数 n和 k，你需要将长度为 n的所有开心字符串按字典序排序。
 *
 * 请你返回排序后的第 k 个开心字符串，如果长度为 n的开心字符串少于 k个，那么请你返回 空字符串。
 *
 * 1 <= n <= 10
 * 1 <= k <= 100
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Practise1415 {

    /**
     * 输入：n = 1, k = 3
     * 输出："c"
     * 解释：列表 ["a", "b", "c"] 包含了所有长度为 1 的开心字符串。按照字典序排序后第三个字符串为 "c" 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String [] args){
        Practise1415 practise1415 = new Practise1415();
        practise1415.getHappyString(1,3);

    }
    /**
     *
     * @param n
     * @param k
     * @return
     */

    char[] chars = {'a','b','c'};
    int times = 0;
    public String getHappyString(int n, int k) {
        //先添加一个，兼容后面，后面会判断最后一个字符，主要避免后面加判断
        for(int i = 0;i< chars.length;i++){
           String result =  getHappyString(""+chars[i],n,k);
           if(!result.equals("")){
               return result;
           }
        }

        return "";
    }

    public String getHappyString(String input,int n,int k){
        //递归终点，字符串长度 = n 并且 次数 = k
        if(input.length() == n){
            times++;
            if(times == k){
                return input;
            }
            //递归终点，字符串长度 = n, 没找到
            return "";
        }

        for(int i = 0;i< chars.length;i++){
            if(input.charAt(input.length()-1) != chars[i]){
                String result = getHappyString(input+chars[i],n,k);
                //如果找到结束递归
                if(!result.equals("")){
                    return result;
                }
            }
        }
        return "";
    }



}

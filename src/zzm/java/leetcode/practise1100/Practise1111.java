package zzm.java.leetcode.practise1100;

/**
 * 输入：seq = "(()())"
 * 输出：[0,1,1,1,1,0]
 * 形成两个
 * () ()()
 * 左边有效嵌套 1
 * 右边有效嵌套 1
 * 求：MAX(左,右)最小 1
 */
public class Practise1111 {


    //((())) (()  ((
    //有效字符，那么最左(    最右)
    //尽可能两个相同

    //0 0 1 1
    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int [seq.length()];
        int a1 = 0;
        int a2 = 0;
        for(int i = 0; i<seq.length();i++) {
            char c = seq.charAt(i);
            if(c == '('){
                if(a1<=a2){
                    a1++;
                    ans[i] = 0;
                }else{
                    a2++;
                    ans[i] = 1;
                }
            }else{
                if(a1>a2){
                    a1--;
                    ans[i] = 0;
                }else{
                    a2--;
                    ans[i] = 1;
                }

            }
        }
        return ans;
    }
}

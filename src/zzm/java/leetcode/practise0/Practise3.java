package zzm.java.leetcode.practise0;

import java.util.*;

/**
 * 寻找最大不重复字符串
 *
 * 如abcdd
 * 输出abcd
 *
 *
 * 典型的滑动窗口 类型
 */
public class Practise3 {
    public static void main(String []args){
        Practise3 practise3 = new Practise3();
        int maxLength = practise3.lengthOfLongestSubstring2("pwwpew");
        System.out.println(maxLength);
    }


    /**
     * 为什么慢？用了很多封装方法，如list.remove(),list.indexOf()
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0 ;
        List list = new ArrayList<>();
        int length = 0;
        for(int i = 0 ;i<s.length(); i++){
            char c = s.charAt(i);
            int index = list.indexOf(c);
            if(index != -1){
               for(int j = 0 ;j<= index;j++){
                   list.remove(0);
               }
               list.add(c);
               int lengthTemp = length - index;
               if(length > maxLength){
                   maxLength = length;
               }
               length = lengthTemp;
            }else{
                length++;
                list.add(c);
            }
        }
        if(length>maxLength){
            return length;
        }
        return maxLength;
    }

    /**
     * 升级版，处理成Map
     * 不必输出字符串
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            // 1 经典：如何过滤掉以前的脏数据，这样做的好处，不用重新生成map，上面的方法1最直接思路
            if (map.containsKey(alpha)) {
                //1.1 先比较,小的不算
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            //1.1 后面的直接覆盖
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }


}

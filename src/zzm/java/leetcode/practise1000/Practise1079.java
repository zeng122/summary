package zzm.java.leetcode.practise1000;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。
 * 返回你可以印出的非空字母序列的数目。
 * 输入："AAB"
 * 输出：8
 * 解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
 */
public class Practise1079 {

    private int num = 0;
    public static void main(String[] args){
        Practise1079 practise1079 = new Practise1079();
        String title = "AAB";
        System.out.println(practise1079.numTilePossibilities(title));
    }

    /**
     * 回溯法
     * @param tiles
     * @return
     */
    public int numTilePossibilities(String tiles) {
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars);
        DFS(chars);
        return num;
    }

    void DFS(char[] chars){
       Map<Character,Boolean> characterHashMap = new HashMap();
       for (int i = 0 ;i<chars.length ;i++){
           //垂直方向，已使用的节点不在使用
           //水平方向没有，表示可以添加成为一个新节点
           if(chars[i] != '*' && !characterHashMap.containsKey(chars[i])){
               characterHashMap.put(chars[i],true);
               num++;
               //用于复原
               char temp = chars[i];
               chars[i] = '*';
               DFS(chars);
               //复原
               chars[i] = temp;
           }
       }
    }
}

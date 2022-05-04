package zzm.java.leetcode.practise500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
 * 输出："apple"
 */
public class Practise524 {

    public static void main(String[] args){
        Practise524 practise524 = new Practise524();
        String[] strings = {"a","b","c","p"};

        practise524.findLongestWord2("abpcplea", Arrays.asList(strings));
    }


    public String findLongestWord2(String s, List<String> dictionary){
        int m = s.length();
        int[][] f = new int[m + 1][26];
        Arrays.fill(f[m], m);

        for (int i = m - 1; i >= 0; --i) {
            for (int j = 0; j < 26; ++j) {
                if (s.charAt(i) == (char) ('a' + j)) {
                    f[i][j] = i;
                } else {
                    f[i][j] = f[i + 1][j];
                }
            }
        }


        String res = "";
        for (String t : dictionary) {
            boolean match = true;
            int j = 0;
            for (int i = 0; i < t.length(); ++i) {
                if (f[j][t.charAt(i) - 'a'] == m) {
                    match = false;
                    break;
                }
                j = f[j][t.charAt(i) - 'a'] + 1;
            }
            if (match) {
                if (t.length() > res.length() ||  (t.length() == res.length() && t.compareTo(res) < 0)) {
                    res = t;
                }
            }
        }
        return res;
    }

    public String findLongestWord(String s, List<String> dictionary) {
        int [] maxIndex = new int [dictionary.size()];
        Arrays.fill(maxIndex,0);
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            for(int j = 0;j<dictionary.size();j++){
                if(maxIndex[j] < dictionary.get(j).length()  && dictionary.get(j).charAt(maxIndex[j]) == c){
                    maxIndex[j]++;
                }
            }
        }
        //Arrays.sort(maxIndex);
        int max = 1;
        String maxString  = "";
        for(int i = 0;i<maxIndex.length;i++){
            if(maxIndex[i] == dictionary.get(i).length()){
                if(maxIndex[i] > max){
                   max = maxIndex[i];
                   maxString = dictionary.get(i);
                }else if(maxIndex[i] == max){
                    if(maxString.equals("") || dictionary.get(i).compareTo(maxString)<0){
                        maxString = dictionary.get(i);
                    }

                }
            }
        }
        return maxString;
    }
}

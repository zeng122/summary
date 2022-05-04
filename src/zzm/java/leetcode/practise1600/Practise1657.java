package zzm.java.leetcode.practise1600;

import java.util.Arrays;

public class Practise1657 {


    public static void main(String [] args){
        Practise1657 practise1657 = new Practise1657();
        System.out.println(practise1657.closeStrings("abbc","bcaa"));
    }

    public boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length()){
            return false;
        }
        int[] temp1 = new int[26];
        int[] temp2 = new int[26];
        for(int i = 0;i<word1.length();i++){
            temp1[word1.charAt(i)-'a']++;
            temp2[word2.charAt(i)-'a']++;
        }

        //大于0的都有
        for(int i = 0 ;i<26;i++){
            if((temp1[i]>0 && temp2[i]==0) || (temp1[i]==0 && temp2[i]>0) ){
                return false;
            }
        }
        //数量相等
        Arrays.sort(temp1);
        Arrays.sort(temp2);
        for(int i = 0;i<26;i++){
            if(temp1[i]!=temp2[i]){
                return false;
            }
        }
        return true;
    }


}

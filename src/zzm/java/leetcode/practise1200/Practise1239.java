package zzm.java.leetcode.practise1200;

import java.util.*;

public class Practise1239 {


    public static  void main(String [] args){
        Practise1239 practise1239  = new Practise1239();
        String[] inputs = {"a", "abc", "d", "de", "def"};
        System.out.println(practise1239.maxLength(Arrays.asList(inputs)));
    }

    public int maxLength(List<String> arr) {
        String temp = "";
        int maxLength = 0;
        for(int i = 0;i<arr.size();i++){
            if(isRightString(temp + arr.get(i))){
                maxLength = Math.max(getMaxLength(arr,temp + arr.get(i),i+1),maxLength);
            }
        }
        return maxLength;
    }

    int getMaxLength(List<String> arr,String temp,int start){
        int maxLength = temp.length();
        for(int i = start;i<arr.size();i++){
            if(isRightString(temp + arr.get(i))){
                maxLength = Math.max(getMaxLength(arr,temp + arr.get(i),i+1),maxLength);
            }
        }
        return maxLength;
    }


    boolean isRightString(String input){
        Set<Character> set = new HashSet<>();
        for(int i = 0 ; i< input.length();i++){
            char c = input.charAt(i);
            if(set.contains(c)){
                return false;
            }
            set.add(c);
        }
        return true;
    }

}

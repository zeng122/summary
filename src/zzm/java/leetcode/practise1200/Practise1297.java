package zzm.java.leetcode.practise1200;

import java.util.HashMap;
import java.util.HashSet;

public class Practise1297 {

    public static void main(String[] args) {
        Practise1297 practise1297 = new Practise1297();
        System.out.println(practise1297.maxFreq("aaaa",1,3,4));
    }

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        HashMap<String,Integer> hashMap = new HashMap<>();
        HashMap<Character,Integer> hashMap2 = new HashMap<>();
        if(s.length()<minSize) {
            return 0;
        }
        for(int i = 0;i<minSize;i++){
            if(hashMap2.containsKey(s.charAt(i))){
                hashMap2.put(s.charAt(i),hashMap2.get(s.charAt(i))+1);
            }else{
                hashMap2.put(s.charAt(i),1);
            }
        }
        if(hashMap2.size()<=maxLetters){
            String subStr = s.substring(0,minSize);
            if(hashMap.containsKey(subStr)){
                hashMap.put(subStr,hashMap.get(subStr)+1);
            }else{
                hashMap.put(subStr,1);
            }
        }
        for(int i = 1 ;i <= s.length()-minSize;i++){
            if(hashMap2.containsKey(s.charAt(i+minSize-1))){
                hashMap2.put(s.charAt(i+minSize-1),hashMap2.get(s.charAt(i+minSize-1))+1);
            }else{
                hashMap2.put(s.charAt(i+minSize-1),1);
            }
            if((hashMap2.get(s.charAt(i-1))-1)>0){
                hashMap2.put(s.charAt(i-1),hashMap2.get(s.charAt(i-1))-1);
            }else{
                hashMap2.remove(s.charAt(i-1));
            };
            if(hashMap2.size()<=maxLetters){
               String subStr = s.substring(i,i+minSize);
               if(hashMap.containsKey(subStr)){
                   hashMap.put(subStr,hashMap.get(subStr)+1);
               }else{
                   hashMap.put(subStr,1);
               }
            }
        }

        int result = 0;
        for(HashMap.Entry<String,Integer> entry :hashMap.entrySet()){
            if(entry.getValue()>result){
                result = entry.getValue();
            }
        }
        return result;
    }

}

package zzm.java.leetcode.practise100;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯法
 */
public class Practise131 {

    public static void main(String []args){
        Practise131 practise131 = new Practise131();
        practise131.partition("aab");
    }
    public List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();

        getHuiWen(s,0,new ArrayList<>(),result);
        return result;
    }


    public void getHuiWen(String s,int start,List<String> input,List<List<String>> result){
        if(start == s.length()){
            List<String> copy = new ArrayList<>(input);
            result.add(copy);
            return ;
        }
        for(int i = start ;i < s.length();i++){
            //找到一个后
            int end = i;
            int tempStart = start;
            int tempEnd = end;
            boolean isRight = true;
            while (tempEnd>=tempStart){
                if(s.charAt(tempEnd) != s.charAt(tempStart)){
                    isRight = false;
                    break;
                }
                tempStart++;
                tempEnd--;
            }


            if(isRight){
                String s1 = s.substring(start,end+1);
                input.add(s1);
                //继续找下一个
                getHuiWen(s,end+1,input,result);
                input.remove(input.size()-1);
            }



        }
    }

}

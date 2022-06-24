package zzm.java.leetcode.practise0;

import java.util.ArrayList;
import java.util.List;

public class Practise93 {
    public static void main(String[] args) {

        Practise93 practise93 = new Practise93();
        practise93.restoreIpAddresses("0");
    }

    public List<String> restoreIpAddresses(String s) {

        List<String> result =  fun1(s,0,4);
        if(result == null){
            return new ArrayList<String>();
        }
        return result;
    }


    //广度优先
    public List<String> fun1(String s,int pos,int time){
        List<String> result = new ArrayList<>();
        if(s.length()-pos>time*3 || s.length()-pos<time){
            return null;
        }

        if(time == 0){
            if(pos == s.length()){
                result.add("");
                return result;
            }
            return null;
        }
        time--;
        int value = 0;
        //头一个为0
        int strMaxLen = 1;
        if(s.charAt(pos) != '0'){
            strMaxLen = 3;
        }
        for(int i = pos;i<pos+strMaxLen && i<s.length();i++){
            value = value*10+(s.charAt(i)-'0');
            if(value > 255){
                break;
            }
            List<String> list = fun1(s,i+1,time);
            if(list != null){
                for(String str :list){
                    if(str.equals("")){
                        result.add(value+str);
                    }else{
                        result.add(value+"."+str);
                    }
                }
            }
        }
        return result;
    }
}

package zzm.java.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {
    private static final String REGEX = "^[1-2]\\d{3}((0[1-9])|(1[0-2]))$";

    public static void main(String [] args){
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher("202006");
        if(matcher.matches()){
            System.out.println("匹配成功");
        }else{
            System.out.println("匹配失败");
        }
    }
}

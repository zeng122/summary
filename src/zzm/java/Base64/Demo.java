package zzm.java.Base64;

import java.util.Base64;

public class Demo {
    public static void main(String [] args){
        String str = "zesdsadsadasd1234111asdddddddddddddddddda24123132143546546456ng123eqwejsdsdewefefsdasadsadwewq42535346";
        String str1 =  Base64.getEncoder().encodeToString(str.getBytes());
        String str2 =  Base64.getMimeEncoder().encodeToString(str.getBytes()).toString();
        String str3 =  Base64.getUrlEncoder().encodeToString(str.getBytes()).toString();
        System.out.println("str1 :"+str1);
        System.out.println("str2 :"+str2);
        System.out.println("str3 :"+str3);
    }
}

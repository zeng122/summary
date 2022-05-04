package zzm.java.code;

public class Code1 {



    public static void main(String []args){
        Code1 code1 = new Code1();
        code1.fun1();
    }

    /**
     *
     */
    public void fun1(){
        String strCh = "我的世界";
        String strEn = "sdsa";
        char str3 =  '\u1D54';
        System.out.println(str3);
        System.out.println("ch:"+strCh.length()+"   en:"+strEn.length());
        int count1 = strCh.codePointCount(0,strCh.length());
        int count2 = strEn.codePointCount(0,strEn.length());
        System.out.println("chPoint:"+count1+"   enPoint"+count2);
    }
}

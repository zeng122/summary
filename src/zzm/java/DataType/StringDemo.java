package zzm.java.DataType;

public class StringDemo {
    public  static  void main(String[] args){
        StringDemo stringDemo = new StringDemo();
        stringDemo.fun1();
    }

    public  void fun1(){
        String a=new String("haha");
        String b =new String("haha");
        String str1 = "ssssss";
        String str2 = "ssssss";
        System.out.println(a == b);
    }
}

package zzm.java.Test;

public class Student1 {

    private int a;

    public Student1 (int a){
        this.a = a;
    }

    public static void main(String[] args){
        Student1 st = new Student1(1);
        st.fun1();

    }

    public void fun1(){
        this.a = 3;
    }
}

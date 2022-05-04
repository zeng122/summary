package zzm.java.Template;

import zzm.java.Test.Test3;

import java.util.ArrayList;
import java.util.List;

public class Template1 {

    public static void main(String [] args){
        List<String>  list = new ArrayList<>();
        System.out.println(list.getClass());
        Template1 template1 = new Template1();
        template1.fun1();
        //会报错
        //template1.getString2(People1.class);
        //template1.getString2(People2.class);
        template1.getString2(People.class);

    }

    private void fun1(){
//        Demo<String> demo = new Demo<>("hello");
//        System.out.println(demo.retT());
        String str  = "Dsad";
        System.out.println(getString(str.getClass()));

        Demo2<String> stringDemo1 = new Demo2<>("hello");
        Demo1<String,Demo2<String>> demo2Demo1 = new Demo1<>();
    }

    //most simple template : template class
    public  class Demo<T>{
        private T t;
        private Demo(T t){
            this.t = t;
        }
        private T retT(){
            return  t;
        }
    }

    public class Demo2<T> extends Demo<T>{
        public Demo2(T t){
            super(t);
        }
    }

    public class Demo1<O , B extends Demo<O>>{

    }

    //template function
    public <A> A getString (Class<A> a){
        try {
            A a1 = a.newInstance();
            return  a1;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return  null;
    }

    // ? 泛型通配符
    public String getString1(Class<?> c){
        try {
            c.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return "Sadad";
    }

    public <T> String getString2(Class<? super People> t){
        return "1111";
    }


    class People{
        public void fun(){
            System.out.println("people");
        }
    }

    class People1 extends People{
        public void fun(){
            System.out.println("people1");
        }
    }

    class People2 extends People1{
        public void fun(){
            System.out.println("people2");
        }
    }
}

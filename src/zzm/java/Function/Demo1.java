package zzm.java.Function;

import java.util.function.Function;

/**
 * Java8 函数式接口
 * 允许在接口中定义具体的方法，default方法和static方法
 *
 * 那么Function<T,R>有什么用呢
 * T input
 * R output
 *
 */
public class Demo1 {

    public static  void main(String[] args){
        Demo1 demo1 = new Demo1();
        Function<String,Integer> function1 = (a)->{
            System.out.println(a);
            return 9;
        };
        function1.apply("sadas");
        demo1.fun1();
    }


    /**
     * Lambda表达式语法：
     *
     */
    public void fun1(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };


        //因为是一个返回类的实例所以可以直接构造参数
        Thread thread = new Thread(()->{

        });


    }


    /**
     * Lambda表达式就相当于一个返回类的实例
     * ()->{},一个参数或者一个表达式可以省略()或者{},相当于实现方法
     * 可以省略参数类型
     *
     */
    public void fun2(){
        MyFunctionDemo myFunctionDemo = (int a)->{
            return 7;
        };
    }



}




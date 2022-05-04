package zzm.java.ExceptionDemo;

import java.beans.Transient;

/**
 * The purpose of this class is to validate if exception occurs whether program can run
 * continue
 *
 *
 * In brief : if exception occurs , the program will jump to the place which is also the
 * the place where program deal with exception(catch)
 */
public class ExceptionDemo1 {
    int i = 1;
    public  static void main(String[] args){
        ExceptionDemo1 exceptionDemo1 = new ExceptionDemo1();
       // exceptionDemo1.fun1();
        try {
            exceptionDemo1.fun6();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

//        try {
//            exceptionDemo1.fun4();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
        System.out.println("SDadsad");
    }

    public int getI(){
        return  i;
    }

    public void fun1(){
        int[] a  = {1,2,0,3,0,2,3,1,0,76};
        for(int i = 0 ; i< 10 ;i++){
            try {
                int j = 100/a[i];
                System.out.println(j);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println("执行吗");
    }

    public void fun2(){
        int[] a  = {1,2,0,3,0,2,3,1,0,76};
        for(int i = 0 ; i< 10 ;i++){
            int j = 100/a[i];
            System.out.println(j);
        }
        System.out.println("执行吗");
    }

    public void fun3() throws Exception{
        int[] a  = {1,2,0,3,0,2,3,1,0,76};
        for(int i = 0 ; i< 10 ;i++){
            int j = 100/a[i];
            System.out.println(j);
        }
        System.out.println("执行吗");
    }

    /**
     * test whether the exception  can catch by its parent's method
     *
     * in brief : the exception can be caught by its parent's method
     */
    public void fun4(){
        int[] a  = {1,2,0,3,0,2,3,1,0,76};
        for(int i = 0 ; i< 10 ;i++){
            int j = 100/a[i];
            System.out.println(j);
        }
    }

    @Transient
    public void fun5() throws  Exception{
        try{
            if(i==1){
                i++;
                throw new Exception("哈哈哈哈");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw  new Exception();
        }
    }

    public void fun6() throws  Exception{
        try{
            throw  new Exception("我要测试了");
        }finally {
            System.out.println("你是无论如何都要运行的");
        }
    }
}

package zzm.java.ExceptionDemo;

public class ExceptionTest {
    public static void main(String []args){
        ExceptionTest exceptionTest = new ExceptionTest();
        exceptionTest.fun1();
    }

    public  void fun1(){
        try {
            fun2();
            return;
        } catch (BaseException1 baseException1) {
            System.out.println(baseException1);
            return;
        }finally {
            System.out.println("11111");
            int i = 1/0;
            return;
        }
    }

    //必须要捕获或者抛出
    public void fun2() throws BaseException1{
        throw new BaseException1("sdadd");
    }

    public void fun3(){
        try{
            fun4();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //不必捕获和抛出
    public void fun4(){
        throw  new BaseException2("DSADSAD");
    }

    public void fun5(){
        try {
            fun6();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void fun6(){
        throw  new BaseException3("SADASDASDCCC");
    }
}

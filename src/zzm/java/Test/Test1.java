package zzm.java.Test;

import java.util.Date;


public class Test1 {
    public static  void main(String [] args){
        Test1 test1 = new Test1();
        Integer j = Integer.valueOf(130);
        System.out.printf("%,+10.2f",-100000.0/3);
        System.out.println(System.getProperty("user.dir"));
        Date date = new Date(1400565124000l);
        double i = 2.2/0;
        System.out.println(i);
        //test1.fun(1 ,2 );
        //test1.fun2(1,2);
    }


    void fun(int i  , int j){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fun(1 , 2);
    }

    void fun2(int i  , int j){
      while (true){
         Test1 test1 = new Test1();
      }

    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("sads");
    }
}

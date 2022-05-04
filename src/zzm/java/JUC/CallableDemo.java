package zzm.java.JUC;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * Callable 例子
 */
public class CallableDemo {
    public static  void main(String []args){
       CallableDemo callableDemo = new CallableDemo();
       callableDemo.fun();
    }

    public void fun(){
        FutureTask<String> futureTask = new FutureTask<String>(callable);
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("hhhhhhs");
    }

    private Callable<String> callable = new Callable<String>() {
        @Override
        public String call() throws Exception {
            Thread.sleep(2000);
            return "I want to be greater";
        }
    };
}

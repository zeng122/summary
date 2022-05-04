package zzm.java.JUC;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CompletableFutureDemo  {

    public static void main(String [] args){
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(()->
            getMoreData()
        );

//        try {
//            future.get(3, TimeUnit.SECONDS);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (TimeoutException e) {
//            e.printStackTrace();
//        }
        System.out.println("sadasdas");

        future.whenComplete((result, excetion) -> {
            System.out.println("执行到whenComplete了，result:" + result);
            System.out.println("执行到whenComplete了，exception:" + (excetion == null ? "无异常" : excetion.getClass()));
        });
        System.out.println("eeee");

        CompletableFuture<Integer> future2 = future.whenComplete((result, excetion) -> {
            System.out.println("执行到whenComplete了，result:" + result);
            System.out.println("执行到whenComplete了，exception:" + (excetion == null ? "无异常" : excetion.getClass()));
        });

        System.out.println("ddddddd");
        try {
            System.out.println("执行到最后一段代码了，future result：" + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("cccccc");
        try {
            System.out.println("执行到最后一段代码了，future2 result：" + future2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }


    public static int getMoreData() {
        System.out.println("begin to start compute");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //throw new RuntimeException();
        System.out.println("end to compute, passed:" + System.currentTimeMillis());
        return new Random(100).nextInt(100);
    }
}

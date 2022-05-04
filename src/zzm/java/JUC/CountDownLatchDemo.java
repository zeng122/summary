package zzm.java.JUC;

import java.util.concurrent.CountDownLatch;


/**
 * 完成后在开始下面一项动作
 */
public class CountDownLatchDemo {

    CountDownLatch countDownLatch = new CountDownLatch(10);
    void fun1(){
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"结束");
        countDownLatch.countDown();
    }

    /**
     * 当countDownLatch变为0时，被唤起
     */
    void fun2(){
        try {
            System.out.println("等待中·········");
            countDownLatch.await();
            System.out.println("开始");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public  static  void main(String[] args){

        CountDownLatchDemo  countDownLatchDemo = new CountDownLatchDemo();
        for(int i = 0;i<20;i++){
            new Thread(()->{
                countDownLatchDemo.fun1();
            }).start();
        }
        countDownLatchDemo.fun2();
    }
}

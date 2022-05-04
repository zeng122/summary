package zzm.java.JUC;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 相对synchronized 有下面几个优点：
 * 1、等待可中断
 * 2、可实现公平锁
 * 3、锁可以绑定多个条件
 * 4、可以尝试获取锁，tryLock()
 */
public class ReentrantLockDemo {
    //交替打印，必须定义一个变量控制谁快谁慢
    private volatile Boolean isFirst1 = false;
    private volatile Boolean isFirst2 = false;
    Semaphore semaphore = new Semaphore(0);
    Lock lock = new ReentrantLock();

    ReentrantLock reentrantLock = new ReentrantLock();
    //多个条件
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();

    void fun1(){
        try{
           // semaphore.release();
            synchronized (this){
                System.out.println("11111");
                Thread.sleep(2000);
                lock.lock();
                if(isFirst2){
                    this.notify();
                }else{
                    isFirst1 = true;
                }
            }

            while (true){
                System.out.println("开始1");
                condition1.signal();
                condition2.await();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    void fun2(){
        try{
            synchronized (this){
                System.out.println("wwwww");
                Thread.sleep(2222);
                if(isFirst1){

                }else{
                    isFirst2 = true;
                    this.wait();
                }

            }
           // semaphore.acquire();
            lock.lock();

            while (true){
                System.out.println("开始2");
                condition2.signal();
                condition1.await();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    void fun3(){
        if(lock.tryLock()){
            try{
                System.out.println("开始3");
            }finally {
                lock.unlock();
            }
        }else{
            System.out.println("没有获取到锁");
        }
    }

    void fun10(){

        try {
            lock.lock();
        }finally {
            lock.unlock();
        }

    }



    Thread t1 = new Thread(()->{
       System.out.println("1111");
        try {
            wait();
            System.out.println("1111");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    });

    Thread t2 = new Thread(()->{

        try {
            TimeUnit.SECONDS.sleep(1);
            t1.notify();
        } catch (Exception e) {
            e.printStackTrace();
        }
    });

    void fun4(){
        try {
            lock.lock();
            try {

               lock.wait(); //wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }finally {
            lock.unlock();
        }
    }

    void fun6(){
     synchronized (this){
         try {
             this.wait();
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }
    }


    void fun5(){
        try {
            lock.lock();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            notify();
        }finally {
            lock.unlock();
        }
    };

    public  static  void main(String[] args){
        ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();

        new Thread(()->{reentrantLockDemo.fun2();}).start();
        new Thread(()->{reentrantLockDemo.fun1();}).start();

        new Thread(()->{reentrantLockDemo.fun3();}).start();
        //new Thread(()->{reentrantLockDemo.fun4();}).start();
        //new Thread(()->{reentrantLockDemo.fun5();}).start();

        // reentrantLockDemo.t1.start();
        // reentrantLockDemo.t2.start();



    }
}

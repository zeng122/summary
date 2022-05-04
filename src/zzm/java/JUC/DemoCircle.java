package zzm.java.JUC;

import java.util.concurrent.locks.LockSupport;

public class DemoCircle {

    volatile  boolean  isFirstA = true;
    volatile  boolean  isFirstB = false;

    public static void main(String[] args) {
        DemoCircle demoCircle = new DemoCircle();
        demoCircle.fun1();
    }
    public void fun1(){
        Thread[] threads = new Thread[20];
        for(int i = 0;i<10;i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        funB();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        for(int i = 10;i<20;i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        funA();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        for(int i = 0;i<20;i++){
            threads[i].start();
        }

    }

    public  void funA() throws InterruptedException {
        synchronized (this){
            if(isFirstB){
                wait();
            }
            System.out.println("A");
            isFirstB = true;
            isFirstA = false;
            notify();
        }
    }

    public  void funB() throws InterruptedException {
        synchronized (this){
            if(isFirstA){
                wait();
            }
            System.out.println("B");
            isFirstA = true;
            isFirstB = false;
            notify();
        }
    }
}

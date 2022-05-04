package zzm.java.JUC;

import sun.misc.Unsafe;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 其实使用的是CAS
 * CAS其实是依赖硬件设备的一个原子性操作，
 *
 */
public class AtomicIntergerDemo {
    static AtomicInteger atomicInteger = new AtomicInteger(0);
    public  static void  fun(){
        for(int i=0;i<1000;i++){
            atomicInteger.incrementAndGet();
        }
    }

    public  static  void main(String[] args){
        ArrayList<Thread> threads = new ArrayList<>();
        for(int i= 0 ;i<1000;i++){
            Thread thread = new Thread(()->{
                fun();
            });
            thread.start();
            threads.add(thread);
        }
        for(Thread thread:threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(atomicInteger);
    }
}

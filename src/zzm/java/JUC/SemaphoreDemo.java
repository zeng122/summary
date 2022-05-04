package zzm.java.JUC;

import java.util.concurrent.Semaphore;

/**
 * 何为Semaphore
 *
 */
public class SemaphoreDemo {
    private volatile  int a = 0;

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1,true);
        new Thread(()->{
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(2000);
                //semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(2000);
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
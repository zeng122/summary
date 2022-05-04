package zzm.java.JUC;

/**
 * synchronized算法
 *
 * 底层实现:
 *
 * MarkWord 对象头里面有两个bit位
 *
 *
 */
public class SynchronizedDemo {

    int i = 0;

    public static void main(String [] args){
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
        synchronizedDemo.init2();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(synchronizedDemo.i);
    }

    public void init1(){
        Thread[] threads = new Thread[100];
        for(int i =0;i<100;i++){
            threads[i] = new Thread(runnable);
            threads[i].start();
        }

    }

    public void init2(){
        Thread[] threads = new Thread[100];
        for(int i =0;i<1;i++){
            threads[i] = new Thread(runnable);
            threads[i].start();
        }

        for(int i =0;i<1;i++){
            threads[i] = new Thread(runnable2);
            threads[i].start();
        }
    }
    /**
     * 方法上锁
     */
    synchronized void fun1(){
        i++;
    }


    /**
     * 过程上锁
     * 可以重入,同一个线程再次申请锁
     */
    void fun2(){
        synchronized (this){
            i++;
            synchronized (this){
                i++;
            }
        }
    }


    /**
     * 过程上锁
     * 可以重入,同一个线程再次申请锁
     */
    void fun3(){
        synchronized (this){
            System.out.println("sadsad");
            i++;
            try {
                this.wait(2000);

                System.out.println("dddddd");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void fun4(){
        synchronized (this){
            System.out.println("sadsad1");
            i++;
            try {

                this.wait();
                System.out.println("dddddd1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void fun5(){
        synchronized (this){
            System.out.println("sadsad1");
            i++;
            try {

                this.notify();
                System.out.println("dddddd2");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try {
                fun4();
            } catch (Exception e) {
                System.out.println("被打断了");
                e.printStackTrace();
            }
        }
    };


    Runnable runnable2 = new Runnable() {
        @Override
        public void run() {
            try {
                fun5();
            } catch (Exception e) {
                System.out.println("被打断了");
                e.printStackTrace();
            }
        }
    };

}

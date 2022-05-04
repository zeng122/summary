package zzm.java.JUC;

public class ThreadDemo {
    public static void main(String[]args){
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.interruptDemo();
        try {
            threadDemo.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadDemo.notify();
        System.out.println("主线程执行完了");
//        this.wait();
//        Object
    }


    /**
     * 等到thread1执行完
     */
    public void joinDemo(){
        Thread thread1 = new Thread(runnable);
        thread1.run();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 重新到就绪状态
     */
    public  void yieldDemo(){
        Thread thread1 = new Thread(runnable,"sadasd");
        thread1.start();
    }


    public void interruptDemo(){
        Thread thread1 = new Thread(runnable,"sadasd");
        thread1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread1.interrupt();
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try {
                Thread.yield();
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName()+"执行完了");
            } catch (InterruptedException e) {
                System.out.println("被打断了");
                e.printStackTrace();
            }
        }
    };
}

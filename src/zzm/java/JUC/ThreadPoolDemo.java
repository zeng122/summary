package zzm.java.JUC;

import java.lang.ref.PhantomReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

//ThreadPoolExecutor.CallerRunsPolicy(): 抛弃旧的任务
//ThreadPoolExecutor.DiscardPolicy() :抛弃当前的任务
//ThreadPoolExecutor.AbortPolicy() :抛出java.util.concurrent.RejectedExecutionException异常,Default异常
//ThreadPoolExecutor.CallerRunsPolicy() :当抛出RejectedExecutionException异常时，
// 会调用rejectedExecution方法
public class ThreadPoolDemo {

    ExecutorService executorService1 = Executors.newFixedThreadPool(1);
    ExecutorService executorService2 = Executors.newSingleThreadExecutor();
    ExecutorService executorService3 = Executors.newCachedThreadPool();
    ExecutorService executorService4 = Executors.newScheduledThreadPool(2);
    ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(5);
    /**
     * 并不是无界的，Interger.Max 2^32 (java int为32位)
     */
    LinkedBlockingDeque<Runnable> queue1 = new LinkedBlockingDeque<>(10);
    /**
     * keepAliveTime:当线程数量超过核心线程数量时，超过一定时间后会被回收
     */
    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,10,1,
            TimeUnit.SECONDS,queue1 ,new ThreadFactoryDemo());

    int j = 0;

    public Runnable runnable = new Runnable() {
        @Override
        public void run() {
            j++;
            System.out.println(j);
        }
    };

    void fun1() throws  Exception{
        for(int i =0 ;i<100 ; i++){
           try{
               System.out.println(i);
               threadPoolExecutor.submit(new Runnable() {
                   @Override
                   public void run() {
                       try {
                           System.out.println(Thread.currentThread().getName());
                           System.out.println("当前队列长度："+queue1.size());
                           TimeUnit.SECONDS.sleep(100000000);
                           synchronized (this) {j++;}
                       } catch (Exception e) {
                           e.printStackTrace();
                       }

                   }
               });
           }catch (Exception e){
               System.out.println(e.getMessage());
           }

        }
    }


    public static void main(String[] args) {
        ThreadPoolDemo threadPoolDemo = new ThreadPoolDemo();

//      for(int i = 0 ; i<10;i++){
//          executorService.submit(threadPoolDemo.runnable);
//      }
//
//      System.out.println(executorService.getActiveCount());
//      executorService.shutdown();
//
        try {
            threadPoolDemo.fun1();
        } catch (Exception e) {
            System.out.println("出现异常:"+e.getMessage());
        }

        threadPoolDemo.threadPoolExecutor.shutdown();
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           // System.out.println("j="+threadPoolDemo.j);
        }



    }

   static class ThreadFactoryDemo implements  ThreadFactory{

        public  AtomicInteger atomicInteger =new AtomicInteger();
        public ThreadFactoryDemo(){

        }

       @Override
       public Thread newThread(Runnable r) {
           return new Thread(r,"MyThread"+atomicInteger.incrementAndGet());
       }

   }

    /**
     * 自定义异常处理
     */
    public static class CallerRunsPolicyDemo implements RejectedExecutionHandler {

        private AtomicInteger atomicInteger = new AtomicInteger();

        public CallerRunsPolicyDemo() { }

        /**
         * Executes task r in the caller's thread, unless the executor
         * has been shut down, in which case the task is discarded.
         *
         * @param r the runnable task requested to be executed
         * @param e the executor attempting to execute this task
         */
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            System.out.println("失败");
           //new Thread(r,"failToAdd"+atomicInteger.incrementAndGet()).start();
        }
    }
}

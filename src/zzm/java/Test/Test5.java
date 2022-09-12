package zzm.java.Test;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test5 {
    public static ExecutorService importThread = new ThreadPoolExecutor(2, 4, 1000, TimeUnit.SECONDS, new ArrayBlockingQueue<>(4), new ThreadPoolExecutor.DiscardPolicy());

    private volatile boolean can = true;


    private volatile boolean can2 = false;

    public static void main(String [] args){
        int i = Integer.MAX_VALUE+1;
        String string = new String("s");
        System.out.println(string.hashCode());
        //Test5 test5 = new Test5();
        //test5.fun2();
        System.out.println(11111);

    }

    public void fun2(){
        System.out.println("1111");
        while(true){
            try {
                Thread.sleep(5*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Task[] tasks = new Task[]{new Task(1,1),new Task(2,1),new Task(3,1),new Task(4,1)};
            for(Task task : tasks){
                Date currentTime = new Date();
                if(task.getStatue() == 2){
                   continue;
                }
                        importThread.submit(new Runnable() {
                            @Override
                            public void run() {
                                fun(task);
                            }
                        });
            }
        }
    }

    public void fun(Task task){
        System.out.println("进入"+task.getA());
        if(can){
          try {
              can = false;
              task.setStatue(2);
              Thread.sleep(30* 1000);
              System.out.println("出去"+task.getA());
              can = true;
              return;
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
        }
        System.out.println("出去，没有获取到锁"+task.getA());
    }


    private class  Task{
        private int a;
        private int statue;
        private Date time = new Date();

        public Task(int a, int statue){
            this.a = a;
            this.statue = statue;
            time = new Date();
        }


        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getStatue() {
            return statue;
        }

        public void setStatue(int statue) {
            this.statue = statue;
        }

        public Date getTime() {
            return time;
        }

        public void setTime(Date time) {
            this.time = time;
        }
    }


}

package zzm.java.JUC;

public class VolatileDemo {

    public static  int race = 0;


    public static Runnable runnable = new Runnable() {
        @Override
        public void run() {
            System.out.println("thread name = "+Thread.currentThread().getName()+"开始:"+race);
            race = race + 1;
            try {
                Thread.sleep(1000 * 3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread name = "+Thread.currentThread().getName()+"结束:"+race);
        }
    };

    public static void increase(){
        System.out.println("thread name = "+Thread.currentThread().getName()+"开始:"+race);
        race++;
        try {
            Thread.sleep(1000 * 3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread name = "+Thread.currentThread().getName()+"结束:"+race);
    }


    public static void main(String [] args){
        Thread[] threads = new Thread[2];
        threads[0] = new Thread(runnable);
        threads[0].start();
        try {
            Thread.sleep(1000 * 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threads[1] = new Thread(runnable);
        threads[1].start();
        try {
            Thread.sleep(1000 * 4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        for(int i = 0;i<threads.length;i++){
//            threads[i] = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    for(int i = 0 ; i<1;i++){
//                        increase();
//                    }
//                }
//            });
//            threads[i].start();
//        }
//
//        for(Thread thread : threads){
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        System.out.println(race);
    }
}

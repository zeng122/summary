package zzm.java.JUC.Demo;

public class BlockQueueDemo {
    private int [] array = new int[1000];

    private volatile  int head = 0;

    private volatile  int tail = 0;

    private volatile  int size = 0;

    public void put(int value) throws InterruptedException {
        synchronized (this){
            if(size == array.length){
                wait();
            }
            array[tail] = value;
            tail++;
            if(tail == array.length){
                tail = 0;
            }
            size++;
            notifyAll();
            System.out.println("释放");
        }
    }

    public int take() throws InterruptedException {
        int ret = -1;
        synchronized (this){
            if(size == 0){
                System.out.println("等待中");
                this.wait();
            }
            ret = array[head];
            head++;
            if(head == array.length){
                head = 0;
            }
            size--;


            notify();
        }
        return ret;
    }



    public static  void main(String [] args){

        BlockQueueDemo blockQueueDemo = new BlockQueueDemo();
        Thread producer = new Thread(){
            @Override
            public void run() {
                for(int i = 0; i<1000; i++) {
                    try {
                        blockQueueDemo.put(i);
                        System.out.println("生产元素："+i);
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        producer.start();

        Thread consumer = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        int ret = blockQueueDemo.take();
                        System.out.println("消费元素: " + ret);
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        consumer.start();
    }
}

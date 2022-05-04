package zzm.java.JUC;

/**
 * 检测StringBuffer和StringBuild
 */
public class StringTest {
    StringBuilder stringBuilder = new StringBuilder();
    StringBuffer stringBuffer = new StringBuffer();
    public static void main(String []args){

        StringTest stringTest = new StringTest();
        stringTest.fun();
    }


    public void fun(){
      Thread []threads = new Thread[1000000];
      for(int i = 0 ;i < threads.length;i++){
          threads[i]= new Thread(runnable);
      }
      for(int i = 0 ;i < threads.length;i++){
          threads[i].start();
      }

      for(int i = 0 ;i < threads.length;i++){
          try {
              threads[i].join();
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }

      System.out.println(stringBuilder.toString().length());

    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            stringBuilder.append("s");
        }
    };
}

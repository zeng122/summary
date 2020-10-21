package zzm.java.ExceptionDemo;

/**
 * The purpose of this class is to validate if exception occurs whether program can run
 * continue
 *
 *
 * In brief : if exception occurs , the program will jump to the place which is also the
 * the place where program deal with exception(catch)
 */
public class ExceptionDemo1 {
    public  static void main(String[] args){
        ExceptionDemo1 exceptionDemo1 = new ExceptionDemo1();
       // exceptionDemo1.fun1();
       // exceptionDemo1.fun2();
        try {
            exceptionDemo1.fun4();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("SDadsad");
    }

    public void fun1(){
        int[] a  = {1,2,0,3,0,2,3,1,0,76};
        for(int i = 0 ; i< 10 ;i++){
            try {
                int j = 100/a[i];
                System.out.println(j);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println("执行吗");
    }

    public void fun2(){
        int[] a  = {1,2,0,3,0,2,3,1,0,76};
        for(int i = 0 ; i< 10 ;i++){
            int j = 100/a[i];
            System.out.println(j);
        }
        System.out.println("执行吗");
    }

    public void fun3() throws Exception{
        int[] a  = {1,2,0,3,0,2,3,1,0,76};
        for(int i = 0 ; i< 10 ;i++){
            int j = 100/a[i];
            System.out.println(j);
        }
        System.out.println("执行吗");
    }

    /**
     * test whether the exception  can catch by its parent's method
     *
     * in brief : the exception can be caught by its parent's method
     */
    public void fun4(){
        int[] a  = {1,2,0,3,0,2,3,1,0,76};
        for(int i = 0 ; i< 10 ;i++){
            int j = 100/a[i];
            System.out.println(j);
        }
    }
}

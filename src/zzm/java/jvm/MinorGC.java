package zzm.java.jvm;
import java.lang.ClassLoader;
/**
 *
 */
public class MinorGC {
    private static  int _1MB  = 1024 * 1024;

    private static int _1KB = 1024;
    /**
     * byte 用8位存储，1字节
     * @param args
     */
    public static void main(String []args){
        //String string = "1111";
        byte [] byte1 = new byte[4 * _1MB];
        byte [] byte2 = new byte[512 *_1KB];
        byte [] byte3 = new byte[2 * _1MB];
        while (true){

        }
        //System.gc();
        //byte [] byte4 = new byte[4 * _1MB];

    }

}

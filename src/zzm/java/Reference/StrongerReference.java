package zzm.java.Reference;

public class StrongerReference {

    public static void main(String []args){

        System.gc();
        byte [] byte1 = new byte[10 * 1024];
        System.out.println("消耗10M后");
        System.gc();
        byte1  = null;
        System.out.println("置为null后");
        System.gc();
    }
}

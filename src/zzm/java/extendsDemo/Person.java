package zzm.java.extendsDemo;

public class Person {
    private final String height = "170cm";

    public final void fun(){
        System.out.println("can not extend");
    }

    public static void test2(){
        System.out.println("sadasda");
    }
    /**
     * private方法不可以重写
     */
    protected void fun2(){
        System.out.println("can extend");
    }

    /**
     * private方法不可以重写
     */
    private void fun3(){
        System.out.println("can extend");
    }

}

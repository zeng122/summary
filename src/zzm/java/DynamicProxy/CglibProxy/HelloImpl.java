package zzm.java.DynamicProxy.CglibProxy;

public class HelloImpl implements HelloInterface {
    @Override
    public void sayHello() {
        System.out.println("hello");
    }
}

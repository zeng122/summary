package zzm.java.DynamicProxy.CglibProxy;


import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test {
    public static  void main(String [] args){
        Enhancer enhancer =new Enhancer();
        enhancer.setSuperclass(HelloImpl.class);
        enhancer.setCallback(new HelloImplCglib());
        HelloImpl targetObject2=(HelloImpl)enhancer.create();
        targetObject2.sayHello();
    }
}

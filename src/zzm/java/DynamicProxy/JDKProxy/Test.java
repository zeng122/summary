package zzm.java.DynamicProxy.JDKProxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test {
    public static  void main(String [] args){
        HelloInterface hello = new HelloImpl();
        InvocationHandler handler = new ProxyHandle(hello);
        HelloInterface helloInterface  = (HelloInterface) Proxy.newProxyInstance(hello.getClass().getClassLoader(),
                hello.getClass().getInterfaces(),handler);
        helloInterface.sayHello();
        byte[] classFile = ProxyGenerator.generateProxyClass("$proxy0",new Class[]{HelloInterface.class});
          // 直接写入项目路径下，方便使用IntelliJ IDEA的反编译功能
        String path = "d://1.class";
        try(FileOutputStream fos = new FileOutputStream(path)){
            fos.write(classFile);
            fos.flush();
            System.out.println("success");
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("fail");
        }

    }
}

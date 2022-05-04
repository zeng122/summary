package zzm.java.jvm.classLoader;

public class ClassLoaderDemo {

    public static  void main(String []args){
        ClassLoader1 classLoader1 = new ClassLoader1();
        ClassLoaderDemo.class.getClassLoader();
        try {
            Object c  =  classLoader1.loadClass("zzm.java.jvm.classLoader.StaticType").newInstance();
            System.out.println(c.getClass());
            System.out.println(c instanceof zzm.java.jvm.classLoader.StaticType);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

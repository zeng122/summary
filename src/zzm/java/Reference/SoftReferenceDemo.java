package zzm.java.Reference;

import java.lang.ref.SoftReference;

/**
 * 软引用
 * 内存快要溢出时，自动回收
 */
public class SoftReferenceDemo {
    public static void main(String []args){
        Student student = new Student("zzm","123");
        SoftReference<Student> softReference = new SoftReference<>(student);
        student = null;
        System.out.println(softReference.get());
        System.gc();
        System.out.println(softReference.get());
        byte [] byte1 = new byte[20 * 1024];
        System.out.println(softReference.get());
    }
}

package zzm.java.Reference;

import java.lang.ref.WeakReference;
import java.util.Map;

/**
 * 弱引用
 * gc后立马回收
 */
public class WeakReferenceDemo {
    public static void main(String []args){
        WeakReference<Student> weakReference = new WeakReference<Student>(new Student("111","222"));
        System.out.println(weakReference.get());
        System.gc();
        System.out.println(weakReference.get());
    }
}

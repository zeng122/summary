package zzm.java.Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class ReflectDemo {
    public static void main(String[] args){
        ReflectDemo reflectDemo = new ReflectDemo();
//        reflectDemo.fun1();
//        reflectDemo.fun2();
//        reflectDemo.fun3();
//        reflectDemo.fun4();
//        Book book = new Book();
//        book.setName("sad");

        reflectDemo.fun5();
    }

    //反射出对象
    public void fun1(){
        try {
            Class<?> classBook = Class.forName("zzm.java.Reflect.Book");
            Object objBook = classBook.newInstance();
            Book book = (Book)objBook;
            book.setAuthor("zzm");
            book.setName("hhh");
            System.out.println(book.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获得私有构造方法
    public void fun2(){
        try {
            Class<?> classBook = Class.forName("zzm.java.Reflect.Book");
            Constructor<?> constructor = classBook.getDeclaredConstructor(String.class , String.class);
            constructor.setAccessible(true);  //忽略访问权限
            Object objBook = constructor.newInstance("zzm","hhh");
            Book book = (Book)objBook;
            System.out.println(book.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获得私有属性
    public void fun3(){
        try {
            Class<?> classBook = Class.forName("zzm.java.Reflect.Book");
            Object objBook = classBook.newInstance();
            Field field  = classBook.getDeclaredField("TAG");
            field.setAccessible(true);
            String tag = (String) field.get(objBook);
            System.out.println(tag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //classloader
    public void fun4(){
        try {
            Class<?> classBook = Class.forName("zzm.java.Reflect.Book");
            ClassLoader classLoader = classBook.getClassLoader();
            System.out.println(classLoader);
            System.out.println(classLoader.getParent().toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void fun5(){
        try {
            Class<?> classBook = Class.forName("zzm.java.Reflect.Book");
            Field [] fields = classBook.getDeclaredFields();
            Book book = new Book("sadsad","sda");
            for(Field field : fields){
                try {
                    field.setAccessible(true);

                    System.out.println(field.get(classBook));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

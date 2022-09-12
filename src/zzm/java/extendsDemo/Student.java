package zzm.java.extendsDemo;

import com.sun.istack.internal.NotNull;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

public class Student extends Person {
    private String name;
    private String password;

    Student(String name , String password){
        this.name = name;
        this.password = password;
    }

    /**
     * From this demo ,wo can know that if we don't override equal function,
     * the two objects are  equal only when they have same address.
     * @param args
     */
    public static void main(String []args){
        HashMap hashMap = new HashMap();
        hashMap.containsKey();
        hashMap.get();
        ConcurrentHashMap
        Hashtable<String,String> hashtable = new Hashtable();
        hashtable.put("ddd",null);
        hashMap.put(null,null);
        Person student1 = new Student("123","231");
        Person student2 = new Student("123","231");
        System.out.println(student1.getHeight());
        if(student1.equals(student2)){
            System.out.println("pl");
        }else{
            System.out.println("fw");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void fun2() {
        super.fun2();
    }
}

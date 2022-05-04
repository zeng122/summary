package zzm.java.Collection.Map;

import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 很多 加锁
 */
public class HashTableDemo {
    public  static  void main(String[] args){
        Hashtable<String , String> hashtable = new Hashtable<>();
        hashtable.put("111","111");
    }
}

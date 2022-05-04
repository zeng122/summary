package zzm.java.Collection.Map;

import java.util.HashMap;

/**
 * 没有锁，所以高并发可能会有问题
 */
public class HashMapDemo {
    public  static  void main(String[] args){
        HashMap<String , Integer> hashMap = new HashMap<>();
        System.out.println(hashMap.hashCode());
        hashMap.put("zzm",1);
        hashMap.put("tt1",2);
        hashMap.get("zzm");
    }
}

package zzm.java.Collection.StreamDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayStream {
    public static  void main(String [] args){
        List<String> strings = new ArrayList<>(3);
        strings.add("123");
        strings.add("23");
        strings.add("23123");
        //strings.stream().collect(Collectors.toMap())
    }
}

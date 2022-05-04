package zzm.java.Collection.List;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListDemo {



    public  static  void main(String[] args){

        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        System.out.println(cal.getTime());

//        LinkedList<String>  strings = new LinkedList<>();
//        strings.add("ssss");
//        strings.addFirst("ttttt");
//        strings.addLast("Sdddsd");
//        Iterator<String> stringsIt =  strings.iterator();
//        while (stringsIt.hasNext()){
//            System.out.println(stringsIt.next());
//        }
    }
}

package zzm.java.Test;


import java.util.*;

public class Test2 {
    public static void main(String []args){
        HashSet<String> goodsNameSet = new HashSet<>();
        //goodsNameSet.add("dsadas");
        if(goodsNameSet.containsAll(goodsNameSet)){
            System.out.println("yes");
        }

        Date date = new Date();
        Date dateToday = Test2.getDayBeginTime(date);
        Date dataToday1 = Test2.getFirstDayOfMonth(date);
        System.out.println("dsadad");
    }

    public static Date getDayBeginTime(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(11, 0);
        c.set(12, 0);
        c.set(13, 0);
        c.set(14, 0);
        return c.getTime();
    }

    public static Date getFirstDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = 3;

	System.out.println("111111");
        cal.set(year, month, day, 0, 0, 0);
	System.out.println("22222");
        return cal.getTime();
    }

}

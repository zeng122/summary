package zzm.java.util;

import javax.xml.crypto.Data;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TimeUtil {

    /**
     * 日期格式，年月日，用横杠分开，例如：2006-12-25，2008-08-08
     */
    public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";


    public static void main(String [] args) throws ParseException {
        try {
            URLEncoder.encode(null,"utf-8");
        }catch (Exception e){
            System.out.println(e);
        }
        HashMap<String,String> stringHashMap = new HashMap<>();
        stringHashMap.put("111","2222");
        stringHashMap.put("123","223");
        stringHashMap.put("134","dddd");
        System.out.println(stringHashMap.get(null));
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);
        Date startTime  = dateFormat.parse("2020-11-01");
        Date endTime =  dateFormat.parse("2020-11-05");
        List<Date> dates  = getAllMonthBetweenTwoMonth(startTime,endTime);

        Date date = formatDdHhMmSsOfDate(new Date());

        System.out.println("1111111");
    }

    public static Date formatDdHhMmSsOfDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH,1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static List<Date> getAllMonthBetweenTwoMonth(Date startTime, Date endTime){
        List<Date> months = new ArrayList<>();
        Calendar startCal = Calendar.getInstance();
        startCal.setTime(startTime);
        Calendar endCal = Calendar.getInstance();
        endCal.setTime(endTime);
        while (endCal.after(startCal)) {
            months.add(startCal.getTime());
            startCal.add(Calendar.DAY_OF_MONTH, 1);
        }
        return months;
    }
}

package zzm.java.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

public class HelloWorld {
    private String str = "111 111";
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date minDate = sdf.parse("2020-07-02 17:03:59");
        Date maxDate = sdf.parse("2020-07-02 17:05:00");
        HelloWorld impl = new HelloWorld();
        List<Date> dates = impl.randomDateList(3, minDate, maxDate);
        for (Date date : dates) {
            String format = sdf.format(date);
            System.out.println(format);
        }

    }

    public List<Date> randomDateList(int n, Date minDate, Date maxDate) {
        LocalDateTime maxDateTime = LocalDateTime.ofInstant(maxDate.toInstant(), ZoneId.systemDefault());
        LocalDateTime minDateTime = LocalDateTime.ofInstant(minDate.toInstant(), ZoneId.systemDefault());
        Duration duration = Duration.between(minDateTime, maxDateTime);
        int seconds = Long.valueOf(duration.getSeconds()).intValue();
        List<Integer> randomList = this.randomList(n, seconds);
        return this.initDateTimeBySeconds(randomList, maxDateTime);
    }

    private List<Date> initDateTimeBySeconds(List<Integer> randomList, LocalDateTime maxDateTime) {
        return randomList.stream()
                .map(randomInt -> {
                    LocalDateTime dateTime = maxDateTime.minusSeconds(randomInt);
                    return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
                }).collect(Collectors.toList());
    }

    /**
     * 生成随机集合 不包括 0 和 max
     * @param n
     * @param max
     * @return
     */
    public List<Integer> randomList(int n, int max) {
        List<Integer> randomList;
        // 如果不能随机生成，就生成n个连续的
        if (n + 2 >= max) {
            randomList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                randomList.add(i + 1);
            }
        } else {
            Set<Integer> set = new TreeSet<>();
            Random ran = new Random();
            while (set.size() < n) {
                set.add(ran.nextInt(max - 1) + 1);
            }
            randomList = new ArrayList<>(set);
        }
        randomList.sort(Comparator.reverseOrder());
        return randomList;
    }

}

package zzm.java.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Test4 {
    public static  void main(String [] args){
        Pattern pattern = Pattern.compile("[0-9]*");
        System.out.println(pattern.matcher("先1111").matches());
        BigDecimal amount = new BigDecimal("12");
        BigDecimal amount1 = new BigDecimal("123");
        amount.divide(amount1,4,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal("23")).setScale(2,BigDecimal.ROUND_HALF_UP);
        BigDecimal amount2 = amount.add(amount1);
        String str = "12345";
        //System.out.println(str.);
        String newStr = str.substring(0,7);
        List<String> custGuids = new ArrayList<>();
        for(int i = 0 ; i< 246;i++){
            custGuids.add("dsadad");
        }
        int pageSize = 1000;
        int totalSize =custGuids.size() ;
        int totalPage = (totalSize-1)/pageSize + 1;
        for(int i = 0;i < totalPage ; i++){
            List<String> subList = custGuids.subList(i * pageSize, (1 + 1) * pageSize > totalSize ? totalSize : (i + 1) * pageSize);
        }
    }
}

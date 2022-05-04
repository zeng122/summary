package zzm.java.util;

import java.math.BigDecimal;

public class BigDecimalUtil {
    public static void main(String []args){

        BigDecimal bigDecimal = new BigDecimal("9.45");
        if (bigDecimal.stripTrailingZeros().scale() > 2){
           System.out.println("1111");
        }
    }
}

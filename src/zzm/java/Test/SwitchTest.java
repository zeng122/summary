package zzm.java.Test;

import java.util.Scanner;

/**
 * this demo just shows a example of usage of switch
 * @date : 2020/09/25
 */
public class SwitchTest {
    public static void main(String []args){
        int i = 0;
        Scanner scanner = new Scanner(System.in);
        i = scanner.nextInt() ;
        switch (i){
            case 1:System.out.println("1");break;
            case 2:System.out.println("2");break;
        }
        System.out.println("正常");
        SwitchTest switchTest = new SwitchTest();
        switchTest.hashCode();
    }
}

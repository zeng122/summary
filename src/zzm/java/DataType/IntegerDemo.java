package zzm.java.DataType;

import java.util.ArrayList;
import java.util.List;

public class IntegerDemo {
    public  static  void main(String[] args){
        Integer integer = new Integer(1);
        IntegerDemo integerDemo = new IntegerDemo();
        integerDemo.fun1(1);
        integerDemo.fun2();
        integerDemo.fun3();
    }

    /**
     * just judge whether Interger can directly valued 1
     * @param i
     */
    void fun1(Integer i){
        System.out.println(i==1);
    }


    void fun2(){
        Integer i = 1;
        List<Integer> list = new ArrayList<>();
        list.add(i);
        i = 1000;
        System.out.println(list.get(0));
    }

    void fun3(){
        Integer i1 = 200;
        Integer i2 = 200;
        Integer i3 = 120;
        Integer i4 = 120;
        System.out.println(i1 == i2                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          );
        System.out.println(i3 == i4);
    }
}

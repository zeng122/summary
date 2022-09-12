package zzm.java.extendsDemo;

public class Parent {
    /**
     * 会报错，因为static按顺序进行加载的
     */
//    static {
//        System.out.println("i="+i);
//    }

    public static int i = 0;


    public int j = 0;

    {
        i++;
        j++;
        System.out.println("i(非静态)="+i);
        System.out.println("j(非静态)="+j);
    }

    static {
        i = i+1;
        System.out.println("i(静态)="+i);
    }

    {
        i++;
        j++;
        System.out.println("i(非静态)="+i);
        System.out.println("j(非静态)="+j);
    }

    public Parent(){
        i++;
        j++;
        System.out.println("i(构造方法)="+i);
        System.out.println("j(非静态)="+j);
    }

}

package zzm.java.extendsDemo;

public class Child extends Parent{
    public static int i = 0;

    public int j = 0;
    {
        i++;
        j++;
        System.out.println("i(子类非静态)="+i);
        System.out.println("j(子类非静态)="+j);
    }

    static {
        i = i+1;
        System.out.println("i(子类静态)="+i);
    }

    {
        i++;
        System.out.println("i(子类非静态)="+i);
    }

    public Child(){
        //显示调用父类构造方法，必须放在最前面，和不写是一样的
        super();
        i++;
        System.out.println("i(子类构造方法)="+i);
    }

    public static void main(String[] args) {
       Child child1 =  new Child();
       Child child2 = new Child();
    }
}

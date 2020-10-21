package zzm.java.DataType;

public class IntegerDemo {
    public  static  void main(String[] args){
        Integer integer = new Integer(1);
        IntegerDemo integerDemo = new IntegerDemo();
        integerDemo.fun1(1);
    }

    /**
     * just judge whether Interger can directly valued 1
     * @param i
     */
    void fun1(Integer i){
        System.out.println(i==1);
    }
}

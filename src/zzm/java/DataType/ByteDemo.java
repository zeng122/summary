package zzm.java.DataType;

public class ByteDemo {
    public static  void main(String []args){
        ByteDemo byteDemo = new ByteDemo();
        byteDemo.fun1();
    }

    private void fun1(){
        Byte b = new Byte((byte)1);
        byte b1 = 1;
        if(b == 1){
            System.out.println("yes");
        }
    }
}

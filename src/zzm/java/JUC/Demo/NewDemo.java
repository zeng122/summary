package zzm.java.JUC.Demo;

public class NewDemo {

    public static void main(String [] args){

        NewDemo newDemo = new NewDemo();
        try {
            newDemo.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}

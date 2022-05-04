package zzm.java.Test;


import java.util.Date;

public class Test3 {
    private String attr;


    /**
     * 如果方法为private，子类是无法访问的。
     * @return
     */
    private String getAttr() {
        return attr;
    }

    void setAttr(String attr) {
        this.attr = attr;
    }
}

class Test3_1 extends  Test3{
    public static void main(String [] args){
        Test3_1 test3_1 = new Test3_1();
        Date date2 = new Date();
        Date date = new Date(1609430400801l);
        Date date1 = new Date(1606752000801l);
        System.out.println("11");
    }
}

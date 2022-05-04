package zzm.java.jvm;

public class FullGC {

    public static void main(String [] args){
        A a1 = new A();
        a1.setColum1("sddd");
        a1.setColum2("weew");
        a1 = null;
        System.gc();

    }

    public static  class  A {
        private  String colum1;
        private String colum2;

        public String getColum1() {
            return colum1;
        }

        public void setColum1(String colum1) {
            this.colum1 = colum1;
        }

        public String getColum2() {
            return colum2;
        }

        public void setColum2(String colum2) {
            this.colum2 = colum2;
        }
    }
}

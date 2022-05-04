package zzm.java.ExceptionDemo;

public class BaseException1 extends Exception {
    private Integer code;
    public BaseException1() {
        super();
    }

    public BaseException1(String msg) {
        super(msg);
    }

    public BaseException1(int code, String msg) {
        super(msg);
        this.code = code;
    }
}

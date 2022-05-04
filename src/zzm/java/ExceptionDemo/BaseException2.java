package zzm.java.ExceptionDemo;

public class BaseException2 extends RuntimeException {
    private Integer code;
    public BaseException2() {
        super();
    }

    public BaseException2(String msg) {
        super(msg);
    }

    public BaseException2(int code, String msg) {
        super(msg);
        this.code = code;
    }
}

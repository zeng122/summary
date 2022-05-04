package zzm.java.ExceptionDemo;

import java.util.Arrays;

public class BaseException3 extends RuntimeException {
    private Integer code;
    public BaseException3() {
        super();
    }

    public BaseException3(String msg) {
        super(msg);
    }

    public BaseException3(int code, String msg) {
        super(msg);
        this.code = code;
    }


    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}

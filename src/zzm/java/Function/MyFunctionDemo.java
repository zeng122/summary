package zzm.java.Function;


/**
 * 在interface中所有的方法都是public abstract的，即使你没有申明它是public abstract的.
 *
 * 在interface中所有的数据成员都是public static final的，即使你没有申明
 */
@FunctionalInterface
public interface MyFunctionDemo {

    public int getFun(int r);
}

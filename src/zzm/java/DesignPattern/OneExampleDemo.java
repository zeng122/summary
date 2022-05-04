package zzm.java.DesignPattern;

/**
 * 单例模式
 * 何为单例：
 * 只有一个实例
 */
public class OneExampleDemo {

}


/**
 * 懒汉模式
 */
class  Student {
    /**
     * 为什么要加volatile
     * 如果不加：
     *
     */
    private static volatile Student student = null;

    private Student() {
    }

    ;

    /**
     * 加同步
     *
     * @return
     */
    public static synchronized Student getInstance() {
        if (student == null) {
            student = new Student();
        }
        return student;
    }

    /**
     * 这个时候就必须加锁volatile,
     * 会有指令重排，new会有三个指令，
     * 初始化(this.a = a )、赋值对象值()、赋值成员变量(student = )，可能赋值成员变量到第一步，就会出现问题了，加上volatile
     * @return
     */
    public static Student getInstance2() {
        if (student == null) {
            synchronized (OneExampleDemo.class){
                student = new Student();
            }
        }
        return student;
    }
}


/**
 * 饿汉模式，类一旦加载就创建一个单例，保证在调用getInstance方法之前单例
 * final 型变量在准备阶段就已经赋值到常量池了
 * 已经存在
 *
 * 缺点：容易浪费空间
 */
class Teacher{
    private static final Teacher instance = new Teacher();

    private Teacher(){

    }

    public static Teacher getInstance(){
        return instance;
    }
}
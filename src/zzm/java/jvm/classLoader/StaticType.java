package zzm.java.jvm.classLoader;

public class StaticType {
    public class Human{
        private void sayHello(){
            System.out.println("Human Say Hello!");
        }
    }

    private class  Man extends Human{
        private void sayHello(){
            System.out.println("man say Hello");
        }
    }


    private void function2(Human human){
        human.sayHello();
    }

    private void function2(Man man){
        man.sayHello();
    }


    /**
     * 思考：为什么会输出Human呢？
     * 这就要考虑重载的实现。
     * 局部变量表的类型是：Human,但是它的实现类
     *
     */
    private void function1(){
        Human human = new Man();
        function2(human);
    }


    public static void main(String [] args){
        StaticType staticType = new StaticType();
        staticType.function1();
    }
}

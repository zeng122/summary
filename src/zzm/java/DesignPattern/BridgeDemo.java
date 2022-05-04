package zzm.java.DesignPattern;

/**
 * 桥接模式
 * 特点：
 * 将抽象与实现分离，各自干自己的事情
 * 抽象：一个物体能干的事情抽象
 * 实现：对于不同物体
 **/
public class BridgeDemo {
    public static void main(String [] args){
        BridgeDemo bridgeDemo = new BridgeDemo();
        bridgeDemo.fun();
    }

    void fun(){
        People people = new People1("小学生");
        people.setClothing(new Clothing1());
        people.show();

    }

    //抽象化角色(一般是一个类)
    abstract private class  People{
        protected Clothing clothing;

        void setClothing(Clothing clothing){
            this.clothing = clothing;
        }
        protected abstract void  show();
    }


    interface Clothing{
        void cloth();
    }

    class  Clothing1 implements Clothing{

        @Override
        public void cloth() {
            System.out.println("穿小学生衣服");
        }
    }
    class  Clothing2 implements Clothing{

        @Override
        public void cloth() {
            System.out.println("穿中学生衣服");
        }
    }


    class People1 extends  People{
        String name;
        People1(String name){
            this.name = name;
        }

        @Override
        protected void show() {
            System.out.println(name+":");
            clothing.cloth();
        }
    }
}



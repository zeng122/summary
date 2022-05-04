package zzm.java.JUC;

/**
 *
 */
public class Test1 {
    DoAction doAction = new DoAction();
    public static void main(String [] agrs){
       Test1 test1 = new Test1();
       test1.fun1();
    }

    public  void fun1(){
        ThreadDemo [] threadDemos = new ThreadDemo[10];
        for(int i = 0;i<threadDemos.length;i++){
            threadDemos[i] = new ThreadDemo(new ChangeBean(1,2));
        }

        for(int i = 0;i<threadDemos.length;i++){
            threadDemos[i].run();
        }

    }
    class ChangeBean{
        int i;
        int j;

        ChangeBean(int i , int j){
            this.i = i ;
            this.j = j ;
        }

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }

        public int getJ() {
            return j;
        }

        public void setJ(int j) {
            this.j = j;
        }
    }

    class ThreadDemo extends  Thread{
        ChangeBean changeBean;
        public ThreadDemo(ChangeBean changeBean){
            this.changeBean = changeBean;
        };
        @Override
        public void run() {
            DoAction doAction = new DoAction();
            doAction.doThing(changeBean);
            System.out.println("i="+changeBean.getI()+"——————"+"j="+changeBean.getJ());
        }
    }

}


class DoAction{
    public void doThing(Test1.ChangeBean changeBean){
        changeBean.setI(changeBean.getI()+1);
        changeBean.setJ(changeBean.getJ()-1);
    }
}
package zzm.java.extendsDemo;

public class Student extends Person {
    private String name;
    private String password;

    Student(String name , String password){
        this.name = name;
        this.password = password;
    }

    /**
     * From this demo ,wo can know that if we don't override equal function,
     * the two objects are  equal only when they have same address.
     * @param args
     */
    public static void main(String []args){
        Student student1 = new Student("123","231");
        Student student2 = new Student("123","231");
        if(student1.equals(student2)){
            System.out.println("pl");
        }else{
            System.out.println("fw");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void fun2() {
        super.fun2();
    }
}

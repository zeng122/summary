package zzm.java.extendsDemo;

import java.util.HashMap;
import java.util.Objects;

public class Teacher extends  Person{
    private String name;
    private String password;
    private int j;

    Teacher(String name , String password,int j){
        this.name = name;
        this.password = password;
        this.j = j ;

    }

    public static void main(String []args){
        Teacher teacher1 = new Teacher("123","234",2);
        Teacher teacher2 = new Teacher("123","234",2);
        if(teacher1.equals(teacher2)){
            System.out.println("11");
        }else{
            System.out.println("22");
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;
        Teacher teacher = (Teacher) o;
        return j == teacher.j &&
                Objects.equals(name, teacher.name) &&
                Objects.equals(password, teacher.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password, j);
    }
}

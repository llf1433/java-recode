import java.util.Scanner;

public class Student {
    public int sno;
    public String name;
    public int age;
    public void setStudent(int sno, String name, int age) {
        this.sno = sno;
        this.name = name;
        this.age = age;
        this.print();
    }
    public void print() {
        System.out.println(this.sno + "->" + this.name + "->" + this.age);
    }


    public static void main(String[] args) {
        Student st = new Student();
        st.setStudent(10,"lll",20);
    }

}


class Data {

    private int x;
    private int y;

    public Data(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}


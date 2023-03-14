import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;


class Student implements Comparable<Student>{
    private final String name;
    private int age;

    private double score;

    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        return (int)(this.score - o.score);
    }
}
public class TestMain {
    public static void main1(String[] args) {
        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(new Student("李明",18,89));
        studentArrayList.add(new Student("丽华",16,98));
        studentArrayList.add(new Student("流名",17,70));

        Collections.sort(studentArrayList);//排序
        for (Student x : studentArrayList) {
            System.out.println(x);
        }
    }

    public static ArrayList<Character> fuc(String str1,String str2) {
        ArrayList<Character> arrayList= new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            if (!str2.contains(ch + "")) {
                arrayList.add(ch);
            }
        }
        return arrayList;
    }
    public static void main(String[] args) {
        String str1 = "welcome to bit";
        String str2 = "come";
        ArrayList<Character> ret = fuc(str1,str2);
        /*for (Character character : ret) {
            System.out.print(character);
        }*/
        for (int i = 0; i < ret.size() ; i++) {
            System.out.print(ret.get(i));
        }
        //System.out.println(ret);
    }
}

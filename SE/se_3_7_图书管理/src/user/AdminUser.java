package user;

import operations.*;

import java.util.Scanner;

//管理员
public class AdminUser extends User{
    public AdminUser (String name) {
        super(name);//构父类
        this.ioPerations = new IOperation[]{
                new ExitOperation(),
                new FindOperation(),
                new DisOperation(),
                new AddOperation(),
                new DelOperation()
        };
    }

    public int menu() {
        System.out.println("*****************************");
        System.out.println(name + "欢迎进入图书练习");
        System.out.println("1.查找图书");
        System.out.println("2.显示所有图书");
        System.out.println("3.添加图书");
        System.out.println("4.删除图书");
        System.out.println("0.退出系统");
        System.out.println("*****************************");
        System.out.print("输入你的操作：");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }



}

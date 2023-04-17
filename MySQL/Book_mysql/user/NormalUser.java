package user;
import operations.*;
import java.sql.SQLException;
import java.util.Scanner;

//普通用户
public class NormalUser extends User{
    public NormalUser (String name) throws SQLException {
        super(name);
        /*
            接口数组
         */
        this.ioPerations = new IOperation[] {
                new ExitOperation(),
                new FindOperation(),
                new BorrowOperation(),
                new ReturnOperation(),
        };
    }

    public int menu() {
        System.out.println("*****************************");
        System.out.println(name + "欢迎进入图书练习");
        System.out.println("1.查找图书");
        System.out.println("2.借阅图书");
        System.out.println("3.归还图书");
        System.out.println("0.退出系统");
        System.out.println("*****************************");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}

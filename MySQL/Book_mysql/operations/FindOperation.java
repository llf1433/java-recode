package operations;

import java.sql.SQLException;
import java.util.Scanner;

public class FindOperation extends IOperation{
    public FindOperation() throws SQLException {
        super();
    }

    public void work() {
        //查找图书
        //System.out.println("查找图书");
        System.out.println("输入你要查找的图书名：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();


        System.out.println("没找到！");
    }
}

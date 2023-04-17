package operations;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DelOperation extends IOperation{
    public void work() throws SQLException {
        //删除图书
        System.out.println("输入删除的图书名：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String sql = "delete from book where name = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);

        int row = statement.executeUpdate();
        if (row == 1) {
            System.out.println("删除成功!");
        } else {
            System.out.println("删除失败!");
        }

        statement.close();
    }

}

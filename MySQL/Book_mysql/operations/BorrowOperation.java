package operations;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BorrowOperation extends IOperation{
    public void work() throws SQLException {
        //借阅图书
        System.out.println("输入图书名：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String sql = "select isBorrow from book where name = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,name);


        ResultSet resultSet = statement.executeQuery();
        if (!resultSet.next()) {
            System.out.println("未找到你要借书");
        } else {
            int isBorrow = resultSet.getInt("isBorrow");
            if (isBorrow == 0) {
                String sql2 = "update book set isBorrow = 1 where name = ?";
                PreparedStatement statement1 = connection.prepareStatement(sql2);
                statement1.setString(1,name);
                int row = statement1.executeUpdate();

                if (row == 1) {
                    System.out.println("借阅成功!");
                }
                statement1.close();
            } else {
                System.out.println("此书被借出,借阅失败!");
            }
        }
        resultSet.close();
        statement.close();

    }
}

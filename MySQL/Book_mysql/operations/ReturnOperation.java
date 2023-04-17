package operations;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class ReturnOperation extends IOperation{
    public void work() throws SQLException {
        //归还图书
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入要归还的图书名:");
        String name = scanner.nextLine();
        String sql = "select * from book where name = ?";
        /*
            预处理sql
         */
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,name);
        ResultSet resultSet = statement.executeQuery();
        if (!resultSet.next()) {
            System.out.println("此书不未在图书列表中,无法归还!");
            resultSet.close();
            statement.close();
            return;
        }

        resultSet.beforeFirst();

        if (resultSet.next()) {
            String update = "update book set isBorrow = 0 where name = ?";
            PreparedStatement statement2 = connection.prepareStatement(update);
            statement2.setString(1,name);
            System.out.println("归还成功!");
            statement2.close();
        }

        resultSet.close();
        statement.close();
    }
}

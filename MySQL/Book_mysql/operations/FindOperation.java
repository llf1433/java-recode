package operations;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class FindOperation extends IOperation{


    public void work() throws SQLException {
        //查找图书
        System.out.println("输入你要查找的图书名：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        String sql = "select * from book where name = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, name);
        ResultSet resultSet =  statement.executeQuery();
        if (!resultSet.next()) { //移动了光标
            System.out.println("没有找到!");
            statement.close();
            return;
        }

        resultSet.beforeFirst();//光标回到上一个
        while (resultSet.next()) {
            //next 相当于移动光标,指向下一行 --初始指向第一行之前
            String bookName = resultSet.getString("name");
            String author = resultSet.getString("author");
            double price = resultSet.getDouble("price");
            String type = resultSet.getString("type");
            int isBorrow = resultSet.getInt("isBorrow");
            String borrow = "未借出";
            if (isBorrow != 0) {
                borrow = "已借出";
            }

            System.out.println("姓名: " + bookName +
                    "作者: "+ author +
                    " 价格: " + price +
                    "类型: " + type + " 状态: " + borrow);
        }
        resultSet.close();
        statement.close();

    }

}

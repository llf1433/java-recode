package operations;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisOperation extends IOperation{
    public void work() throws SQLException {
        //显示所有图书
        String sql = "select * from book";
        /*
            预处理sql
         */
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

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
                    "类型: " + type + " 状态: " + borrow + " ");
        }

        /*
            释放资源,不断连接
        */
        resultSet.close();
        statement.close();
        //connection.close();
    }
}

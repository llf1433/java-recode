package operations;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class AddOperation extends IOperation{

    public void work() throws SQLException {
        //添加图书
        System.out.println("输入图书名：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.print("输入作者名：");
        String author = scanner.nextLine();
        System.out.print("输入价格：");
        int price = scanner.nextInt();
        System.out.print("输入类型：");
        String type = scanner.next();

        /*
            构造sql语句
            用一个特定的对象描述sql语句
         */
        String sql = "insert into book values (?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1,name);//替换?
        statement.setString(2,author);
        statement.setInt(3,price);
        statement.setString(4,type);
        statement.setString(5, "0");//


        /*
           执行sql
        */
        int row = statement.executeUpdate();
        if (row == 1) {
            System.out.println("插入成功!");
        } else {
            System.out.println("插入失败!");
        }
        /*
            断开连接,释放资源
        */
        statement.close();
    }
}

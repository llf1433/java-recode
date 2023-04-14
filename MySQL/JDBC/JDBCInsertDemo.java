import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import javax.sql.DataSource;
import java.sql.Connection; //--连接
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCInsertDemo {
    public static void main(String[] args) throws SQLException{
        /*
            数据库(llf) 数据表()
         */
        //1.创建数据源 -- 数据库的位置
        DataSource dataSource = new MysqlDataSource();
        /*
            设置数据库的位置
            用户名和密码
         */
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/llf?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("Llf.172839");


        //2.连接数据库
        Connection connection = dataSource.getConnection();

        //3.构造SQL语句
        //String sql = "insert into student values ('张三', 18),('李四',19)";
        String sql = "insert into student values (?,?)";


        /*
            用一个特定对象描述sql语句
        */
        PreparedStatement statement = connection.prepareStatement(sql);
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入姓名:");
        String name = scanner.next();
        int age = scanner.nextInt();


        statement.setString(1,name);
        /*
            4.执行sql
            执行增,删,改使用executeUpdate()
                    查使用executeQuery()
            ret--影响的行(row)数
         */
        int ret = statement.executeUpdate();
        System.out.println(ret);
        /*
            5.断开连接,释放资源
            手动释放
            释放顺序与创建相反
         */
        statement.close();
        connection.close();
    }

}

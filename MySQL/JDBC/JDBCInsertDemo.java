import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import javax.sql.DataSource;
import java.sql.Connection;//--连接
import java.sql.SQLException;

public class JDBCInsertDemo {
    public static void main(String[] args) {

        /*
            数据库(llf) 数据表()
         */
        //创建数据源 -- 数据库的位置
        DataSource dataSource = new MysqlDataSource();
        // 设置数据库的位置
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/llf?characterEncoding = utf8 & useSSL = false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("Llf.172839");

        //连接数据库
        try {
            Connection connection = dataSource.getConnection();
        } catch(SQLException ignored) {

        }

    }

}

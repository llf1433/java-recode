package operations;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class IOperation implements Conn{
    public abstract void work() throws SQLException;
    /*
        connection全局连接一次,在ExitOperation中断开连接
     */
    protected static Connection connection;

    static {
        try {
            connection = Conn.connect();
        } catch (SQLException e) {
            System.out.println("连接数据库失败!");
            throw new RuntimeException(e);
        }
    }

}

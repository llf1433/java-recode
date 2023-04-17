package operations;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class IOperation implements Conn{
    public abstract void work() throws SQLException;
    protected static Connection connection;

    static {
        try {
            connection = Conn.connect();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}

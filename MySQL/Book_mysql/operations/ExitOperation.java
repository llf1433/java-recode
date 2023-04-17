package operations;

import java.sql.SQLException;

public class ExitOperation extends IOperation{
    public void work() throws SQLException {
        /*
            退出系统,断开连接
        */
        connection.close();
        System.out.println("退出系统");
        System.exit(0);
    }
}

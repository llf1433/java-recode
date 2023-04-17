package user;
import operations.IOperation;
import java.sql.SQLException;

public abstract class User {
    protected String name;
    protected IOperation[] ioPerations;//只定义 不进行初始化 未分配内存
    public User(String name) {
        this.name = name;
    }
    public abstract int menu();//

    public void doOperation(int choice) throws SQLException {
        ioPerations[choice].work();
    }

}

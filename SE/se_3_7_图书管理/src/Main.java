import book.BookList;
import user.AdminUser;
import user.NormalUser;
import user.User;
import java.util.Scanner;
public class Main {

    //使用向上转型来确定对象
    public static User login() {
        System.out.print("请输入你的姓名：");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();
        System.out.println("输入你的身份：0-》管理员，1-》普通用户");
        int choice = scanner.nextInt();
        if (choice == 0) {
            return new AdminUser(userName);
        } else {
            return new NormalUser(userName);
        }

    }
    public static void main(String[] args) {
        //0.准备数据
        BookList bookList = new BookList();

        //1.登录
        User user = login();//不同身份生成不同对象
        while (true){
            int choice = user.menu();//引用谁就是谁的menu//2.加载界面
            user.doOperation(choice, bookList);
        }

    }
}

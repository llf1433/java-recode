import java.util.Scanner;

public class Testlogin {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用户名：");
        String username = scanner.nextLine();
        System.out.print("请输入密码：");
        String password = scanner.nextLine();

        try {
            login(username, password);
            System.out.println("登录成功！");
        } catch (LoginException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void login(String username, String password) throws LoginException {
        // 判断用户名密码是否正确，这里简单地以"admin"和"123456"作为正确的用户名和密码
        if (!"admin".equals(username) || !"123456".equals(password)) {
            throw new LoginException("用户名或密码错误！");
        }
    }

}

class LoginException extends Exception {
    public LoginException(String message) {
        super(message);
    }
}
package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TcpClient {
    private Socket socket = null;
    public TcpClient(String serverIp,int PORT) throws IOException {
        // new对象的同时建立TCP连接,Socket方法能够识别点分十进制,比DatagramPacket更方便
        socket = new Socket(serverIp,PORT);
    }

    public void start(){
        System.out.println("客户端启动!");
        Scanner scanner = new Scanner(System.in);
        try(InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream()){
            while (true) {
                // 1.从键盘获取用户输入的内容
                System.out.print(">");
                String request = scanner.next();
                if (request.equals("exit")){
                    System.out.println("Bye");
                    break;
                }

                // 2.将读取到的内容构成请求发送给服务器
                PrintWriter printWriter = new PrintWriter(outputStream);
                printWriter.println(request);
                printWriter.flush();// 保证数据发出
                // 3.读取服务器响应
                Scanner respScanner = new Scanner(inputStream);
                String response = respScanner.next();
                // 4.将响应显示到界面
                System.out.println(response);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TcpClient client = new TcpClient("127.0.0.1",8868);
        client.start();
    }
}

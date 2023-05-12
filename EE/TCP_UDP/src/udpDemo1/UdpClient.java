package udpDemo1;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpClient {
    // 服务端socket地址,包含域名或ip和端口号
/*
    private static final SocketAddress ADDRESS =
            new InetSocketAddress("localhost",8888);
*/

    private DatagramSocket socket = null;
    private String serverIp = null;
    private int serverPort;
    public UdpClient(String serverIp,int serverPort) throws SocketException {
        // 创建客户端DatagramSocket,无参构造则使用随机端口,发送和接收UDP数据报
        socket = new DatagramSocket();
        // 服务端socket地址,域名或ip和端口号
        this.serverIp = serverIp;
        this.serverPort = serverPort;
    }

    public void start() throws IOException {
        System.out.println("客户端启动!");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(">");
            // 获取将要发送的数据
            String request = scanner.next();
            if (request.equals("exit")) {
                System.out.println("Bye!");
                break;
            }

            // 组装要发送的UDP数据报,包含数据和服务端的信息(服务器ip和端口)
            // 此处ip是一个32位整数形式,需要使用InetAddress.getByName()进行转换
            // IP:127.0.0.1 点分十进制(范围0-255,一个字节)
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),request.getBytes().length,
                    InetAddress.getByName(serverIp),serverPort);
            // 发送UDP数据报
            socket.send(requestPacket);

            //读取服务器的响应,并解析
            DatagramPacket responsePacket = new DatagramPacket(new byte[4096],4096);
            socket.receive(responsePacket);
            String response = new String(responsePacket.getData(),0,responsePacket.getLength());
            System.out.println(response);

        }

    }

    public static void main(String[] args) throws IOException {
        UdpClient udpClient = new UdpClient("127.0.0.1",8888);
        udpClient.start();
    }
}

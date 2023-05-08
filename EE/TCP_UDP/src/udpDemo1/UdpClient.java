package udpDemo1;

import java.io.IOException;
import java.net.*;

public class UdpClient {
    // 服务端socket地址,包含域名或ip和端口号
    private static final SocketAddress ADDRESS =
            new InetSocketAddress("localhost",8888);


    public static void main(String[] args) throws IOException {
        // 创建客户端DatagramSocket,无参构造则使用随机端口,发送和接收UDP数据报
        DatagramSocket socket = new DatagramSocket();

        // 准备发送的数据报bytes
        byte[] bytes = "hello".getBytes();

        // 组装要发送的UDP数据报,包含数据和服务端的信息(服务器ip和端口)
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length,ADDRESS);

        // 发送UDP数据报
        socket.send(packet);


    }
}

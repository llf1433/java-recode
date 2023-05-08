package udpDemo1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Arrays;

/**
 *  服务器端不停的接收客户端UDP数据报
 */
public class UdpServer {
    // private static final int PORT = 8888;// 服务器socket绑定的端口号
    DatagramSocket socket = null;
    public UdpServer(int PORT) throws SocketException {
        /*
           创建服务端DatagramSocket,指定端口
           可以接收和发送UDP数据报
         */
        socket = new DatagramSocket(PORT);
    }

    public void start() throws IOException {
        // 不断的接收
        while (true){
            /*
                UPD最多64K,包含UDP首部的8byte
                1024byte = 1kb, 1024 kb = 1m
             */
            byte[] bytes = new byte[1024];
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
            System.out.println("=============================");
            System.out.println("等待接收客户端发送的UDP数据报...");

            /*
                receive 会一直阻塞等待接收客户端发送的UDP数据报
                接收到UDP数据报之后,DatagramPacket对象就包含了数据(bytes),客户端ip和端口号
             */
            socket.receive(packet);
            System.out.printf("客户端ip: %s\n", packet.getAddress().getHostAddress());
            System.out.printf("客户端端口号:%s\n", packet.getPort());
            System.out.printf("客户端发送的原生数据:%s\n", Arrays.toString(packet.getData()));
            System.out.printf("客户端发送的文本数据:%s\n",new String(packet.getData()));

        }
    }
    public static void main(String[] args) throws IOException {
        UdpServer server = new UdpServer(8888);// 服务器socket绑定的端口号
        server.start();

    }
}

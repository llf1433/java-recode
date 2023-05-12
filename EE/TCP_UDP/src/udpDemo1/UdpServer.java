package udpDemo1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.HashMap;

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
        System.out.println("服务器启动!");

        // 不断的接收
        while (true){
            /*
                UPD最多64K,包含UDP首部的8byte
                1024B = 1K, 1024 KB = 1MB
             */
            // 输出型参数,构造空白对象留给receive填充
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096],4096);
            /*
                receive 会一直阻塞等待接收客户端发送的UDP数据报
                接收到UDP数据报之后,DatagramPacket对象就包含了数据(bytes),客户端ip和端口号
             */
            socket.receive(requestPacket);
            // DatagramPacket不容易处理,将数据拿出来构造字符串
            String request = new String(requestPacket.getData(),0,requestPacket.getLength());
            // 根据请求计算响应
            String response = process(request);

            // 使用响应数据构造Packet
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),
                    response.getBytes().length, requestPacket.getSocketAddress());
            socket.send(responsePacket);// send的参数也是DatagramPacket

            /*System.out.printf("客户端ip: %s\n", packet.getAddress().getHostAddress());
            System.out.printf("客户端端口号:%s\n", packet.getPort());
            System.out.printf("客户端发送的原生数据:%s\n", Arrays.toString(packet.getData()));
            System.out.printf("客户端发送的文本数据:%s\n",new String(packet.getData()));*/
            // 显示 本次请求的中间处理结果
            System.out.printf("[%s:%d] request:%s;response:%s\n",requestPacket.getAddress().toString(),
                    requestPacket.getPort(),request,response);
        }
    }


    protected String process(String request) {
        // 回显字符串
        return request;
    }

    public static void main(String[] args) throws IOException {
        UdpServer server = new UdpServer(8888);// 服务器socket绑定的端口号
        server.start();
    }
}

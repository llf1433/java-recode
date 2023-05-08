package udpDemo2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class UdpServer {
    // 服务端socket绑定固定端口
    private final static int PORT = 8888;

    public UdpServer(){

    }

    public static void main(String[] args) throws IOException {
        // 创建服务端DatagramSocket,指定端口,可以发送和接收udp数据报
        DatagramSocket socket = new DatagramSocket(PORT);

        // 不停的接收客户端发送的udp数据报
        while (true) {
            // 创建数据报,用来接收客户端发送的udp数据报
            byte[] requestData = new byte[1024];
            DatagramPacket requestPacket =
                    new DatagramPacket(requestData,requestData.length);

            System.out.println("=================================");

            /*
                一直阻塞等待接收客户端发送的udp数据报
                接收后DatagramPacket包含数据,客户端的ip和端口号
             */

            socket.receive(requestPacket);
            System.out.printf("客户端ip:%s\n",requestPacket.getAddress().getHostAddress());
            System.out.printf("客户端端口号:%s\n",requestPacket.getPort());

            // 把接收的数据作为请求,根据请求执行业务,并返回相应
            for (int i = 0; i < requestData.length; i++) {
                byte b = requestData[i];
                // 结束符
                if (b == '\3') {
                    // 根据约定好的结束符读取约定符之前的数据
                    String request = new String(requestData,0, i);




                }
            }





        }


    }
}

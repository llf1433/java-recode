package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpServer {
    private ServerSocket serverSocket = null;
    public TcpServer(int PORT) throws IOException {
        serverSocket = new ServerSocket(PORT);// 初始化服务端ServerSocket

    }

    public void start() throws IOException {
        System.out.println("启动服务器!");
        ExecutorService threadPool = Executors.newCachedThreadPool();
        while (true) {
            // 与客户端建立连接,未连接完成之前一直阻塞等待
            Socket clientSocket = serverSocket.accept();
            // 使用clientSocket与客户进行交流

            // 使用多线程
            /*
            Thread thread = new Thread(()->{
                processConnection(clientSocket);
            });
            thread.start();
            */

            // 使用线程池
            threadPool.submit(()->{
                processConnection(clientSocket);
            });

        }
    }

    // 使用processConnection方法处理连接
    // 一个连接对应一个客户端,可能进行多次交互
    private void processConnection(Socket clientSocket) {
        System.out.printf("[%s:%d]客户端上线!\n",clientSocket.getInetAddress().toString(),clientSocket.getPort());
        // 基于socket对象和客户端进行通信
        try(InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream()) {
            while (true) {
                // 1.读取请求
                Scanner scanner = new Scanner(inputStream);
                if (!scanner.hasNext()){
                    // 没有下个数据就是读完了,客户端关闭了连接
                    System.out.printf("[%s:%d]客户端已下线!\n",clientSocket.getInetAddress().toString(),clientSocket.getPort());
                    break;
                }

                // next一直读到换行符/空格/其他空白符结束,但并不包含
                String request = scanner.next();
                // 2.根据请求构造响应
                String response = process(request);
                // 3.返回响应结果
                // OutputStream没有write String 方法,可以把String的字节数组拿出来进行写入
                // 也可以使用字符流进行转换一下
                PrintWriter printWriter = new PrintWriter(outputStream);
                // 使用println写入,带有换行符'\n',让另一端更好接收解析
                printWriter.println(response);
                // 刷新缓冲区,保证当前写入数据发送出去了
                printWriter.flush();
                System.out.printf("[%s:%d] request:%s; response:%s\n",clientSocket.getInetAddress().toString(),
                        clientSocket.getPort(),request,response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String process(String request) {
        // 回显字符串
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpServer tcpEchoServer = new TcpServer(8868);
        tcpEchoServer.start();
    }

}

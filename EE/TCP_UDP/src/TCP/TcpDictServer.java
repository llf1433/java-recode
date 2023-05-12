package TCP;

import java.io.IOException;
import java.util.HashMap;

public class TcpDictServer extends TcpServer{
    HashMap<String,String> dict = new HashMap<>();
    public TcpDictServer(int PORT) throws IOException {
        super(PORT);
        // 设置字典内容
        dict.put("cat","猫");
        dict.put("dog","狗");
        // ...
    }

    @Override
    protected String process(String request) {
        // 查询哈希表
        return dict.getOrDefault(request,"当前单词未收录!");
    }

    public static void main(String[] args) throws IOException {
        TcpServer tcpServer = new TcpDictServer(8868);
        tcpServer.start();
    }
}

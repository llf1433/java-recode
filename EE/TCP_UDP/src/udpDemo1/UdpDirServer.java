package udpDemo1;

import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;

public class UdpDirServer extends UdpServer{
    HashMap<String,String> dict = new HashMap<>();

    public UdpDirServer(int PORT) throws SocketException {
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
        UdpServer udpServer = new UdpDirServer(8888);
        udpServer.start();
    }
}

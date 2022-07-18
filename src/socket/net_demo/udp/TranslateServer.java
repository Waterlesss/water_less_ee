package socket.net_demo.udp;

import socket.net_demo.util.Log;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: Waterless
 * @Date: 2022/07/16/10:35
 * @Description:
 */
public class TranslateServer {
    // 公开的 ip 地址：就看进程工作在哪个 ip 上
    // 公开的 port：需要程序中指定
    public static final int PORT = 8888;

    // SocketException -> IOException -> Exception
    public static void main(String[] args) throws Exception {
        Log.println("准备进行字典的初始化");
        initMap();
        Log.println("完成字典的初始化");

        Log.println("准备创建 UDP socket，端口是 " + PORT);
        DatagramSocket socket = new DatagramSocket(PORT);
        //有参数代表绑定固定端口号 一般服务器需要绑定
        Log.println("UDP socket 创建成功");

        // 作为服务器，是被动的，循环的进行请求-响应周期的处理
        // 等待请求，处理并发送响应，直到永远
        while (true) {
            // 1. 接收请求
            byte[] buf = new byte[1024];    // 1024 代表我们最大接收的数据大小（字节）
            DatagramPacket receivedPacket = new DatagramPacket(buf, buf.length);
            Log.println("准备好接收 DatagramPacket，最大大小为: " + buf.length);
            Log.println("开始接收请求");
            socket.receive(receivedPacket); // 这个方法就会阻塞（程序执行到这里就不动了，直到有客户发来请求，才能继续）
            Log.println("接收到请求");

            // 2. 一旦走到此处，一定是接收到请求了，拆信
            // 拆出对方的 ip 地址
            InetAddress address = receivedPacket.getAddress();
            Log.println("对方的 IP 地址: " + address);
            // 拆出对方的端口
            int port = receivedPacket.getPort();
            Log.println("对方的 port: " + port);

            // 拆出对方的 ip 地址 + port
            SocketAddress socketAddress = receivedPacket.getSocketAddress();
            Log.println("对象的完整地址: " + socketAddress);

            // 拆出对方发送过来的数据，其实这个 data 就是我们刚才定义的 buf 数组
            byte[] data = receivedPacket.getData();
            Log.println("接收到的对象的数据: " + Arrays.toString(data));
            // 拆出接收到的数据的大小（字节）
            int length = receivedPacket.getLength();
            Log.println("接收的数据大小（字节）：" + length);

            // 3. 解析请求 ：意味着我们需要定义自己的应用层协议
            // 首先，做字符集解码    byte[] -> String
            String request = new String(data, 0, length, "UTF-8");
            // 这个按照我们的应用层协议
            String engWord = request;
            Log.println("请求（英文单词）：" + engWord);

            // 4. 执行业务（翻译服务），不是我们本次演示的重点
            String chiWord = translate(engWord);
            Log.println("翻译后的结果：" + chiWord);

            // 5. 按照应用层协议，封装响应
            String response = chiWord;
            // 进行字符集编码  String -> byte[]
            byte[] sendBuf = response.getBytes("UTF-8");

            // 6. 发送响应
            // 作为发送方需要提供
            DatagramPacket sentPacket = new DatagramPacket(
                    sendBuf, 0, sendBuf.length,     // 要发送的数据
                    socketAddress                         // 从请求信封中拆出来的对象的地址（ip + port）
            );
            Log.println("准备好发送 DatagramPacket 并发送");
            socket.send(sentPacket);
            Log.println("发送成功");

            // 7. 本次请求-响应周期完成，继续下一次请求-响应周期
        }

//        socket.close(); // 由于我们是死循环，这里永远不会走到
    }

    private static final HashMap<String, String> map = new HashMap<>();

    private static void initMap() {
        map.put("apple", "苹果");
        map.put("pear", "梨");
        map.put("orange", "橙子");
    }

    private static String translate(String engWord) {
        return map.getOrDefault(engWord, "查无此单词");
    }
}

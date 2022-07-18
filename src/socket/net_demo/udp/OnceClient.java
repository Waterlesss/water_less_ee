package socket.net_demo.udp;

import socket.net_demo.util.Log;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Author: Waterless
 * @Date: 2022/07/16/11:00
 * @Description:
 */
public class OnceClient {
    public static void main(String[] args) throws Exception {
        // 1. 创建 UDP socket
        Log.println("准备创建 UDP socket");
        DatagramSocket socket = new DatagramSocket();
        Log.println("UDP socket 创建结束");

        // 2. 发送请求
        String engWord = "apple";
        Log.println("英文单词是: " + engWord);
        String request = engWord;
        byte[] bytes = request.getBytes("UTF-8");

        // 手动构造服务器的地址
        // 现在，服务器和客户端在同一台主机上，所以，使用 127.0.0.1 （环回地址 loopback address）
        // 端口使用 TranslateServer.PORT（8888）
        InetAddress loopbackAddress = InetAddress.getLoopbackAddress();
        DatagramPacket sentPacket = new DatagramPacket(
                bytes, 0, bytes.length, // 要发送的数据
                loopbackAddress, TranslateServer.PORT   // 对方的 ip + port
        );
        Log.println("准备发送请求");
        socket.send(sentPacket);
        Log.println("请求发送结束");

        // 3. 接收响应
        byte[] buf = new byte[1024];
        DatagramPacket receivedPacket = new DatagramPacket(buf, buf.length);
        Log.println("准备接收响应");
        socket.receive(receivedPacket);
        Log.println("响应接收接收");
        byte[] data = receivedPacket.getData();
        int len = receivedPacket.getLength();

        String response = new String(data, 0, len, "UTF-8");
        String chiWord = response;
        Log.println("翻译结果: " + chiWord);

        // 4. 关闭 socket
        socket.close();
    }
}

package socket.sggtcp.upload;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: Waterless
 * @Date: 2022/07/22/23:06
 * @Description: 文件上传的服务器
 * 1.建立服务器对象，打开端口号
 * 2.accept等待客户端连接
 * 3.字节输入流 读取客户端发来的数组
 * 4.字节输出流，数组保存到自己的磁盘中
 * 5.向客户端回写数据 上传成功
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        //1.建立服务器对象，打开端口号
        ServerSocket serverSocket = new ServerSocket(8888);
        //2.accept等待客户端连接
        Socket socket = serverSocket.accept();
        //3.获取字节输入流 读取客户端发来的数组
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024*10];
        int r = 0;
        //4.字节输出流，数组保存到自己的磁盘中 一边读一边写
        FileOutputStream fos = new FileOutputStream("C:\\Users\\86177\\Desktop\\test\\Java内部类.png");
        while ((r = inputStream.read(bytes)) != -1) {
            fos.write(bytes,0,r);
        }
        //5.向客户端回写数据 上传成功
        socket.getOutputStream().write("上传成功".getBytes());
        //关闭流
        fos.close();
        socket.close();
        serverSocket.close();
    }
}

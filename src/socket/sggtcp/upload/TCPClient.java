package socket.sggtcp.upload;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author: Waterless
 * @Date: 2022/07/22/22:56
 * @Description: 实现TCP文件上传的客户端
 * 1.连接服务器
 * 2.字节流读取磁盘中的图片
 * 3.连接对象的字节输出流，读取到的图片写到服务器
 * 4.读取服务器发回来的数据
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8888);
        //读磁盘中的图片
        FileInputStream fis = new FileInputStream("C:\\Users\\86177\\Desktop\\Java内部类.png");
        //字节数组缓冲
        byte[] bytes = new byte[1024*10];
        int r = 0;
        //通过Socket对象获取字节输出流额，数组写向服务器
        OutputStream out = socket.getOutputStream();
        while ((r = fis.read(bytes)) != -1) {
            out.write(bytes,0,r);
        }
        //客户端数据读完了，但是此时服务器还等着客户端的数据，我们需要主动告诉服务器没数据了
        //socket对象的方法 socket.shutDownOutput()
        socket.shutdownOutput();//终止此字节输出流，在终止之前，会向服务器发送一个终止序列符号
        
        //读取服务器回来的数据
        InputStream inputStream = socket.getInputStream();
        r = inputStream.read(bytes);
        System.out.println("服务器回来的数据："+new String(bytes,0,r));
        fis.close();
        socket.close();
    }
}

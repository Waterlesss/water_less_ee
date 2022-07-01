package IO.inputstream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * @Author: Waterless
 * @Date: 2022/07/01/21:03
 * @Description:
 */
public class code {
    public static void main(String[] args) throws Exception{
//        try(InputStream is = new FileInputStream("E:\\Java\\JavaEE\\hello.txt")) {
//            byte[] buf = new byte[5];
//            //文件大小为3个字节
//           int n = is.read(buf);
//            System.out.println(n);
//            for (byte b : buf) {
//                System.out.printf("%02x ",b);
//            }
//            for (int i = 0; i < n; i++) {
//                System.out.printf("%02x ",buf[i]);
//            }
            //利用String类的构造方法，将读到的编码转换为文本
//            String s = new String(buf,0,n,"UTF-8");
//            System.out.println(s);
//        } catch (IOException exc) {
//            exc.printStackTrace();
//        }

        //用Scanner的构造方法转码
        try(InputStream is = new FileInputStream("E:\\Java\\JavaEE\\hello.txt")) {
            try (Scanner scan = new Scanner(is,"UTF-8")) {
                while (scan.hasNextLine()) {
                    String str = scan.nextLine();
                    System.out.println(str);
                }
            }
        }
    }
}

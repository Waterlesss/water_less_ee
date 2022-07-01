package IO.inputstream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: Waterless
 * @Date: 2022/06/29/20:19
 * @Description: 文件IO流 InputStream
 */
public class Read {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("E:\\Java\\JavaEE\\hello.txt");
//        while (true) {
//            //没有参数的read方法代表一次读一个字节，当没有可读字节时(读完了)，返回-1；
        //拿着准备好的桶去水龙头接水
        //data代表这次接到了几滴水 data一定小于数组的长度，最少>=0
//            int data = is.read();
//            if (data == -1) {
//                //所有数据都读完了
//                break;
//            }
//            //data就是我们取到的数据
//            byte b = (byte) data;
//            System.out.printf("%02x ",b);
//        }
        //准备一个水桶
        byte[] buf = new byte[5]; //5代表最多接到5滴水

        while (true) {
            //有参数的read方法，代表从输入流读取若干字节，把他们保存到参数指定的字节数组中。
            //返回的整数表示读取字节的数目。
            int n = is.read(buf);
            // n == 0 只是本次没数据，以后还有
            // n == -1 本次没数据，以后也没数据了 EOS
            if (n == -1) {
                // 代表数据全部读完
                break;
            }
            for (byte b : buf) {
                System.out.printf("%02x ", b);
            }
        }
        is.close();
    }
}

package IO.inputstream.homework;

import java.io.*;

/**
 * @Author: Waterless
 * @Date: 2022/07/03/9:38
 * @Description:
 */
public class CopyFile {
    public static void main(String[] args) throws Exception {
        File srcFile = new File("C:\\Users\\86177\\Desktop\\show.png");
        File destFile = new File("C:\\Users\\86177\\Desktop\\show2.png");

        // 1. 准备好搬数据的桶
        byte[] buf = new byte[1024];

        // 2. 打开两个文件
        int count = 0;
        try (InputStream is = new FileInputStream(srcFile)) {
            try (OutputStream os = new FileOutputStream(destFile)) {
                // 3. 不断地用桶从 is 接水，倒入 os 中
                while (true) {
                    int n = is.read(buf);
                    count += n;
                    System.out.printf("已经复制了 %d 字节的数据\n", count);
                    if (n == -1) {
                        // 全部读完了，可以中止循环了
                        break;
                    }

                    // 直接将读入的数据，原封不同的写入 os 中
                    os.write(buf);
                }

                // 4. 冲刷缓冲区
                os.flush();
            }
        }
    }
}

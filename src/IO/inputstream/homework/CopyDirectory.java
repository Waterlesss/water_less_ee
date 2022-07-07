package IO.inputstream.homework;

import java.io.*;

/**
 * @Author: Waterless
 * @Date: 2022/07/07/8:54
 * @Description: 将一个目录下的所有文件复制到其他目录
 * 没有的目录会自动创建
 */
public class CopyDirectory {
    static File srcFile = new File("E:\\Java\\项目");
    static File destFile = new File("E:\\Java\\dest");
    public static void main(String[] args) throws Exception{

        traversal(srcFile);

    }

    private static void traversal(File dirFile) throws Exception {
        File[] files = dirFile.listFiles();
        if (files == null) {
            return;
        }
        for (File file : files) {
//            System.out.println(srcFile.getCanonicalPath());
//            System.out.println(file.getCanonicalPath());
//            System.out.println(destFile.getCanonicalPath());
//            System.out.println();
            String srcFilePath = srcFile.getCanonicalPath();
            String filePath = file.getCanonicalPath();
            String destFilePath = destFile.getCanonicalPath();
            //怎么得到相对路径，利用src的绝对路径、destFile的绝对路径、file的绝对路径
            String relativePath = filePath.substring(srcFilePath.length());
//            System.out.println(relativePath);
            String destPath = destFilePath + relativePath;
//            System.out.println(destPath);
            File dirDestFile = new File(destPath);
            if (file.isDirectory()) {
                dirDestFile.mkdir();
                traversal(file);
            } else if (file.isFile()) {
                copyFile(file,dirDestFile);
            }
        }
    }
    private static void copyFile(File srcFile, File destFile) throws Exception {

        // 1. 准备好搬数据的桶
        byte[] buf = new byte[1024];

        // 2. 打开两个文件
//        int count = 0;
        try (InputStream is = new FileInputStream(srcFile)) {
            try (OutputStream os = new FileOutputStream(destFile)) {
                // 3. 不断地用桶从 is 接水，倒入 os 中
                while (true) {
                    int n = is.read(buf);
//                    count += n;
//                    System.out.printf("已经复制了 %d 字节的数据\n", count);
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

package IO.inputstream;

import java.io.*;

/**
 * @Author: Waterless
 * @Date: 2022/07/01/21:43
 * @Description:
 */
public class Output {
    public static void main(String[] args) throws Exception{
        //OutputStream -> FileOutStream
        //如果文件之前不存在，则会进行创建(创建可能失败：1.权限不够 2.路径上的目录不存在)
        //如果文件存在，会清空之前的文件，重新写入
//        try (OutputStream os = new FileOutputStream("E:\\Java\\JavaEE\\world.txt")) {
//            //单独去写 0xe6 0x88 0x91是 “我" 的 UTF-8编码的字节序列
//            os.write(0x20); //空格
//            os.write(0x0d); // \r
//            os.write(0x0a); // \n 换行
//
//            os.write(0xe6);
//            os.write(0x88);
//            os.write(0x91);
//
//            //刷盘 确保可能把……缓冲区遗留的数据全部写入输出设备中
//            os.flush();
//        }

        //一次写一堆
//        try (OutputStream os = new FileOutputStream("E:\\Java\\JavaEE\\world.txt")) {
//            byte[] buf = new byte[] {0x65,0x65,0x20,0x65,0x0d,0x0a,0x65};
//            //整个写入
////            os.write(buf);
//            //选择写入 从下标2开始，写4个长度
//            os.write(buf,2,4);
//            os.flush();
//        }

        //直接写入字符
        try (OutputStream os = new FileOutputStream("E:\\Java\\JavaEE\\world.txt")) {
            try (Writer writer = new OutputStreamWriter(os,"UTF-8")) {
//                writer.write("你好中国\r\n");
//                writer.write("妙妙也好\r\n");
//                writer.flush();
                try (PrintWriter printWriter = new PrintWriter(writer)) {
                    printWriter.println(1+1);
                    printWriter.print(3);
                    printWriter.println("喵喵喵");
                    printWriter.printf("%s + %d","妙",14);
                    printWriter.flush();
                }
            }
        }
    }
}

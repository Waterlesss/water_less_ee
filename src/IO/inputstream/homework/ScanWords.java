package IO.inputstream.homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Waterless
 * @Date: 2022/07/02/11:34
 * @Description: 扫描指定目录，并找到内容中包含指定字符的普通文件
 */
public class ScanWords {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入要扫描的根目录:");
        String rootDirPath = scan.next();
        //创建File对象
        File file = new File(rootDirPath);
        if (!file.isDirectory()) {
            System.out.println("输入目录有误，或不是目录");
            return;
        }
        System.out.println("请输入要找出的文件名中的字符:");
        String token = scan.next();

        List<File> list = new ArrayList<>();
        //用深度优先遍历
        scanDir(file,token,list);
        for (File file1 : list) {
            System.out.println(file1.getCanonicalPath());
        }
    }

    private static void scanDir(File file, String token, List<File> list) throws IOException{
        //返回File对象代表的目录下的所有文件，以File对象表示
        File[] files = file.listFiles();
        if (files == null || files.length == 0) return;

        for (File file1 : files) {
            //如果是目录，继续递归
            if (file1.isDirectory()) {
                scanDir(file1,token,list);
            } else {
                if (isContentcontains(file1,token)) {
                    list.add(file1.getAbsoluteFile());
                }
            }
        }
    }
    //找到文件中是否包含指定内容
    private static boolean isContentcontains(File file1, String token) throws IOException{
        StringBuilder sb = new StringBuilder();
        try (InputStream is =new FileInputStream(file1)) {
            try (Scanner scanner = new Scanner(is,"UTF-8")) {
                while (scanner.hasNextLine()) {
                    //把file1中的内容输入到sb中
                    sb.append(scanner.nextLine());
                    sb.append("\r\n");
                }
            }
        }
        //返回sb中token第一次出现的位置，若没有出现，返回-1
        return sb.indexOf(token) != -1;
    }
}

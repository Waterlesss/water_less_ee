package IO.inputstream.homework;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Waterless
 * @Date: 2022/07/02/10:01
 * @Description: 扫描指定目录，并找到名称中包含指定字符的所有普通文件
 * 并询问用户是否删除
 */
public class ScanDir {
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
            System.out.println(file1.getCanonicalPath()+  "  请问是否删除该文件? y/n");
            String choose = scan.next();
            if (choose.toLowerCase().equals("y")) {
                file1.delete();
            }
        }
    }

    private static void scanDir(File file, String token, List<File> list) {
        //返回File对象代表的目录下的所有文件，以File对象表示
        File[] files = file.listFiles();
        if (files == null || files.length == 0) return;

        for (File file1 : files) {
            //如果是目录，继续递归
            if (file1.isDirectory()) {
                scanDir(file1,token,list);
            } else {
                //此时一定是普通文件，将包含指定名称的文件添加到list中
                if (file1.getName().contains(token)) {
                    list.add(file1.getAbsoluteFile());
                }
            }
        }
    }
}

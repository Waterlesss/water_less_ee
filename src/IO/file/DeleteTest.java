package IO.file;

import java.io.File;

/**
 * @Author: Waterless
 * @Date: 2022/06/27/22:14
 * @Description: File删除操作
 */
public class DeleteTest {
    public static void main(String[] args) throws Exception {
        File file1 = new File("C:\\Users\\86177\\Desktop");
//        System.out.println(file1.delete());
        traversal(file1);
    }
    private static void traversal(File dir) throws Exception {
        File[] files = dir.listFiles();
        // 查看这个目录下的所有孩子（不是子孙）
        for (File file : files) {
            if (file.isDirectory()) {
                // 如果这个孩子也是目录，继续深度优先进行遍历
                //getCanonicalPath() 返回file对象修饰过的绝对路径
                System.out.println(file.getCanonicalPath() + "\\");
                traversal(file);
                // 当深度优先的遍历完成时，则可以认为该目录一定是空目录了
//                file.delete();
            } else {
                System.out.println(file.getCanonicalPath());
                // 得到这个文件的一个标准（去除一切无意义的 . 和 ..)
//                file.delete();
            }
        }
    }}

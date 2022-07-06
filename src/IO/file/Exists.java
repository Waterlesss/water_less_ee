package IO.file;

import com.sun.scenario.effect.impl.PoolFilterable;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Waterless
 * @Date: 2022/06/29/18:50
 * @Description: 判断是否存在等其他基本操作
 */
public class Exists {
    public static void main(String[] args) throws Exception {
        File file1 = new File("E:\\Java\\JavaEE");
        //判断file对象描述的文件啊是否存在
//        System.out.println(file1.exists());
//        //判断file对象代表的文件是否一个目录
//        System.out.println(file1.isDirectory());
//        //判断file对象代表的文件是否是一个普通文件
//        System.out.println(file1.isFile());
//        //返回对象的一般绝对路径
//        System.out.println(file1.getAbsolutePath());
//        //返回对象修饰过的(标准的)绝对路径
//        System.out.println(file1.getCanonicalPath());
//        //得到文件名，不区分是普通文件还是目录文件
//        System.out.println(file1.getName());
//        //得到当前文件的父路径
//        System.out.println(file1.getParent());
//        //更标准的父路径
//        System.out.println(file1.getParentFile().getCanonicalPath());
        //判断经过了多少时间
//        long s = System.currentTimeMillis();    // 毫秒
//        Thread.sleep(1000);
//        long e = System.currentTimeMillis();
//        long 经过的毫秒 = e - s;
//        System.out.println(经过的毫秒);
        //判断file对象创建时是否用了根目录
//        System.out.println(file1.isAbsolute());
        //判断文件是否是隐藏文件 isHidden()
        //返回该文件最后一次被修改的时间(以时间戳的形式返回)
//        System.out.println(file1.lastModified());
        //返回目录下的所有孩子
//        File[] files = file1.listFiles();
//        System.out.println(Arrays.toString(files));
        //深度优先遍历
//        traversalDepthFirst(file1);
        //广度优先遍历
//        traversalBroadFirst(file1);
        //列出文件系统有多少个根 listRoots() 静态方法
//        File[] files = File.listRoots();
//        System.out.println(Arrays.toString(files));
        //创建文件夹，mkdir不能创建上一级不存在的文件夹 mkdirs可以
//        File file = new File("E:\\Java\\JavaEE\\a\\b");
//        System.out.println(file.mkdir());
//        System.out.println(file.mkdirs());
        //重命名 1.文件修改名称 2.剪切+粘贴 rename TO
        //重命名演示
//        File file = new File("E:\\Java\\JavaEE\\hello.txt");
//        File file2 = new File("E:\\Java\\JavaEE\\test.txt");
//        file.renameTo(file2);
        //剪切演示
        File file = new File("E:\\Java\\JavaEE\\test.txt");
        //要剪切在哪个文件夹中，前提是文件夹存在
        File file2 = new File("E:\\Java\\JavaEE\\hello\\test.txt");
        file.renameTo(file2);
    }
    //遍历目录
    // 深度优先的遍历
    private static void traversalDepthFirst(File dir) throws Exception {
        // 1. 找到这个目录下的所有孩子
        File[] files = dir.listFiles();
        if (files == null) {
            return;
        }

        // 2. 针对每个孩子，判断是目录还是文件
        for (File file : files) {
            if (file.isDirectory()) {
                // 如果确定是个目录，则继续递归去遍历处理
                System.out.println("目录 " + file.getCanonicalPath());
                traversalDepthFirst(file);
            } else {
                System.out.println("文件 " + file.getCanonicalPath());
            }
        }
    }
    //广度优先遍历
    private static void traversalBroadFirst(File dir) throws Exception {
        //使用队列辅助
        Queue<File> queue = new LinkedList<>();
        queue.offer(dir);
        //队列不为空时
        while (!queue.isEmpty()) {
            File pollFile = queue.poll();
            if (pollFile.isDirectory()) {
                System.out.println("目录 " + pollFile.getCanonicalPath());
            } else {
                System.out.println("文件 " + pollFile.getCanonicalPath());
            }
            if (pollFile.isDirectory()) {
                File[] files = pollFile.listFiles();
                if (files == null) continue;
                for (File file : files) {
                    queue.offer(file);
                }
            }
        }
    }
}

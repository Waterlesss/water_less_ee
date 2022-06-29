package IO.file;

import java.io.File;
import java.io.IOException;

/**
 * @Author: Waterless
 * @Date: 2022/06/27/22:14
 * @Description: File创建操作
 */
public class CreateTest {
    public static void main(String[] args) throws IOException {
        //1.绝对路径的方式创建
        //1.1传入字符串的路径
        File file1 = new File("C:\\Users\\86177\\Desktop\\show.png");
        //1.2船夫父路径 + 子路径
        File file2 = new File("C:\\Users\\86177\\Desktop","show.png");
        //1.3以File传入parent
        File parent = new File("C:\\Users\\86177\\Desktop");
        File file3 = new File(parent,"show.png");
        // 负数代表 file1 < file2
        // 0 代表 file1 == file2
        // 正数代表 file1 > file2
        int cmp1 = file1.compareTo(file2);
        int cmp2 = file2.compareTo(file3);
        System.out.println(cmp1);
        System.out.println(cmp2);

        File file4 = new File("C:\\Users\\86177\\Desktop\\world.txt");
        // 异常的知识点：Java 中的异常分为 受查异常（checked exception） or 非受查异常（uncheck exception）
        // 方法中如果可能抛出受查异常，有语法要求
        // 要么，我们自己 try catch，不再抛出受查异常
        // 要么，在方法签名中通过 throws 声明有受查异常可能被抛出
        // java.lang.RuntimeException 及其子类是非受查异常
        // java.io.IOException 是受查异常
        boolean r1 = file4.createNewFile();
        System.out.println(r1);
        // 这里打印 true
        r1 = file4.createNewFile();
        // 由于文件被创建过了，所以是 false
        System.out.println(r1);
    }
}

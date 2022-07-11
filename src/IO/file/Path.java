package IO.file;

import java.io.File;
import java.io.IOException;

/**
 * @Author: Waterless
 * @Date: 2022/07/01/18:05
 * @Description:
 */
public class Path {
    public static void main(String[] args) throws IOException {
        File file = new File("show.png");
        //工程所在目录作为启动目录,IDEA的默认配置就是工程目录下
        System.out.println(file.getCanonicalPath());
    }
}

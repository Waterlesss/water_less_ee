package IO.inputstream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: Waterless
 * @Date: 2022/07/01/20:40
 * @Description: 语法糖
 * try with resource
 */
public class TryWithResource {
    public static void main(String[] args) {
        try (InputStream is = new FileInputStream("E:\\Java\\JavaEE\\hello.txt")) {

        } catch (IOException exc) {
            exc.printStackTrace();
        }//省略.close 编译后会自动添加
    }
}

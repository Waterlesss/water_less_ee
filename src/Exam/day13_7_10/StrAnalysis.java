package Exam.day13_7_10;

import java.util.Scanner;

/**
 * @Author: Waterless
 * @Date: 2022/07/12/20:16
 * @Description: 在命令行输入如下命令：
 * xcopy /s c:\\ d:\\e，
 * 各个参数如下：
 * 参数1：命令字xcopy
 * 参数2：字符串/s
 * 参数3：字符串c:\\
 * 参数4: 字符串d:\\e
 * 请编写一个参数解析程序，实现将命令行各个参数解析出来。
 */
public class StrAnalysis {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int count = 0;
        int flag = 1;
        //计算有几个空格
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '"') {
                //do while循环 碰到“的时候 i 一直走 知道碰到第二个引号
                do{
                    i++;
                } while (str.charAt(i) != '"');
            }
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        //多加1 四个字符串只需要三个空格分割
        System.out.println(count + 1);
        //标志位 看哪些字符是引号里面的
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '"') {
                flag = flag ^ 1;
            }
            //不是空格也不是引号 直接输出
            if (str.charAt(i) != ' ' && str.charAt(i) != '"') {
                System.out.print(str.charAt(i));
                //此时在引号里面 并且碰到了引号里面的空格 不用换行 直接输出
            } else if (flag == 0 && str.charAt(i) == ' ') {
                System.out.print(str.charAt(i));
                //此时在引号外面 碰到空格需要换行
            } else if (flag == 1 && str.charAt(i) == ' ') {
                System.out.println();
            }

        }
    }
}

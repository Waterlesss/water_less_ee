package Exam.day17_7_14;

import java.util.Scanner;

/**
 * @Author: Waterless
 * @Date: 2022/07/16/21:26
 * @Description:
 */
public class StrCount {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();
        String str2 = scan.nextLine();
        //为了判断大小写 先将所有的字符都转成小写
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        //转为字符 方便进行比较
        char c = str2.charAt(0);
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            //每次遍历都从第一个字符串中取出来一个字符进行比较
            if (str1.charAt(i) == c) {
                //相等就次数+1；
                count++;
            }
        }
        System.out.print(count);
    }
}

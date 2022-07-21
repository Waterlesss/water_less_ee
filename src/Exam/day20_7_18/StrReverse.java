package Exam.day20_7_18;

import java.util.Scanner;

/**
 * @Author: Waterless
 * @Date: 2022/07/21/16:35
 * @Description: 反转字符串
 * 接受一个只包含小写字母的字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 */
public class StrReverse {
    public static void main(String []args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int i = 0;
        int j = str.length() -1;
        //转为字符数组，左右指针交换元素
        char[] arr = str.toCharArray();
        while (i < j) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
        System.out.println(arr);
    }
}

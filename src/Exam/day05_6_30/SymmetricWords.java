package Exam.day05_6_30;

import java.util.Scanner;

/**
 * @Author: Waterless
 * @Date: 2022/07/02/15:42
 * @Description: 统计回文串
 * 在原本的回文串上插入一个新的字符判断有几种插入方式
 */
public class SymmetricWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();
        String str2 = scan.nextLine();
        int count = 0;

        for (int i = 0; i <= str1.length(); i++) {
            StringBuilder sb = new StringBuilder(str1);
            sb.insert(i, str2);
            if (helper(sb.toString())) {
                count++;
            }
        }
        System.out.println(count);
    }
    //判断传进来的字符串是否是回文串
    public static boolean helper(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}

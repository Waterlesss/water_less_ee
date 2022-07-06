package Exam.day08_7_04;

import java.util.Scanner;

/**
 * @Author: Waterless
 * @Date: 2022/07/06/23:52
 * @Description: 给定n个字符串，判断这些字符串是根据哪种方式排序的
 * 1.字典序
 * 2.长度排序
 */
public class TwoSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = scan.next();
        }
        if (isLength(str) && isZiDian(str)) {
            System.out.println("both");
        } else if (isLength(str)) {
            System.out.println("lengths");
        } else if (isZiDian(str)) {
            System.out.println("lexicographically");
        } else {
            System.out.println("none");
        }

    }
    public static boolean isZiDian(String[] str) {
        for (int i = 0; i < str.length -1; i++) {
            if (str[i].compareTo(str[i+1]) > 0) {
                return false;
            }
        }
        return true;
    }
    public static boolean isLength(String[] str) {
        for (int i = 0; i < str.length - 1; i++) {
            if (str[i].length() > str[i+1].length()) {
                return false;
            }
        }
        return true;
    }
}

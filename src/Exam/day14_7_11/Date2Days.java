package Exam.day14_7_11;

import java.util.Scanner;

/**
 * @Author: Waterless
 * @Date: 2022/07/13/20:24
 * @Description: 给定一个日期 转换为该年份的多少天
 */
public class Date2Days {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int y = scan.nextInt();
            int m = scan.nextInt();
            int d = scan.nextInt();
            int[] arr = {31,28,31,30,31,30,31,31,30,31,30,31};
            int sum = 0;
            if (y % 4 == 0 && y % 100 != 0 || y % 400 == 0) {
                for (int i = 0; i < m - 1; i++) {
                    sum = sum + arr[i];
                }
                if (m <= 2) {
                    System.out.println(sum+d);
                }else {
                    System.out.println(sum+1+d);
                }

            }else {
                for (int i = 0; i < m - 1; i++) {
                    sum = sum + arr[i];
                }
                System.out.println(sum+d);
            }

        }
    }
}

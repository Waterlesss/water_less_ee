package Exam.day17_7_14;

import java.util.Scanner;

/**
 * @Author: Waterless
 * @Date: 2022/07/16/21:36
 * @Description: 杨辉三角的变形
 */
public class YangHuiTriangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if (n <= 2) {
            System.out.println(-1);
        } else {
            if (n % 2 == 1) {
                System.out.println(2);
            } else if (n % 4 == 2) {
                System.out.println(4);
            } else {
                System.out.println(3);
            }
        }
    }
    
}

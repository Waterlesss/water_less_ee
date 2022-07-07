package Exam.day09_7_05;

import java.util.Scanner;

/**
 * @Author: Waterless
 * @Date: 2022/07/07/15:13
 * @Description: 走方格的方案数
 * 请计算n*m的棋盘格子（n为横向的格子数，m为竖向的格子数）
 * 从棋盘左上角出发沿着边缘线从左上角走到右下角，总共有多少种走法，
 * 要求不能走回头路，即：只能往右和往下走，不能往左和往上走。
 */
public class Walk {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n =scan.nextInt();
        int m = scan.nextInt();
        System.out.println(backTracking(n,m));
    }
    public static int backTracking(int n, int m) {
        //边界条件
        if ((n == 1 && m>= 1) || (n >= 1 && m == 1)) {
            return n + m;
        }
        return backTracking(n - 1,m) + backTracking(n, m - 1);
    }
}

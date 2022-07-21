package Exam.day18_7_15;

import java.util.Scanner;

/**
 * @Author: Waterless
 * @Date: 2022/07/17/20:04
 * @Description: 统计每个月兔子的数量
 * 有一种兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子。
 * 例子：假设一只兔子第3个月出生，那么它第5个月开始会每个月生一只兔子。
 * 一月的时候有一只兔子，假如兔子都不死，问第n个月的兔子总数为多少？
 */
public class RabbitCount {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        //不死神兔问题 本质就是斐波那契数列
        int dp1 = 1;
        int dp2 = 1;
        for (int i = 1; i < n; i++) {
            int tmp = dp2;
            dp2 = dp1 + dp2;
            dp1 = tmp;
        }
        System.out.println(dp1);
    }
}

package Exam.day07_7_03;

import java.util.Scanner;

/**
 * @Author: Waterless
 * @Date: 2022/07/05/17:57
 * @Description: 整数转Fibonacci数列
 * 给你一个N，你想让其变为一个Fibonacci数，
 * 每一步你可以把当前数字X变为X-1或者X+1，
 * 现在给你一个数N求最少需要多少步可以变为Fibonacci数。
 */
public class FibonacciNum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        //斐波那契数列的第一个数是0，第二个是1
        int fb1 = 0;
        int fb2 = 1;
        //循环，让fb2走到n
        while (fb2 < n) {
            int temp = fb2;
            fb2 = fb1 + fb2;
            fb1 = temp;
        }
        //此时 一定是fb2 >= n >= fb1,直接求两个差的最小值
        int step = Math.min(n - fb1, fb2 - n);
        System.out.println(step);
    }
}

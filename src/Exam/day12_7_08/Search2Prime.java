package Exam.day12_7_08;

import java.util.Scanner;

/**
 * @Author: Waterless
 * @Date: 2022/07/11/16:01
 * @Description: 查找一个偶数的差最小的两个质数
 * 任意一个偶数（大于2）都可以由2个素数组成，组成偶数的2个素数有很多种情况，
 * 本题目要求输出组成指定偶数的两个素数差值最小的素数对。
 */
public class Search2Prime {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        //给定的数 除2 从差最小的开始
        int res1 = num >> 1, res2 = num >>1;
        //每次循环判断两个数是否为素数
        while (res1 >= 0 && res2 <= num) {
            if (isPrime(res1) && isPrime(res2)) {
                break;
            } else {
                res1--;
                res2++;
            }
        }
        System.out.println(res1);
        System.out.println(res2);
    }
    //判断一个数是否为素数
    public static boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}

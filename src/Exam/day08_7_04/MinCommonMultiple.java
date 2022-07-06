package Exam.day08_7_04;

import java.util.Scanner;

/**
 * @Author: Waterless
 * @Date: 2022/07/06/23:59
 * @Description: 给定两个整数A和B，求这两个整数的最小公倍数
 */
public class MinCommonMultiple {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int A = scan.nextInt();
        int B = scan.nextInt();
        int res = 0;
        if (A >= B) {
            res = A;
        } else {
            res = B;
        }
        while (res < A * B) {
            if (res % A == 0 && res % B == 0) {
                break;
            } else{
                res++;
            }
        }
        System.out.print(res);
    }
}
